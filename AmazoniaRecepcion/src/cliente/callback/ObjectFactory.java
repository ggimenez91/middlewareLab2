
package cliente.callback;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cliente.callback package. 
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

    private final static QName _MetodoAsincResponseResponse_QNAME = new QName("http://callback.cliente/", "metodoAsincResponseResponse");
    private final static QName _MetodoAsincResponse_QNAME = new QName("http://callback.cliente/", "metodoAsincResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cliente.callback
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MetodoAsincResponseResponse }
     * 
     */
    public MetodoAsincResponseResponse createMetodoAsincResponseResponse() {
        return new MetodoAsincResponseResponse();
    }

    /**
     * Create an instance of {@link MetodoAsincResponse }
     * 
     */
    public MetodoAsincResponse createMetodoAsincResponse() {
        return new MetodoAsincResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetodoAsincResponseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://callback.cliente/", name = "metodoAsincResponseResponse")
    public JAXBElement<MetodoAsincResponseResponse> createMetodoAsincResponseResponse(MetodoAsincResponseResponse value) {
        return new JAXBElement<MetodoAsincResponseResponse>(_MetodoAsincResponseResponse_QNAME, MetodoAsincResponseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MetodoAsincResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://callback.cliente/", name = "metodoAsincResponse")
    public JAXBElement<MetodoAsincResponse> createMetodoAsincResponse(MetodoAsincResponse value) {
        return new JAXBElement<MetodoAsincResponse>(_MetodoAsincResponse_QNAME, MetodoAsincResponse.class, null, value);
    }

}
