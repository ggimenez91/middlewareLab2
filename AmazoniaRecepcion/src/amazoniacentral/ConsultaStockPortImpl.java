
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
 * 2015-11-14T15:09:42.376-02:00
 * Generated source version: 3.1.4
 * 
 */

@javax.jws.WebService(
                      serviceName = "ConsultaStockService",
                      portName = "ConsultaStockPort",
                      targetNamespace = "http://amazoniacentral/",
                      wsdlLocation = "http://localhost:63083/ConsultaStock?wsdl",
                      endpointInterface = "amazoniacentral.ConsultaStock")
                      
public class ConsultaStockPortImpl implements ConsultaStock {

    private static final Logger LOG = Logger.getLogger(ConsultaStockPortImpl.class.getName());

    /* (non-Javadoc)
     * @see amazoniacentral.ConsultaStock#consultarStock(amazoniacentral.Compra  arg0 )*
     */
    public amazoniacentral.Compra consultarStock(amazoniacentral.Compra arg0) { 
        LOG.info("Executing operation consultarStock");
        System.out.println(arg0);
        try {
            amazoniacentral.Compra _return = new amazoniacentral.Compra();
            _return.setIdCompra("IdCompra1114266155");
            _return.setIdProducto(Long.valueOf(-1618743120936277858l));
            _return.setCantidad(Integer.valueOf(-547937978));
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
