package com.example.odontologos.service;

import com.example.odontologos.model.Paciente;
import com.example.odontologos.repository.IDao;
import com.example.odontologos.repository.impl.PacienteRepository;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteIDao = pacienteRepository;
    }

    public Paciente guardar(Paciente paciente) {
        return pacienteIDao.crear(paciente);
    }

    public Paciente buscar(int id) {
        return pacienteIDao.buscar(id);
    }


    public Boolean eliminar(Integer id){

       return pacienteIDao.eliminar(id);

    }

    /*



   public Pelicula actualizar(Pelicula pelicula){

       return peliculaRepository.actualizar(pelicula);

   }



   public Pelicula buscar(Integer id){

       return peliculaRepository.buscar(id);

   }
     */
}
