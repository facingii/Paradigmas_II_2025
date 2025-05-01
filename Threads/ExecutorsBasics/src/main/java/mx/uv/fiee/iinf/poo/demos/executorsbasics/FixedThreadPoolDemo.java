package mx.uv.fiee.iinf.poo.demos.executorsbasics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Implementación de executor basada en un FixedTheadPool, que utiliza un ThreadPool
 * con un número máximo de hilos.
 *
 * En este ejemplo creamos 3 tareas que serán pasadas al planificador del executor,
 * cuyo número de hilos será de dos.
 */
public class FixedThreadPoolDemo {
    
    public static void main (String [] args) {
        System.out.println ("Inside: " + Thread.currentThread ().getName ());
        
        System.out.println ("Creating executor service with a thread pool of size 2");
        // Crea el executor estableciendo el número de hilos en 2
        ExecutorService service = Executors.newFixedThreadPool (2);

        // Creamos las diferentes tareas que serán pasadas al servicio del executor,
        // y cuya lógica solo retrasa la ejecución del hilo actual durante 2 segundos.
        Runnable task1 = () -> {
            System.out.println ("Executing task 1 inside: " + Thread.currentThread ().getName ());
            
            try {
                // Utilizamos a la clase TimeUnit que representa periodos de tiempo, y ejecuta
                // operaciones de cronómetro y retraso.
                // Aquí retrasamos la ejecución del hilo durante 2 segundos.
                // el método SECONDS.sleep, invoca al método Thread.sleep
                TimeUnit.SECONDS.sleep (3);
            } catch (InterruptedException in) { in.printStackTrace (); }
        };
        
        Runnable task2 = () -> {
            System.out.println ("Executing task 2 inside: " + Thread.currentThread ().getName ());
            
            try {
                TimeUnit.SECONDS.sleep (2);
            } catch (InterruptedException in) { in.printStackTrace (); }
        };
        
        Runnable task3 = () -> {
            System.out.println ("Executing task 3 inside: " + Thread.currentThread ().getName ());
            
            try {
                TimeUnit.SECONDS.sleep (2);
            } catch (InterruptedException in) { in.printStackTrace (); }
        };
        
        
        System.out.println ("Add tasks to the service...");
        // agregamos las tareas al planificador, que se encargará de encolarlas y ejecutarlas
        service.submit (task1);
        service.submit (task2);
        service.submit (task3);

        System.out.println ("Shutting down executor service");
        service.shutdown (); // cerramos al planificador para recibir nuevas tareas
    }
    
}