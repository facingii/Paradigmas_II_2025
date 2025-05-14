package mx.uv.fiee.iinf.poo.streamsbasics;

import java.util.stream.Stream;

public class Main {

    public static void main (String [] args) {
//        Stream.of ("d2", "a2", "b1", "b3", "c")
//                .filter (s ->
//                        s.contains ("b")
//                )
//                .forEach (s -> {
//                    System.out.println ("Foreach:" + s);
//                });
//

//        Stream.of ("d2", "a2", "b1", "b3", "c", "a5")
//                .map (s -> {
//                    System.out.println ("map: " + s);
//                    return s.toUpperCase ();
//                })
//                .filter (s -> {
//                    System.out.println ("filter: " + s);
//                    return s.startsWith ("A");
//                })
//                .forEach(s -> {
//                    System.out.println ("Foreach:" + s);
//                });

//            Stream.of ("d2", "a2", "b1", "b3", "c")
//                .filter (s -> {
//                    System.out.println ("filter: " + s);
//                    return s.startsWith ("b");
//                })
//                .map (s -> {
//                    System.out.println ("map: " + s);
//                    return s.toUpperCase ();
//                })
//                .forEach(s -> {
//                    System.out.println ("Foreach:" + s);
//                });

//            Stream.of ("d2", "a2", "b1", "b3", "c")
//                    .sorted ((s1, s2) -> {
//                        System.out.printf ("Sort: %s, %s\n", s1, s2);
//                        return s1.compareTo (s2);
//                    })
//                    .filter (s -> {
//                        System.out.println ("filter: " + s);
//                        return s.startsWith ("a");
//                    })
//                    .map (s -> {
//                        System.out.println ("map: " + s);
//                        return s.toUpperCase ();
//                    })
//                    .forEach(s -> {
//                        System.out.println ("Foreach:" + s);
//                    });

            Stream.of ("d2", "a2", "b1", "b3", "b2", "c")
                    .filter (s -> {
                        System.out.println ("filter: " + s);
                        return s.startsWith ("b");
                    })
                    .sorted ((s1, s2) -> {
                        System.out.printf ("Sort: %s, %s\n", s1, s2);
                        return s1.compareTo (s2);
                    }) // b1, b3
                    .map (s -> {
                        System.out.println ("map: " + s);
                        return s.toUpperCase ();
                    })
                    .forEach(s -> {
                        System.out.println ("Foreach:" + s);
                    });

    }
    
}