package com.example.odontologos.model;

import com.example.odontologos.service.CrearPersona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

public class Usuario {

    private String user, password;
    private Rol rol;
    private int id;

    private static final Logger logger = LogManager.getLogger(CrearPersona.class);

    public Odontologo crearOdontologo(int id, String nombre, String apellido, int matricula, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info(String.format("Se creó un odontólogo con el nombre %s, el apellido %s y la matrícula %s por el usuario %s.", nombre, apellido, matricula, usuario));
            return new Odontologo(id, matricula, nombre, apellido);
        }
        logger.info(String.format("No se pudo crear el odontólogo porque el usuario %s no tiene acceso.", usuario));
        return null;

    }

    public Paciente crearPaciente(String nombre, String apellido, String domicilio, Date fechaAlta, int dni, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info(String.format("Se creó un paciente con el nombre %s, el apellido %s, la fecha de alta %s y el DNI %s por el usuario %s", nombre, apellido, fechaAlta, dni, usuario));
            return new Paciente(1, apellido, nombre, domicilio, dni, fechaAlta);
        }
        logger.info(String.format("No se pudo crear el odontólogo porque el usuario %s no tiene acceso.", usuario));
        return null;
    }

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

    public Usuario(String user, String password, Rol rol) {
        this.user = user;
        this.password = password;
        this.rol = rol;
    }

    public int getId() {
        return id;
    }
}
