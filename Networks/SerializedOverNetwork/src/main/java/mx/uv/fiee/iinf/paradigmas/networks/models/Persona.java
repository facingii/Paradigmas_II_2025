package mx.uv.fiee.iinf.paradigmas.networks.models;

import java.io.Serializable;

/**
 * Clase que representa una persona y que implementa la interfaz Serializable
 * para permitir su serialización.
 */
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    private String fullname;
    private int age;
    private String uuid;

    /**
     * Obtiene el nombre completo de la persona.
     * @return Nombre completo.
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * Establece el nombre completo de la persona.
     * @param fullname Nombre completo.
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * Obtiene la edad de la persona.
     * @return Edad.
     */
    public int getAge() {
        return age;
    }

    /**
     * Establece la edad de la persona.
     * @param age Edad.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Obtiene el UUID de la persona.
     * @return UUID.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Establece el UUID de la persona.
     * @param uuid UUID.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
