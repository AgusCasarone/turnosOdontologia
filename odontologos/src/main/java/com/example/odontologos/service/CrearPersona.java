package com.example.odontologos.service;


import com.example.odontologos.model.Domicilio;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.model.Paciente;
import com.example.odontologos.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;

public abstract class CrearPersona implements IUsuarioFacade{

    private static final Logger logger = LogManager.getLogger(CrearPersona.class);

    public Odontologo crearOdontologo(int id, String nombre, String apellido, int matricula, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info(String.format("Se creó un odontólogo con el nombre %s, el apellido %s y la matrícula %s por el usuario %s.", nombre, apellido, matricula, usuario));
            return new Odontologo(id, matricula, nombre, apellido);
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
