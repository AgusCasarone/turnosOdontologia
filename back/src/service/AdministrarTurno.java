package service;

import model.Odontologo;
import model.Paciente;
import model.Turno;
import model.Usuario;

import java.util.Date;

public abstract class AdministrarTurno implements ITurnosFacade{

    Usuario usuario;
    private Turno turno;


    public Turno generarTurno(Date fechaYHora, Paciente paciente, Odontologo odontologo) {
        if(usuario.getRol().equals("admin")) {
            return turno = new Turno(paciente, odontologo, fechaYHora);
        }
        return null;
    }
}
