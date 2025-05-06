package mx.uv.fiee.iinf.poo.threading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class CountTimingSemaphore {

    public static void main (String [] args) {
        var semaphore = new Semaphore (1);

        var t1 = new Thread (() -> {
            try {
                System.out.println ("Thread1 trying to adquire lock");
                if (semaphore.tryAcquire (2, TimeUnit.SECONDS)) {
                    System.out.println ("Thread1 lock adquired!");
                    Thread.sleep (5000);
                    semaphore.release ();
                }
            } catch (InterruptedException ex) { ex.printStackTrace (); }
        });

        var t2 = new Thread (() -> {
            try {
                System.out.println ("Thread2 trying to adquire lock");
                if (semaphore.tryAcquire (2, TimeUnit.SECONDS)) {
                    System.out.println ("Thread2 lock adquired!");
                    Thread.sleep (5000);
                    semaphore.release ();
                }
            } catch (InterruptedException ex) { ex.printStackTrace (); }
        });

        var t3 = new Thread (() -> {
            try {
                System.out.println ("Thread3 trying to adquire lock");
                if (semaphore.tryAcquire (2, TimeUnit.SECONDS)) {
                    System.out.println ("Thread3 lock adquired!");
                    semaphore.release ();
                }
            } catch (InterruptedException ex) { ex.printStackTrace (); }
        });

        var t4 = new Thread (() -> {
            try {
                System.out.println ("Thread4 trying to adquire lock");
                if (semaphore.tryAcquire (2, TimeUnit.SECONDS)) {
                    System.out.println ("Thread4 lock adquired!");
                    semaphore.release ();
                }
            } catch (InterruptedException ex) { ex.printStackTrace (); }
        });


        t1.start ();
        t2.start ();
        t3.start ();
        t4.start();
    }

}
