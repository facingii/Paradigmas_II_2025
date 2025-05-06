package mx.uv.fiee.iinf.poo.demos.executorcallable;

import mx.uv.fiee.iinf.poo.demos.executorcallable.utils.HttpHandler;

import java.util.concurrent.*;

public class Main2 {

    public static void main(String[] args) {
        String url = "";

        FutureTask<String> futureTask = new FutureTask<> (new HttpHandler(url));
        try (ExecutorService service = Executors.newSingleThreadExecutor ()) {
            service.submit (futureTask);

            // otros procesos
            // BD

            try {
                System.out.println("Getting text...");
                String foo = futureTask.get();
                System.out.printf ("Here is the text downloaded: \n\t%s", foo);
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }

            service.shutdown();
        }
    }

}

//async / await

