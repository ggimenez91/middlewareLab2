package ws.stock.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ws.stock.model.AnulacionReservaResponse;
import ws.stock.model.Compra;
import ws.stock.model.Compras;
import ws.stock.model.ReservaResponse;

@WebService(targetNamespace = "http://impl.stock.ws/", endpointInterface = "ws.stock.impl.StockServiceApi", portName = "StockServiceImplPort", serviceName = "StockServiceImplService")
public class StockServiceImpl implements StockServiceApi {

	private Map<Long, List<Compra>> reservas = new HashMap<Long, List<Compra>>();
	
	@WebMethod(operationName = "reservarProducto", action = "urn:ReservarProducto")
	@WebResult(name = "return")
	public ReservaResponse reservarProducto(@WebParam(name = "arg0") Compras compras) {
		
		Long idReserva = new Long(0);
		if (compras != null && compras.getCompras() != null){
			for (Compra compra : compras.getCompras()){
				if (compra.getCantidad() > 25){
					return new ReservaResponse("401", "Cantidad del producto: "+compra.getIdProducto()+" no disponible.");
				}
				else if (compra.getIdProducto() == 8 || compra.getIdProducto() == 9){
					return new ReservaResponse("402", "Producto no disponible: "+compra.getIdProducto()+".");
				}
			}
			boolean encontre = false;
			while (!encontre) {
				Random r = new Random();
				idReserva = new Long(r.nextInt(10000000));
				if (!reservas.containsKey(idReserva)) {
					encontre = true;
				} else {
					encontre = false;
				}
			}	
			reservas.put(idReserva, compras.getCompras());
		}	
		
		return new ReservaResponse("200", "Productos reservados correctamente.", idReserva);
	}

	
	@WebMethod(operationName = "anularReserva", action = "urn:AnularReserva")
	@WebResult(name = "return")
	public AnulacionReservaResponse anularReserva(@WebParam(name = "arg0") Long idReserva) {		
		
		if (reservas.containsKey(idReserva)){
			reservas.remove(idReserva);
			return new AnulacionReservaResponse("200", "Reserva anulada correctamente.");
		} else {
			return new AnulacionReservaResponse("404", "Reserva inexistente.");
		}
	}	
}
