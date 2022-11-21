package com.example.odontologos.repository.impl;

import com.example.odontologos.repository.IDao;
import com.example.odontologos.model.Usuario;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class UsuarioRepository implements IDao<Usuario> {

    @Override
    public Usuario crear(Usuario usuario) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection("jdbc:h2:~/test4;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'table.sql' ");

            preparedStatement = connection.prepareStatement("INSERT INTO USUARIOS (id " +
                    ", user , password , idRol) VALUES (?,?,?,?)  ");

            preparedStatement.setInt(1, usuario.getId());
            preparedStatement.setString(2, usuario.getUser());
            preparedStatement.setString(3, usuario.getPassword());
            preparedStatement.setInt(4, usuario.getRol().getId());

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

        return usuario;
    }

    @Override
    public Usuario buscar(Integer id) {
        return null;
    }

    @Override
    public Boolean eliminar(int id) {
        return null;
    }


    @Override
    public List<Usuario> listar() {
        return null;
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
        return null;
    }

}
