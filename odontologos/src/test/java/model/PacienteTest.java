package model;

import com.example.odontologos.model.Domicilio;
import com.example.odontologos.model.Paciente;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.Date;

public class PacienteTest {

    String apellido = "Apellido";
    String nombre = "Nombre";
    int dni = 789;

    Date fecha = new Date(1996, 05, 01);
    String domicilio = "Domicilio";
    Paciente paciente = new Paciente(1, apellido, nombre, domicilio, dni, fecha);


    @Test
    public void deberiaPasarConNombreApellidoDomicilioDNIFechaDeAlta() {

        //Arrange
        //Act

        //Assert
        Assertions.assertEquals(nombre, paciente.getNombre());
        Assertions.assertEquals(apellido, paciente.getApellido());
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(dni, paciente.getDni());
        Assertions.assertEquals(fecha, paciente.getFechaDeAlta());
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
        Assertions.assertEquals(fecha, paciente.getFechaDeAlta());
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
        Assertions.assertEquals(fecha, paciente.getFechaDeAlta());
    }


    @Test
    public void deberiaCambiarElDomicilio() {
        //Arrange

        String otroDomicilio = new Domicilio(1, "Otro", "Domicilio", "Inventado", 2);

        //Act
        paciente.setDomicilio(otroDomicilio);

        //Assert
        Assertions.assertEquals(nombre, paciente.getNombre());
        Assertions.assertEquals(apellido, paciente.getApellido());
        Assertions.assertNotSame(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(dni, paciente.getDni());
        Assertions.assertEquals(fecha, paciente.getFechaDeAlta());
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
        Assertions.assertEquals(fecha, paciente.getFechaDeAlta());
    }

    @Test
    public void deberiaCambiarLaFechaDeAlta() {
        //Arrange

        //Act
        paciente.setFechaDeAlta(new Date(2022,5, 1));

        //Assert
        Assertions.assertEquals(nombre, paciente.getNombre());
        Assertions.assertEquals(apellido, paciente.getApellido());
        Assertions.assertEquals(domicilio, paciente.getDomicilio());
        Assertions.assertEquals(dni, paciente.getDni());
        Assertions.assertNotSame(fecha, paciente.getFechaDeAlta());
    }
}
