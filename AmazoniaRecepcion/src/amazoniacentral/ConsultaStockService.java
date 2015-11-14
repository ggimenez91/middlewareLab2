package amazoniacentral;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-14T13:45:48.196-02:00
 * Generated source version: 3.1.4
 * 
 */
@WebServiceClient(name = "ConsultaStockService", 
                  wsdlLocation = "http://localhost:63082/ConsultaStock?wsdl",
                  targetNamespace = "http://amazoniacentral/") 
public class ConsultaStockService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://amazoniacentral/", "ConsultaStockService");
    public final static QName ConsultaStockPort = new QName("http://amazoniacentral/", "ConsultaStockPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:63082/ConsultaStock?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ConsultaStockService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:63082/ConsultaStock?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ConsultaStockService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ConsultaStockService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ConsultaStockService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ConsultaStockService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ConsultaStockService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ConsultaStockService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ConsultaStock
     */
    @WebEndpoint(name = "ConsultaStockPort")
    public ConsultaStock getConsultaStockPort() {
        return super.getPort(ConsultaStockPort, ConsultaStock.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ConsultaStock
     */
    @WebEndpoint(name = "ConsultaStockPort")
    public ConsultaStock getConsultaStockPort(WebServiceFeature... features) {
        return super.getPort(ConsultaStockPort, ConsultaStock.class, features);
    }

}
