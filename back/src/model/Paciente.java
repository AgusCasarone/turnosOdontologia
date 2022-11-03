package model;

import java.time.LocalDate;

public class Paciente extends Persona {

    LocalDate fechaAlta;

    private Domicilio domicilio;
    private int dni;

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Paciente(String apellido, String nombre, Domicilio domicilio, int dni, LocalDate fechaAlta) {
        super(apellido, nombre);
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }
}
