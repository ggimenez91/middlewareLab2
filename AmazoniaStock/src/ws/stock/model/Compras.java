package ws.stock.model;

import java.io.Serializable;
import java.util.List;

public class Compras implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	List<Compra> compras;	
	
	public Compras() {
		super();
	}

	public Compras(List<Compra> compras) {
		super();
		this.compras = compras;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compras == null) ? 0 : compras.hashCode());
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
		Compras other = (Compras) obj;
		if (compras == null) {
			if (other.compras != null)
				return false;
		} else if (!compras.equals(other.compras))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Compras [compras=" + compras + "]";
	}

	
	
}
