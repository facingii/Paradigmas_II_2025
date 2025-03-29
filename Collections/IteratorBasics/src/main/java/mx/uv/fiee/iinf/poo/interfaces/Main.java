package mx.uv.fiee.iinf.poo.interfaces;

import java.util.Iterator;

/**
 * Clase cliente
 */
public class Main {
    public static void main (String [] args) {
        // creamos al objeto que almacenará los objetos Film
        MyMarvelCollection collection = new MyMarvelCollection ();

        // agreamos algunos objetos Film al almacenamiento
        collection.add (new Film ("Ironman", 2008));
        collection.add (new Film ("Captain America", 2010));
        collection.add (new Film ("The Avengers", 2012));

        System.out.println ("Iterator Objet...");
        Iterator<Film> iterator = collection.iterator ();
        while (iterator.hasNext ()) {
            System.out.println (iterator.next ());
        }
        
        for (Film f: collection) {
            System.out.println (f);
        }
    }
}