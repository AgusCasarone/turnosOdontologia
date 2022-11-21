package model;

import com.example.odontologos.model.Odontologo;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class OdontologoTest {

        String nombre = "Nombre";
        String apellido = "Apellido";
        int matricula = 123;

        Odontologo odontologo = new Odontologo(1, matricula, nombre, apellido);


    @Test
        public void deberiaPasarConNombreApellidoMatricula() {

            //Arrange
            //Act
            //Assert
            Assertions.assertEquals(nombre, odontologo.getNombre());
            Assertions.assertEquals(apellido, odontologo.getApellido());
            Assertions.assertEquals(matricula, odontologo.getMatricula());
        }

        @Test
        public void deberiaCambiarElApellido() {
            //Arrange
            //Act
            odontologo.setApellido("Jajas");
            //Assert
            Assertions.assertEquals(nombre, odontologo.getNombre());
            Assertions.assertNotSame(apellido, odontologo.getApellido());
            Assertions.assertEquals(matricula, odontologo.getMatricula());
        }

        @Test
        public void deberiaCambiarLaMatricula() {
            //Arrange
            //Act
            odontologo.setMatricula(456);
            //Assert
            Assertions.assertEquals(nombre, odontologo.getNombre());
            Assertions.assertEquals(apellido, odontologo.getApellido());
            Assertions.assertNotSame(matricula, odontologo.getMatricula());
        }

        @Test
        public void deberiaCambiarElNombre() {
            //Arrange
            //Act
            odontologo.setNombre("chau");
            //Assert
            Assertions.assertNotSame(nombre, odontologo.getNombre());
            Assertions.assertEquals(apellido, odontologo.getApellido());
            Assertions.assertEquals(matricula, odontologo.getMatricula());
        }
}
