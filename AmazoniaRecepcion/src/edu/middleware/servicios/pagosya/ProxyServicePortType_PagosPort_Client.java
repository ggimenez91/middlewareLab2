
package edu.middleware.servicios.pagosya;

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
 * 2015-11-14T12:44:58.050-02:00
 * Generated source version: 3.1.4
 * 
 */
public final class ProxyServicePortType_PagosPort_Client {

    private static final QName SERVICE_NAME = new QName("http://servicios.middleware.edu/pagosya", "PagosService");

    private ProxyServicePortType_PagosPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = PagosService.WSDL_LOCATION;
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
      
        PagosService ss = new PagosService(wsdlURL, SERVICE_NAME);
        ProxyServicePortType port = ss.getPagosPort();  
        
        {
        System.out.println("Invoking invoke...");
        java.lang.Object _invoke_arg0 = null;
        java.lang.Object _invoke__return = port.invoke(_invoke_arg0);
        System.out.println("invoke.result=" + _invoke__return);


        }

        System.exit(0);
    }

}
