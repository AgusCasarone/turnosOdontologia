package com.example.odontologos.model;

public class Domicilio {

    private String calle, localidad, provincia;


    private int id, numero;
    public int getId() {
        return id;
    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Domicilio(int id, String calle, String localidad, String provincia, int numero) {
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
        this.id = id;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "calle='" + calle + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", id=" + id +
                ", numero=" + numero +
                '}';
    }
}
