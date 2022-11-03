package model;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;

public class DomicilioTest {

    String calle = "Calle";
    String localidad = "Localidad";
    String provincia = "Provinvia";
    int numero = 123;

    @Test
    public void deberiaConstruirConCalleLocalidadProvinciaNumero() {
        // Arrange
        // Las variables comunes

        // Act
        Domicilio domicilio = new Domicilio(calle, localidad, provincia, numero);

        // Assert
        Assert.assertEquals(calle, domicilio.getCalle());
        Assert.assertEquals(localidad, domicilio.getLocalidad());
        Assert.assertEquals(provincia, domicilio.getProvincia());
        Assert.assertEquals(numero, domicilio.getNumero());

    }

    @Test
    public void deberiaCambiarLaCalle() {
        // Arrange
        String calle2 = "Calle 2";

        // Act
        Domicilio domicilio = new Domicilio(calle, localidad, provincia, numero);
        domicilio.setCalle(calle2);

        // Assert
        Assert.assertNotSame(calle, domicilio.getCalle());
        Assert.assertEquals(localidad, domicilio.getLocalidad());
        Assert.assertEquals(provincia, domicilio.getProvincia());
        Assert.assertEquals(numero, domicilio.getNumero());

    }

    @Test
    public void deberiaCambiarLaLocalidad() {
        // Arrange
        String localidad2 = "Localidad 2";

        // Act
        Domicilio domicilio = new Domicilio(calle, localidad, provincia, numero);
        domicilio.setLocalidad(localidad2);

        // Assert
        Assert.assertEquals(calle, domicilio.getCalle());
        Assert.assertNotSame(localidad, domicilio.getLocalidad());
        Assert.assertEquals(provincia, domicilio.getProvincia());
        Assert.assertEquals(numero, domicilio.getNumero());

    }

    @Test
    public void deberiaCambiarLaProvincia() {
        // Arrange
        String provincia2 = "Provincia 2";

        // Act
        Domicilio domicilio = new Domicilio(calle, localidad, provincia, numero);
        domicilio.setProvincia(provincia2);

        // Assert
        Assert.assertEquals(calle, domicilio.getCalle());
        Assert.assertEquals(localidad, domicilio.getLocalidad());
        Assert.assertNotSame(provincia, domicilio.getProvincia());
        Assert.assertEquals(numero, domicilio.getNumero());

    }

    @Test
    public void deberiaCambiarElNumero() {
        // Arrange
        int numero2 = 456;

        // Act
        Domicilio domicilio = new Domicilio(calle, localidad, provincia, numero);
        domicilio.setNumero(numero2);

        // Assert
        Assert.assertEquals(calle, domicilio.getCalle());
        Assert.assertEquals(localidad, domicilio.getLocalidad());
        Assert.assertEquals(provincia, domicilio.getProvincia());
        Assert.assertNotSame(numero, domicilio.getNumero());

    }
}
