
package edu.middleware.servicios.pagosya;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.middleware.servicios.pagosya package. 
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

    private final static QName _Invoke_QNAME = new QName("http://servicios.middleware.edu/pagosya", "invoke");
    private final static QName _InvokeResponse_QNAME = new QName("http://servicios.middleware.edu/pagosya", "invokeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.middleware.servicios.pagosya
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Invoke }
     * 
     */
    public Invoke createInvoke() {
        return new Invoke();
    }

    /**
     * Create an instance of {@link InvokeResponse }
     * 
     */
    public InvokeResponse createInvokeResponse() {
        return new InvokeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Invoke }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios.middleware.edu/pagosya", name = "invoke")
    public JAXBElement<Invoke> createInvoke(Invoke value) {
        return new JAXBElement<Invoke>(_Invoke_QNAME, Invoke.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvokeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servicios.middleware.edu/pagosya", name = "invokeResponse")
    public JAXBElement<InvokeResponse> createInvokeResponse(InvokeResponse value) {
        return new JAXBElement<InvokeResponse>(_InvokeResponse_QNAME, InvokeResponse.class, null, value);
    }

}
