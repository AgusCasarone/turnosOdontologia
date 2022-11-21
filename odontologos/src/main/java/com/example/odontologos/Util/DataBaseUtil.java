package com.example.odontologos.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil {
    private static final Logger logger = LogManager.getLogger(DataBaseUtil.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";

    public static Connection connection() throws SQLException, ClassNotFoundException
    {
        Class.forName(DB_JDBC_DRIVER);
        logger.info("Conección a la base de datos exitosa");
        return DriverManager.getConnection("jdbc:h2:~/test3, USER=sa, PASSWORD=sa,INIT=RUNSCRIPT FROM 'scriptfile.sql'");
    }
}
