package amazoniacentral;


import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jws.WebService;

import org.apache.activemq.ActiveMQConnectionFactory;

@WebService
public class EnvioJMS {
	
//	private final static Logger LOGGER = Logger.getLogger(EnvioJMS.class.getName()); 
	
	
	public long EnviarColaMensaje (long idReserva) throws JMSException{
		
//		enviarMensaje(idReserva);
		
		
		ResultadoAnulacion res = new ResultadoAnulacion();
		res.Codigo = "OK";
		res.descripcion = "";
		
		
//		String ret = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:impl=\"http://impl.stock.ws/\">" +
//				  "<soapenv:Header/><soapenv:Body><impl:anularReserva><!--Optional:--><arg0>9194086</arg0></impl:anularReserva></soapenv:Body></soapenv:Envelope>";
			
		return idReserva;
		
	}
	
	
//	public void enviarMensaje(String mensaje) throws JMSException{
//		
//		
//		
//		   ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
//	        Connection connection = connectionFactory.createConnection();
//	        connection.start();
//
//	        // JMS messages are sent and received using a Session. We will
//	        // create here a non-transactional session object. If you want
//	        // to use transactions you should set the first parameter to 'true'
//	        Session session = connection.createSession(false,
//	                Session.AUTO_ACKNOWLEDGE);
//
//	        Topic topic = session.createTopic("ActiveMQ");
//
//	        MessageProducer producer = session.createProducer(topic);
//
//	        // We will send a small text message saying 'Hello'
//
//	        TextMessage message = session.createTextMessage();
//
//	        message.setText("HELLO JMS WORLD");
//	        // Here we are sending the message!
//	        producer.send(message);
//	        System.out.println("Sent message '" + message.getText() + "'");
//
//	        connection.close();
//		
//		
//		
//	}
	

}
