
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

    private final static QName _ObtenerStockResponseResponse_QNAME = new QName("http://amazoniacentral/", "obtenerStockResponseResponse");
	private final static QName _ObtenerStockResponse_QNAME = new QName("http://amazoniacentral/", "obtenerStockResponse");
	private final static QName _ConsultarStock_QNAME = new QName("http://amazoniacentral/", "consultarStock");
	private final static QName _ConsultarStockResponse_QNAME = new QName("http://amazoniacentral/", "consultarStockResponse");
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
     * Create an instance of {@link ObtenerStockResponse }
     * 
     */
    public ObtenerStockResponse createObtenerStockResponse() {
        return new ObtenerStockResponse();
    }

	/**
     * Create an instance of {@link ObtenerStockResponseResponse }
     * 
     */
    public ObtenerStockResponseResponse createObtenerStockResponseResponse() {
        return new ObtenerStockResponseResponse();
    }

	/**
     * Create an instance of {@link ConfirmacionResponse }
     * 
     */
    public ConfirmacionResponse createConfirmacionResponse() {
        return new ConfirmacionResponse();
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerStockResponseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "obtenerStockResponseResponse")
    public JAXBElement<ObtenerStockResponseResponse> createObtenerStockResponseResponse(ObtenerStockResponseResponse value) {
        return new JAXBElement<ObtenerStockResponseResponse>(_ObtenerStockResponseResponse_QNAME, ObtenerStockResponseResponse.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ObtenerStockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "obtenerStockResponse")
    public JAXBElement<ObtenerStockResponse> createObtenerStockResponse(ObtenerStockResponse value) {
        return new JAXBElement<ObtenerStockResponse>(_ObtenerStockResponse_QNAME, ObtenerStockResponse.class, null, value);
    }

	/**
     * Create an instance of {@link ConsultarStock }
     * 
     */
    public ConsultarStock createConsultarStock() {
        return new ConsultarStock();
    }

	/**
     * Create an instance of {@link ConsultarStockResponse }
     * 
     */
    public ConsultarStockResponse createConsultarStockResponse() {
        return new ConsultarStockResponse();
    }

	/**
     * Create an instance of {@link Compra }
     * 
     */
    public Compra createCompra() {
        return new Compra();
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarStock }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "consultarStock")
    public JAXBElement<ConsultarStock> createConsultarStock(ConsultarStock value) {
        return new JAXBElement<ConsultarStock>(_ConsultarStock_QNAME, ConsultarStock.class, null, value);
    }

	/**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarStockResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "consultarStockResponse")
    public JAXBElement<ConsultarStockResponse> createConsultarStockResponse(ConsultarStockResponse value) {
        return new JAXBElement<ConsultarStockResponse>(_ConsultarStockResponse_QNAME, ConsultarStockResponse.class, null, value);
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
//    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "EnviarColaMensaje")
    public JAXBElement<EnviarColaMensaje> createEnviarColaMensaje(EnviarColaMensaje value) {
        return new JAXBElement<EnviarColaMensaje>(_EnviarColaMensaje_QNAME, EnviarColaMensaje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JMSException }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "JMSException")
    public JAXBElement<JMSException> createJMSException(JMSException value) {
        return new JAXBElement<JMSException>(_JMSException_QNAME, JMSException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviarColaMensajeResponse }{@code >}}
     * 
     */
//    @XmlElementDecl(namespace = "http://amazoniacentral/", name = "EnviarColaMensajeResponse")
    public JAXBElement<EnviarColaMensajeResponse> createEnviarColaMensajeResponse(EnviarColaMensajeResponse value) {
        return new JAXBElement<EnviarColaMensajeResponse>(_EnviarColaMensajeResponse_QNAME, EnviarColaMensajeResponse.class, null, value);
    }

}
