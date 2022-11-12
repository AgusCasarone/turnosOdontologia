package com.example.odontologos.dao.impl;

import com.example.odontologos.Util.DataBaseUtil;
import com.example.odontologos.dao.IDao;
import com.example.odontologos.model.Domicilio;
import com.example.odontologos.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {

    private static final Logger LOGGER = LogManager.getLogger(PacienteDAOH2.class);

    private PreparedStatement preparedStatement;
    private Connection connection;

    public PacienteDAOH2() {
        preparedStatement = null;
        connection = null;
    }

    @Override
    public Paciente guardar(Paciente paciente) {

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("INSERT INTO PACIENTES (nombre , apellido " +
                    "domicilio, dni, fechadealta) VALUES (?,?,?,?,?) ");

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio().toString());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setString(5, paciente.getFechaAlta());

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
        return paciente;
    }


    @Override
    public List<Paciente> listar() {
        List<Paciente> pacientes = new ArrayList<>();

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("SELECT ID , DNI , NOMBRE , APELLIDO, DOMICILIO, FECHADEALTA FROM PACIENTES");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int dni = result.getInt("DNI");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String domicilio = result.getString("domicilio");
                String fechaDeAlta = result.getString("fechaDeAlta");
                pacientes.add(new Paciente(apellido, nombre, domicilio, fechaDeAlta));
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
        return pacientes;
    }
}
