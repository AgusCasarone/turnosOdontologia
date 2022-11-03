package service;

import model.Persona;

import java.util.List;

public interface IPersonasFacade {

    Persona modificarPersona();
    List listarPersonas();
    Boolean eliminarPersona();
}
