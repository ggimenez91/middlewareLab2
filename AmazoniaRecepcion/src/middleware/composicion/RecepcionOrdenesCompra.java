package middleware.composicion;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.jws.WebService;
import javax.xml.rpc.ServiceException;

import ws.stock.impl.Compra;
import ws.stock.impl.ReservaResponse;
import ws.stock.impl.StockServiceApi;
import ws.stock.impl.StockServiceImplServiceLocator;

@WebService(targetNamespace = "http://composicion.middleware/", endpointInterface = "middleware.composicion.RecepcionOrdenesCompraInterfaz", portName = "RecepcionOrdenesCompraPort", serviceName = "RecepcionOrdenesCompraService")
public class RecepcionOrdenesCompra implements RecepcionOrdenesCompraInterfaz {
	public void RecibirOrden (String idCompra,Long nroTarjeta, ArrayList<LineaOrdenCompra> productos) throws ServiceException{
		System.out.println("OK");
		// Llamo a servicio de stock local
		StockServiceImplServiceLocator locator = new StockServiceImplServiceLocator();
		StockServiceApi api = locator.getStockServiceImplPort();
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
			                   "Descripcion" + resultadoStockLocal.getDescripcion() +
			                   "Id reserva" + resultadoStockLocal.getIdReserva());
			
		}
		
	}
}
