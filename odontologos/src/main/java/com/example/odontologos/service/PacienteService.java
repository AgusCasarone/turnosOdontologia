package com.example.odontologos.service;

import com.example.odontologos.model.Paciente;
import com.example.odontologos.repository.impl.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> findById(Integer id) {
        return pacienteRepository.findById(id);
    }

    public Boolean eliminar(Integer id){
        if (pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /* public Paciente actualizar(Integer paciente){
        return pacienteRepository.;
    } */

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }
}
