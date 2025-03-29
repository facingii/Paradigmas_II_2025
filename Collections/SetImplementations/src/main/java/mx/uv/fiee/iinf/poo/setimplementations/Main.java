package mx.uv.fiee.iinf.poo.setimplementations;

import java.util.*;

public class Main {

    public static void main (String [] args) {

        //var soccerTeams = new LinkedHashSet<String>();
        //var soccerTeams = new HashSet<String>();
        /*soccerTeams.add ("Liverpool");
        soccerTeams.add ("Manchester United");
        soccerTeams.add ("Barcelona");
        soccerTeams.add ("Real Madrid");
        soccerTeams.add ("Milan");
        soccerTeams.add ("Juventus");
        soccerTeams.add ("Juventus");
        soccerTeams.add (null);
        soccerTeams.add (null);*/

        /*for (String team: soccerTeams) {
            System.out.println (team);
        }*/

        //System.out.println(soccerTeams.contains("Juventus"));

        TreeSet<String> strings = new TreeSet<> (Collections.reverseOrder());
        strings.add("uno");
        strings.add("dos");
        strings.add("cuatro");
        strings.add("diez");

        for (String e: strings) {
            //System.out.println (e);
        }

        TreeSet<Employee> employees = new TreeSet<>();
        employees.add(new Employee("Juan", 1000.0));
        employees.add(new Employee("Pedro", 2000.0));
        employees.add(new Employee("Maria", 1500.0));
        employees.add(new Employee("Ana", 3000.0));

        for (Employee e: employees) {
            System.out.println (e.getName () + " " + e.getPayment ());
        }

    }

}


class Employee implements Comparable<Employee> {
    String name;
    Double payment;
    public Employee (String name, Double payment) {
        this.name = name;
        this.payment = payment;
    }
    public String getName () { return name; }
    public Double getPayment () { return payment; }

    @Override
    public int compareTo(Employee o) {
        return this.payment.compareTo (o.payment);
    }
}

class MyNameComparator implements Comparator<Employee> {
    @Override
    public int compare (Employee e1, Employee e2) {
            return e1.getName().compareTo (e2.getName ());
    }
}










