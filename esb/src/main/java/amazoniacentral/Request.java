package amazoniacentral;

import org.springframework.stereotype.Component;

public class Request {
	
	
//	
	public static String requestUno(long entrada)
	{
		
		String ret = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:impl=\"http://impl.stock.ws/\">" +
		  "<soapenv:Header/><soapenv:Body><impl:anularReserva><!--Optional:--><arg0>qwe</arg0></impl:anularReserva></soapenv:Body></soapenv:Envelope>";
		
		
//		String ret = "<impl:anularReserva><!--Optional:--><arg0>4901689</arg0></impl:anularReserva>";
//				
		return ret;
	}

}
