package org.example.persistenciaBase;

import java.io.IOException;
import java.util.Properties;

public class DataBaseConfig {
    private static Properties properties = new Properties();

    static {
        try {
            // Cargar el archivo de propiedades desde el classpath
            properties.load(DataBaseConfig.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUser() {
        return properties.getProperty("db.user");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }
}

