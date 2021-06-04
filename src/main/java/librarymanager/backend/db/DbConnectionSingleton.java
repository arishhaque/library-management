package librarymanager.backend.db;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class DbConnectionSingleton {

    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "library_db";
    String driver = "com.mysql.cj.jdbc.Driver";
    String userName = "admin";
    String password = "admin";

    private static DbConnectionSingleton dbConnectionObj;

    private Connection con;

    private DbConnectionSingleton() {
        con = createConnection();
    }


    public Connection createConnection() {

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

    public static DbConnectionSingleton getInstance() {

        if (dbConnectionObj == null) {
            dbConnectionObj = new DbConnectionSingleton();
        }
        return dbConnectionObj;
    }
}
