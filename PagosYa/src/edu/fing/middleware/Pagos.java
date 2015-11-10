package edu.fing.middleware;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBElement;

import edu.fing.middleware.entities.Pago;
import edu.fing.middleware.entities.PagoYa;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Pagos
 */
@Path("/Pagos")
public class Pagos {

	@GET
	@Path("/ping")
	@Produces(MediaType.APPLICATION_JSON)
	public Response ping() {
		JSONObject jsonObject = new JSONObject();
 		jsonObject.put("recibido", true);
 		return Response.status(200).entity(jsonObject.toString()).build();
 	}
	
	
	@POST
	@Path("/pagos")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response pagosYa(JAXBElement<PagoYa> element) throws JSONException {
		
		PagoYa pago = element.getValue();
		JSONObject jsonObject = new JSONObject();
		
		if (pago.getPago()/*.getIdCompra()*/ != null /*&& pago.getPago().getNroTarjetaCredito() != null
				&& pago.getPago().getMonto() != null && pago.getPago().getFecha() != null*/) {

			if (pago.getPago().getMonto() > 0) {
				
				if (pago.getPago().getIdCompra() != 1) {
					Random r = new Random();
		            Long number = r.nextLong();
					jsonObject.put("confirmacionPago", Math.abs(number));
					
					Logger.getGlobal().info("Pago satisfactorio: id: " + pago.getPago().getIdCompra()
                    + ";;tarjetaCredito: " + pago.getPago().getNroTarjetaCredito()
                    + ";;monto: " + pago.getPago().getMonto()
                    + ";;fecha: " + pago.getPago().getFecha());
					
					return Response.status(200).entity(jsonObject.toString()).build();
					
				} else {
					jsonObject.put("error", 902);
					jsonObject.put("descripcion", "El id de compra debe ser distinto de 1.");
					
					Logger.getGlobal().log(Level.WARNING, "Error al procesar pago: " + pago.getPago().getIdCompra()
                    + ". El id de compra debe ser distinto de 1.");
					
					return Response.status(400).entity(jsonObject.toString()).build();
				}
				
			} else {
				jsonObject.put("error", 901);
				jsonObject.put("descripcion", "El monto debe ser mayor a 0.");
				
				Logger.getGlobal().log(Level.WARNING, "Error al procesar pago: " + pago.getPago().getIdCompra()
                + ". El monto debe ser mayor a 0.");
				
				return Response.status(400).entity(jsonObject.toString()).build();
			}

		} else {
			jsonObject.put("error", 900);
			jsonObject.put("descripcion", "No hay pago para realizar.");
			
			Logger.getGlobal().log(Level.WARNING, "Error al procesar pago. No hay pago para realizar.");
			
			return Response.status(400).entity(jsonObject.toString()).build();
		}
	}
}
