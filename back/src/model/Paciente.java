package model;

import java.util.Date;
import java.util.List;

public class Paciente extends Persona {

    private String domicilio, dni;
    private Date fechaAlta;

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Paciente(String apellido, String nombre, List listaTurnos, String domicilio, String dni, Date fechaAlta) {
        super(apellido, nombre, listaTurnos);
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechaAlta = fechaAlta;
    }
}
