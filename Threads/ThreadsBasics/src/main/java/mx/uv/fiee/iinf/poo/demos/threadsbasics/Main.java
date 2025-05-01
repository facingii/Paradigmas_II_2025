package mx.uv.fiee.iinf.poo.demos.threadsbasics;

import java.util.concurrent.Callable;

/**
 * Ejemplos demostrativos del trabajo multihilos
 *
 * La interfaz Runnable nos define una tarea, una porción de código que deseamos
 * que sea ejecutado. Nada diferente a lo que venimos haciendo, lo realmente importante
 * es el contexto donde se ejecutará tal código.
 *
 * La clase Thread por otra lado, implementa la interfaz Runnable, por lo tanto, incluye el
 * código que deseamos sea ejecutado, pero internamente realiza el trabajo necesario para
 * que dicho código sea ejecutado en un hilo paralelo al hilo desde dónde se invoca.
 *
 * Por otro lado, la clase Thread incluye varios métodos estáticos que nos ayudan con la
 * administración de los hilos.
 *
 */
public class Main {

    public static void main (String [] args) {
        /*****************************Creación de objetos de tipo Runnable************************/

        /**
         * creando un objeto de tipo Runnable a partir de una lambda
         */
        Runnable myRunna1 = () -> {
            /**
             * La lógica de este ejemplo es la ejecución de un ciclo, que itera en 5 ocasiones,
             * pausando la ejecución del hilo donde se ejecuta el código durante 1 segundo.
             */
            for (int i = 0; i < 5; i++) {
                // hacemos uso del método estático currentThread para obtener información del hijo en ejecución,
                // entre tal información, el nombre que el sistema le he asignado a dicho hilo
                System.out.println ("Inside Runnable 1 Name: " + Thread.currentThread ().getName () + " -> " + i);

                // es necesario envolver la llamada a Thread.sleep en una estructura try catch ya que es posible
                // que se produczca una excepción durante la espera...por ejemplo, un interrupción por parte del
                // usuario
                try {
                    // el método estático sleep, pausa la ejecución del hilo durante el tiempo especificado
                    Thread.sleep (1000);
                } catch (InterruptedException in) { in.printStackTrace (); }
            }
        };

        
        /**
         * creando un objeto anónimo de tipo Runnable a partir de una clase anónima
         */
        Runnable myRunna2 = new Runnable () {
            public void run () {
                for (int i = 0; i < 5; i++) {
                    System.out.println ("Inside Runnable 2 Name: " + Thread.currentThread ().getName () + " -> " + i);
                    try {
                       Thread.sleep (1000);
                    } catch (InterruptedException ex) { ex.printStackTrace (); }
                }
            }
        };

        /**
         * Utilizamos la clase que implementa Runnable para crear un objeto de este tipo.
         */
        Runnable foo = new Foo ();

        /*****************************************************************e************************/


        /******************************Creación de objetos de tipo Thread**************************/

        /**
         * Creando un objeto de tipo Thread pasando una expresión lambda como parámetro del constructor,
         * esto es posible ya que una de las sobrecargas recibe un objeto de tipo Runnable, que puede ser
         * creado mediante este forma
         */
        Thread myThread1 = new Thread (() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println ("Inside Thread 1 Name: " + Thread.currentThread ().getName () + " -> "+ i);
//                try {
//                    Thread.sleep (1000);
//                } catch (InterruptedException in) { in.printStackTrace (); }
            }
        });


        /**
         * Creando un objeto tipo Thread basado en un objeto Runnable ya existente.
         */
        Thread myThread2 = new Thread (foo);
        
        /**
         * Utilizamos la clase que hereda de Thread para crear un nuevo objeto
         */
        Thread bar = new Bar ();

        /*******************************************************************************************/

        System.out.println ("Starting execution...");

        // Runnables, ejecución sincrona
//        myRunna1.run ();
//        myRunna2.run ();
//        foo.run ();

        // Threads, ejecución asíncrona
        myThread1.start ();
        myThread2.start ();
        bar.start ();

        // para evitar que el hilo principal finalice antes que los hilos que
        // fueron lanzados, se invoca a la función join (), que le indica al sistema
        // que espere al hilo en ejecución antes de continuar con la ejecución del hilo
        // desde donde fue iniciado.
        try {
            myThread1.join ();
            myThread2.join ();
            bar.join ();
        } catch (InterruptedException ex) { ex.printStackTrace (); }

        System.out.println ("Terminated...");
    }

}


/**
 * Clase que implementa la interfaz Runnable, por lo que se está obligado a definir
 * al método abstracto "run"
 *
 */
class Foo implements Runnable {
    @Override
    public void run () {
        for (int i = 0; i < 5; i++) {
            System.out.println ("Inside Runnable Foo Name: " + Thread.currentThread ().getName () + " -> " + i);
//            try {
//                Thread.sleep (1000);
//            } catch (InterruptedException ex) { ex.printStackTrace (); }
        }
    }
}


/**
 * Clase que extiende la clase Thread.
 *
 * La clase Thread implementa a la interfaz Runnable, por tanto el código que deseamos que sea ejecutado
 * debe ser colocado en el método "run" definido en dicha interfaz, y que podemos sobreescribir.
 *
 */
class Bar extends Thread {
    @Override
    public void run () {
        super.run ();

        for (int i = 0; i < 5; i++) {
            System.out.println("Inside Thread-Bar Name: " + this.getName () + " -> " + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException in) { in.printStackTrace (); }
        }
    }
}

