package mx.uv.fiee.iinf.poo.demos;

public abstract class Profesor extends Persona {
    private String idProfesor;
    
    public Profesor () {}
    
    public Profesor (String nombre, String apellidos, int edad, String id) {
        super (nombre, apellidos, edad);
    }

    public String getIdProfesor () {
        return idProfesor;
    }

    public void setIdProfesor (String idProfesor) {
        this.idProfesor = idProfesor;
    }
    
    public String mostrarDatos () {
        return this.getNombre () + this.getApellidos ();
    }
    
    public abstract double importeNomina ();
    
    @Override
    public String toString () {
        return this.getNombre() + " " + this.getApellidos();
    }
}
