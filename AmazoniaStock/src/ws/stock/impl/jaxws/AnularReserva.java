
package ws.stock.impl.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.17
 * Sun Nov 01 16:51:19 UYST 2015
 * Generated source version: 2.7.17
 */

@XmlRootElement(name = "anularReserva", namespace = "http://impl.stock.ws/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anularReserva", namespace = "http://impl.stock.ws/")

public class AnularReserva {

    @XmlElement(name = "arg0")
    private java.lang.Long arg0;

    public java.lang.Long getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.Long newArg0)  {
        this.arg0 = newArg0;
    }

}

