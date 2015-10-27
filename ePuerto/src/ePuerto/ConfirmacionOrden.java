package ePuerto;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ConfirmacionOrden {
	
	private int confirmarOrdenCSV(ArrayList<DataConfirmar> ordenes, String nombreArchivo) throws IOException
	{
		String COMMA_DELIMITER = ",";	
		String NEW_LINE_SEPARATOR = "\n";   
		FileWriter fileW = new FileWriter("C:\\FTPePuerto\\Confirmación\\confirmacion_" + nombreArchivo);
		try {
            for (DataConfirmar e : ordenes) {
            	fileW.append(e.idCompra);
            	fileW.append(COMMA_DELIMITER);	             	
            	fileW.append(e.idReserva);            	
            	fileW.append(COMMA_DELIMITER);	             	
            	fileW.append(String.valueOf(e.codResult));            		
            	fileW.append(COMMA_DELIMITER);	             	
            	fileW.append(e.descResult);
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
	
	public int confirmarOrden(ArrayList<DataConfirmar> elementos, String nombreArchivo)
	{	
		int result;
		try {
			result = confirmarOrdenCSV(elementos, nombreArchivo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}
}
