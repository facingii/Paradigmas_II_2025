package mx.uv.fiee.iinf.poo.parallelstreams;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Main {

    public static void main (String [] args) {
        List<String> strings = Arrays.asList ("a", "b", "c", "d", "e", "f", "g", "h", "cc", "dd", "ddd", "ccc");
        /*System.out.println ("------------ejecución secuencial------------");
        execute (strings.stream ());
        System.out.println ("------------ejecución paralela------------");
        execute (strings.parallelStream ());*/
        
        
        strings.parallelStream ()
                .filter (s -> {
                    System.out.println ("Filter " + LocalTime.now () + " - value: " + s + " - thread: " + Thread.currentThread ().getName ());
                    return s.contains ("c") || s.contains ("d");
                })
                .map (s -> {
                    System.out.println ("Map " + LocalTime.now () + " - value: " + s + " - thread: " + Thread.currentThread ().getName ());
                    return s.toUpperCase ();
                })
                .forEach (s -> {
                    System.out.println ("For " + LocalTime.now () + " - value: " + s + " - thread: " + Thread.currentThread ().getName ());
                    System.out.println ("Located value " + s);
                });
                
    }
 
    private static void execute (Stream<String> stream) {
        stream.forEach (item -> {
            System.out.println (LocalTime.now () + " - value: " + item + " - thread: " + Thread.currentThread ().getName ());
            
            try {
                Thread.sleep (200);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        });
    }
}
