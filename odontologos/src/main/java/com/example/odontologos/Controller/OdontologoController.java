package com.example.odontologos.Controller;

import com.example.odontologos.dto.OdontologoDto;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.service.OdontologoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private static final Logger LOGGER = LogManager.getLogger(OdontologoController.class);

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping (value = "add")
    public ResponseEntity<OdontologoDto> addOdontologo(@RequestBody OdontologoDto odontologoDto) {
        LOGGER.info("Se creó un nuevo odontólogo");
        return ResponseEntity.ok(odontologoService.parseOdontologoEntityToDto(odontologoService.addOdontologo(odontologoDto)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Odontologo>> findOdontologoById(@PathVariable Integer id){
        if (odontologoService.findOdontologoById(id).isPresent()) {
            LOGGER.info(String.format("Se encontró el odontólogo con id %s", id));
            return ResponseEntity.ok(odontologoService.findOdontologoById(id));
        } else {
            LOGGER.error(String.format("No se encontró ningún odontólogo con id %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Odontologo> updateOdontologo(@PathVariable Integer id, @RequestBody OdontologoDto odontologoDto){
        if (odontologoService.findOdontologoById(id).isPresent()) {
            LOGGER.info(String.format("Se actualizó el odontólogo con id %s", id));
            odontologoDto.setId(id);
            return ResponseEntity.ok(odontologoService.addOdontologo(odontologoDto));
        } else {
            LOGGER.error(String.format("No se encontró ningún odontólogo con id %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Odontologo> deleteOdontologo(@PathVariable Integer id) {
        if (odontologoService.deleteOdontologo(id)) {
            LOGGER.info(String.format("Se eliminó el odontólogo con id %s", id));
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            LOGGER.error(String.format("No se encontró el odontólogo con id %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Odontologo>> listOdontologos(){
        return ResponseEntity.ok(odontologoService.listOdontologos());
    }
}
