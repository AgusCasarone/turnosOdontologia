package service;

import com.example.odontologos.model.Domicilio;
import com.example.odontologos.model.Odontologo;
import com.example.odontologos.model.Paciente;
import com.example.odontologos.model.Turno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TurnoTest {

    String apellidoPaciente1 = "Apellido1";
    String apellidoPaciente2 = "Apellido2";
    String apellidoOdontologo1 = "Apellido12";
    String apellidoOdontologo2 = "Apellido22";
    String nombrePaciente1 = "Nombre1";
    String nombrePaciente2 = "Nombre2";
    String nombreOdontologo1 = "Nombre12";
    String nombreOdontologo2 = "Nombre22";
    String calle1 = "calle1";
    String calle2 = "calle2";
    String localidad1 = "localidad1";
    String localidad2 = "loalidad2";
    String provincia1 = "provincia1";
    String provincia2 = "provincia2";
    int numero1 = 456;
    int numero2 = 21;
    int dniPaciente1 = 789;
    int dniPaciente2 = 2131;
    Domicilio domicilio1 = new Domicilio(calle1, localidad1, provincia1, numero1);
    Domicilio domicilio2 = new Domicilio(calle2, localidad2, provincia2, numero2);
    int matricula1 = 1;
    int matricula2 = 2;
    LocalDateTime fechaYHora1 = LocalDateTime.of(2002, 5, 12, 12, 45);
    LocalDateTime fechaYHora2 = LocalDateTime.of(2023, 12, 31, 15, 52);
    LocalDate fecha1 = LocalDate.of(1996, 5, 1);
    LocalDate fecha2 = LocalDate.of(2000, 1, 3);

    Paciente paciente1 = new Paciente(apellidoPaciente1, nombrePaciente1, domicilio1, dniPaciente1, fecha1);
    Odontologo odontologo1 = new Odontologo(1, matricula1, nombreOdontologo1, apellidoOdontologo1);

    @Test

    public void crearTurno() {
        // Arrange

        // Act
        Turno turno1 = new Turno(paciente1, odontologo1, fechaYHora1);

        //Assert
        Assertions.assertEquals(paciente1, turno1.getPaciente());
        Assertions.assertEquals(odontologo1, turno1.getOdontologo());
        Assertions.assertEquals(fechaYHora1, turno1.getFechaYHora());
    }

    @Test

    public void cambarPacienteDelTurno() {
        // Arrange
        Paciente paciente2 = new Paciente(apellidoPaciente2, nombrePaciente2, domicilio2, dniPaciente2, fecha2);

        // Act
        Turno turno1 = new Turno(paciente1, odontologo1, fechaYHora1);
        turno1.setPaciente(paciente2);

        //Assert
        Assertions.assertNotSame(paciente1, turno1.getPaciente());
        Assertions.assertEquals(odontologo1, turno1.getOdontologo());
        Assertions.assertEquals(fechaYHora1, turno1.getFechaYHora());
    }

    @Test

    public void cambarOdontologoDelTurno() {
        // Arrange
        Odontologo odontologo2 = new Odontologo(1, matricula2, nombreOdontologo2, apellidoOdontologo2);



        // Act
        Turno turno1 = new Turno(paciente1, odontologo1, fechaYHora1);
        turno1.setOdontologo(odontologo2);

        //Assert
        Assertions.assertEquals(paciente1, turno1.getPaciente());
        Assertions.assertNotSame(odontologo1, turno1.getOdontologo());
        Assertions.assertEquals(fechaYHora1, turno1.getFechaYHora());
    }

    @Test

    public void cambarFechaYHoraDelTurno() {
        // Arrange

        // Act
        Turno turno1 = new Turno(paciente1, odontologo1, fechaYHora2);
        turno1.setFechaYHora(fechaYHora2);

        //Assert
        Assertions.assertEquals(paciente1, turno1.getPaciente());
        Assertions.assertEquals(odontologo1, turno1.getOdontologo());
        Assertions.assertNotSame(fechaYHora1, turno1.getFechaYHora());
    }
}