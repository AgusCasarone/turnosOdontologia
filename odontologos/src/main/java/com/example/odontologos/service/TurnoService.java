package com.example.odontologos.service;

import com.example.odontologos.dto.TurnoDto;
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

    public Turno guardar(TurnoDto turnoDto) {
        Turno turnoEntity = parseTurnoDtoToEntity(turnoDto);
        return this.turnoRepository.save(turnoEntity);
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


    private Turno parseTurnoDtoToEntity(TurnoDto turnoDto) {

        Turno turnoEntity = new Turno();

        turnoEntity.setId(turnoDto.getId());
        turnoEntity.setOdontologo(turnoDto.getOdontologo());
        turnoEntity.setPaciente(turnoDto.getPaciente());
        turnoEntity.setFecha(turnoDto.getFecha());
        turnoEntity.setHora(turnoDto.getHora());

        return turnoEntity;
    }

    public TurnoDto parseTurnoEntityToDto(Turno turnoEntity) {

        TurnoDto turnoDto = new TurnoDto();

        turnoDto.setId(turnoEntity.getId());
        turnoDto.setFecha(turnoEntity.getFecha());
        turnoDto.setHora(turnoEntity.getHora());
        turnoDto.setOdontologo(turnoEntity.getOdontologo());
        turnoDto.setPaciente(turnoEntity.getPaciente());

        return turnoDto;

    }
}
