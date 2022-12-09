package com.example.odontologos.Controller;

import com.example.odontologos.dto.TurnoDto;
import com.example.odontologos.model.Turno;
import com.example.odontologos.repository.IDomicilioRepository;
import com.example.odontologos.service.OdontologoService;
import com.example.odontologos.service.PacienteService;
import com.example.odontologos.service.TurnoService;
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
@RequestMapping("/turnos")
public class TurnoController {

    private static final Logger LOGGER = LogManager.getLogger(IDomicilioRepository.class);
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<TurnoDto> crear(@RequestBody TurnoDto turnoDto) {

        if (!pacienteService.findPacienteById(turnoDto.getPaciente().getId()).isPresent()|| !odontologoService.findOdontologoById(turnoDto.getOdontologo().getId()).isPresent()) {
            LOGGER.error("El odontólogo o el paciente no existen y no se pudo crear el turno.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LOGGER.info(String.format("Turno registrado con éxito. " +
                    "\n FECHA Y HORA: %s %s" +
                    "\n ID ODONTÓLOGO: %s" +
                    "\n ID PACIENTE: %s.", turnoDto.getFecha(), turnoDto.getHora(), turnoDto.getOdontologo().getId(), turnoDto.getPaciente().getId()));
            return ResponseEntity.ok(turnoService.parseTurnoEntityToDto(turnoService.guardar(turnoDto)));
        }
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar(){
        if (turnoService.listar().isEmpty()){
            LOGGER.error("No existen turnos para listar.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LOGGER.info(String.format("Se listan los %s turnos existentes.", turnoService.listar().size()));
        return ResponseEntity.ok(turnoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(turnoService.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turno> eliminar(@PathVariable Integer id){

        if (turnoService.eliminar(id)) {
            LOGGER.info(String.format("Se eliminó el turno con id %s", id));
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            LOGGER.error(String.format("No se encontró el turno con id %s",id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping (value = "update/{id}")
    public ResponseEntity<Turno> updateTurno(@PathVariable Integer id, @RequestBody TurnoDto turnoDto){
        if (turnoService.buscar(id).isPresent()) {
            excludeNullValues();
            LOGGER.info(String.format("Se actualizó el turno con id %s", id));
            turnoDto.setId(id);
            return ResponseEntity.ok(turnoService.guardar(turnoDto));
        } else {
            LOGGER.error(String.format("No se encontró ningún turno con el id %s", id));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    public void excludeNullValues() {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }


}
