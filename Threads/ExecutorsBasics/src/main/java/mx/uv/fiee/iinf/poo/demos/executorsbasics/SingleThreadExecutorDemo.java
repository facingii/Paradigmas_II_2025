package mx.uv.fiee.iinf.poo.demos.executorsbasics;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Implementación del executor que utiliza un SingleThreadPool, que internamente
 * mantiene un solo hilo para la ejecución de las tareas.
 *
 * Según la lógica del ejemplo, podrá notarse que las dos tareas enviadas
 * al executor son realizadas por el mismo hilo, una tras otra
 */
public class SingleThreadExecutorDemo {

    public static void main (String[] args) {
        //System.out.println ("Inside: " + Thread.currentThread ().getName ());
        
        System.out.println ("Creating Executor Service...");
        // creamos al servicio executor basada en un tipo SingleThreadExecutor
        ExecutorService service = Executors.newSingleThreadExecutor ();

        // La primer tarea solo realiza una pausa de 2 segundos dentro de un ciclo
        // de 5 iteraciones.
        //
        // Utilizamos al método estático currentThread para obtener información del hilo
        // que está ejecutando la tarea.
        System.out.println ("Creating Tasks...");
        Runnable task1 = () -> {
            System.out.printf ("\nTask 1 Inside: %s \n\n", Thread.currentThread ().getName ());
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep (2000);
                } catch (InterruptedException in) { in.printStackTrace (); }
            }
        };

        // La segunda tarea imprime por consola, la sumatoria de los números primos
        // menores a 100000
        Runnable task2 = () -> {
            System.out.printf ("Task 2 Inside: %s \n", Thread.currentThread ().getName ());

            int acum = 0;
            for (int i = 1; i <= 100000; i++) {
                if (isPrime (i)) {
                    acum += i;
                }
            }

            System.out.printf ("\tPrime numbers acum: %d \n", acum);
        };

        System.out.println ("Add tasks to the executor service");
        // el método submit envía las tareas a la cola del executor, quien dependiendo de la
        // disponibilidad del único hilo disponible, asigna la tarea o la pone en espera
        service.submit (task1);
        service.submit (task2);
        
        System.out.println ("Shutting down the executor");
        // el método shutdown previene que se agreguen más tareas al planificador
        // del executor, esperando la finalización de las tareas pendientes para liberar
        // sus recursos
        service.shutdown ();
    }

    /**
     * Valida si el número pasado es primo o no
     * @param num valor enteror a verificar
     * @return verdadero si es primo, falso sino lo es
     */
    private static boolean isPrime (int num) {
        if (num == 2) return true;

        if (num < 2 || num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }

        return true;
    }
    
}