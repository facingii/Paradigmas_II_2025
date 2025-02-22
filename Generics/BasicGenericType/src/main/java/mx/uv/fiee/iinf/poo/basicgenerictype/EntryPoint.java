package mx.uv.fiee.iinf.poo.basicgenerictype;


import java.util.ArrayList;

class ObjectList {
    ArrayList container = new ArrayList ();

    public void add (Object item) {
        container.add (item);
    }
    public Object get (int index) {
        return container.get(index);
    }
}

public class EntryPoint {

    public static void main(String[] args) {
        ObjectList o = new ObjectList ();
        o.add(new Student ("Othon"));
        o.add(new Student("Oscar"));
        o.add(500);

        Student s = (Student) o.get(2);

        AnyList<Student> list = new AnyList<> ();
        list.add (new Student ("Valery")); //sin boxing
        list.add (new Student ("Vicky"));
        list.add (new Student ("Veronica"));
        //list.add(500);

        var list2 = new AnyList<Integer>();
        list2.add (5);

        Student foo = list.get (0); // Valery record… //sin conversiones
        System.out.println(foo);
    }

}

class Student {
    private String name;
    public Student (String _name) {
        name = _name;
    }

    @Override
    public String toString() {
        return name;
    }
}


class AnyList<T> {
    ArrayList<T> container = new ArrayList<> ();
    public void add (T item) {
        container.add (item);
    }
    public T get (int index) {
        return container.get(index);
    }
}
