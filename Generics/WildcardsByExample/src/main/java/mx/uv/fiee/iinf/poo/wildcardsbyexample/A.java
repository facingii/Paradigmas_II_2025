package mx.uv.fiee.iinf.poo.wildcardsbyexample;

public class A {
    @Override public String toString () {
        return "I'm class A object";
    }
}

class B extends A {
    @Override public String toString () {
        return "I'm class B object";
    }
}

class C extends A {
    @Override public String toString () {
        return "I'm class C object";
    }
}