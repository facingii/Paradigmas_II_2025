package mx.uv.fiee.iinf.poo.demos.executorcallable;

import mx.uv.fiee.iinf.poo.demos.executorcallable.utils.HttpHandler;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main4 {

    public static void main(String[] args) {
        String url = "https://8f772cee268d493f9ec478a875331b83.api.mockbin.io/";


        /*
        CompletableFuture<Optional<String>> task = CompletableFuture.supplyAsync (() -> {
            System.out.println ("Executing in thread: " + Thread.currentThread ().getName ());

            try {
                var httpHandler = new HttpHandler (url);
                return Optional.of (httpHandler.call ());
            }
            catch (Exception ex) {
                ex.printStackTrace ();
            }

            return Optional.empty ();
        });

        task.thenAccept (result -> result.ifPresent (s -> {
            System.out.println ("Returning with result. I'm in thread: " + Thread.currentThread().getName ());
            System.out.println (s);
        }));
        */




        CompletableFuture<Optional<String>> task1 = CompletableFuture.supplyAsync (() -> {
            System.out.println ("Executing task1 in thread: " + Thread.currentThread ().getName ());

            try {
                var httpHandler = new HttpHandler (url);
                return Optional.of (httpHandler.call ());
            }
            catch (Exception ex) {
                ex.printStackTrace ();
            }

            return Optional.empty ();
        });

        CompletableFuture<Optional<String>> task2 = CompletableFuture.supplyAsync (() -> {
            System.out.println ("Executing task2 in thread: " + Thread.currentThread ().getName ());

            try {
                var httpHandler = new HttpHandler (url);
                return Optional.of (httpHandler.call ());
            }
            catch (Exception ex) {
                ex.printStackTrace ();
            }

            return Optional.empty ();
        });

        CompletableFuture<Optional<String>> task3 = CompletableFuture.supplyAsync (() -> {
            System.out.println ("Executing task3 in thread: " + Thread.currentThread ().getName ());

            try {
                var httpHandler = new HttpHandler (url);
                return Optional.of (httpHandler.call ());
            }
            catch (Exception ex) {
                ex.printStackTrace ();
            }

            return Optional.empty ();
        });

        CompletableFuture.allOf (task1, task2, task3)
                .thenRun (() -> {
                    try {
                        task1.get ().ifPresent(s -> System.out.printf ("Get text from task1:\n\t%s\nOn thread: \n\t%s\n", s, Thread.currentThread ().getName ()));
                        task1.get ().ifPresent(s -> System.out.printf ("Get text from task2:\n\t%s\nOn thread: \n\t%s\n", s, Thread.currentThread ().getName ()));
                        task1.get ().ifPresent(s -> System.out.printf ("Get text from task3:\n\t%s\nOn thread: \n\t%s\n", s, Thread.currentThread ().getName ()));
                    }
                    catch (InterruptedException | ExecutionException ie) {
                        ie.printStackTrace ();
                    }
                });



        // control loop in main thread showing up other tasks executing
        for (int i = 0; i < 10; i++) {
            System.out.println (i);
            try {
                Thread.sleep (1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }

}
