package service;

import model.Persona;
import model.Usuario;
import org.apache.log4j.Logger;

import java.util.List;

public interface IPersonasFacade {

    Persona modificarPersona(Usuario usuario);

    List<Persona> listarPersonas(Usuario usuario);
    Boolean eliminarPersona(Usuario usuario);
}
