package mx.uv.fiee.iinf.poo.streamsadvanced;

import java.util.Arrays;
import java.util.List;

public class Reduce {
    public static void main (String [] args) {
        List<Person> persons = Arrays.asList (
                new Person ("Natasha", 25),
                new Person ("Wanda", 22),
                new Person ("Anthony", 45),
                new Person ("Steve", 97)
        );

        // SELECT name FROM Persons ORDER BY age ASC LIMIT 1
//        persons.stream ()
//                .reduce ((p1, p2) -> p1.age < p2.age ? p1 : p2)
//                .ifPresent (System.out::println);

//        Person pResult = persons.stream ().reduce (new Person ("", 0), (p1, p2) -> {
//            p1.age += p2.age;
//            p1.name += p2.name;
//            return p1;
//        });

        //System.out.printf ("name = %s, age = %s", pResult.name, pResult.age);
//
        int ageSum = persons.stream ().reduce  (0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);
        System.out.println (ageSum);
    }
    
    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return name;
        }
    }
    
}