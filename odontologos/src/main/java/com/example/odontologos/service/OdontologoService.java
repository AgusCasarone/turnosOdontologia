package com.example.odontologos.service;

import com.example.odontologos.model.Odontologo;
import com.example.odontologos.repository.IDao;
import com.example.odontologos.repository.impl.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OdontologoService {

    @Autowired
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(OdontologoRepository odontologoDaoH2) {
        this.odontologoIDao = odontologoDaoH2;

    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoIDao.crear(odontologo);
    }

    public List<Odontologo> listar() {
        return odontologoIDao.listar();
    }

    public Odontologo buscar(Integer id) {
        return odontologoIDao.buscar(id);
    }
}
