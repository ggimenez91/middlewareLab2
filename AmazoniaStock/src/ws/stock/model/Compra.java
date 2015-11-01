package ws.stock.model;

import java.io.Serializable;


public class Compra implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	Long idProducto;
	Integer cantidad;
			
	public Compra() {
		super();		
	}

	public Compra(Long idProducto, Integer cantidad) {
		super();
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	
	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result
				+ ((idProducto == null) ? 0 : idProducto.hashCode());
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
		Compra other = (Compra) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (idProducto == null) {
			if (other.idProducto != null)
				return false;
		} else if (!idProducto.equals(other.idProducto))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Compra [idProducto=" + idProducto + ", cantidad=" + cantidad
				+ "]";
	}
	
	
	
}

