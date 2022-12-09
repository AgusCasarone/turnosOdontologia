package com.example.odontologos.Controller;

import com.example.odontologos.dto.OdontologoDto;
import com.example.odontologos.exception.ResourceNotFoundException;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping (value = "add")
    public ResponseEntity<OdontologoDto> addOdontologo(@RequestBody OdontologoDto odontologoDto) {
        return ResponseEntity.ok(odontologoService.parseOdontologoEntityToDto(odontologoService.addOdontologo(odontologoDto)));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Odontologo>> findOdontologoById(@PathVariable Integer id) throws ResourceNotFoundException, Exception {
        return ResponseEntity.ok(odontologoService.findOdontologoById(id));
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<Odontologo> updateOdontologo(@PathVariable Integer id, @RequestBody OdontologoDto odontologoDto) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.updateOdontologo(odontologoDto, id));
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteOdontologo(@PathVariable Integer id) throws ResourceNotFoundException, Exception {
        odontologoService.deleteOdontologo(id);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Se eliminó el odontólogo con id %s", id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Odontologo>> listOdontologos(){
        return ResponseEntity.ok(odontologoService.listOdontologos());
    }

}
