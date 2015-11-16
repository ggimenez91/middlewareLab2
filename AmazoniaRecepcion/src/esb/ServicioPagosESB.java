package esb;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-15T14:15:31.352-02:00
 * Generated source version: 3.1.4
 * 
 */
@WebServiceClient(name = "servicioPagosESB", 
                  wsdlLocation = "http://localhost:8081/PagosService?wsdl",
                  targetNamespace = "http://esb/") 
public class ServicioPagosESB extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://esb/", "servicioPagosESB");
    public final static QName ServicioPagoPort = new QName("http://esb/", "ServicioPagoPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8081/PagosService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ServicioPagosESB.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8081/PagosService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ServicioPagosESB(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ServicioPagosESB(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioPagosESB() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ServicioPagosESB(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ServicioPagosESB(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ServicioPagosESB(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ServicioPago
     */
    @WebEndpoint(name = "ServicioPagoPort")
    public ServicioPago getServicioPagoPort() {
        return super.getPort(ServicioPagoPort, ServicioPago.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioPago
     */
    @WebEndpoint(name = "ServicioPagoPort")
    public ServicioPago getServicioPagoPort(WebServiceFeature... features) {
        return super.getPort(ServicioPagoPort, ServicioPago.class, features);
    }

}
