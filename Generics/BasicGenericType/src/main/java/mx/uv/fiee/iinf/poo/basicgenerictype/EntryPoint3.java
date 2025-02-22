package mx.uv.fiee.iinf.poo.basicgenerictype;

//
// Objective: implement a generic stack that can store elements of any type and
// compare it with type-specific stacks
//

import java.util.ArrayList;

public class EntryPoint3 {

    public static void main(String[] args) {

        Stack<String> stringStack = new Stack<> ();
        Stack<Double> doubleStack = new Stack<> ();

        StringStack stringStack2 = new StringStack ();

        LightStack<Double, Integer> l = new LightStack<Double, Integer> ();
    }

}

class StringStack {

    ArrayList<String> container = new ArrayList<>();

    public void push (String item) {
        container.add (item);
    }

    public String pop () {
        return container.remove (container.size () - 1);
    }

    public boolean isEmpty () {
        return container.size () == 0;
    }

}

class IntegerStack {

    ArrayList<Integer> container = new ArrayList<>();

    public void push (Integer item) {
        container.add (item);
    }

    public Integer pop () {
        return container.remove (container.size () - 1);
    }

    public boolean isEmpty () {
        return container.size () == 0;
    }

}

class DocbleStack {

    ArrayList<Double> container = new ArrayList<>();

    public void push (Double item) {
        container.add (item);
    }

    public Double pop () {
        return container.remove (container.size () - 1);
    }

    public boolean isEmpty () {
        return container.size () == 0;
    }

}

class Stack<T> {

    ArrayList<T> container = new ArrayList<>();

    public void push (T item) {
        container.add (item);
    }

    public T pop () {
        return container.remove (container.size () - 1);
    }

    public boolean isEmpty () {
        return container.size () == 0;
    }

}

class LightStack<T, U> extends Stack<T> {

    ArrayList<U> container2 = new ArrayList<> ();

}













