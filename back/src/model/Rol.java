package model;

public class Rol {
    private String nombre;

    public int getId() {
        return id;
    }

    private int id;

    public Rol(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
}
