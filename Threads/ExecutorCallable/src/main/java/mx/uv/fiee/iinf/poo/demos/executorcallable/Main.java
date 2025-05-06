package mx.uv.fiee.iinf.poo.demos.executorcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Main {

    public static void main (String [] args) {
        
         // Defines a Callable object in Java that sleeps for a specified duration and then returns a string.
        Callable<String> callOne = new Callable<String> () {
            @Override
            public String call() throws Exception {
                Thread.sleep (5000);
                return "perkatgr@y";
            }
        };
        
        
        Callable<Double> callTwo = () -> {
            Thread.sleep (2000);
            return Math.PI;
        };


        try (ExecutorService executor = Executors.newSingleThreadExecutor ()) {
            Future<String> strFuture = executor.submit (callOne);
            Future<Double> dblFuture = executor.submit (callTwo);

            // other tasks - main THREAD is available

            System.out.println("Main thread...getting results...");

            try {
                System.out.println("first result set");
                String foo = strFuture.get(); // bloqueante
                System.out.println("Result: " + foo);

                System.out.println("second result set");
                Double bar = dblFuture.get();
                System.out.println("Result: " + bar);
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

            executor.shutdown();
        }
    }
    
}
