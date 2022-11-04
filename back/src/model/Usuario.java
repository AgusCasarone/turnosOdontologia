package model;

import org.apache.log4j.Logger;
import service.CrearPersona;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Usuario {

    private String user, password;
    private Rol rol;
    private int id;

    private static final Logger logger = Logger.getLogger(CrearPersona.class);

    public Odontologo crearOdontologo(String nombre, String apellido, String matricula, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info(String.format("Se creó un odontólogo con el nombre %s, el apellido %s y la matrícula %s por el usuario %s.", nombre, apellido, matricula, usuario));
            return new Odontologo(apellido, nombre, matricula);
        }
        logger.info(String.format("No se pudo crear el odontólogo porque el usuario %s no tiene acceso.", usuario));
        return null;

    }

    public Paciente crearPaciente(String nombre, String apellido, Domicilio domicilio, LocalDate fechaAlta, int dni, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info(String.format("Se creó un paciente con el nombre %s, el apellido %s, la fecha de alta %s y el DNI %s por el usuario %s", nombre, apellido, fechaAlta, dni, usuario));
            return new Paciente(apellido, nombre, domicilio, dni, fechaAlta);
        }
        logger.info(String.format("No se pudo crear el odontólogo porque el usuario %s no tiene acceso.", usuario));
        return null;
    }

    public Turno generarTurno(LocalDateTime fechaYHora, Paciente paciente, Odontologo odontologo) {
        return new Turno(paciente, odontologo, fechaYHora);
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
