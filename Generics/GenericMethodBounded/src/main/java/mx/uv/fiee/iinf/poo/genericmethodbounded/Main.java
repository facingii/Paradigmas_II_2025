package mx.uv.fiee.iinf.poo.genericmethodbounded;

import java.util.ArrayList;

public class Main {

    public static void main (String [] args) {
        ArrayList<Integer> source = new ArrayList<> ();
        source.add (10);
        source.add (20);
        source.add (30);
        source.add (40);
        source.add (50);
        
        ArrayList<Object> destination = new ArrayList<> ();
        destination.add (10.10);
        destination.add (20.20);
        destination.add (30.30);
        
        ArrayList<Number> result =  Utils.<Number>listCopy (source, destination);
        
        for (Object item: result) {
            System.out.println (item.toString ());
        }
    }
    
}