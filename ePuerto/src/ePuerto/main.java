package ePuerto;

import java.io.File;

public class main {
    public static void main(String[] args) {
	    //RecibirOrden obj = new RecibirOrden();
	   // obj.procesarArchivo("solicitud.csv");
    	EscucharCarpetas ec = new EscucharCarpetas();
    	File dir = new File("C:\\FTPePuerto\\Recepción");
    	ec.escucharCarpeta(dir.toPath());
	}
}
