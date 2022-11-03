package model;


import junit.framework.Assert;
import org.junit.Test;

public class OdontologoTest {

    @Test
    public void deberiaPasarConNombreApellidoMatricula() {

        //Arrange
        String nombre = "Profesor";
        String apellido = "Jirafales";
        String matricula = "e12";

        //Act
        Odontologo odontologo = new Odontologo(apellido, nombre, matricula);

        //Assert
        Assert.assertEquals(nombre, odontologo.getNombre());
        Assert.assertEquals(apellido, odontologo.getApellido());
        Assert.assertEquals(matricula, odontologo.getMatricula());
    }

    @Test
    public void deberiaCambiarElApellido() {
        //Arrange
        String nombre = "El";
        String apellido = "Chavo";
        String matricula = "e12";

        //Act
        Odontologo odontologo = new Odontologo(apellido, nombre, matricula);
        odontologo.setApellido("Jajas");

        //Assert
        Assert.assertEquals(nombre, odontologo.getNombre());
        Assert.assertNotSame(apellido, odontologo.getApellido());
        Assert.assertEquals(matricula, odontologo.getMatricula());
    }

    @Test
    public void deberiaCambiarLaMatricula() {
        //Arrange
        String nombre = "Nombre";
        String apellido = "Apellido";
        String matricula = "Matricula";

        //Act
        Odontologo odontologo = new Odontologo(apellido, nombre, matricula);
        odontologo.setMatricula("NuevaMatricula");

        //Assert
        Assert.assertEquals(nombre, odontologo.getNombre());
        Assert.assertEquals(apellido, odontologo.getApellido());
        Assert.assertNotSame(matricula, odontologo.getMatricula());
    }

    @Test
    public void deberiaCambiarElNombre() {
        //Arrange
        String nombre = "Hola";
        String apellido = "Kease";
        String matricula = "123456";

        //Act
        Odontologo odontologo = new Odontologo(apellido, nombre, matricula);
        odontologo.setNombre("chau");

        //Assert
        Assert.assertNotSame(nombre, odontologo.getNombre());
        Assert.assertEquals(apellido, odontologo.getApellido());
        Assert.assertEquals(matricula, odontologo.getMatricula());
    }
}

