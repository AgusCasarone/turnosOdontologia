package service;

import model.Persona;
import model.Usuario;
import org.apache.log4j.Logger;

import java.util.List;

public interface IPersonasFacade {

    static final Logger logger = Logger.getLogger(IPersonasFacade.class);

    Persona modificarPersona(Usuario usuario);

    List listarPersonas(Usuario usuario);
    Boolean eliminarPersona(Usuario usuario);
}
