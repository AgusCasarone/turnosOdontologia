package com.example.odontologos.service;

import com.example.odontologos.dto.OdontologoDto;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private IOdontologoRepository odontologoRepository;

    public Odontologo addOdontologo(OdontologoDto odontologoDto) {

        Odontologo odontologoEntity = parseOdontologoDtoToEntity(odontologoDto);
        return odontologoRepository.save(odontologoEntity);
    }

    public Optional<Odontologo> findOdontologoById(Integer id) {
        return odontologoRepository.findById(id);
    }

    public boolean deleteOdontologo(Integer id){

        if (odontologoRepository.existsById(id)){
            odontologoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Odontologo> listOdontologos() {
        return odontologoRepository.findAll();
    }

    private Odontologo parseOdontologoDtoToEntity(OdontologoDto odontologoDto) {

        Odontologo odontologoEntity = new Odontologo();

        odontologoEntity.setId(odontologoDto.id);
        odontologoEntity.setApellido(odontologoDto.apellido);
        odontologoEntity.setNombre(odontologoDto.nombre);
        odontologoEntity.setMatricula(odontologoDto.matricula);

        return odontologoEntity;
    }

    public OdontologoDto parseOdontologoEntityToDto(Odontologo odontologoEntity) {

        OdontologoDto odontologoDto = new OdontologoDto();

        odontologoDto.id = odontologoEntity.getId();
        odontologoDto.nombre = odontologoEntity.getNombre();
        odontologoDto.apellido = odontologoEntity.getApellido();
        odontologoDto.matricula = odontologoEntity.getMatricula();

        return odontologoDto;
    }
}
