package model;

import service.IPersonasFacade;

import java.util.List;

public abstract class Persona implements IPersonasFacade {

    private String apellido, nombre;
    private List listaTurnos;

    public Persona(String apellido, String nombre, List listaTurnos) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.listaTurnos = listaTurnos;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public List getListaTurnos() {
        return listaTurnos;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaTurnos(List listaTurnos) {
        this.listaTurnos = listaTurnos;
    }
}
