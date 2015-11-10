package edu.fing.middleware.entities;

import java.util.Date;

public class Pago {

	private Long idCompra;


	private String nroTarjetaCredito;


	private Double monto;


	private Date fecha;
	
	
	public Pago() {
		super();
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public String getNroTarjetaCredito() {
		return nroTarjetaCredito;
	}

	public void setNroTarjetaCredito(String nroTarjetaCredito) {
		this.nroTarjetaCredito = nroTarjetaCredito;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}
