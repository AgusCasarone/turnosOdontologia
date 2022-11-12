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
            logger.info(String.format("El usuario %s modificó una persona.", usuario));
            // logica de crear persona
        }
        logger.info(String.format("No se pudo modificar la persona porque el usuario %s no tiene acceso.", usuario));
        return null;
    }

    @Override
    public List<Persona> listarPersonas(Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info(String.format("El usuario %s creó una persona.", usuario));
            // logica de crear persona
        }
        logger.info(String.format("No se pudo crear la persona porque el usuario %s no tiene acceso.", usuario));
        return null;
    }

    @Override
    public Boolean eliminarPersona(Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            logger.info(String.format("El usuario %s eliminó una persona.", usuario));
            // logica de crear persona
        }
        logger.info(String.format("No se pudo eliminar la persona porque el usuario %s no tiene acceso.", usuario));
        return null;
    }
}
