package ePuerto;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;


public class EscucharCarpetas {

   public static void escucharCarpeta(Path path) {
        RecibirOrden recibirOrden = new RecibirOrden();
        try {
            Boolean isFolder = (Boolean) Files.getAttribute(path,
                    "basic:isDirectory", NOFOLLOW_LINKS);
            if (!isFolder) {
                throw new IllegalArgumentException("Path: " + path
                        + " is not a folder");
            }
        } catch (IOException ioe) {
            // La carpeta no existe
            ioe.printStackTrace();
        }

        System.out.println("Escuchando en la ruta: " + path);
        FileSystem fs = path.getFileSystem();

        // Creamos el WatchService 
        try (WatchService service = fs.newWatchService()) {
        	
        	//Evento de creacion de archivos
            path.register(service, ENTRY_CREATE);

            WatchKey key = null;
            while (true) {
                key = service.take();

                // Desencolando eventos
                Kind<?> kind = null;
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    // Obtengo el tipo de evento
                    kind = watchEvent.kind();
                    if (OVERFLOW == kind) {
                        continue; // loop
                    } else if (ENTRY_CREATE == kind) {
                        // A new Path was created
                        Path newPath = ((WatchEvent<Path>) watchEvent)
                                .context();
                        // Proceso el pedido
                        recibirOrden.procesarArchivo(newPath.toString(),path.toString());      
                    }
                }

                if (!key.reset()) {
                    break; // loop
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}