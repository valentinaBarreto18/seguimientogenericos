package org.example.persistenciaBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static final String URL = DataBaseConfig.getUrl();
    private static final String USER = DataBaseConfig.getUser();
    private static final String PASSWORD = DataBaseConfig.getPassword();

    public static Connection getConnection() throws SQLException {
        // Crea una nueva conexión en cada llamada
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

