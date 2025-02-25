package mx.uv.fiee.iinf.poo.boundedbyexample;

public class Calculator {
    //T [] nums;
    
    /*public Calculator (T [] n) {
        nums = n;
    }*/
    
    public <T extends Number> double average (T[] nums) {
        double sum = 0.0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums [i].doubleValue ();
        }
        
        return sum / nums.length;
    }
}