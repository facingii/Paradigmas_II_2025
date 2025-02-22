package mx.uv.fiee.iinf.poo.calculator;

public class Main {

    public static void main (String [] args) {
        Integer [] intNums = { 1, 2, 3, 4, 5 };
        Calculator<Integer> intCalc = new Calculator<Integer> (intNums);
        System.out.println (intCalc.average ());
        
        Double [] doubleNums = { 1.1, 2.2, 3.3, 4.4, 5.5 };
        Calculator<Double> doubleCalc = new Calculator<Double> (doubleNums);
        System.out.println (doubleCalc.average ());

        // esto debe fallar
//      String [] strNums = { "1", "2", "3", "4", "5" };
//      Calculator<String> strCalc = new Calculator<String> (strNums);
//      System.out.println (strCalc.average ());
    }
    
}