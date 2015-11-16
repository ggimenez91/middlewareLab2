package middleware.composicion;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.jws.Oneway;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.rpc.ServiceException;

import org.springframework.scheduling.annotation.Async;

import amazoniacentral.ConfirmacionResponse;
import amazoniacentral.ConsultaStock;
import amazoniacentral.ConsultaStockPortImpl;
import amazoniacentral.ConsultaStockService;
import amazoniacentral.EnvioJMS;
import amazoniacentral.EnvioJMSService;
import amazoniacentral.StockResponse;
import amazoniacentral.StockResponseService;

import esb.ServicioPago;
import esb.ServicioPagoPortImpl;
import esb.ServicioPagosESB;

import ws.stock.impl.Compra;
import ws.stock.impl.Compras;
import ws.stock.impl.ReservaResponse;
import ws.stock.impl.StockServiceApi;
import ws.stock.impl.StockServiceImplService;

//@HandlerChain(file = "handler-chain.xml")
@WebService(targetNamespace = "http://composicion.middleware/", endpointInterface = "middleware.composicion.RecepcionOrdenesCompraInterfaz", portName = "RecepcionOrdenesCompraPort", serviceName = "RecepcionOrdenesCompraService")

public class RecepcionOrdenesCompra implements RecepcionOrdenesCompraInterfaz {
	@Oneway
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
					ePuertoResponse = stockResponseEPuerto.obtenerStockResponse(compraePuer.getIdCompra(),String.valueOf(compraePuer.getIdProducto()));
					if(ePuertoResponse.getCodResultado() != 0){
						break; //tengo que retornar que no se pudo comprar xq no hay stock
					} else {				
				        
						
						ServicioPagosESB locatorPagosService = new ServicioPagosESB();
						ServicioPago pagosService = locatorPagosService.getServicioPagoPort();					
						Calendar cal = GregorianCalendar.getInstance();			            
						String response  = pagosService.realizarPago(idCompra,nroTarjeta,montoTotal,toXMLGregorianCalendar(cal));
						
						String idComp = obtenerIdCompra("confirmacionPago",response);
						//TODO
						
						if ( idComp == null || idComp.isEmpty()) {
							EnvioJMSService locatorEnvioAnulacion = new EnvioJMSService();
							EnvioJMS envioJms = locatorEnvioAnulacion.getEnvioJMSPort();
							try {
								envioJms.enviarColaMensaje(Long.valueOf(ePuertoResponse.getIdReserva()));
								//aca va lo que dio vacio o error
							} catch (Exception e) {
								//TODO 
							}
						}
						else
						{	
							//Retornar el OK a el llamado
//							ClaseAsincService asincService = new ClaseAsincService();
//							ClaseAsingPortImpl port = asincService.getClaseAsincPort(features)
						}
						
						
					}
				}	
			} else {
				// Invoco a servicio de pagos
				ServicioPagosESB locatorPagosService = new ServicioPagosESB();
				ServicioPago pagosService = locatorPagosService.getServicioPagoPort();				GregorianCalendar cal = new GregorianCalendar(2015, 1, 1);
	            
				String response  = pagosService.realizarPago(idCompra,nroTarjeta,montoTotal,toXMLGregorianCalendar(cal));
				
				String idComp = obtenerIdCompra("confirmacionPago",response);
				
				if (idComp == null || idComp.isEmpty()) {
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
					//Retornar el OK a el llamado
					
				}
				
			}
			
		}
		
		
		
	}
	
	
	public static XMLGregorianCalendar toXMLGregorianCalendar(Calendar c)
			{
			
			try {
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTimeInMillis(c.getTimeInMillis());
				XMLGregorianCalendar xc;
				xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
				return xc;
			} catch (DatatypeConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
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
				 String ret="";
				 System.out.println( "matcher creado") ; 
				while(matcher.find()){
						System.out.println( "matcher find entro") ; 
					if (!matcher.group(1).isEmpty())
					{
					  System.out.println( "matcher group encontro") ; 
					//al ser group(1) devuelve SOLO el valor y no incluye las tags
//						 
					  ret = matcher.group(1).toString();
//					  valoresEtiquetas[i] = matcher.group(1).toString();
						 System.out.println( "ewncontro") ;
					}
					else {
						 System.out.println( "NO encontro") ;
						throw new Exception("Etiqueta no econtrada/error matcher find");
					}
				}
					
				return ret;
			}
				
			catch (Exception e) {
			
				System.out.println( e.getMessage());
				return e.getMessage();
			}
		
		
//	}
	}
}
