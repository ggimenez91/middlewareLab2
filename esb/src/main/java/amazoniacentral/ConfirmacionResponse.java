package amazoniacentral;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ConfirmacionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idCompra;
	private String idReserva;
	private Integer codResultado;
	private String descripcionResultado;	
	
	public String getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(String idCompra) {
		this.idCompra = idCompra;
	}
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public Integer getCodResultado() {
		return codResultado;
	}
	public void setCodResultado(Integer codResultado) {
		this.codResultado = codResultado;
	}
	public String getDescripcionResultado() {
		return descripcionResultado;
	}
	public void setDescripcionResultado(String descripcionResultado) {
		this.descripcionResultado = descripcionResultado;
	}	
}
