package com.example.odontologos.service;


import com.example.odontologos.dao.IDao;
import com.example.odontologos.model.Rol;
import com.example.odontologos.model.Usuario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UsuarioService {

    private static final Logger LOGGER = LogManager.getLogger(UsuarioService.class);
    private final IDao<Usuario> usuarioDAO;

    public UsuarioService(IDao<Usuario> usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario crearUsuario(Usuario usuario) {
        LOGGER.debug("Crear usuario:" + usuario.getUser());
        return usuarioDAO.guardar(usuario);
    }

    public Usuario actualizarUsuario(String user, String password, Rol rol) {
        System.out.println("Hay que actualizar la DB llamando al DAO de Usuario");
        return new Usuario(user, password, rol);
    }
}
