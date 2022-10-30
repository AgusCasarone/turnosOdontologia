package model;

import java.util.Date;

public class Usuario {

    private String user, password;
    private Rol rol;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario(String user, String password, Rol rol, Turno turno) {
        this.user = user;
        this.password = password;
        this.rol = rol;
    }
}
