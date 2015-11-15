package esb;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.ibm.icu.text.SimpleDateFormat;

@WebService(/*endpointInterface = "org.example.HelloWorld", */ serviceName = "servicioPagosESB")
public class ServicioPago {
	@WebMethod
	public String realizarPago (String idCompra, Long nroTarjetaCredito, double monto, Date fecha){
		//SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		//String fechaFormateada = format1.format(fecha);
		String fechaFormateada = "2015-01-01";
		return 
		"{" +
		"\"pago\": {" +
		"\"idCompra\":\"" + idCompra + "\"," +
		"\"nroTarjetaCredito\":\"" + nroTarjetaCredito + "\"," +
		"\"monto\":\"" + monto + "\"," +
		"\"fecha\":\"" + fechaFormateada +
		"\"}}";
				
				
	}

}
