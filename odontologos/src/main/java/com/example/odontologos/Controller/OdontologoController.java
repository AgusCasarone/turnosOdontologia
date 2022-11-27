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
        return ResponseEntity.ok(parseEntityToDto(odontologoService.save(odontologoDto)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Odontologo>> findById(@PathVariable Integer id){
        if (odontologoService.findById(id).isPresent()) {
            LOGGER.info("Se encontró el odontólogo el odontólogo con id %s" + id);
            return ResponseEntity.ok(odontologoService.findById(id));
        } else {
            LOGGER.error("No se encontró ningún odontólogo con id %s" + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Odontologo> updateOdontologo(@PathVariable Integer id, @RequestBody OdontologoDto odontologoDto){
        if (odontologoService.findById(id).isPresent()) {
            LOGGER.info("Se actualizó el odontólogo con id %s" + id);
            odontologoDto.setId(id);
            return ResponseEntity.ok(odontologoService.save(odontologoDto));
        } else {
            LOGGER.error("No se encontró ningún odontólogo con id %s" + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    private OdontologoDto parseEntityToDto(Odontologo odontologoEntity) {

        OdontologoDto odontologoDto = new OdontologoDto();

        odontologoDto.id = odontologoEntity.getId();
        odontologoDto.nombre = odontologoEntity.getNombre();
        odontologoDto.apellido = odontologoEntity.getApellido();
        odontologoDto.matricula = odontologoEntity.getMatricula();

        return odontologoDto;
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Odontologo> deleteOdontologo(@PathVariable Integer id) {
        if (odontologoService.deleteOdontologo(id)) {
            LOGGER.info("Se eliminó el odontólogo con id %s" + id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            LOGGER.error("No se encontró el odontólogo con id %s" + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Odontologo>> listOdontologos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }
}
