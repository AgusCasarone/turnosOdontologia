package dao.impl;

import dao.IDao;
import model.Usuario;

import java.sql.*;

public class UsuarioDAOH2 implements IDao<Usuario> {

    @Override
    public Usuario guardar(Usuario usuario) {
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
    public Usuario buscar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Usuario usuario = null;
        try {
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection("jdbc:h2:~/test4;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'table.sql' ");

            preparedStatement = connection.prepareStatement("SELECT id , user , password , idRol FROM USUARIOS " +
                    "WHERE ID = ?");

            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                int idUsu = result.getInt("id");
                String user = result.getString("user");
                String password = result.getString("password");
                int idRol = result.getInt("idRol");


                /* ESTO NO FUNCA PORQUE NO SE ME OCURRE CÓMO RESOLVER EL TIPO DE USUARIO
                usuario = new Usuario(user, password, idRol);
                 */

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}
