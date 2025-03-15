package mx.uv.fiee.iinf.poo;

import java.text.MessageFormat;
import java.util.Iterator;

public class Main {

    public static void main (String [] args) {
        Circle circle1 = new Circle (10, 10, 20);
        Circle circle2 = new Circle (15, 15, 21);
        Circle circle3 = new Circle (10, 10, 20);

        double d = circle1.calculateArea ();
        String message = MessageFormat.format ("The area for the Circle is {0}", d);
        //System.out.println (message);

        /*if (circle1.compareTo (circle2) == 0) {
            System.out.println ("Circles are equals");
        } else {
            System.out.println ("Circles are not equals");
        };*/

        circle3.calculateArea();

        if (circle1.equals(circle3)) {
            System.out.println ("Circles are equals");
        } else {
            System.out.println ("Circles are not equals");
        };

        var rectangle1 = new Rectangle (10, 10, 20, 20);
        var rectangle2 = new Rectangle (15, 15, 25, 25);

        d = rectangle1.calculateArea ();
        message = MessageFormat.format ("The area for the Rectangle is {0}", d);
        System.out.println (message);



        Shapes shapes = new Shapes();

        for (Draw item: shapes) {
            System.out.println(item);
        }
    }
}

class Shapes implements Iterable<Draw> {

    void add (Draw shape) {
        //add to storage
    }

    Draw get (int index) {
        return null;
    }

    @Override
    public Iterator<Draw> iterator() {
        return null;
    }
}





