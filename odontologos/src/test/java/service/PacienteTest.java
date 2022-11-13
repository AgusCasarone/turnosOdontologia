package service;

import com.example.odontologos.model.Domicilio;
import com.example.odontologos.model.Paciente;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;

public class PacienteTest {

    String apellido = "Apellido";
    String nombre = "Nombre";
    String calle = "calle";
    String localidad = "localidad";
    String provincia = "provincia";
    int numero = 456;
    int dni = 789;

    LocalDate fecha = LocalDate.of(1996, 05, 01);
    Domicilio domicilio = new Domicilio(calle, localidad, provincia, numero);
    Paciente paciente = new Paciente(apellido, nombre, domicilio, dni, fecha);


    @Test
    public void deberiaPasarConNombreApellidoDomicilioDNIFechaDeAlta() {

        //Arrange
        //Act

        //Assert
        Assertions.assertEquals(nombre, paciente.getNombre());
        Assertions.assertEquals(apellido, paciente.getApellido());
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(dni, paciente.getDni());
        Assertions.assertEquals(fecha, paciente.getFechaAlta());
    }

    @Test
    public void deberiaCambiarElNombre() {
        //Arrange

        //Act
        paciente.setNombre("Miguel");

        //Assert
        Assertions.assertNotSame(nombre, paciente.getNombre());
        Assertions.assertEquals(apellido, paciente.getApellido());
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(dni, paciente.getDni());
        Assertions.assertEquals(fecha, paciente.getFechaAlta());
    }

    @Test
    public void deberiaCambiarElApellido() {
        //Arrange

        //Act
        paciente.setApellido("OtroApellido");

        //Assert
        Assertions.assertEquals(nombre, paciente.getNombre());
        Assertions.assertNotSame(apellido, paciente.getApellido());
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(dni, paciente.getDni());
        Assertions.assertEquals(fecha, paciente.getFechaAlta());
    }


    @Test
    public void deberiaCambiarElDomicilio() {
        //Arrange

        Domicilio otroDomicilio = new Domicilio("Otro", "Domicilio", "Inventado", 2);

        //Act
        paciente.setDomicilio(otroDomicilio);

        //Assert
        Assertions.assertEquals(nombre, paciente.getNombre());
        Assertions.assertEquals(apellido, paciente.getApellido());
        Assertions.assertNotSame(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(dni, paciente.getDni());
        Assertions.assertEquals(fecha, paciente.getFechaAlta());
    }

    @Test
    public void deberiaCambiarElDNI() {
        //Arrange

        //Act
        paciente.setDni(654321);

        //Assert
        Assertions.assertEquals(nombre, paciente.getNombre());
        Assertions.assertEquals(apellido, paciente.getApellido());
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
        Assertions.assertNotSame(dni, paciente.getDni());
        Assertions.assertEquals(fecha, paciente.getFechaAlta());
    }

    @Test
    public void deberiaCambiarLaFechaDeAlta() {
        //Arrange

        //Act
        paciente.setFechaAlta(LocalDate.of(2022,5, 1));

        //Assert
        Assertions.assertEquals(nombre, paciente.getNombre());
        Assertions.assertEquals(apellido, paciente.getApellido());
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(dni, paciente.getDni());
        Assertions.assertNotSame(fecha, paciente.getFechaAlta());
    }
}
