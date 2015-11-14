
package amazoniacentral;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para confirmacionResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="confirmacionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idCompra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codResultado" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="descripcionResultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "confirmacionResponse", propOrder = {
    "idCompra",
    "idReserva",
    "codResultado",
    "descripcionResultado"
})
public class ConfirmacionResponse {

    protected String idCompra;
    protected String idReserva;
    protected Integer codResultado;
    protected String descripcionResultado;

    /**
     * Obtiene el valor de la propiedad idCompra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCompra() {
        return idCompra;
    }

    /**
     * Define el valor de la propiedad idCompra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCompra(String value) {
        this.idCompra = value;
    }

    /**
     * Obtiene el valor de la propiedad idReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdReserva() {
        return idReserva;
    }

    /**
     * Define el valor de la propiedad idReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdReserva(String value) {
        this.idReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad codResultado.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCodResultado() {
        return codResultado;
    }

    /**
     * Define el valor de la propiedad codResultado.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCodResultado(Integer value) {
        this.codResultado = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcionResultado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionResultado() {
        return descripcionResultado;
    }

    /**
     * Define el valor de la propiedad descripcionResultado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionResultado(String value) {
        this.descripcionResultado = value;
    }

}
