package ws.stock.model;

import java.io.Serializable;

public class ReservaResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String codigo;
	String descripcion;
	Long idReserva;
		
	
	public ReservaResponse() {
		super();
	}
	
	public ReservaResponse(String codigo, String descripcion, Long idReserva) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.idReserva = idReserva;
	}
	
	
	public ReservaResponse(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result
				+ ((idReserva == null) ? 0 : idReserva.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaResponse other = (ReservaResponse) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (idReserva == null) {
			if (other.idReserva != null)
				return false;
		} else if (!idReserva.equals(other.idReserva))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ReservaResponse [codigo=" + codigo + ", descripcion="
				+ descripcion + ", idReserva=" + idReserva + "]";
	}	
	
	
}
