package mx.uv.fiee.iinf.poo.demos.executorcallable;

import mx.uv.fiee.iinf.poo.demos.executorcallable.complementary.MyAsync;
import mx.uv.fiee.iinf.poo.demos.executorcallable.interfaces.TaskDone;
import mx.uv.fiee.iinf.poo.demos.executorcallable.utils.HttpHandler;

import java.util.concurrent.*;

public class Main3 {

    public static void main (String [] args) {
        String url = "";

        try (ExecutorService service = Executors.newSingleThreadExecutor()) {
            MyAsync async = new MyAsync(new HttpHandler(url));
            async.setTaskDoneListener(new TaskDone() {
                @Override
                public void finish() {
                    try {
                        String bar = async.get();
                        System.out.println(bar);
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            System.out.println("Submiting...");
            service.submit(async);
            System.out.println("Executing...");
            service.shutdown();
        }
        System.out.println ("Scheduler close...");

        System.out.println ("Counting within main thread");
        for (int i = 0; i < 10; i++) {
            System.out.println (i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) { ex.printStackTrace (); }
        }
    }

}



