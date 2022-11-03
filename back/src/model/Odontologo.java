package model;

public class Odontologo extends Persona {

    private String matricula;
    private int id;

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Odontologo(String apellido, String nombre, String matricula) {
        super(apellido, nombre);
        this.matricula = matricula;
    }
}
