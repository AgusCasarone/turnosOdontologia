package com.example.odontologos.service;

import com.example.odontologos.model.Turno;
import com.example.odontologos.repository.IDao;
import com.example.odontologos.repository.impl.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TurnoService {

    @Autowired
    private IDao<Turno> turnoRepository;

    public void TurnosService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardar(Turno turno) {
        return this.turnoRepository.crear(turno);
    }

    public List<Turno> listar() {
        return turnoRepository.listar();
    }

    public Turno buscar(Integer id) {
        return turnoRepository.buscar(id);
    }

    public boolean eliminar(int id) {
        return turnoRepository.eliminar(id);
    }

    public Turno actualizar(Turno turno){
        return turnoRepository.actualizar(turno);
    }
}
