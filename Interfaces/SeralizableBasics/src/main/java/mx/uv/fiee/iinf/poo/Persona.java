package mx.uv.fiee.iinf.poo;

import java.io.Serializable;

/**
 * implementa la interfaz serializable con el objetivo de persistir
 * la información hacia un archivo
 *
 * <a href="https://docs.oracle.com/javase/tutorial/javabeans/quick/index.html">java beans</a>
 * no confundir con EJB
 */
public class Persona implements Serializable {
    public static final long serialVersionUID = 15L;
    public static String pais = "MEXICO"; // los métodos estáticos no se serializan
    private String nombre;
    private String apellidos;
    private int edad;
    private transient int sueldo; // transient indica que valor del campo no se tome en cuenta

    private Address address;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public void setAddress (Address address) {
        this.address = address;
    }

    public Address getAddress () {
        return this.address;
    }
 }

class Address implements Serializable {
    public String calle;
    public String colonia;
    public int numero;
}