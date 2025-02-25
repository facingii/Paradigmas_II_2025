package mx.uv.fiee.iinf.poo.boundedbyexample;

public class Calculator <T extends Number> {
    T [] nums;
    
    public Calculator (T [] n) {
        nums = n;
    }
    
    public double average () {
        double sum = 0.0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums [i].doubleValue ();
        }
        
        return sum / nums.length;
    }
}