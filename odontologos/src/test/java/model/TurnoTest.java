package model;

import com.example.odontologos.model.Paciente;
import com.example.odontologos.model.Turno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;

public class TurnoTest {

    int idPaciente1 = 111;
    int idPaciente2 = 112;
    int idOdontologo1 = 121;
    int idOdontologo2 = 122;

    String apellidoPaciente1 = "Apellido Paciente 1";
    String apellidoPaciente2 = "Apellido Paciente 2";
    String apellidoOdontologo1 = "Apellido Odontologo 1";
    String apellidoOdontologo2 = "Apellido Odontologo 2";

    String nombrePaciente1 = "Nombre Paciente 1";
    String nombrePaciente2 = "Nombre Paciente 2";
    String nombreOdontologo1 = "Nombre Odontologo 1";
    String nombreOdontologo2 = "Nombre Odontologo 2";

    int dniPaciente1 = 111;
    int dniPaciente2 = 112;

    Date fechaDeAltaPaciente1 = new Date(2001, 5, 20);
    Date fechaDeAltaPaciente2 = new Date(2001, 5, 20);

    int matriculaOdontologo1 = 221;
    int matriculaOdontologo2 = 222;

    Paciente paciente1 = new Paciente(idPaciente1, apellidoPaciente1, nombrePaciente1, "domicilio1", dniPaciente1, fechaDeAltaPaciente1);
    Paciente paciente2 = new Paciente(idPaciente2, apellidoPaciente2, nombrePaciente2, "domicilio2", dniPaciente2, fechaDeAltaPaciente2);

    @Test

    public void crearTurno() {
        // Arrange

        // Act

        //Assert
    }

    @Test

    public void cambarPacienteDelTurno() {
        // Arrange
        int paciente2_fk = 456;

        // Act

        //Assert
    }

    @Test

    public void cambarOdontologoDelTurno() {
        // Arrange
        int odontologo2_fk = 4567;

        // Act

        //Assert
    }

    @Test

    public void cambarFechaYHoraDelTurno() {
        // Arrange

        // Act

        //Assert
    }
}