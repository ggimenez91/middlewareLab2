
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
 * 2015-11-14T13:06:02.690-02:00
 * Generated source version: 3.1.4
 * 
 */

@javax.jws.WebService(
                      serviceName = "EnvioJMSService",
                      portName = "EnvioJMSPort",
                      targetNamespace = "http://amazoniacentral/",
                      wsdlLocation = "http://localhost:63081/activemq?wsdl",
                      endpointInterface = "amazoniacentral.EnvioJMS")
                      
public class EnvioJMSPortImpl implements EnvioJMS {

    private static final Logger LOG = Logger.getLogger(EnvioJMSPortImpl.class.getName());

    /* (non-Javadoc)
     * @see amazoniacentral.EnvioJMS#enviarColaMensaje(long  arg0 )*
     */
    public long enviarColaMensaje(long arg0) throws JMSException_Exception    { 
        LOG.info("Executing operation enviarColaMensaje");
        System.out.println(arg0);
        try {
            long _return = -3468333199733246404l;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        //throw new JMSException_Exception("JMSException...");
    }

}
