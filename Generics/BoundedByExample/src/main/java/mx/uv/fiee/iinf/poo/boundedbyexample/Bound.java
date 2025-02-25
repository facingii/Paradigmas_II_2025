package mx.uv.fiee.iinf.poo.boundedbyexample;

public class Bound <T extends B> {
    private T ref;
    
    public Bound (T foo) {
        ref = foo;
    }
    
    public void doSomething () {
        this.ref.display ();
    }
}

class A {
    public void display () {
        System.out.println ("Desde la clase A");
    }
}

class B extends A {
    @Override
    public void display () {
        System.out.println ("Desde la clase B");
    }
}

class C extends A {
    @Override
    public void display () {
        System.out.println ("Desde la clase C");
    }
}
