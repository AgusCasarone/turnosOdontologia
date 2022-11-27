package com.example.odontologos.Controller;

import com.example.odontologos.model.Paciente;
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
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger LOGGER = LogManager.getLogger(PacienteController.class);

    @Autowired
    private PacienteService pacienteService;


    @PostMapping
    public ResponseEntity<Paciente> crear(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> buscar(@PathVariable int id){
        return ResponseEntity.ok(pacienteService.findById(id));
    }


    /* @PutMapping
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.actualizar(paciente));
    } */


    @DeleteMapping("/{id}")
    public ResponseEntity<Paciente> eliminar(@PathVariable int id) {

        ResponseEntity response = null;

        if (pacienteService.eliminar(id)) {
            LOGGER.info("Se eliminó el paciente con id %s" + id);
            response = ResponseEntity.status(HttpStatus.OK).build();
        } else {
            LOGGER.error("No se encontró el paciente con id %s y no pudo ser eliminado" + id);
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Paciente>> listarPacientes() {
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }




}
