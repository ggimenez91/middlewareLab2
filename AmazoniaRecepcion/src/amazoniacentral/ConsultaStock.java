package amazoniacentral;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-14T15:09:42.396-02:00
 * Generated source version: 3.1.4
 * 
 */
@WebService(targetNamespace = "http://amazoniacentral/", name = "ConsultaStock")
@XmlSeeAlso({ObjectFactory.class})
public interface ConsultaStock {

    @WebMethod
    @RequestWrapper(localName = "consultarStock", targetNamespace = "http://amazoniacentral/", className = "amazoniacentral.ConsultarStock")
    @ResponseWrapper(localName = "consultarStockResponse", targetNamespace = "http://amazoniacentral/", className = "amazoniacentral.ConsultarStockResponse")
    @WebResult(name = "return", targetNamespace = "")
    public amazoniacentral.Compra consultarStock(
        @WebParam(name = "arg0", targetNamespace = "")
        amazoniacentral.Compra arg0
    );
}
