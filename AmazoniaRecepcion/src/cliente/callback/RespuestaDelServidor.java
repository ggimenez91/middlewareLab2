package cliente.callback;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-15T22:33:47.510-02:00
 * Generated source version: 3.1.4
 * 
 */
@WebService(targetNamespace = "http://callback.cliente/", name = "respuestaDelServidor")
@XmlSeeAlso({ObjectFactory.class})
public interface RespuestaDelServidor {

    @WebMethod(action = "urn:MetodoAsincResponse")
    @RequestWrapper(localName = "metodoAsincResponse", targetNamespace = "http://callback.cliente/", className = "cliente.callback.MetodoAsincResponse")
    @ResponseWrapper(localName = "metodoAsincResponseResponse", targetNamespace = "http://callback.cliente/", className = "cliente.callback.MetodoAsincResponseResponse")
    public void metodoAsincResponse(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
