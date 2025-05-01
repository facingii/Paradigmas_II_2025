package mx.uv.fiee.iinf.poo.demos.executorsbasics;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Implementación de un executor basado en un ScheduledThreadPool, que permite
 * que las tareas se ejecuten progradas.
 *
 * La lógica de este ejemplo es la de crear una tarea que será pasada
 * al ejecutor, pero programada para ser ejecutada 3 segundos después de
 * ser asignada al hilo que la procesará
 */
public class ScheduledThreadPoolDemo {
    
    public static void main (String [] args) {
        // creamos un executor basado en un ScheduledThreadPool de un solo hilo
        ScheduledExecutorService service = Executors.newScheduledThreadPool (1);

        // preparamos una tarea para ser procesada por el executor
        Runnable task1 = () -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException in) {
                in.printStackTrace ();
            }
            System.out.println ("Executing task at " + System.nanoTime ());
        };

        System.out.println ("Submitting task at " + System.nanoTime () + " time, to be executed after 3 seconds");
        // programamos la ejecución de la tarea para ser ejecutada 3 segundos después de ser asignada
        // al hilo que la procesará
        service.schedule (task1, 10, TimeUnit.SECONDS);

        System.out.println ("Shutting down service preventing add new tasks");
        service.shutdown (); // cerramos al planificador del servicio, para no recibir más tareas

        try {
            // esperamos un tiempo de 5 segundos por la finalización de las tareas calendarizadas,
            // sino se han ejecutado en ese tiempo,
            if (!service.awaitTermination (10000, TimeUnit.MILLISECONDS)) {
                System.out.println ("Shutting down after wait 10000 milliseconds...");
                service.shutdownNow (); // cerramos el servicio inmediatamente
            }
        } catch (InterruptedException e) {
            // si se produce un excepción durante la espera por la finalización de las tareas,
            // forzamos el cierre del sercvicio de inmediato
            System.out.println ("Schedule interrupted, shutting down now...");
            service.shutdownNow ();
        }
    }
    
}