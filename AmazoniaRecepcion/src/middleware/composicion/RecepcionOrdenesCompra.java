package middleware.composicion;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.WebService;
import javax.xml.rpc.ServiceException;

import amazoniacentral.ConfirmacionResponse;
import amazoniacentral.ConsultaStock;
import amazoniacentral.ConsultaStockPortImpl;
import amazoniacentral.ConsultaStockService;
import amazoniacentral.EnvioJMS;
import amazoniacentral.EnvioJMSService;
import amazoniacentral.StockResponse;
import amazoniacentral.StockResponseService;
import edu.middleware.servicios.pagosya.PagosService;
import edu.middleware.servicios.pagosya.ProxyServicePortType;
import ws.stock.impl.Compra;
import ws.stock.impl.Compras;
import ws.stock.impl.ReservaResponse;
import ws.stock.impl.StockServiceApi;
import ws.stock.impl.StockServiceImplService;

//@HandlerChain(file = "handler-chain.xml")
@WebService(targetNamespace = "http://composicion.middleware/", endpointInterface = "middleware.composicion.RecepcionOrdenesCompraInterfaz", portName = "RecepcionOrdenesCompraPort", serviceName = "RecepcionOrdenesCompraService")
public class RecepcionOrdenesCompra implements RecepcionOrdenesCompraInterfaz {
	
