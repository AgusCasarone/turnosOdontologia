package service;

import model.Persona;

import java.util.List;

public interface IPersonasFacade {

    // Persona administrarPersona(Persona persona);
    List<Persona> listaDePersonas(List listaDePersonas);
    Persona agregarPersona();
    Persona modificarPersona();
    List listarPersonas(List listaDePersonas);
    Boolean eliminarPersona();



}
