package com.example.odontologos.service;

import com.example.odontologos.model.Paciente;
import com.example.odontologos.repository.IDao;
import com.example.odontologos.repository.impl.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteService {

    @Autowired
    private IDao<Paciente> pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.crear(paciente);
    }

    public Paciente buscar(int id) {
        return pacienteRepository.buscar(id);
    }

    public Boolean eliminar(Integer id){
       return pacienteRepository.eliminar(id);
    }

    public Paciente actualizar(Paciente paciente){
        return pacienteRepository.actualizar(paciente);
    }

    public List<Paciente> listar() {
        return pacienteRepository.listar();
    }
}
