package com.example.odontologos.model;

import java.time.LocalDate;
import java.util.List;

public class Paciente extends Persona {

    private LocalDate fechaAlta;

    private Domicilio domicilio;
    private int dni;

    public Paciente(String apellido, String nombre, Domicilio domicilio, int dni, LocalDate fechaAlta) {
        super(apellido, nombre);
        this.fechaAlta = fechaAlta;
        this.domicilio = domicilio;
        this.dni = dni;
    }

    public Paciente(String apellido, String nombre, int dni) {
        super(apellido, nombre);
        this.dni = dni;
    }

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

    public String getFechaAlta() {
        return fechaAlta.toString();
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


}
