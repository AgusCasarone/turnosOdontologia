package service;

import model.*;
import org.apache.log4j.Logger;

import java.time.LocalDate;

public abstract class CrearPersona implements IUsuarioFacade{

    private static final Logger logger = Logger.getLogger(CrearPersona.class);

    public Odontologo crearOdontologo(String nombre, String apellido, String matricula, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info(String.format("Se creó un odontólogo con el nombre %s, el apellido %s y la matrícula %s por el usuario %s.", nombre, apellido, matricula, usuario));
            return new Odontologo(apellido, apellido, matricula);
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
}
