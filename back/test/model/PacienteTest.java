package model;


import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;
import java.time.LocalDate;

public class PacienteTest {

    @Test
    public void deberiaPasarConNombreApellidoDomicilioDNIFechaDeAlta() {

        //Arrange
        String nombre = "Profesor";
        String apellido = "Jirafales";
        Domicilio domicilio = new Domicilio("San Martín", "3 Arroyos", "Buenos Aires", 1778);
        int dni = 123456;
        LocalDate fechaDeAlta = LocalDate.of(2023, 12, 30);

        //Act
        Paciente paciente = new Paciente(apellido, nombre, domicilio, dni, fechaDeAlta);

        //Assert
        Assert.assertEquals(nombre, paciente.getNombre());
        Assert.assertEquals(apellido, paciente.getApellido());
        Assert.assertEquals(domicilio, paciente.getDomicilio());
        Assert.assertEquals(dni, paciente.getDni());
        Assert.assertEquals(fechaDeAlta, paciente.getFechaAlta());

    }

    @Test
    public void deberiaCambiarElNombre() {
        //Arrange
        String nombre = "Agustina";
        String apellido = "Casarone";
        Domicilio domicilio = new Domicilio("4", "La Plata", "Buenos Aires", 1779);
        int dni = 39341924;
        LocalDate fechaDeAlta = LocalDate.of(2023, 12, 30);

        //Act
        Paciente paciente = new Paciente(apellido, nombre, domicilio, dni, fechaDeAlta);
        paciente.setNombre("Miguel");

        //Assert
        Assert.assertNotSame(nombre, paciente.getNombre());
        Assert.assertEquals(apellido, paciente.getApellido());
        Assert.assertEquals(domicilio, paciente.getDomicilio());
        Assert.assertEquals(dni, paciente.getDni());
        Assert.assertEquals(fechaDeAlta, paciente.getFechaAlta());

    }

    @Test
    public void deberiaCambiarElApellido() {
        //Arrange
        String nombre = "Nombre";
        String apellido = "Apellido";
        Domicilio domicilio = new Domicilio("Calle", "Localidad", "Provincia", 1778);
        int dni = 123456;
        LocalDate fechaDeAlta = LocalDate.of(2023, 12, 30);

        //Act
        Paciente paciente = new Paciente(apellido, nombre, domicilio, dni, fechaDeAlta);
        paciente.setApellido("OtroApellido");

        //Assert
        Assert.assertEquals(nombre, paciente.getNombre());
        Assert.assertNotSame(apellido, paciente.getApellido());
        Assert.assertEquals(domicilio, paciente.getDomicilio());
        Assert.assertEquals(dni, paciente.getDni());
        Assert.assertEquals(fechaDeAlta, paciente.getFechaAlta());

    }


    @Test
    public void deberiaCambiarElDomicilio() {
        //Arrange
        String nombre = "Nombre";
        String apellido = "Apellido";
        Domicilio domicilio = new Domicilio("Calle", "Localidad", "Provincia", 1778);
        int dni = 123456;
        LocalDate fechaDeAlta = LocalDate.of(2023, 12, 30);

        Domicilio otroDomicilio = new Domicilio("Otro", "Domicilio", "Inventado", 2);

        //Act
        Paciente paciente = new Paciente(apellido, nombre, domicilio, dni, fechaDeAlta);
        paciente.setDomicilio(otroDomicilio);

        //Assert
        Assert.assertEquals(nombre, paciente.getNombre());
        Assert.assertEquals(apellido, paciente.getApellido());
        Assert.assertNotSame(domicilio, paciente.getDomicilio());
        Assert.assertEquals(dni, paciente.getDni());
        Assert.assertEquals(fechaDeAlta, paciente.getFechaAlta());

    }

    @Test
    public void deberiaCambiarElDNI() {
        //Arrange
        String nombre = "Nombre";
        String apellido = "Apellido";
        Domicilio domicilio = new Domicilio("Calle", "Localidad", "Provincia", 1778);
        int dni = 123456;
        LocalDate fechaDeAlta = LocalDate.of(2023, 12, 30);

        //Act
        Paciente paciente = new Paciente(apellido, nombre, domicilio, dni, fechaDeAlta);
        paciente.setDni(654321);

        //Assert
        Assert.assertEquals(nombre, paciente.getNombre());
        Assert.assertEquals(apellido, paciente.getApellido());
        Assert.assertEquals(domicilio, paciente.getDomicilio());
        Assert.assertNotSame(dni, paciente.getDni());
        Assert.assertEquals(fechaDeAlta, paciente.getFechaAlta());

    }

    @Test
    public void deberiaCambiarLaFechaDeAlta() {
        //Arrange
        String nombre = "Nombre";
        String apellido = "Apellido";
        Domicilio domicilio = new Domicilio("Calle", "Localidad", "Provincia", 1778);
        int dni = 123456;
        LocalDate fechaDeAlta = LocalDate.of(2023, 12, 30);

        //Act
        Paciente paciente = new Paciente(apellido, nombre, domicilio, dni, fechaDeAlta);
        paciente.setFechaAlta(LocalDate.of(2022,05, 01));

        //Assert
        Assert.assertEquals(nombre, paciente.getNombre());
        Assert.assertEquals(apellido, paciente.getApellido());
        Assert.assertEquals(domicilio, paciente.getDomicilio());
        Assert.assertEquals(dni, paciente.getDni());
        Assert.assertNotSame(fechaDeAlta, paciente.getFechaAlta());

    }
}

