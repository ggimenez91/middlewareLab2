package ePuerto;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecibirOrden {
	  static Integer idReserva = 0;

	  public void procesarArchivo(String csvFile, String path) throws InterruptedException {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		boolean error = false;
		ArrayList<DataConfirmar> listaDatos = new ArrayList<DataConfirmar>();
		try {
			
			// Espero a que me deje leerlo 
			File source = new File(path + "\\" + csvFile);
			while(!source.renameTo(source)) {
		        Thread.sleep(10);
		    }
			
			br = new BufferedReader(new FileReader(path + "\\" + csvFile));
			int ind = 1;
			DataConfirmar dataConf;
			while (((line = br.readLine()) != null) && !error) {
				String[] linea = line.split(cvsSplitBy);
				// Control cantidad de campos
				if (linea.length != 3){
					System.out.println("Error: cantidad no permitida de campos encontrados en la línea" + ind);
					error = true;
				}else{
					ind++;
					System.out.println(linea[0] + "," + linea[1] + "," + linea[2]);
					// Creo elemento de archivo de confirmación
					dataConf = new DataConfirmar();
					dataConf.idCompra = linea[0];
					dataConf.idReserva = idReserva.toString();
					idReserva++;
					dataConf.codResult = 0;
					dataConf.descResult = "OK";
					listaDatos.add(dataConf);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
					// Muevo a archivos procesados
                    File source = new File(path + "\\" + csvFile);
                    File destination = new File("C:\\FTPePuerto\\Procesados" + "\\" + csvFile);
                    if (destination.exists()) {
                    	int num = 2;
                        while (destination.exists()){
                        	destination = new File("C:\\FTPePuerto\\Procesados" + "\\" + num + "_" + csvFile);
                        	num++;
                        }
                    }
                    source.renameTo(destination);
                    
					ConfirmacionOrden co = new ConfirmacionOrden();
					co.confirmarOrden(listaDatos,csvFile);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
	  
	private int crearOrdenCSV(ArrayList<DataOrden> ordenes) throws IOException
	{
		String COMMA_DELIMITER = ",";	
		String NEW_LINE_SEPARATOR = "\n";   
		FileWriter fileW = new FileWriter("orden.csv");
		try {	
            for (DataOrden e : ordenes) {
            	fileW.append(e.idCompra);
            	fileW.append(COMMA_DELIMITER);	 
            	fileW.append(String.valueOf(e.idProducto));            	
            	fileW.append(COMMA_DELIMITER);	             	
            	fileW.append(String.valueOf(e.cantidad));
            	fileW.append(NEW_LINE_SEPARATOR);
            }	         
		}
	   
		catch (Exception e) {			
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
		} 
		    
       try {
        	fileW.flush();
        	fileW.close();
	   } 
	   catch (IOException e) {
            System.out.println("Error while flushing/closing fileWriter !!!");
            e.printStackTrace();
       }
       return 0;
	}
	
	public int recibirOrden(ArrayList<DataOrden> elementos )
	{
		int result;
		try {
			result = crearOrdenCSV(elementos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}	
	  
}
