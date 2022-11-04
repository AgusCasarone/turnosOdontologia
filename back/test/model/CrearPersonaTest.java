package model;

import junit.framework.Assert;
import org.junit.Test;
import service.CrearPersona;

public class CrearPersonaTest {



    @Test
    public void deberiaConstruirUnOdontologo() {
        // Arrange
        String nombreDeUsuario = "usuarioAdmin";
        String nombreRolEstandar = "estandar";
        String nombreRolAdmin = "admin";
        String password = "123";
        Rol admin = new Rol(nombreRolAdmin);
        Rol estandar = new Rol(nombreRolEstandar);
        Usuario usuarioAdmin = new Usuario(nombreDeUsuario, password, admin);
        Usuario usuarioEstandar = new Usuario(nombreDeUsuario, password, estandar);
        String nombre = "Nombre";
        String apellido = "Apellido";
        String matricula = "Matricula";

        // Act
        Odontologo odontologo = usuarioAdmin.crearOdontologo(nombre, apellido, matricula, usuarioAdmin);

        // Assert
        Assert.assertEquals(nombre, odontologo.getNombre());
        Assert.assertEquals(apellido, odontologo.getApellido());
        Assert.assertEquals(matricula, odontologo.getMatricula());

    }

}
