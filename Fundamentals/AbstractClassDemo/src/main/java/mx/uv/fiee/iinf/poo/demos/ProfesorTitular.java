package mx.uv.fiee.iinf.poo.demos;

public class ProfesorTitular extends Profesor {

    public ProfesorTitular (String n, String a, int e) {
        super (n, a, e, "001");
    }
    
    @Override
    public double importeNomina() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public String toString() {
//        return "" + this.getEdad(); //To change body of generated methods, choose Tools | Templates.
//    }

   
    
}
