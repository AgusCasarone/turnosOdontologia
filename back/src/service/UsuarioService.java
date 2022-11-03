package service;

import dao.IDao;
import model.Rol;
import model.Usuario;
import org.apache.log4j.Logger;

public class UsuarioService {

    private static final Logger LOGGER = Logger.getLogger(UsuarioService.class);
    private IDao<UsuarioService> usuarioDAO;

    public UsuarioService(IDao<UsuarioService> usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario crearUsuario(Usuario usuario) {
        LOGGER.debug("Crear usuario:" + usuario.getUser());
        return usuarioDAO.guardar(usuario);
    }

    public Usuario buscarUsuario(int id) {
        return usuarioDAO.buscar(id);
    }

    public Usuario actualizarUsuario(String user, String password, Rol rol) {
        System.out.println("Hay que actualizar la DB llamando al DAO de Usuario");
        return new Usuario(user, password, rol);
    }
}
