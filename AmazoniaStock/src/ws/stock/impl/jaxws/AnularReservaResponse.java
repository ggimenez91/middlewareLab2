
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

@XmlRootElement(name = "anularReservaResponse", namespace = "http://impl.stock.ws/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "anularReservaResponse", namespace = "http://impl.stock.ws/")

public class AnularReservaResponse {

    @XmlElement(name = "return")
    private ws.stock.model.AnulacionReservaResponse _return;

    public ws.stock.model.AnulacionReservaResponse getReturn() {
        return this._return;
    }

    public void setReturn(ws.stock.model.AnulacionReservaResponse new_return)  {
        this._return = new_return;
    }

}

