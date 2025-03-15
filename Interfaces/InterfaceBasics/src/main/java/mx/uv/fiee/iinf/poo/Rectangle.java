package mx.uv.fiee.iinf.poo;

import java.util.Objects;

/**
 * Representa un objeto rectangulo que implementa las interfaces Draw y Shape
 * por lo tanto, está oblidada a implementar los métodos que estas definen.
 *
 */
public class Rectangle implements Draw, Calculate, Comparable<Rectangle> {
    int x1, y1, x2, y2;
    double area;

    public Rectangle (int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /***
     * Sobreescribe los métodos definidos en la interfaz Draw
     */
    @Override
    public void paint () {
        String m = String.format ("Dibujando el rectangulo desde el punto (%d, %d) al punto (%d, %d)", x1, y1, x2, y2);
        System.out.println (m);
    }

    @Override
    public void fill () {
        System.out.println ("Rectángulo coloreado!");
    }
    /******/

    /**
     * Sobreescribe al método definido en la interfaz Shape
     */
    @Override
    public double calculateArea () {
        int base = x2 - x1;
        int altura = y2 - y1;
        this.area = base * altura;

        return  this.area;
    }

    @Override
    public int compareTo (Rectangle o) {
        return Double.compare (this.area, o.area);
    }
}