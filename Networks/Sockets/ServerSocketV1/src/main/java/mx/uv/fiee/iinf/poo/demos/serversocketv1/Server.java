package mx.uv.fiee.iinf.poo.demos.serversocketv1;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase demostrativa de los fundamentos del manejo de Sockets de tipo Servidor.
 *
 * La funcionalidad es abrir un socket en el equipo local, en un puerto
 * determinado y esperar a que algún cliente se conecte.
 *
 * Las tareas de recepción de datos recaen en las clase InputStream y DataInputStream,
 * que se encarga de abrir el flujo de entrada y de leer de él, respectivamente.
 *
 * https://docs.oracle.com/javase/8/docs/api/java/io/InputStream.html
 * https://docs.oracle.com/javase/8/docs/api/java/io/DataInputStream.html
 *
 * Una vez realizada la conexión, se invoca al método getInputStream que
 * abre el flujo de entrada para recibir bytes, pero no realiza la lectura.
 *
 * Los bytes son leídos por la clase DataInputStream se encarga de
 * convertirlo en su representación hexadecimal. Y ya que se esperan caracteres
 * es posible obtener la entrada en su forma unicode mediate el método
 * readUTF() del DataInputStream.
 */
public class Server {
    public static int PORT = 19888; // puerto donde se realiza la escucha
    
    public static void main (String [] args) {
        
        try {
            System.out.println ("Listening in port " + PORT);

            // creamos un objeto ServerSocket en un puerto
            // predterminado
            ServerSocket server = new ServerSocket (PORT);

            // el método accept del objeto ServerSocket creado
            // pone a la ejecución en espera
            // hasta que se produzca una conexión
            // para finalizar la espera es necesaria una interrupción
            // por parte del usuario
            Socket socket = server.accept ();

            // una vez realizada la conexión, se abre el flujo de entrada
            // pero no se realiza ninguna lectura
            InputStream in = socket.getInputStream ();

            // la clase DataInputStream se encarga de procesar los
            // bytes entrantes
            DataInputStream dis = new DataInputStream (in);

            // el método readUTF(), se usa para obtener los datos entrantes con
            // códificación de caracteres unicode
            String message = dis.readUTF ();
            dis.close (); // finalmente se cierra el flujo
            
            System.out.println (message);
            
            server.close (); // y se finaliza el socket
        } catch (IOException ioex) {
            ioex.printStackTrace ();
        }
    }
    
}