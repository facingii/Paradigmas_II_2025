package mx.uv.fiee.iinf.poo;

/**
 * Todas las interfaces que definen un único método se consideran funcionales,
 * esto es, su implementación puede ser reemplazada por una expresión (función) lambda
 */
interface MyMathLib {
    long pow (int exponent, int base);
}

/**
 * Clase concreta que implementa nuestra interfaz
 */
/*class MyMathClient implements MyMathLib {

    // sobreescribe al método de la interfaz, con lógica propia
    @Override
    public long pow (int exponent, int base) {
        System.out.printf ("Raising %d, %d exponent times - Inside MyMathClient Object\n", base, exponent);
        return 0;
    }

}*/

class Main {

    public static void main (String [] args) {
        // forma tradicional de crear un objeto
        /*MyMathClient client1 = new MyMathClient ();
        execute (client1);

        // el polimorfismo nos permite utilizar a la interfaz como tipo base para
        // la instanciación de aquellas clases que implementen a dicha interfaz
        MyMathLib client2 = new MyMathClient ();
        execute (client2);

        // esta forma es un 'atajo' que nos permite el compilador, ya que internamente
        // él se encarga de crear 'al vuelo' una clase que implemente a la interfaz utilizada como
        // tipo base, y le añade el código que estamos definiendo en el bloque de código
        //
        // tambièn es conocido como creación de objeto anónimo
        MyMathLib client3 = new MyMathLib () {
            @Override
            public long pow(int exponent, int base) {
                System.out.printf ("Raising %d, %d exponent times - Inside Anonymous Object\n", base, exponent);
                return 0;
            }
        };
        execute (client3);*/

        /**
         * Ya que la función execute recibe como parámetro a una intefaz con un único método, podemos utilizar una
         * expresión lambda que represente a un objeto del tipo de la interfaz y pasarla como parámetro.
         *
         * Dicha expresión es meramente una representación del único método que define a la interfaz, respetando sus
         * parámetros y tipo de retorno
         *
         * Los tipos de datos de los parámetros pueden obviarse, ya que el compilador los infiere de la firma del método
         */
        execute ( (exponent, base) -> {
            System.out.printf ("Raising %d, %d exponent times - Inside Lambda expression\n", base, exponent);
            return 0;
        } );

        /**
         * En esta otra forma se usa una expresión lambda de manera similar a la anterior, solo que en lugar de
         * pasar a la expresión como parámetro, esta se asigna a una variable cuyo tipo base es la interfaz misma.
         *
         * Dicha variable puede ser tratada entonces como un objeto cuya clase, aun sin definise realmente,
         * implementa a la interfaz en cuestión.
         */
        MyMathLib mm = (exponent, base) -> {
            System.out.printf ("Raising %d, %d exponent times - Inside Lambda Anonymous\n", base, exponent);
            return 0;
        };
        execute (mm);

    }

    /**
     * Esta función recibe un objeto cuya clase implemente a la interfaz MyMathLib y como conoce
     * la estructura de dicha interfaz, invoca a su método pow.
     *
     * @param client objeto a ejecutar
     */
    static void execute (MyMathLib client) {
        client.pow (2, 10);
    }
}