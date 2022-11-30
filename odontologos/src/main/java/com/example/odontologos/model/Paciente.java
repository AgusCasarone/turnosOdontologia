package com.example.odontologos.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int dni;
    private String nombre, apellido;

    @ManyToOne
    private Domicilio domicilio;
    private Date fechaDeAlta;

    public Paciente() {
    }

    public Paciente(Integer id, String apellido, String nombre, Domicilio domicilio, int dni, Date fechaDeAlta) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.fechaDeAlta = fechaDeAlta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public java.sql.Date getFechaDeAlta() {
        return fechaDeAlta;
    }

    public void setFechaDeAlta(Date fechaDeAlta) {
        this.fechaDeAlta = fechaDeAlta;
    }
}