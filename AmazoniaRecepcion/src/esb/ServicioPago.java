package esb;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-15T14:15:31.339-02:00
 * Generated source version: 3.1.4
 * 
 */
@WebService(targetNamespace = "http://esb/", name = "ServicioPago")
@XmlSeeAlso({ObjectFactory.class})
public interface ServicioPago {

    @WebMethod
    @RequestWrapper(localName = "realizarPago", targetNamespace = "http://esb/", className = "esb.RealizarPago")
    @ResponseWrapper(localName = "realizarPagoResponse", targetNamespace = "http://esb/", className = "esb.RealizarPagoResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String realizarPago(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.Long arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        double arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        javax.xml.datatype.XMLGregorianCalendar arg3
    );
}
