package com.example.odontologos.Controller;

import com.example.odontologos.model.Turno;
import com.example.odontologos.repository.impl.IDomicilioRepository;
import com.example.odontologos.service.OdontologoService;
import com.example.odontologos.service.PacienteService;
import com.example.odontologos.service.TurnoService;
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
    public ResponseEntity<Turno> crear(@RequestBody Turno turno) {

        ResponseEntity<Turno> response;
        if (pacienteService.findPacienteById(turno.getPaciente().getId()) == null || !odontologoService.findOdontologoById(turno.getOdontologo().getId()).isPresent()) {
            LOGGER.error("El odontólogo o el paciente no existen y no se pudo crear el turno.");
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            LOGGER.info("Turno registrado con éxito. " +
                    "\n FECHA: %s" +
                    "\n HORA: %s" +
                    "\n ID ODONTÓLOGO: %s" +
                    "\n ID PACIENTE: %s." + turno.getFecha() + turno.getHora() + turno.getOdontologo() + turno.getPaciente());
            response = ResponseEntity.ok(turnoService.guardar(turno));
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar(){
        if (turnoService.listar().isEmpty()){
            LOGGER.error("No existen turnos para listar.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        LOGGER.info("Los turnos existentes son:" +
                "\n %s" + turnoService.listar());
        return ResponseEntity.ok(turnoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Turno>> buscar(@PathVariable Integer id) {
        return ResponseEntity.ok(turnoService.buscar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turno> eliminar(@PathVariable Integer id){

        if (turnoService.eliminar(id)) {
            LOGGER.info("Se eliminó el turno con id %s" + id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            LOGGER.error("No se encontró el turno con id %s" + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // actualizar


}
