package mx.uv.fiee.iinf.poo.basicgenerictype;

import java.util.ArrayList;

public class EntryPoint2 {

    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<> ();
        intList.add (10);
        intList.add (20);

        Utilities.fill("Hola", 12.0);

        //Double d = Utilities.<Integer, Double>multiply (intList, 2);
        //System.out.println ("Resultado: " + d);

        var result = Utilities.calculateExponent (30);
        System.out.println(result);
    }

}

class Utilities {
    public static <T, U> Double multiply(ArrayList<T> list, U val) {
        Double result = 0.0;

        for (int i = 0; i < list.size(); i++) {
            System.out.println (list.get(i));
            Double bar = ((Number) list.get(i)).doubleValue();
            System.out.println (bar);
            Double foo = ((Number) val).doubleValue();
            result += (bar * foo);
        }
        return result;
    }

    public static <T> void fill (T key, T val)
    {
        System.out.println (key.getClass().getTypeName());
        System.out.println (val.getClass().getTypeName());

        if (key instanceof String) {
            System.out.println ("Es un string");
        }

        if (val instanceof Double) {
            System.out.println ("Es un double");
        }
    }

    public static <T extends Integer> Double calculateExponent (T parameter) {
        var type = parameter.getClass().getName();
        System.out.println(type);

        return Math.pow (parameter, 10);
    }
}












