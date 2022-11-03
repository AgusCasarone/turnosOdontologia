package service;

import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public abstract class CrearPersona implements IUsuarioFacade{
    public Odontologo crearOdontologo(String nombre, String apellido, String matricula, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            return new Odontologo(apellido, apellido, matricula);
        }
        return null;
    }

    public Paciente crearPaciente(String nombre, String apellido, Domicilio domicilio, LocalDate fechaAlta, int dni, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            return new Paciente(apellido, nombre, domicilio, dni, fechaAlta);
        }
        return null;
    }
}
