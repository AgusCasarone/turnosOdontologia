package com.example.odontologos.Controller;

import com.example.odontologos.model.Odontologo;
import com.example.odontologos.repository.impl.OdontologoRepository;
import com.example.odontologos.service.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private OdontologoService odontologoService = new OdontologoService(new OdontologoRepository());

    @PostMapping
    public Odontologo registraPaciente(@RequestBody Odontologo odontologo) {
        return odontologoService.guardar(odontologo);
    }

    @GetMapping
    public List<Odontologo> listarOdontologos() {
        return odontologoService.listar();
    }

}
