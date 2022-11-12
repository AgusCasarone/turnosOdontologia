package com.example.odontologos.dao.impl;

import com.example.odontologos.Util.DataBaseUtil;
import com.example.odontologos.dao.IDao;
import com.example.odontologos.model.Domicilio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DomicilioDAOH2 implements IDao<Domicilio> {


    private PreparedStatement preparedStatement;
    private Connection connection;

    public DomicilioDAOH2() {
        preparedStatement = null;
        connection = null;
    }

    @Override
    public Domicilio guardar(Domicilio domicilio) {

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("INSERT INTO DOMICILIOS (ID " +
                    ", idProvincia , idLocalidad , idCalle , numero) VALUES (?,?,?,?,?) ");

            preparedStatement.setInt(1, domicilio.getId());
            preparedStatement.setString(2, domicilio.getProvincia());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getCalle());
            preparedStatement.setInt(5, domicilio.getNumero());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return domicilio;
    }

    @Override
    public List<Domicilio> listar() {
        return null;
    }

}
