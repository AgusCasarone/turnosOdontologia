package com.example.odontologos.service;

import com.example.odontologos.model.Turno;
import com.example.odontologos.repository.IDao;
import com.example.odontologos.repository.impl.TurnoRepository;
import com.mashape.unirest.http.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class TurnoService {

    private ObjectMapper mapper;
    private IDao<Turno> turnoRepository;

    public void TurnosService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    public Turno guardar(Turno turno) {
        return this.turnoRepository.crear(turno);
    }

    public List<Turno> listar() {

        List<Turno> turnos = turnoRepository.listar();
        List<TurnoRepository> turnoRepositories = new ArrayList<TurnoRepository>();

        for (Turno turno :
            turnos ) {
            TurnoRepository tu
        }

        return turnoRepository.listar();
    }

    public Turno buscar(Integer id) {
        return turnoRepository.buscar(id);
    }
}
