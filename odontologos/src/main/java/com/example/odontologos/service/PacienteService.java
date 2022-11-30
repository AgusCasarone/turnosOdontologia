package com.example.odontologos.service;

import com.example.odontologos.dto.PacienteDto;
import com.example.odontologos.model.Paciente;
import com.example.odontologos.repository.impl.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    public Paciente addPaciente(PacienteDto pacienteDto) {

        Paciente pacienteEntity = parsePacienteDtoToEntity(pacienteDto);
        return pacienteRepository.save(pacienteEntity);
    }

    public Optional<Paciente> findPacienteById(Integer id) {
        return pacienteRepository.findById(id);
    }

    public Boolean deletePaciente(Integer id){
        if (pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Paciente> listPacientes() {
        return pacienteRepository.findAll();
    }



    public Paciente parsePacienteDtoToEntity(PacienteDto pacienteDto) {

        Paciente pacienteEntity = new Paciente();

        pacienteEntity.setId(pacienteDto.getId());
        pacienteEntity.setApellido(pacienteDto.getApellido());
        pacienteEntity.setNombre(pacienteDto.getNombre());
        pacienteEntity.setDni(pacienteDto.getDni());
        pacienteEntity.setDomicilio(pacienteDto.getDomicilio());
        pacienteEntity.setFechaDeAlta(pacienteDto.getFechaDeAlta());

        return pacienteEntity;
    }

    public PacienteDto parsePacienteEntityToDto(Paciente pacienteEntity) {
        PacienteDto pacienteDto = new PacienteDto();

        pacienteDto.setId(pacienteEntity.getId());
        pacienteDto.setApellido(pacienteEntity.getApellido());
        pacienteDto.setNombre(pacienteEntity.getNombre());
        pacienteDto.setDni(pacienteEntity.getDni());
        pacienteDto.setDomicilio(pacienteEntity.getDomicilio());
        pacienteDto.setFechaDeAlta(pacienteEntity.getFechaDeAlta());

        return pacienteDto;
    }
}
