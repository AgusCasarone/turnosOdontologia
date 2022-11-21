package com.example.odontologos.repository.impl;

import com.example.odontologos.Util.DataBaseUtil;
import com.example.odontologos.repository.IDao;
import com.example.odontologos.model.Domicilio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DomicilioRepository implements IDao<Domicilio> {

    private static final Logger LOGGER = LogManager.getLogger(DomicilioRepository.class);

    private PreparedStatement preparedStatement;
    private Connection connection;

    @Override
    public Domicilio crear(Domicilio domicilio) {

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
            LOGGER.error("Error insert DB: " + e.getMessage());
            throw new RuntimeException(e);
        } finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Error close DB: " + e.getMessage());
                throw new RuntimeException(e);
            }
        }

        return domicilio;
    }

    @Override
    public Domicilio buscar(Integer id) {
        return null;
    }

    @Override
    public Boolean eliminar(int id) {
        return null;
    }


    @Override
    public List<Domicilio> listar() {List<Domicilio> domicilios = new ArrayList<>();

        try {
            connection = DataBaseUtil.connection();
            preparedStatement = connection.prepareStatement("SELECT ID , CALLE , LOCALIDAD , PROVINCIA , NUMERO FROM ODONTOLOGOS");

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int id = result.getInt("id");
                String calle = result.getString("cale");
                String localidad = result.getString("localidad");
                String provincia = result.getString("provincia");
                int numero = result.getInt("numero");
                domicilios.add(new Domicilio(id, calle, localidad, provincia, numero));
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
        return domicilios;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        return null;
    }

}
