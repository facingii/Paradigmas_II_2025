package mx.uv.fiee.iinf.paradigmas.poo;

public class Main {

    public static void main (String [] args) {
        Integer [] values = {10, 1, 4, 6, 2, 6, 3, 8, 12, 5};
        MinMax<Integer> m = new MinMax<> (values);
        System.out.println (m.min ());
        System.out.println (m.max ());

        Character [] letters = { 'z', 'x', 'c', 'w', 'g', 'l', 'p', 'k', 'a', 't' };
        MinMax<Character> c = new MinMax<> (letters);
        System.out.println (c.min ());
        System.out.println (c.max ());

        Student [] students = {
                new Student ("Grissel", 28),
                new Student ("Cintya", 25),
                new Student ("Perla", 31)
        };

        MinMax<Student> e = new MinMax<Student> (students);
        System.out.println (e.min ());
        System.out.println (e.max ());
    }

}
