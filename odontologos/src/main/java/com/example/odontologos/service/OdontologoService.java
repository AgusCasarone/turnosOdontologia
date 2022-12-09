package com.example.odontologos.service;

import com.example.odontologos.dto.OdontologoDto;
import com.example.odontologos.exception.ResourceNotFoundException;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.repository.IOdontologoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private static final Logger LOGGER = LogManager.getLogger(OdontologoService.class);

    @Autowired
    private IOdontologoRepository odontologoRepository;

    public Odontologo addOdontologo(OdontologoDto odontologoDto) {

        LOGGER.info("Se creó un nuevo odontólogo");

        Odontologo odontologoEntity = parseOdontologoDtoToEntity(odontologoDto);
        return odontologoRepository.save(odontologoEntity);
    }

    public Optional<Odontologo> findOdontologoById(Integer id) {

        LOGGER.info(String.format("Se encontró el odontólogo con id %s", id));
        return odontologoRepository.findById(id);
    }

    public Odontologo updateOdontologo(OdontologoDto odontologoDtoEddit, Integer id) throws ResourceNotFoundException {

        OdontologoDto odontologoDtoOriginal = parseOdontologoEntityToDto(
                odontologoRepository.findById(id).orElseThrow(
                        () -> new ResourceNotFoundException("No se encontró el odontólogo")));

        if (odontologoDtoEddit.getMatricula() != null) {
            odontologoDtoOriginal.setMatricula(odontologoDtoEddit.getMatricula());
        }
        if (odontologoDtoEddit.getNombre() != null) {
            odontologoDtoOriginal.setNombre(odontologoDtoEddit.getNombre());
        }
        if (odontologoDtoEddit.getApellido() != null) {
            odontologoDtoOriginal.setApellido(odontologoDtoEddit.getApellido());
        }

        odontologoDtoOriginal.setId(id);

        LOGGER.info(String.format("Se actualizó el odontólogo con id %s", id));
        odontologoRepository.save(parseOdontologoDtoToEntity(odontologoDtoOriginal));
        return parseOdontologoDtoToEntity(odontologoDtoOriginal);
    }

    public boolean deleteOdontologo(Integer id){

        if (odontologoRepository.existsById(id)){
            LOGGER.info(String.format("Se eliminó el odontólogo con id %s", id));
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
