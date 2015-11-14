
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package ws.stock.impl;

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
 * 2015-11-14T13:01:54.527-02:00
 * Generated source version: 3.1.4
 * 
 */

@javax.jws.WebService(
                      serviceName = "StockServiceImplService",
                      portName = "StockServiceImplPort",
                      targetNamespace = "http://impl.stock.ws/",
                      wsdlLocation = "http://localhost:8383/AmazoniaStockService/services/stockservice?wsdl",
                      endpointInterface = "ws.stock.impl.StockServiceApi")
                      
public class StockServiceImplPortImpl implements StockServiceApi {

    private static final Logger LOG = Logger.getLogger(StockServiceImplPortImpl.class.getName());

    /* (non-Javadoc)
     * @see ws.stock.impl.StockServiceApi#anularReserva(java.lang.Long  arg0 )*
     */
    public ws.stock.impl.AnulacionReservaResponse anularReserva(java.lang.Long arg0) { 
        LOG.info("Executing operation anularReserva");
        System.out.println(arg0);
        try {
            ws.stock.impl.AnulacionReservaResponse _return = new ws.stock.impl.AnulacionReservaResponse();
            _return.setCodigo("Codigo483085689");
            _return.setDescripcion("Descripcion-1791907729");
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see ws.stock.impl.StockServiceApi#reservarProducto(ws.stock.impl.Compras  arg0 )*
     */
    public ws.stock.impl.ReservaResponse reservarProducto(ws.stock.impl.Compras arg0) { 
        LOG.info("Executing operation reservarProducto");
        System.out.println(arg0);
        try {
            ws.stock.impl.ReservaResponse _return = new ws.stock.impl.ReservaResponse();
            _return.setCodigo("Codigo49380799");
            _return.setDescripcion("Descripcion88633679");
            _return.setIdReserva(Long.valueOf(-3583318698979832122l));
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}