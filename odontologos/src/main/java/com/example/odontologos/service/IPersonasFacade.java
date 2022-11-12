package service;

import model.Persona;
import model.Usuario;

import java.util.List;

public interface IPersonasFacade {

    Persona modificarPersona(Usuario usuario);

    List<Persona> listarPersonas(Usuario usuario);
    Boolean eliminarPersona(Usuario usuario);
}
