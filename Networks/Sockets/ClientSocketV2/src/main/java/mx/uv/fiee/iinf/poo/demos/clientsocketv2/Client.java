package mx.uv.fiee.iinf.poo.demos.clientsocketv2;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * En esta versión del cliente se permite una conexión uno a uno
 * recibiendo mensajes del servidor y dando la capacidad al usuario de
 * responderlos.
 *
 * Los puntos principales son, el uso de un ciclo para controlar el flujo
 * de la aplicación, terminando hasta que se lee de la consola la palabra "stop".
 *
 * Para enviar y recibir mensajes es necesario utilizar ambos flujos proporcionados
 * por el socket, entrada mediante InputStream y salida mediante OutputStream.
*
* La entrada del usuario es manejado mediante el flujo de entrada de la consola
* referenciado por método "in", de la clase System.
*
*/
public class Client {
    public static String ADDRESS = "localhost";
    public static int PORT = 9888;
    
    public static void main(String [] args) {
        try {
            Socket socket = new Socket (ADDRESS, PORT);

            DataInputStream din = new DataInputStream (socket.getInputStream ());
            DataOutputStream dos = new DataOutputStream (socket.getOutputStream ());

            InputStreamReader in = new InputStreamReader (System.in, StandardCharsets.UTF_8);
            BufferedReader buff = new BufferedReader (in);

            String line1 = "", line2 = "";

            while (!line1.equals ("stop")) {
                System.out.print ("Message: ");
                line1 = buff.readLine ();

                boolean isFile = line1.contains ("file:");
                if (isFile) {
                    var filepath = Paths.get (line1.split (":")[1]);
                    if (!Files.exists (filepath) || Files.isDirectory (filepath)) {
                        System.out.println ("Invalid file!");
                        continue;
                    }

                    // filename to be used
                    dos.writeUTF ("file:" + filepath.getFileName ());
                    dos.flush ();

                    // lee el archivo y crea el buffer
                    FileInputStream fis = new FileInputStream (filepath.toFile ());
                    byte [] buffer = fis.readAllBytes ();

                    // envia el tamaño del buffer
                    dos.writeInt (buffer.length);
                    dos.flush ();
                    //envía los datos
                    dos.write (buffer, 0, buffer.length);
                    dos.flush ();

                    fis.close ();
                    System.out.println ("File sent!");
                    continue;
                }

                System.out.println ("sending...");
                dos.writeUTF (line1);
                dos.flush ();

                line2 = din.readUTF ();

                isFile = line2.contains ("file:");
                if (isFile) {
                    var filename = line2.split (":")[1];
                    System.out.println ("Receiving file: " + filename);

                    FileOutputStream fos = new FileOutputStream (Paths.get (filename).toFile ());

                    // creando el buffer a ser almacenado
                    int length = din.readInt ();
                    byte [] buffer = new byte [length];
                    din.readFully (buffer, 0, buffer.length);

                    // guardando los bytes
                    fos.write (buffer);
                    fos.flush ();
                    fos.close ();

                    System.out.println ("File saved!");
                    continue;
                }

                System.out.println ("Server says: " + line2);
            }

            din.close ();
            dos.close ();
            socket.close ();
            
        } catch (IOException ex) {
            ex.printStackTrace ();
        }
    }   
}