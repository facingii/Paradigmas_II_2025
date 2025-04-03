package mx.uv.fiee.iinf.poo.demos.serversocketv2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * En esta versión del servidor se permite una conexión uno a uno
 * recibiendo mensajes del cliente y dando la capacidad al usuario de
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
public class Server {
    public static int PORT = 9888;
    
    public static void main(String[] args) {
        try {
            System.out.println ("Listening in port " + PORT);
            ServerSocket server = new ServerSocket (PORT);
            Socket socket = server.accept ();

            DataInputStream din = new DataInputStream (socket.getInputStream ());
            DataOutputStream dos = new DataOutputStream (socket.getOutputStream ());
            InputStreamReader in = new InputStreamReader (System.in, StandardCharsets.UTF_8);
            BufferedReader buff = new BufferedReader (in);
            String line1 = "", line2 = "";

            while (!line1.equals ("stop")) {
                System.out.println ("Listening");
                line1 = din.readUTF ();

                boolean isFile = line1.contains ("file:");
                if (isFile) {
                    var filename = line1.split (":")[1];
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

                System.out.println ("Client says " + line1);
                
                System.out.print ("Response: ");
                // lee la entrada del usuario, el flujo de la aplicación se detiene
                line2 = buff.readLine ();

                isFile = line2.contains ("file:");
                if (isFile) {
                    var filepath = Paths.get (line2.split (":")[1]);
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

                dos.writeUTF (line2);
                dos.flush ();
            }

            din.close ();
            dos.close ();
            server.close ();
        } catch (IOException ex) {
            ex.printStackTrace ();
        }
    }
}