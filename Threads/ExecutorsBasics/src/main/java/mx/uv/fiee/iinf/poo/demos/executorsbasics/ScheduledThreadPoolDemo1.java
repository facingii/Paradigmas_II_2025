package mx.uv.fiee.iinf.poo.demos.executorsbasics;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * Implementación de un executor basado en un ScheduledThreadPool, que permite
 * que las tareas se ejecuten progradas.
 *
 * La lógica de este ejemplo es la de crear una tarea que será pasada
 * al ejecutor, pero programada para ser ejecutada recurrentemente cada 2 segundos
 */
public class ScheduledThreadPoolDemo1 {
    
    public static void main (String [] args) {
        // creamos un executor basado en un scheduledthreadpool de un solo hilo
        ScheduledExecutorService service = Executors.newScheduledThreadPool (1);

        // preparamos una tarea para ser procesada por el executor
        Runnable task = () -> {
            System.out.println ("Executing task at " + System.nanoTime ());
        };
    
        System.out.println ("Task scheduled to be executed every 2 seconds with initial delay of 0");
        // programamos la ejecución de la tarea para ser ejecutada cada 2 con un retraso inicial
        // de 0 segundos, esto es, sin retraso inicial
        service.scheduleAtFixedRate (task, 0, 2, TimeUnit.SECONDS);

        // en este caso no podemos cerrar al planificador ya que esto
        // implica que no se agenden más tareas
        //service.shutdown ();
    }
    
}