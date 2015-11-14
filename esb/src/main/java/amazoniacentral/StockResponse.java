package amazoniacentral;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class StockResponse {
	
	private String fileSeparator = System.getProperty("file.separator");
	private String confirmacionFolder = "C:"+fileSeparator+"ePuerto"+fileSeparator+"Confirmacion";
	
	@WebMethod
	public ConfirmacionResponse obtenerStockResponse(String idCompra) {
		String csvFile = confirmacionFolder+fileSeparator+idCompra+".csv";
		System.out.println("Inicio Ejecucion");
		System.out.println(csvFile);
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		while (br == null) {
			try {
				FileReader fr = new FileReader(csvFile);
				br = new BufferedReader(fr);
				int i = 0;
				while ((line = br.readLine()) != null) {
			        // use comma as separator
					String [] response = line.split(cvsSplitBy);
					
					if (i == 1) {
						response = line.split(cvsSplitBy);
						ConfirmacionResponse confResponse = new ConfirmacionResponse();
						confResponse.setCodResultado(Integer.valueOf(response[2].replaceAll("\\s+","")));
						confResponse.setDescripcionResultado(response[3].replaceAll("\\s+",""));
						confResponse.setIdCompra(response[0].replaceAll("\\s+",""));
						confResponse.setIdReserva(response[1].replaceAll("\\s+",""));
		
						return confResponse;
					}			
					i++;
				}	
			} catch (FileNotFoundException e) {
				// Si no encuentro el archivo vuelvo a iterar.
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;		
	}
}
