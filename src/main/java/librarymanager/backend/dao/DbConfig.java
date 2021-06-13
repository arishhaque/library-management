package librarymanager.backend.dao;


import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


// singleton
public class DbConfig {

    final String url = "jdbc:mysql://localhost:3306/";
    final String dbName = "library_db";
    final String driver = "com.mysql.cj.jdbc.Driver";
    final String userName = "admin";
    final String password = "admin";

    private static DbConfig dbConnectionObj;

    private Connection con;


    public Connection getConnection() {

        try {
            // Load the JDBC driver
            Class driver_class = Class.forName(driver);
            Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url + dbName, userName, password);

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

    public static DbConfig getInstance() {

        if (dbConnectionObj == null) {
            dbConnectionObj = new DbConfig();
        }
        return dbConnectionObj;
    }
}
