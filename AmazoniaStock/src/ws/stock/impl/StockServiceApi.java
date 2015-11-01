package ws.stock.impl;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ws.stock.model.AnulacionReservaResponse;
import ws.stock.model.Compras;
import ws.stock.model.ReservaResponse;

@WebService(name = "StockServiceApi", targetNamespace = "http://impl.stock.ws/")
public interface StockServiceApi {

	@WebMethod(operationName = "reservarProducto", action = "urn:ReservarProducto")
	@WebResult(name = "return")
	ReservaResponse reservarProducto(@WebParam(name = "arg0") Compras compras);

	@WebMethod(operationName = "anularReserva", action = "urn:AnularReserva")
	@WebResult(name = "return")
	AnulacionReservaResponse anularReserva(@WebParam(name = "arg0") Long idReserva);

}