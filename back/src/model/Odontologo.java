package model;

import java.util.List;

public class Odontologo extends Persona {

    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Odontologo(String apellido, String nombre, List listaTurnos, String matricula) {
        super(apellido, nombre, listaTurnos);
        this.matricula = matricula;
    }
}
