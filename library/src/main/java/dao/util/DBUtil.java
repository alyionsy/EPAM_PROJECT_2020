package dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private String database;

    public DBUtil(String database){
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
}
