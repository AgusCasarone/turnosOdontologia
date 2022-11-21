package com.example.odontologos.repository.impl;

import com.example.odontologos.Util.DataBaseUtil;
import com.example.odontologos.repository.IDao;
import com.example.odontologos.model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OdontologoRepository implements IDao<Odontologo> {
    private static final Logger LOGGER = LogManager.getLogger(OdontologoRepository.class);

    private PreparedStatement preparedStatement;
    private Connection connection;

    @Override
    public Odontologo crear(Odontologo odontologo) {

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (ID, matricula " +
                    ", nombre , apellido ) VALUES (?, ?,?,?)  ");

            preparedStatement.setInt(1, odontologo.getId());
            preparedStatement.setInt(2, odontologo.getMatricula());
            preparedStatement.setString(3, odontologo.getNombre());
            preparedStatement.setString(4, odontologo.getApellido());

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
    public Odontologo buscar(Integer id) {
        return null;
    }

    @Override
    public Boolean eliminar(int id) {
        return null;
    }


    @Override
    public List<Odontologo> listar() {List<Odontologo> odontologos = new ArrayList<>();

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

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }
}
