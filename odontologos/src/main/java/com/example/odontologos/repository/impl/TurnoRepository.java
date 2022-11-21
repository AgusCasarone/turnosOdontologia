package com.example.odontologos.repository.impl;

import com.example.odontologos.Util.DataBaseUtil;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.model.Paciente;
import com.example.odontologos.model.Turno;
import com.example.odontologos.repository.IDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Repository
public class TurnoRepository implements IDao<Turno> {

    private static final Logger LOGGER = LogManager.getLogger(TurnoRepository.class);

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private OdontologoRepository odontologoRepository;
    private PreparedStatement preparedStatement;
    private Connection connection;


    @Override
    public Turno crear(Turno turno) {
        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("INSERT INTO TURNOS (ID " +
                    ", FK_PACIENTE , FK_ODONTOLOGO , FECHA, HORA) VALUES (?,?,?,?,?) ");

            preparedStatement.setInt(1, turno.getId());
            preparedStatement.setInt(2, turno.getPaciente().getId());
            preparedStatement.setInt(3, turno.getOdontologo().getId());
            preparedStatement.setDate(4, turno.getFecha());
            preparedStatement.setTime(5, turno.getHora());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Error insert DB: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                LOGGER.error("Error en close DB: " + e.getMessage());
            }
        }
        return turno;
    }

    @Override
    public Turno buscar(Integer id) {
        return null;
    }

    @Override
    public Boolean eliminar(int id) {
        return null;
    }


    @Override
    public List<Turno> listar() {


        List<Turno> turnos = new ArrayList<>();

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("SELECT ID , FK_PACIENTE , FK_ODONTOLOGO , FECHA, HORA FROM TURNOS");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int fk_paciente = result.getInt("fk_paciente");
                int fk_odontologo = result.getInt("fk_odontologo");
                Date fecha = result.getDate("fecha");
                Time hora = result.getTime("hora");
                Paciente paciente = pacienteRepository.buscar(fk_paciente);
                Odontologo odontologo = odontologoRepository.buscar(fk_odontologo);

                turnos.add(new Turno(id, paciente, odontologo, fecha, hora));
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Error insert DB: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                LOGGER.error("Error close DB: " + e.getMessage());
            }
        }
        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        return turno;
    }
}
