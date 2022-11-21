package com.example.odontologos.Util;

import com.example.odontologos.service.CrearPersona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
    private static final Logger logger = LogManager.getLogger(DataBaseUtil.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    private final static String DB_URL = "jdbc:h2:~/db_Odontologos";

    private final static String DB_USER = "sa";

    private final static String DB_PASSWORD = "sa";


    public static Connection connection() throws SQLException, ClassNotFoundException
    {
        Class.forName(DB_JDBC_DRIVER);
        logger.info("Conección a la base de datos exitosa");
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }


}
