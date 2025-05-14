package mx.uv.fiee.iinf.poo.streamsadvanced;

import java.util.ArrayList;
import java.util.List;

public class FlatMap {
    
    public static void main (String [] args) {
        Person person1 = new Person ("Karen");
        person1.addTravel (new Travel ("England"));
        person1.addTravel (new Travel ("France"));
        
        Person person2 = new Person ("Anthony");
        person2.addTravel (new Travel ("Italy"));
        person2.addTravel (new Travel ("Netherlands"));
        
        List<Person> persons = new ArrayList<> ();
        persons.add (person1);
        persons.add (person2);

//        for (Person person: persons) {
//            for (Travel travel: person.getTravels ()) {
//                System.out.println (travel.getCountry ());
//            }
//        }
//
//        persons.forEach (p -> {
//            p.getTravels().forEach (c -> {
//                System.out.println (c.getCountry ());
//            });
//        });


//        persons.stream ()
//                .map (Person::getTravels)
//                .forEach (System.out::println);

//          persons.stream ()
//                  .map (p -> p.getTravels ())
//                  .flatMap (t -> t.stream ())
//                  .forEach (travel -> System.out.println (travel.getCountry ()));
                  
          persons.stream ()
                  .map (p -> p.getTravels ())
                  .flatMap (f -> f.stream ())
                  .map (travel -> travel.getCountry ())
                  .forEach (s -> System.out.println (s));

    }
    
    
    static class Person {
        private String name;
        private List<Travel> travels = new ArrayList<> ();

        public Person (String name) {
            this.name = name;
        }
        
        public void setName (String name) {
            this.name = name;
        }
        
        public String getName () {
            return this.name;
        }
        
        public void addTravel (Travel travel) {
            this.travels.add (travel);
        }
        
        public List<Travel> getTravels () {
            return this.travels;
        } 
    }
    
    
    static class Travel {
        private String country;
        
        public Travel (String country) {
            this.country = country;
        }
        
        public void setCountry (String country) {
            this.country = country;
        }
        
        public String getCountry () {
            return this.country;
        }

        @Override
        public String toString() {
            return "Travel{" +
                    "country='" + country + '\'' +
                    '}';
        }
    }
    
}
