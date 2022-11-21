package com.example.odontologos.repository.impl;

import com.example.odontologos.Util.DataBaseUtil;
import com.example.odontologos.repository.IDao;
import com.example.odontologos.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteRepository implements IDao<Paciente> {

    private static final Logger LOGGER = LogManager.getLogger(PacienteRepository.class);

    private PreparedStatement preparedStatement;
    private Connection connection;

    @Override
    public Paciente crear(Paciente paciente) {

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("INSERT INTO PACIENTES (nombre , apellido , " +
                    "domicilio, dni, fechadealta) VALUES (?,?,?,?,?) ");

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDomicilio());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setDate(5, paciente.getFechaDeAlta());

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
    public Paciente buscar(Integer id) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;

        try {
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection("jdbc:h2:~/test;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'create.sql' ");
            preparedStatement = connection.prepareStatement("SELECT nombre , apellido ," +
                    "                    \"domicilio, dni, fecha_de_alta FROM PACIENTES where id = ?");
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String domicilio = result.getString("domicilio");
                int dni = result.getInt("dni");
                Date fechaDeAlta = result.getDate("fecha_de_alta");

                paciente = new Paciente(id, apellido, nombre, domicilio, dni, fechaDeAlta);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return paciente;
    }

    @Override
    public Boolean eliminar(int id) {
        return null;
    }


    @Override
    public List<Paciente> listar() {

        List<Paciente> pacientes = new ArrayList<>();

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("SELECT ID , DNI , NOMBRE , APELLIDO, FECHA_DE_ALTA, DOMICILIO FROM PACIENTES");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int dni = result.getInt("DNI");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                Date fechaDeAlta = result.getDate("fecha_de_alta");
                String domicilio = result.getString("domicilio");
                pacientes.add(new Paciente(id, apellido, nombre, domicilio, dni, fechaDeAlta));
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

    @Override
    public Paciente actualizar(Paciente paciente) {
        return null;
    }

}
