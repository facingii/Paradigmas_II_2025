package mx.uv.fiee.iinf.poo;

import java.io.*;

public class Main {

    public static void main (String[] args) throws IOException, ClassNotFoundException {
        String filepath = "persona.dat";

        // crea un objeto persona asignando valores a sus campos
//        Persona p = new Persona ();
//        p.setNombre ("Zack");
//        p.setApellidos ("Snyder");
//        p.setEdad (46);
//        p.setSueldo (180000);
//
//        Address address = new Address ();
//        address.calle = "sdsd";
//        address.colonia = "fdfdf";
//        address.numero = 344;
//
//        p.setAddress (address);

        // para realizar la serialización del objeto se utiliza la clase ObjectOutputStream
        // utilizando el flujo de salida hacia el archivo deseado
//        FileOutputStream fos = new FileOutputStream (filepath);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream (fos);
        // el método write escribe el objeto, su estructura y los valores de los campos
//        objectOutputStream.writeObject (p);
//        objectOutputStream.flush ();
//        objectOutputStream.close ();

        // para deserializar el archivo se utiliza a clase ObjectInputStream que mediante
        // el método readObject crea una instancia a partir de la estructura de la información
        // almacenada en el archivo de entrada
        FileInputStream fis = new FileInputStream (filepath);
        ObjectInputStream objectInputStream = new ObjectInputStream (fis);
        // el cast es necesario ya que la lectura del archivo produce un objeto basado en la clase Object
        Persona p1 = (Persona) objectInputStream.readObject ();

        String foo = String.format ("Nombre: %s\nApellidos: %s\nEdad: %d\nSueldo: %d\nCalle: %s",
                p1.getNombre (), p1.getApellidos (), p1.getEdad (), p1.getSueldo (), p1.getAddress().calle);

        System.out.println (foo);
    }

}

