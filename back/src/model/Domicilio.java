package model;

public class Domicilio {
    private String calle, localidad, provincia;
    private int numero;

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

    public Domicilio(String calle, String localidad, String provincia, int numero) {
        this.calle = calle;
        this.localidad = localidad;
        this.provincia = provincia;
        this.numero = numero;
    }
}
