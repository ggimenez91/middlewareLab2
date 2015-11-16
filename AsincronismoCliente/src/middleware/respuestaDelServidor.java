package middleware;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(targetNamespace = "http://callback.cliente/", portName = "respuestaDelServidorPort", serviceName = "respuestaDelServidorService")
public class respuestaDelServidor {
	@WebMethod(operationName = "metodoAsincResponse", action = "urn:MetodoAsincResponse")
	@RequestWrapper(className = "cliente.callback.jaxws.MetodoAsincResponse", localName = "metodoAsincResponse", targetNamespace = "http://callback.cliente/")
	@ResponseWrapper(className = "cliente.callback.jaxws.MetodoAsincResponseResponse", localName = "metodoAsincResponseResponse", targetNamespace = "http://callback.cliente/")
	@WebResult(name = "return")
	public void metodoAsincResponse(String respuestaServidor){
    	System.out.println("Resultado: " + respuestaServidor);
    }
}
