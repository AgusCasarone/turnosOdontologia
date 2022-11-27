package com.example.odontologos.service;

import com.example.odontologos.dto.OdontologoDto;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.repository.impl.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OdontologoService {

    @Autowired
    private IOdontologoRepository IOdontologoRepository;

    public OdontologoService(com.example.odontologos.repository.impl.IOdontologoRepository IOdontologoRepository) {
        this.IOdontologoRepository = IOdontologoRepository;
    }

    public Odontologo save(OdontologoDto odontologoDto) {

        Odontologo odontologoEntity = parseDtoToEntity(odontologoDto);
        return IOdontologoRepository.save(odontologoEntity);
    }


    public List<Odontologo> listarOdontologos() {
        return IOdontologoRepository.findAll();
    }

    public Optional<Odontologo> findById(Integer id) {
        return IOdontologoRepository.findById(id);
    }

    public boolean deleteOdontologo(Integer id){

        if (IOdontologoRepository.existsById(id)){
            IOdontologoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }


    private Odontologo parseDtoToEntity(OdontologoDto odontologoDto) {

        Odontologo odontologoEntity = new Odontologo();

        odontologoEntity.setId(odontologoDto.id);
        odontologoEntity.setApellido(odontologoDto.apellido);
        odontologoEntity.setNombre(odontologoDto.nombre);
        odontologoEntity.setMatricula(odontologoDto.matricula);

        return odontologoEntity;
    }
}
