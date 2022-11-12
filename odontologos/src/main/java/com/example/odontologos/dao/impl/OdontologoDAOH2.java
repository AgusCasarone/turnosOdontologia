package com.example.odontologos.dao.impl;

import com.example.odontologos.Util.DataBaseUtil;
import com.example.odontologos.dao.IDao;
import com.example.odontologos.model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    private static final Logger LOGGER = LogManager.getLogger(OdontologoDAOH2.class);

    private PreparedStatement preparedStatement;
    private Connection connection;

    public OdontologoDAOH2() {
        preparedStatement = null;
        connection = null;
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (matricula " +
                    ", nombre , apellido ) VALUES (?,?,?)  ");

            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());

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
        return odontologo;
    }


    @Override
    public List<Odontologo> listar() {
        List<Odontologo> odontologos = new ArrayList<>();

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("SELECT ID , MATRICULA , NOMBRE , APELLIDO FROM ODONTOLOGOS");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                int matricula = result.getInt("matricula");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                odontologos.add(new Odontologo(id, matricula, nombre, apellido));
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
        return odontologos;
    }
}
