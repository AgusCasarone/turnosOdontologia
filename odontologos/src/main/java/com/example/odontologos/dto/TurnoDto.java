package com.example.odontologos.dto;

import com.example.odontologos.model.Odontologo;
import com.example.odontologos.model.Paciente;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

public class TurnoDto {


    private Integer id;
    private Paciente paciente;
    private Odontologo odontologo;
    private Date fecha;
    private Time hora;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public TurnoDto() {
    }

    public TurnoDto(Integer id, Paciente paciente, Odontologo odontologo, Date fecha, Time hora) {
        this.id = id;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
        this.hora = hora;
    }
}
