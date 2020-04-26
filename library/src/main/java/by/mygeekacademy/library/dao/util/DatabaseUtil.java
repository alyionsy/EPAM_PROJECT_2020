package by.mygeekacademy.library.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private String database;

    public DatabaseUtil(String database){
        this.database = database;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public Connection getConnection() throws SQLException {
        String url = "jdbc:sqlserver://192.168.99.104:1433;";
        String user = "user=sa;";
        String password = "password=MicrosoftTheBest2020;";
        String database = String.format("database=%s;", this.database);
        String connectionUrl = url + database + user + password;
        return DriverManager.getConnection(connectionUrl);
    }

    public static void connectionFailed() {
        System.out.println("You can't you the program without correct Database connection.");
        System.exit(0);
    }
}
