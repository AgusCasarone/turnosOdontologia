package com.example.odontologos.Controller;

import com.example.odontologos.dto.PacienteDto;
import com.example.odontologos.model.Paciente;
import com.example.odontologos.service.PacienteService;
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
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger LOGGER = LogManager.getLogger(PacienteController.class);

    @Autowired
    private PacienteService pacienteService;


    @PostMapping (value = "add")
    public ResponseEntity<PacienteDto> addPaciente(@RequestBody PacienteDto pacienteDto){
        LOGGER.info("Se creó un nuevo paciente");
        return ResponseEntity.ok(pacienteService.parsePacienteEntityToDto(pacienteService.addPaciente(pacienteDto)));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Paciente>> findPacienteById(@PathVariable int id){

        if (pacienteService.findPacienteById(id).isPresent()){
            LOGGER.info(String.format("Se encontró el paciente con id %s", id));
            return ResponseEntity.ok(pacienteService.findPacienteById(id));
        } else {
            LOGGER.error(String.format("No se encontró ningún paciente con el id %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


    @PutMapping (value = "update/{id}")
    public ResponseEntity<Paciente> updatePaciente(@PathVariable Integer id, @RequestBody PacienteDto pacienteDto){

        if (pacienteService.findPacienteById(id).isPresent()) {
            excludeNullValues();
            LOGGER.info(String.format("Se actualizó el paciente con id %s", id));
            pacienteDto.setId(id);
            return ResponseEntity.ok(pacienteService.addPaciente(pacienteDto));

        } else {
            LOGGER.error(String.format("No se encontró ningún paciente con id %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> deletePaciente(@PathVariable int id) {
        if (pacienteService.deletePaciente(id)) {
            LOGGER.info(String.format("Se eliminó el paciente con id %s", id));
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            LOGGER.error(String.format("No se encontró el paciente con id %s y no pudo ser eliminado", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listPacientes());
    }

    public void excludeNullValues() {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

}
