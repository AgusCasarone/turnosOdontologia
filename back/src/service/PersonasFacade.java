package service;

import model.Persona;
import model.Usuario;
import org.apache.log4j.Logger;

import java.util.List;

public class PersonasFacade implements IPersonasFacade{

    private static final Logger logger = Logger.getLogger(PersonasFacade.class);

    @Override
    public Persona modificarPersona(Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info("entre a crear personas");
            // logica de crear persona
        }
        return null;
    }

    @Override
    public List<Persona> listarPersonas(Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info("entre a crear personas");
            // logica de crear persona
        }
        return null;
    }

    @Override
    public Boolean eliminarPersona(Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info("entre a crear personas");
            // logica de crear persona
        }
        return null;
    }
}
