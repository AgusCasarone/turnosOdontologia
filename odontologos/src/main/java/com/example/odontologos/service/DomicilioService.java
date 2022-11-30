package com.example.odontologos.service;

import com.example.odontologos.dto.DomicilioDto;
import com.example.odontologos.dto.OdontologoDto;
import com.example.odontologos.model.Domicilio;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.repository.impl.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    public Domicilio addDomicilio(DomicilioDto domicilioDto) {

        Domicilio domicilioEntity = parseDomiciloDtoToEntity(domicilioDto);
        return domicilioRepository.save(domicilioEntity);
    }

    public Optional<Domicilio> findDomicilioById(Integer id) {
        return domicilioRepository.findById(id);
    }

    //Delete

    public boolean deleteDomicilio(Integer id) {
        if (domicilioRepository.existsById(id)) {
            domicilioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Domicilio> listDomiclios() {
        return domicilioRepository.findAll();
    }

    private Domicilio parseDomiciloDtoToEntity(DomicilioDto domicilioDto) {

        Domicilio domicilioEntity = new Domicilio();

        domicilioEntity.setId(domicilioDto.getId());
        domicilioEntity.setCalle(domicilioDto.getCalle());
        domicilioEntity.setNumero(domicilioDto.getNumero());
        domicilioEntity.setLocalidad(domicilioDto.getLocalidad());
        domicilioEntity.setProvincia(domicilioDto.getProvincia());

        return domicilioEntity;
    }

    //EntityToDto

    public Domicilio parseDomiciloEntityToDto(DomicilioDto domicilioDto) {

        Domicilio domicilioEntity = new Domicilio();

        domicilioEntity.setId(domicilioDto.getId());
        domicilioEntity.setCalle(domicilioDto.getCalle());
        domicilioEntity.setLocalidad(domicilioDto.getLocalidad());
        domicilioEntity.setNumero(domicilioDto.getNumero());
        domicilioEntity.setProvincia(domicilioDto.getProvincia());

        return domicilioEntity;

    }

}
