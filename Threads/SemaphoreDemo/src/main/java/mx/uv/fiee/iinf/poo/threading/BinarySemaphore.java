package mx.uv.fiee.iinf.poo.threading;

import java.util.concurrent.Semaphore;

public class BinarySemaphore {
    public static int accum;

    public static void main (String [] args) {
        var semaphore = new Semaphore (1);

        var t1 = new Thread (() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println ("Thread1 trying to adquire lock");
                    semaphore.acquire ();
                    System.out.println ("Thread1 adquire lock");
                    System.out.println ("Value accumulated by thread1: " + ++accum);
                    semaphore.release ();
                }
            } catch (InterruptedException ex) { ex.printStackTrace (); }
        });

        var t2 = new Thread (() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println("Thread 2 trying to adquire lock");
                    semaphore.acquire ();
                    System.out.println ("Thread2 adquire lock");
                    System.out.println ("Value accumulated by thread2: " + ++accum);
                    semaphore.release ();
                }
            } catch (InterruptedException ex) { ex.printStackTrace (); }
        });

        var t3 = new Thread (() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println ("Thread 3 trying to adquire lock");
                    semaphore.acquire ();
                    System.out.println ("Thread3 adquire lock");
                    System.out.println ("Value accumulated by thread3: " + ++accum);
                    semaphore.release ();
                }
            } catch (InterruptedException ex) { ex.printStackTrace (); }
        });

        t1.start ();
        t2.start ();
        t3.start ();
    }


}

