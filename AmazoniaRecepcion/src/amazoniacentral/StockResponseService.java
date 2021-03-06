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
 * 2015-11-15T16:43:02.813-02:00
 * Generated source version: 3.1.4
 * 
 */
@WebServiceClient(name = "StockResponseService", 
                  wsdlLocation = "http://localhost:63082/ResponseStock?wsdl",
                  targetNamespace = "http://amazoniacentral/") 
public class StockResponseService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://amazoniacentral/", "StockResponseService");
    public final static QName StockResponsePort = new QName("http://amazoniacentral/", "StockResponsePort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:63082/ResponseStock?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(StockResponseService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:63082/ResponseStock?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public StockResponseService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public StockResponseService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public StockResponseService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public StockResponseService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public StockResponseService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public StockResponseService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns StockResponse
     */
    @WebEndpoint(name = "StockResponsePort")
    public StockResponse getStockResponsePort() {
        return super.getPort(StockResponsePort, StockResponse.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns StockResponse
     */
    @WebEndpoint(name = "StockResponsePort")
    public StockResponse getStockResponsePort(WebServiceFeature... features) {
        return super.getPort(StockResponsePort, StockResponse.class, features);
    }

}
