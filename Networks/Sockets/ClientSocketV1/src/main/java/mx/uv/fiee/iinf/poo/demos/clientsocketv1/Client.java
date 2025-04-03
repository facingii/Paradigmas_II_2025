package mx.uv.fiee.iinf.poo.demos.clientsocketv1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * La funcionalidad de está clase es la de conectar a un host remoto
 * indicado por la variable ADDRESS y el puerto a utilizar.
 *
 * Una vez realizada la conexión se abre el flujo de salida para enviar los datos
 * al host destino.
 *
 * La funcionalidad de envío de datos recae en las clases OutputStream y DataOutputStream,
 * que es la encargada de abrir el flujo de salida y escribir en el flujo, respectivamente.
 *
 * https://docs.oracle.com/javase/8/docs/api/java/io/OutputStream.html
 * https://docs.oracle.com/javase/8/docs/api/java/io/DataOutputStream.html
 *
 * Para este ejemplo se utiliza el método WriteUTF de la clase DataOutStream que codifica
 * los caracteres pasados como parámetros en un arreglo de bytes, y los coloca en el flujo
 * de salida.
 */
public class Client {
    public static String ADDRESS = "localhost"; // dirección remota donde deseamos conectarnos
    // puerto donde la aplicación remota escucha, si los puertos son diferentes
    // la conexión nunca se realizará
    public static int PORT = 19888;
    
    public static void main (String [] args) {
        
        try {
            System.out.printf ("Connecting to %s on PORT %d\n",ADDRESS, PORT);
            // para conectarnos a un host remoto debemos crear un
            // objeto Socket, indicándole la dirección y puerto remoto
            Socket socket = new Socket (ADDRESS, PORT);
            System.out.print ("Connected!\n\n");

            System.out.print ("Sending message to remote address\n\n");

            // ya que se realizó la conexión, es necesario obtener la referencia
            // al flujo de salida, para lo que se utiliza el método getOutputStream
            // y, ya que intentamos enviar caracteres, se utiliza la clase DataOutputStream
            // de modo que sea ella la que formatee los caracteres unicode al tipo byte
            DataOutputStream dos = new DataOutputStream (socket.getOutputStream ());
            dos.writeUTF ("Hello, from your client!"); // escribe en el buffer del flujo de salida
            dos.flush (); // el envío real, se realiza hasta que llamamos al método flush().
            dos.close (); // cerramos el flujo de salida

            System.out.print ("Closing connection.\n");
            socket.close (); // finalizamos la conexión
        } catch (IOException ex) {
            ex.printStackTrace ();
        }
        
    }
    
}