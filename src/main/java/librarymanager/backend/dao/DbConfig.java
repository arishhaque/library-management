package librarymanager.backend.dao;


import librarymanager.util.PropertiesLoader;

import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


// singleton
public class DbConfig {

    private static DbConfig dbConnectionObj;

    private Connection con;


    public Connection getConnection() {

        try {
            // Load the JDBC driver
            Class driver_class = Class.forName(PropertiesLoader
                    .loadProperties().getProperty("db.jdbc.driverClassName"));
            Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(
                    PropertiesLoader.loadProperties().getProperty("db.jdbc.url"),
                    PropertiesLoader.loadProperties().getProperty("db.jdbc.user"),
                    PropertiesLoader.loadProperties().getProperty("db.jdbc.pass"));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static DbConfig getInstance() {

        if (dbConnectionObj == null) {
            dbConnectionObj = new DbConfig();
        }
        return dbConnectionObj;
    }
}
