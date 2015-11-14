package middleware.composicion;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.xml.rpc.ServiceException;

import ws.stock.impl.Compra;
import ws.stock.impl.ReservaResponse;
import ws.stock.impl.StockServiceApi;

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
		StockServiceImplServiceLocator locatorStock = new StockServiceImplServiceLocator();
		StockServiceApi api = locatorStock.getStockServiceImplPort();
		Compra compraAux = null;
		ArrayList<Compra> listaCompras = new ArrayList<Compra>();
		ReservaResponse resultadoStockLocal = null;
		for(LineaOrdenCompra linea: productos){
			  compraAux = new Compra();
			  compraAux.setIdProducto(linea.idProducto);
			  compraAux.setCantidad(linea.cantidad);
		}
		try {
			resultadoStockLocal = api.reservarProducto(listaCompras.toArray(new Compra[listaCompras.size()]));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (resultadoStockLocal != null){
			System.out.println("Codigo" + resultadoStockLocal.getCodigo()+
			                   " Descripcion" + resultadoStockLocal.getDescripcion() +
			                   " Id reserva" + resultadoStockLocal.getIdReserva());
			
		}
		
		// Llamo al servio de pagos
		//PagosServiceLocator locatorPagos = new PagosServiceLocator();
		//ProxyServicePortType servicioPagos = locatorPagos.getPagosPort();
		//servicioPagos.invoke();
		
	}
}
