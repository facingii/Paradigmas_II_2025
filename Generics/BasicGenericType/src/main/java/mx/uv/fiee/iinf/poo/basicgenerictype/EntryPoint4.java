package mx.uv.fiee.iinf.poo.basicgenerictype;

public class EntryPoint4 {

    public static void main(String[] args) {

        MyMath m = new MyMath();
        double result = m.divide (10.0, 2.3f);

        System.out.println(result);
    }

}

class MyMath {

    public <T extends Number> double divide (T a,T b) {
        double x = a.doubleValue();
        double y = b.doubleValue();

        return x / y;
    }

}