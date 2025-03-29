package mx.uv.fiee.iinf.poo.interfaces;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Esta clase administra nuestra colección de objetos Film.
 *
 * Implementa la interfaz Iterable para darle la capacidad a la clase
 * de iterar a través de los elementos que almacena.
 *
 */
public class MyMarvelCollection implements Iterable<Film> {
    private ArrayList<Film> films; //almacenamiento interno de objetos Film

    public MyMarvelCollection () {
        films = new ArrayList<> (); // inicializa el almacenamiento interno
    }

    /**
     * Agrega un objeto Film al almacenamiento interno
     * @param film objeto a ser almacenado
     */
    public void add (Film film) {
        films.add (film);
    }

    /**
     * Elimina el objeto Film indicado de la colección
     *
     * @param film objeto a ser eliminado
     * @return verdadero si se elimina correctamente, falso en caso contrario
     */
    public boolean remove (Film film) {
        return films.remove (film);
    }

    /**
     * Estos métodos son utilizados con el único propósito
     * de obtener los elementos almacenados en el almacenamiento interno
     * recorriendolo mediante un ciclo for tradicional.
     *
     * El método get obtiene un objeto Film a parti de un índice específico
     *
     * @param index posición del elemento a ser recuperado
     * @return objeto Film almacenado en la posición indicada
     */
    /*public Film get (int index) {
        return films.get (index);
    }*/

    /**
     * Este método devuelve el tamaño actual del almacenamiento interno
     *
     * @return valor entero
     */
    /*public int size () {
       return films.size();
    }*/

    /**
     * Este método está definido en la interfaz Iterable y tiene como objetivo
     * devolver un objeto que implemente a la interfaz Iterator
     *
     * @return objeto iterador que tiene la capacidad de recorrer la estructura
     * interna de la colección
     */
    @Override
    public Iterator<Film> iterator () {
        /**
         * Dada la capacidad que nos brinda el compilador de crear un objeto
         * mediante la implementación anónima de la interfaz Iterator, devolvemos
         * directamente el resultado sin necesidad de crear clases adicionales
         */
        return new Iterator<Film> () {
            private int position = -1; // campo que mantiene referencia al último indice léido

            /**
             * Verifica que existan elementos a recorrer (leer), utilizando el campo position
             * como indicador de última posición
             *
             * @return verdadero si quedan elementos sin leer, falso en caso contrario
             */
            @Override
            public boolean hasNext () {
                return position < films.size () - 1;
            }

            /**
             * Devuelve el objeto Film apuntado por el campo position (+1)
             *
             * @return objeto almacenado
             */
            @Override
            public Film next () {
                position++;
                return films.get (position);
            }
        };
    }
}