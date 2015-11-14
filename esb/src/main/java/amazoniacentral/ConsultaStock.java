package amazoniacentral;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class ConsultaStock {
	
	@WebMethod
	public Compra consultarStock (Compra c) {		
		return c;
	}
}
