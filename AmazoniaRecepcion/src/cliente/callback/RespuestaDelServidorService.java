package cliente.callback;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-15T22:33:47.524-02:00
 * Generated source version: 3.1.4
 * 
 */
@WebServiceClient(name = "respuestaDelServidorService", 
                  wsdlLocation = "http://localhost:8080/AsincronismoCliente/services/respuestaDelServidorPort?wsdl",
                  targetNamespace = "http://callback.cliente/") 
public class RespuestaDelServidorService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://callback.cliente/", "respuestaDelServidorService");
    public final static QName RespuestaDelServidorPort = new QName("http://callback.cliente/", "respuestaDelServidorPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/AsincronismoCliente/services/respuestaDelServidorPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(RespuestaDelServidorService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/AsincronismoCliente/services/respuestaDelServidorPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public RespuestaDelServidorService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public RespuestaDelServidorService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public RespuestaDelServidorService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public RespuestaDelServidorService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public RespuestaDelServidorService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public RespuestaDelServidorService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns RespuestaDelServidor
     */
    @WebEndpoint(name = "respuestaDelServidorPort")
    public RespuestaDelServidor getRespuestaDelServidorPort() {
        return super.getPort(RespuestaDelServidorPort, RespuestaDelServidor.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns RespuestaDelServidor
     */
    @WebEndpoint(name = "respuestaDelServidorPort")
    public RespuestaDelServidor getRespuestaDelServidorPort(WebServiceFeature... features) {
        return super.getPort(RespuestaDelServidorPort, RespuestaDelServidor.class, features);
    }

}
