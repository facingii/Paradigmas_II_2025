package mx.uv.fiee.iinf.poo;

import java.util.*;
import java.util.function.BiConsumer;

public class Main {

    public static void main (String [] args) {
        System.out.println("--------------HASHMAP----------------");

        /**
         * se crea el objeto hashmap mediante el constructor predeterminado
         * lo que inicializa la estructura subyacente con 16 bloques iniciales y
         * un factor de carga de 0.75, de modo que al insertar 12 elementos la
         * estructura aumenta su capacidad al doble
         */
        HashMap<Integer, String> hashMap = new HashMap<> ();
        hashMap.put (200, "OK");
        hashMap.put (303, "See Other");
        hashMap.put (404, "Not Found");
        hashMap.put (500, "Internal Error");
        hashMap.put (403, "Forbidden");

        for (Integer key : hashMap.keySet ()) {
            System.out.println ("Key " + key + " Value " + hashMap.get (key));
        }


        System.out.println("--------------LINKEDMAP----------------");

        /**
         * utilizamos el constructor de la clase para definir un tamaño inicial de 5 bloques
         * para el array de keys, y un factor de carga de 0.6, con esto se logra que al insertar 3
         * elementos dicho array se expanda al doble
         */
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<> (5, 0.6f);
        linkedMap.put (200, "OK");
        linkedMap.put (303, "See Other");
        linkedMap.put (404, "Not Found");
        linkedMap.put (500, "Internal Error");
        linkedMap.put (403, "Forbidden");

        for (String value : linkedMap.values ()) {
            System.out.println ("Value " + value);
        }

        System.out.println ("Getting Internal server error description:  " + linkedMap.get (500));

        //System.out.println("--------------TREEMAP----------------");


        System.out.println("--------------TREEMAP----------------");
        /**
         * haciendo uso de la función estática reverseOrder del objeto Comparator
         * se ordenan los elementos insertados de forma inversa
         */
        TreeMap<Integer, String> treeMap = new TreeMap<> (Comparator.reverseOrder ());
        treeMap.put (200, "OK");
        treeMap.put (303, "See Other");
        treeMap.put (404, "Not Found");
        treeMap.put (500, "Internal Error");
        treeMap.put (403, "Forbidden");

        for (Map.Entry<Integer, String> entry: treeMap.entrySet ()) {
            System.out.printf ("Key: %d Value: %s \n", entry.getKey (), entry.getValue ());
        }
    }

}