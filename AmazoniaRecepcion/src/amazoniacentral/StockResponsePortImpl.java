
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package amazoniacentral;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-15T16:43:02.770-02:00
 * Generated source version: 3.1.4
 * 
 */

@javax.jws.WebService(
                      serviceName = "StockResponseService",
                      portName = "StockResponsePort",
                      targetNamespace = "http://amazoniacentral/",
                      wsdlLocation = "http://localhost:63082/ResponseStock?wsdl",
                      endpointInterface = "amazoniacentral.StockResponse")
                      
public class StockResponsePortImpl implements StockResponse {

    private static final Logger LOG = Logger.getLogger(StockResponsePortImpl.class.getName());

    public amazoniacentral.ConfirmacionResponse obtenerStockResponse(java.lang.String arg0,java.lang.String arg1) { 
        LOG.info("Executing operation obtenerStockResponse");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            amazoniacentral.ConfirmacionResponse _return = new amazoniacentral.ConfirmacionResponse();
            _return.setIdCompra("IdCompra1388749546");
            _return.setIdReserva("IdReserva1471918270");
            _return.setCodResultado(Integer.valueOf(-390990993));
            _return.setDescripcionResultado("DescripcionResultado-1475137600");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

	/* (non-Javadoc)
     * @see amazoniacentral.StockResponse#obtenerStockResponse(java.lang.String  arg0 )*
     */
    public amazoniacentral.ConfirmacionResponse obtenerStockResponse(java.lang.String arg0) { 
        LOG.info("Executing operation obtenerStockResponse");
        System.out.println(arg0);
        try {
            amazoniacentral.ConfirmacionResponse _return = new amazoniacentral.ConfirmacionResponse();
            _return.setIdCompra("IdCompra-322747989");
            _return.setIdReserva("IdReserva1750912259");
            _return.setCodResultado(Integer.valueOf(-1261105601));
            _return.setDescripcionResultado("DescripcionResultado-332850846");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
