package ru.ivmiit.alfia.config;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoConfig {

    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        String resourceName = "datasource.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            prop.load(resourceStream);
        }
        Class.forName(prop.getProperty("dataSource.driverClassName"));
        return DriverManager.getConnection(prop.getProperty("dataSource.url"),
                prop.getProperty("dataSource.user"), prop.getProperty("dataSource.password"));
    }
}
