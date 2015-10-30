package edu.fing.middleware.entities;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement
public class PagoYa {

	private List<Pago> pagos;

	public List<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
	
	
}
