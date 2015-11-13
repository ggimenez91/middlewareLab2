package middleware.composicion;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.rpc.ServiceException;

import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;

import edu.middleware.servicios.pagosya.PagosServiceLocator;
import edu.middleware.servicios.pagosya.ProxyServicePortType;
import ws.stock.impl.Compra;
import ws.stock.impl.ReservaResponse;
import ws.stock.impl.StockServiceApi;
import ws.stock.impl.StockServiceImplServiceLocator;

//@HandlerChain(file = "handler-chain.xml")
@WebService(targetNamespace = "http://composicion.middleware/", endpointInterface = "middleware.composicion.RecepcionOrdenesCompraInterfaz", portName = "RecepcionOrdenesCompraPort", serviceName = "RecepcionOrdenesCompraService")
public class RecepcionOrdenesCompra implements RecepcionOrdenesCompraInterfaz {
	
	public void RecibirOrden (String idCompra,Long nroTarjeta, ArrayList<LineaOrdenCompra> productos) throws ServiceException{
		
		
		ServerFactoryBean factory = new JaxWsServerFactoryBean();
		Server server = factory.create();
		Endpoint cxfEndpoint = server.getEndpoint();
		Map<String,Object> inProps = new HashMap<String,Object>();	 
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
		cxfEndpoint.getInInterceptors().add(wssIn);
		
		
		
		
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
		PagosServiceLocator locatorPagos = new PagosServiceLocator();
		ProxyServicePortType servicioPagos = locatorPagos.getPagosPort();
		//servicioPagos.invoke();
		
	}
}
