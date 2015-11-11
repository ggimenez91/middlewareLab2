package middleware.composicion;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.rpc.ServiceException;

@WebService(name = "RecepcionOrdenesCompraInterfaz", targetNamespace = "http://composicion.middleware/")
public interface RecepcionOrdenesCompraInterfaz {

	@WebMethod(operationName = "RecibirOrden", action = "urn:RecibirOrden")
	@WebResult(name = "return")
	public abstract void RecibirOrden(@WebParam(name = "arg0") String idCompra, @WebParam(name = "arg1") Long nroTarjeta,
			@WebParam(name = "arg2") ArrayList<LineaOrdenCompra> productos) throws ServiceException;

}