package librarymanager.backend.dbconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

//@PropertySource({ "classpath:application.properties" })
//@Configuration
//@Component
public class DbConnectionSingleton {

    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "library_db";
    String driver = "com.mysql.cj.jdbc.Driver";
    String userName = "admin";
    String password = "admin";

    private static DbConnectionSingleton dbConnectionObj;

    private Connection con;

   @Autowired
   private Environment env;

    private DbConnectionSingleton() {
    }



    public Connection getConnection() {

        try {
            // Load the JDBC driver

            Class driver_class = Class.forName(driver);
            Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url + dbName, userName, password);

             /* create dao and dao impl
            Class driver_class = Class.forName(env.getProperty("db.jdbc.driverClassName"));
            Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(env.getProperty("db.jdbc.url"),
                    env.getProperty("db.jdbc.user"), env.getProperty("db.jdbc.pass"));

             */

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static DbConnectionSingleton getInstance() {

        if (dbConnectionObj == null) {
            dbConnectionObj = new DbConnectionSingleton();
        }
        return dbConnectionObj;
    }
}
