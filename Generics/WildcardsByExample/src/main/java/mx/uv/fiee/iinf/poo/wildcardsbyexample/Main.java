package mx.uv.fiee.iinf.poo.wildcardsbyexample;

import java.util.ArrayList;

public class Main {

    public static void main (String [] args) {
        ArrayList<A> listA = new ArrayList<A> ();
        listA.add (new A ());
        listA.add (new B ());
        listA.add (new C ());
        
        ArrayList<B> listB = new ArrayList<B> ();
        listB.add (new B ());
        listB.add (new B ());
        
        //System.out.println ("---print list of type A---");
        //processElements (listA);
        
        //System.out.println ("---print unknown list---");
        ArrayList<?> listUKnown = listA;
        //processElementsUK (listUKnown);
        
        //System.out.println ("---print unknown list extending A---");
        ArrayList<? extends A> listExtends = listB;
        //processElementsExtends (listExtends);
        
        System.out.println ("---print unknown list super A---");
        ArrayList<? super A> listSuper = listA;
        insertElements (listSuper);
        processElementsSuper (listSuper);
    }
    
    public static void processElements (ArrayList<A> elements) {
        for (A item: elements) {
            System.out.println ("\t" + item);
        }

        elements.add(new A());

        for (A item: elements) {
            System.out.println ("\t" + item);
        }
    }
    
    public static void processElementsUK (ArrayList<?> elements) {
        for (Object item: elements) {
            System.out.println ("\t" + item);
        }
    }
    
    public static void processElementsExtends (ArrayList<? extends A> elements) {
        for (A item: elements) {
            System.out.println ("\t" + item);
        }
    }
    
    public static void insertElements (ArrayList<? super A> list) {
        list.add (new B ());
        list.add (new C ());
        list.add (new A ());
    }
    
    public static void processElementsSuper (ArrayList<? super A> elements) {
        for (Object item: elements) {
            System.out.println ("\t" + item);
        }
    }
}


