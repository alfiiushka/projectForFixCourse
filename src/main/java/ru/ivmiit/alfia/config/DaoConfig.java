package ru.ivmiit.alfia.config;

import org.hibernate.cfg.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.ivmiit.alfia.model.StoreUser;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DaoConfig {

    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = getProperties();
        Class.forName(properties.getProperty("dataSource.driverClassName"));
        return DriverManager.getConnection(properties.getProperty("dataSource.url"),
                properties.getProperty("dataSource.user"), properties.getProperty("dataSource.password"));
    }

    public DataSource getDataSource() throws IOException {
        Properties properties = getProperties();
        DriverManagerDataSource dataSource = new DriverManagerDataSource(properties.getProperty("dataSource.url"),
                properties.getProperty("dataSource.user"), properties.getProperty("dataSource.password"));
        dataSource.setDriverClassName(properties.getProperty("dataSource.driverClassName"));
        return dataSource;
    }

    public Configuration getConfiguration() throws IOException {
        Configuration configuration = new Configuration();
        Properties properties = getProperties();
        configuration.setProperty("hibernate.connection.url", properties.getProperty("dataSource.url"));
        configuration.setProperty("hibernate.connection.username", properties.getProperty("dataSource.user"));
        configuration.setProperty("hibernate.connection.password", properties.getProperty("dataSource.password"));
        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("dataSource.driverClassName"));
        configuration.setProperty("hibernate.dialect", properties.getProperty("hibernate.dialect"));
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.addAnnotatedClass(StoreUser.class);
        return configuration;
    }

    private Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String resourceName = "datasource.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            properties.load(resourceStream);
        }
        return properties;
    }

}
