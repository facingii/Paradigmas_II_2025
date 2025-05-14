package mx.uv.fiee.iinf.poo.streamsadvanced;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MyCollector {

    public static void main (String[] args) {
        List<Person> persons = Arrays.asList (
                new Person ("Natasha", 25),
                new Person ("Wanda", 22),
                new Person ("Anthony", 45),
                new Person ("Steve", 97),
                new Person ("Steve", 32)
        );
        
        persons.stream ()
                .filter (p -> p.name.startsWith ("S"))
                .collect (Collectors.toList ())
                .forEach (p -> System.out.println(p));

        var filtered = persons.stream ()
                .filter (p -> p.name.startsWith ("S"))
                .collect (Collectors.toList ());

        for (Person p: filtered) {
            System.out.println (p);
        }

        Map<String, List<Person>> personsByAge = persons.stream ()
                .collect (Collectors.groupingBy (p -> p.name));

        // natasha -> objeto natasha
        // steve -> objeto steve1, objeto steve 2
        // Wanda -> objeta wanda
        personsByAge.forEach ((k, v) -> {
            System.out.printf ("Name: %s: %s\n", k, v);
        });

//
//        Double averageAge = persons.stream ()
//                .collect (Collectors.averagingInt (p -> p.age));
//
//        System.out.printf ("Average Age: %s\n", averageAge);


//        String message = persons.stream ()
//                .filter (p -> p.age > 40)
//                .map (p -> p.name)
//                .collect (Collectors.joining (" and ", "In most countries in the world ", " are experienced adults."));
//
//
//        System.out.println (message);

//        Map<Integer, String> map = persons.stream ()
//                .collect (Collectors.toMap (
//                        p -> p.age,
//                        p -> p.name
//                ));
//
//        System.out.println (map);

        /**
         * Este collector personalizado crea un objeto StringJoiner, agrega al mismo el contenido del campo name 
         * del objeto Person (convertido a mayúsculas) y devuelve el resultado como una objeto String
         * 
         * https://docs.oracle.com/javase/8/docs/api/java/util/StringJoiner.html
         */
        /*Collector<Person, int[], Integer> personNameCollector =
                Collector.of (
                        () -> new int [1], //supplier
                        (sb, p) -> sb[0] += p.age, //sb.append (p.name.toUpperCase()), //accumulator
                        (sb1, sb2) -> { //combiner, only necessary for ParallelStreams
                            System.out.printf ("%s <--> %s\n", sb1.toString (), sb2.toString ());
                            //System.out.printf ("%s <--> %s, Thread counting: %s\n", j1.toString (), j2.toString (), Thread.currentThread().getName());
                            //return sb1.append (sb2);
                            return new int [1];
                        },
                        sb -> sb[0]
                        //StringJoiner::toString //finisher
                );*/

        //String inLineNames = persons.stream ()
        //        .collect (personNameCollector);
        //int inLineNames = persons.stream().collect(personNameCollector);
//
        //System.out.println (inLineNames);
        
        /**
         * Collector personalizado que suma los valores del campo age de los objetos Person
         * 
         * Debido a que se espera que el supplier sea una referencia mutable, utilizamos un array de enteros de una posición
         * para almacenar los valores de la suma
         * 
         * El acumulador únicamente suma las edades de cada objeto Person y almacena el resultado en el array
         * 
         * Debido a que el tipo devuelto por el finisher debe ser una referencia, utilizamos un tipo Integer para
         * envolver el resultado
         */
        // X [int]
        // int [] x = new int [1]
        // [93] -> storage
//        Collector<Person, int [], Integer> ageSumCollector = Collector.of (
//                () -> new int [1], //supplier (storage)
//                (intStore, person) -> intStore [0] += person.age, //acumulator
//                (vector1, vector2) -> { //combiner
//                    vector1 [0] += vector2 [0];
//                    return vector1;
//                },
//                result -> result [0] //finisher
//        );

//        int sum = persons.stream ().collect (ageSumCollector);
//        System.out.printf ("Sum of all person's age: %d\n", sum);
    }
}

class Person {
    String name;
    int age;
    
    Person (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}