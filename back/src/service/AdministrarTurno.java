package service;


import model.Odontologo;
import model.Paciente;
import model.Turno;
import model.Usuario;
import org.apache.log4j.Logger;

import java.util.Date;

public abstract class AdministrarTurno implements IUsuarioFacade {

    private static final Logger logger = Logger.getLogger(AdministrarTurno.class);

    public Turno generarTurno(Date fechaYHora, Paciente paciente, Odontologo odontologo, Usuario usuario) {
        if(usuario.getRol().getNombre().equals("admin")) {
            return new Turno(paciente, odontologo, fechaYHora);
        }
        return null;
    }
}
