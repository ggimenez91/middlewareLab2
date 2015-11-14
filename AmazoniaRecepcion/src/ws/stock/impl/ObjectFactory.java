
package ws.stock.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.stock.impl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ReservarProductoResponse_QNAME = new QName("http://impl.stock.ws/", "reservarProductoResponse");
    private final static QName _AnularReservaResponse_QNAME = new QName("http://impl.stock.ws/", "anularReservaResponse");
    private final static QName _AnularReserva_QNAME = new QName("http://impl.stock.ws/", "anularReserva");
    private final static QName _ReservarProducto_QNAME = new QName("http://impl.stock.ws/", "reservarProducto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.stock.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AnularReservaResponse }
     * 
     */
    public AnularReservaResponse createAnularReservaResponse() {
        return new AnularReservaResponse();
    }

    /**
     * Create an instance of {@link ReservarProductoResponse }
     * 
     */
    public ReservarProductoResponse createReservarProductoResponse() {
        return new ReservarProductoResponse();
    }

    /**
     * Create an instance of {@link ReservarProducto }
     * 
     */
    public ReservarProducto createReservarProducto() {
        return new ReservarProducto();
    }

    /**
     * Create an instance of {@link AnularReserva }
     * 
     */
    public AnularReserva createAnularReserva() {
        return new AnularReserva();
    }

    /**
     * Create an instance of {@link ReservaResponse }
     * 
     */
    public ReservaResponse createReservaResponse() {
        return new ReservaResponse();
    }

    /**
     * Create an instance of {@link Compra }
     * 
     */
    public Compra createCompra() {
        return new Compra();
    }

    /**
     * Create an instance of {@link Compras }
     * 
     */
    public Compras createCompras() {
        return new Compras();
    }

    /**
     * Create an instance of {@link AnulacionReservaResponse }
     * 
     */
    public AnulacionReservaResponse createAnulacionReservaResponse() {
        return new AnulacionReservaResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarProductoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.stock.ws/", name = "reservarProductoResponse")
    public JAXBElement<ReservarProductoResponse> createReservarProductoResponse(ReservarProductoResponse value) {
        return new JAXBElement<ReservarProductoResponse>(_ReservarProductoResponse_QNAME, ReservarProductoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnularReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.stock.ws/", name = "anularReservaResponse")
    public JAXBElement<AnularReservaResponse> createAnularReservaResponse(AnularReservaResponse value) {
        return new JAXBElement<AnularReservaResponse>(_AnularReservaResponse_QNAME, AnularReservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AnularReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.stock.ws/", name = "anularReserva")
    public JAXBElement<AnularReserva> createAnularReserva(AnularReserva value) {
        return new JAXBElement<AnularReserva>(_AnularReserva_QNAME, AnularReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReservarProducto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.stock.ws/", name = "reservarProducto")
    public JAXBElement<ReservarProducto> createReservarProducto(ReservarProducto value) {
        return new JAXBElement<ReservarProducto>(_ReservarProducto_QNAME, ReservarProducto.class, null, value);
    }

}
