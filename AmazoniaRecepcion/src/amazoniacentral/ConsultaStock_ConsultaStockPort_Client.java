
package amazoniacentral;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2015-11-14T13:45:48.020-02:00
 * Generated source version: 3.1.4
 * 
 */
public final class ConsultaStock_ConsultaStockPort_Client {

    private static final QName SERVICE_NAME = new QName("http://amazoniacentral/", "ConsultaStockService");

    private ConsultaStock_ConsultaStockPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ConsultaStockService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ConsultaStockService ss = new ConsultaStockService(wsdlURL, SERVICE_NAME);
        ConsultaStock port = ss.getConsultaStockPort();  
        
        {
        System.out.println("Invoking consultarStock...");
        amazoniacentral.Compra _consultarStock_arg0 = new amazoniacentral.Compra();
        _consultarStock_arg0.setIdCompra("IdCompra1257665373");
        _consultarStock_arg0.setIdProducto(Long.valueOf(5680819459846341841l));
        _consultarStock_arg0.setCantidad(Integer.valueOf(-338499977));
        amazoniacentral.Compra _consultarStock__return = port.consultarStock(_consultarStock_arg0);
        System.out.println("consultarStock.result=" + _consultarStock__return);


        }

        System.exit(0);
    }

}
