
package esb;

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
 * 2015-11-15T14:15:31.208-02:00
 * Generated source version: 3.1.4
 * 
 */
public final class ServicioPago_ServicioPagoPort_Client {

    private static final QName SERVICE_NAME = new QName("http://esb/", "servicioPagosESB");

    private ServicioPago_ServicioPagoPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ServicioPagosESB.WSDL_LOCATION;
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
      
        ServicioPagosESB ss = new ServicioPagosESB(wsdlURL, SERVICE_NAME);
        ServicioPago port = ss.getServicioPagoPort();  
        
        {
        System.out.println("Invoking realizarPago...");
        java.lang.String _realizarPago_arg0 = "_realizarPago_arg0-49088420";
        java.lang.Long _realizarPago_arg1 = Long.valueOf(5046655437420928478l);
        double _realizarPago_arg2 = 0.11135712614794024;
        javax.xml.datatype.XMLGregorianCalendar _realizarPago_arg3 = javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2015-11-15T14:15:31.301-02:00");
        java.lang.String _realizarPago__return = port.realizarPago(_realizarPago_arg0, _realizarPago_arg1, _realizarPago_arg2, _realizarPago_arg3);
        System.out.println("realizarPago.result=" + _realizarPago__return);


        }

        System.exit(0);
    }

}