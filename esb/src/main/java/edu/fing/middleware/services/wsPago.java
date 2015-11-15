package edu.fing.middleware.services;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class wsPago {

	@WebMethod	
	public String webPagoMethod(Pago p)
	{
		System.out.println(p.toString());
		
		String ret = "<pago><idCompra>" + 11 + "</idCompra><nroTarjetaCredito>" +
	      p.nroTarjetaCredito + "</nroTarjetaCredito><monto>" + p.monto + "</monto>"+
        "<fecha>" + p.fecha.toString() + "</fecha></pago>";
        
        return ret;
		
		
		
	}
}
