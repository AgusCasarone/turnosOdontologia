package com.example.odontologos.model;

import java.util.List;

public abstract class Persona {

    protected String apellido;
    protected String nombre;
    protected List<Turno> listaTurnos;

    public Persona(String apellido, String nombre, List<Turno> listaTurnos) {
        this(apellido, nombre);
        this.listaTurnos = listaTurnos;
    }

    public Persona(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
}
