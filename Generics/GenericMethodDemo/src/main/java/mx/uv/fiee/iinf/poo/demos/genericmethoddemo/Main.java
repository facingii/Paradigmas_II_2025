package mx.uv.fiee.iinf.poo.demos.genericmethoddemo;

import java.util.ArrayList;

public class Main {

    public static void main (String [] args) {
        ArrayList<Integer> intList = new ArrayList<> ();
        intList.add (10);
        intList.add (20);
        intList.add (30);
        intList.add (40);
        intList.add (50);
        
        System.out.println ("Lista original: " + intList);
        
        Utilities.<Integer>fill (intList, 500);
        
        System.out.println ("Lista modificada: " + intList + "\n");
        
        //podemos obviar la declaración de los tipos y dejar que el compilador los infiera a partir de los parámetros
        Double res = Utilities.multiply (intList, 2.5);
        System.out.println ("Resultado de la multiplicación: " + res);
    }
    
}