package com.example.odontologos.service;

import com.example.odontologos.model.Turno;
import com.example.odontologos.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    public void TurnosService(ITurnoRepository ITurnoRepository) {
        this.turnoRepository = ITurnoRepository;
    }

    public Turno guardar(Turno turno) {
        return this.turnoRepository.save(turno);
    }

    public List<Turno> listar() {
        return turnoRepository.findAll();
    }

    public Optional<Turno> buscar(Integer id) {
        return turnoRepository.findById(id);
    }

    public boolean eliminar(Integer id) {
        if (turnoRepository.existsById(id)){
            turnoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /* public Turno actualizar(Turno turno){
        return turnoRepository.actualizar(turno);
    } */
}