	public void RecibirOrden (String idCompra,Long nroTarjeta, ArrayList<LineaOrdenCompra> productos) throws ServiceException{
			
		/*ServerFactoryBean factory = new JaxWsServerFactoryBean();
		Server server = factory.create();
		Endpoint cxfEndpoint = server.getEndpoint();
		Map<String,Object> inProps = new HashMap<String,Object>();	 
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		cxfEndpoint.getInInterceptors().add(wssIn);
		*/
		
		System.out.println("OK");
		// Llamo a servicio de stock local
		StockServiceImplService locatorStock = new StockServiceImplService();
		StockServiceApi api = locatorStock.getStockServiceImplPort();
		Compra compraAux = null;
		ArrayList<Compra> listaCompras = new ArrayList<Compra>();
		ReservaResponse resultadoStockLocal = null;
		Double montoTotal = new Double(0);
		for(LineaOrdenCompra linea: productos){
		  compraAux = new Compra();
		  compraAux.setIdProducto(linea.idProducto);
		  compraAux.setCantidad(linea.cantidad);
		  listaCompras.add(compraAux);
		  montoTotal += linea.precioUnitario * linea.cantidad;
		}
		Compras compra = new Compras();
		compra.compras = listaCompras;
		resultadoStockLocal = api.reservarProducto(compra);
	
		if (resultadoStockLocal != null){
			System.out.println("Codigo" + resultadoStockLocal.getCodigo()+
			                   " Descripcion" + resultadoStockLocal.getDescripcion() +
			                   " Id reserva" + resultadoStockLocal.getIdReserva());
			ConfirmacionResponse ePuertoResponse;
			if (!resultadoStockLocal.getCodigo().equals("200")) {
				
				// Armo lista para invocar a ePuerto a travès del ESB
				amazoniacentral.Compra compraePuerto;				
				List<amazoniacentral.Compra> comprasePuerto = new ArrayList<amazoniacentral.Compra>();
				
				for (LineaOrdenCompra linea: productos) {
					compraePuerto = new amazoniacentral.Compra();
					compraePuerto.setCantidad(linea.cantidad);
					compraePuerto.setIdCompra(idCompra);
					compraePuerto.setIdProducto(linea.idProducto);
					comprasePuerto.add(compraePuerto);
				}
								
				// Invoco servicio de ePuerto a travès del ESB
				ConsultaStockService locatorEPuertoStock = new ConsultaStockService();
				ConsultaStock consultaStock = locatorEPuertoStock.getConsultaStockPort();
				
				StockResponseService locatorEPuertoResponse = new StockResponseService();
				StockResponse stockResponseEPuerto = locatorEPuertoResponse.getStockResponsePort();
				
				
				for (amazoniacentral.Compra compraePuer: comprasePuerto){
					consultaStock.consultarStock(compraePuer);
					ePuertoResponse = stockResponseEPuerto.obtenerStockResponse(compraePuer.getIdCompra());
					if(ePuertoResponse.getCodResultado() != 0){
						break; //tengo que retornar que no se pudo comprar xq no hay stock
					} else {
						// Invoco a servicio de pagos
						PagosService locatorPagosService = new PagosService();
						ProxyServicePortType pagosService = locatorPagosService.getPagosPort();
				
						StringBuilder sb = new StringBuilder();
						sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pag=\"http://servicios.middleware.edu/pagosya\">");
						sb.append("<soapenv:Header/>");
						sb.append("<soapenv:Body>");
						sb.append("<pago>");
						sb.append("<idCompra>");
						sb.append(idCompra);
						sb.append("</idCompra>");
						sb.append("<nroTarjetaCredito>");
						sb.append(String.valueOf(nroTarjeta));
						sb.append("</nroTarjetaCredito>");
						sb.append("<monto>");
						sb.append(String.valueOf(montoTotal));
						sb.append("</monto>");
						sb.append("<fecha>");
						sb.append(String.valueOf(montoTotal));
						sb.append("</fecha>");
						sb.append("</pago>");
						sb.append("</soapenv:Body>");
						sb.append("</soapenv:Envelope>");
						
						String response = (String) pagosService.invoke(sb.toString());
				        
						String idComp = obtenerIdCompra("confirmacionPago",response);
						
						if (!idComp.isEmpty() || idComp == null) {
							EnvioJMSService locatorEnvioAnulacion = new EnvioJMSService();
							EnvioJMS envioJms = locatorEnvioAnulacion.getEnvioJMSPort();
							try {
								envioJms.enviarColaMensaje(Long.valueOf(resultadoStockLocal.getIdReserva()));
								//aca va lo que dio vacio o error
							} catch (Exception e) {
								//TODO 
							}
						}
						else
						{	
							//Aca dio OK
							
						}
						
						
					}
				}	
			} else {
				// Invoco a servicio de pagos
				PagosService locatorPagosService = new PagosService();
				ProxyServicePortType pagosService = locatorPagosService.getPagosPort();
		
				StringBuilder sb = new StringBuilder();
				sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:pag=\"http://servicios.middleware.edu/pagosya\">");
				sb.append("<soapenv:Header/>");
				sb.append("<soapenv:Body>");
				sb.append("<pago>");
				sb.append("<idCompra>");
				sb.append(idCompra);
				sb.append("</idCompra>");
				sb.append("<nroTarjetaCredito>");
				sb.append(String.valueOf(nroTarjeta));
				sb.append("</nroTarjetaCredito>");
				sb.append("<monto>");
				sb.append(String.valueOf(montoTotal));
				sb.append("</monto>");
				sb.append("<fecha>");
				sb.append(String.valueOf(montoTotal));
				sb.append("</fecha>");
				sb.append("</pago>");
				sb.append("</soapenv:Body>");
				sb.append("</soapenv:Envelope>");
				
				String response = (String) pagosService.invoke(sb.toString());
		        
				String idComp = obtenerIdCompra("confirmacionPago",response);
				
				if (!idComp.isEmpty() || idComp == null) {
					EnvioJMSService locatorEnvioAnulacion = new EnvioJMSService();
					EnvioJMS envioJms = locatorEnvioAnulacion.getEnvioJMSPort();
					try {
						envioJms.enviarColaMensaje(Long.valueOf(resultadoStockLocal.getIdReserva()));
						//aca va lo que dio vacio o error
					} catch (Exception e) {
						//TODO 
					}
				}
				else
				{	
					//Aca dio OK
					
				}
				
			}
			
		}
		
		// Llamo al servio de pagos
		//PagosServiceLocator locatorPagos = new PagosServiceLocator();
		//ProxyServicePortType servicioPagos = locatorPagos.getPagosPort();
		//servicioPagos.invoke();
		
	}
	
	
	
	public String obtenerIdCompra(String etiqueta,String xmlContenido)
	{
		//nombre de confirmacionPago
		
			try  {
				
				
				String patronABuscar = "";
				
				
				int i = 0;
				//Realizo el patron segun las etiquetas de entrada.
				System.out.println(etiqueta);
				
				patronABuscar ="<" + etiqueta + ">" + "(.*?)" + "</" + etiqueta + ">";
				
	        	System.out.println(patronABuscar);
				
				Pattern p = Pattern.compile(patronABuscar);
				 
				Matcher matcher = p.matcher(xmlContenido);
				 
				 System.out.println( "matcher creado") ; 
				while(matcher.find()){
						System.out.println( "matcher find entro") ; 
					if (!matcher.group(1).isEmpty())
					{
					  System.out.println( "matcher group encontro") ; 
					//al ser group(1) devuelve SOLO el valor y no incluye las tags
						// valoresEtiquetas[i] = matcher.group(1).toString();
						 System.out.println( "ewncontro") ;
					}
					else {
						 System.out.println( "NO encontro") ;
						throw new Exception("Etiqueta no econtrada/error matcher find");
					}
				}
					
				return "ok- .";
			}
				
			catch (Exception e) {
			
				System.out.println( e.getMessage());
				return e.getMessage();
			}
		
		
//	}
	}
}
