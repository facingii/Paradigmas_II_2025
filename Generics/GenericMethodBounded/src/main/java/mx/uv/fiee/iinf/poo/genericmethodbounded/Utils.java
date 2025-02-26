package mx.uv.fiee.iinf.poo.genericmethodbounded;

import java.util.ArrayList;

public class Utils {
  
    public static <T> ArrayList<T> listCopy (ArrayList<? extends T> source, ArrayList<? super T> destination) {
        source.forEach (item -> {
            destination.add ((T) item);
        });
        
        return (ArrayList<T>) destination;
    }

}