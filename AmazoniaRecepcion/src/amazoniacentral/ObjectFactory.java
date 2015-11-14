
package amazoniacentral;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the amazoniacentral package. 
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

    private final static QName _EnviarColaMensaje_QNAME = new QName("http://amazoniacentral/", "EnviarColaMensaje");
    private final static QName _JMSException_QNAME = new QName("http://amazoniacentral/", "JMSException");
    private final static QName _EnviarColaMensajeResponse_QNAME = new QName("http://amazoniacentral/", "EnviarColaMensajeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: amazoniacentral
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnviarColaMensaje }
     * 
     */
    public EnviarColaMensaje createEnviarColaMensaje() {
        return new EnviarColaMensaje();
    }

    /**
     * Create an instance of {@link JMSException }
     * 
     */
    public JMSException createJMSException() {
        return new JMSException();
    }

    /**
     * Create an instance of {@link EnviarColaMensajeResponse }
     * 
     */
    public EnviarColaMensajeResponse createEnviarColaMensajeResponse() {
        return new EnviarColaMensajeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarColaMensaje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "EnviarColaMensaje")
    public JAXBElement<EnviarColaMensaje> createEnviarColaMensaje(EnviarColaMensaje value) {
        return new JAXBElement<EnviarColaMensaje>(_EnviarColaMensaje_QNAME, EnviarColaMensaje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JMSException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "JMSException")
    public JAXBElement<JMSException> createJMSException(JMSException value) {
        return new JAXBElement<JMSException>(_JMSException_QNAME, JMSException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarColaMensajeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "EnviarColaMensajeResponse")
    public JAXBElement<EnviarColaMensajeResponse> createEnviarColaMensajeResponse(EnviarColaMensajeResponse value) {
        return new JAXBElement<EnviarColaMensajeResponse>(_EnviarColaMensajeResponse_QNAME, EnviarColaMensajeResponse.class, null, value);
    }

}
