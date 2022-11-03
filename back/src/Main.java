import org.apache.log4j.Logger;
import service.CrearPersona;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        String nombre = "agus";
        String puntos = "12";
        logger.info(String.format("el ganador es %s y se lleva %s puntos", nombre, puntos));

    }
}