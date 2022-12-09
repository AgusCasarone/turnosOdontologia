package com.example.odontologos.Controller;

import com.example.odontologos.dto.DomicilioDto;
import com.example.odontologos.model.Domicilio;
import com.example.odontologos.service.DomicilioService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    private static final Logger LOGGER = LogManager.getLogger(DomicilioController.class);

    @Autowired
    private DomicilioService domicilioService;

    @PostMapping(value = "add")
    public ResponseEntity<Domicilio> addDomicilio(@RequestBody DomicilioDto domicilioDto) {
        LOGGER.info("Se creó un nuevo domicilio");
        return ResponseEntity.ok(domicilioService.addDomicilio(domicilioDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Domicilio>> findDomicilioById(@PathVariable Integer id){
        if (domicilioService.findDomicilioById(id).isPresent()) {
            LOGGER.info(String.format("Se encontró el domicilio con id %s", id));
            return ResponseEntity.ok(domicilioService.findDomicilioById(id));
        } else {
            LOGGER.error(String.format("No se encontró ningún domicilio con el id %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Domicilio> updateDomicilio(@PathVariable Integer id, @RequestBody DomicilioDto domicilioDto) {
        if (domicilioService.findDomicilioById(id).isPresent()) {
            excludeNullValues();
            LOGGER.info(String.format("Se actualizó el domicilio con id %s", id));
            domicilioDto.setId(id);
            return ResponseEntity.ok(domicilioService.addDomicilio(domicilioDto));
        } else {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Domicilio> deleteDomicilio(@PathVariable Integer id) {
        if (domicilioService.deleteDomicilio(id)) {
            LOGGER.info(String.format("Se eliminó el domicilio con id %s", id));
            return ResponseEntity.status(HttpStatus.OK).build();
        } else{
            LOGGER.error(String.format("No se encontró ningún comicilio con id %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Domicilio>> listDomicilios(){
        return ResponseEntity.ok(domicilioService.listDomiclios());
    }

    public void excludeNullValues() {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

}
