package com.example.odontologos.service;


import com.example.odontologos.model.Persona;
import com.example.odontologos.model.Usuario;

import java.util.List;

public interface IPersonasFacade {

    Persona modificarPersona(Usuario usuario);

    List<Persona> listarPersonas(Usuario usuario);
    Boolean eliminarPersona(Usuario usuario);
}