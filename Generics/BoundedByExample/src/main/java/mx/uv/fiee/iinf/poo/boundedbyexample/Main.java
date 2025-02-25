package mx.uv.fiee.iinf.poo.boundedbyexample;

public class Main {

    public static void main (String [] args) {
        Bound<C> boundC = new Bound<C> (new C ());
        boundC.doSomething ();
        
        Bound<B> boundB = new Bound<B> (new B ());
        boundB.doSomething ();
        
        Bound<A> boundA = new Bound<A> (new A ());
        boundA.doSomething ();
        
        //Bound<String> boundString = new Bound<String> (new String ());
        //boundString.doSomething ();
        
        Integer [] intNums = { 1, 2, 3, 4, 5 };
        /*Calculator<Integer> intCalc = new Calculator<Integer> (intNums);
        System.out.println (intCalc.average ());*/
        
        Double [] doubleNums = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        /*Calculator<Double> doubleCalc = new Calculator<Double> (doubleNums);
        System.out.println (doubleCalc.average ());*/

        Calculator c = new Calculator();
        //System.out.println (c.<Integer>average (intNums));






    }
    
}