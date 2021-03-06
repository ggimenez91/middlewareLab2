
package ws.stock.impl;

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
 * 2015-11-14T15:04:34.643-02:00
 * Generated source version: 3.1.4
 * 
 */
public final class StockServiceApi_StockServiceImplPort_Client {

    private static final QName SERVICE_NAME = new QName("http://impl.stock.ws/", "StockServiceImplService");

    private StockServiceApi_StockServiceImplPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = StockServiceImplService.WSDL_LOCATION;
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
      
        StockServiceImplService ss = new StockServiceImplService(wsdlURL, SERVICE_NAME);
        StockServiceApi port = ss.getStockServiceImplPort();  
        
        {
        System.out.println("Invoking anularReserva...");
        java.lang.Long _anularReserva_arg0 = Long.valueOf(-8267639193586065924l);
        ws.stock.impl.AnulacionReservaResponse _anularReserva__return = port.anularReserva(_anularReserva_arg0);
        System.out.println("anularReserva.result=" + _anularReserva__return);


        }
        {
        System.out.println("Invoking reservarProducto...");
        ws.stock.impl.Compras _reservarProducto_arg0 = new ws.stock.impl.Compras();
        java.util.List<ws.stock.impl.Compra> _reservarProducto_arg0Compras = new java.util.ArrayList<ws.stock.impl.Compra>();
        ws.stock.impl.Compra _reservarProducto_arg0ComprasVal1 = new ws.stock.impl.Compra();
        _reservarProducto_arg0ComprasVal1.setCantidad(Integer.valueOf(502006024));
        _reservarProducto_arg0ComprasVal1.setIdProducto(Long.valueOf(-7513025975199585075l));
        _reservarProducto_arg0Compras.add(_reservarProducto_arg0ComprasVal1);
        _reservarProducto_arg0.getCompras().addAll(_reservarProducto_arg0Compras);
        ws.stock.impl.ReservaResponse _reservarProducto__return = port.reservarProducto(_reservarProducto_arg0);
        System.out.println("reservarProducto.result=" + _reservarProducto__return);


        }

        System.exit(0);
    }

}
