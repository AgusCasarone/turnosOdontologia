package dao.impl;

import dao.IDao;
import model.Domicilio;
import model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DomicilioDAOH2 implements IDao<Domicilio> {
    @Override
    public Domicilio guardar(Domicilio domicilio) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection("jdbc:h2:~/test4;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'table.sql' ");

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
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return domicilio;
    }

    @Override
    public Usuario guardar(Usuario t) {
        return null;
    }

    @Override
    public Usuario buscar(int id) {
        return null;
    }
}
