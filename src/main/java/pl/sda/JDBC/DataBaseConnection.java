package pl.sda.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private final String url = "jdbc:mysql://localhost:3306/test?serverTime=CET";
    private final String user = "root";
    private final String password = "zdjavapol105";

    private Connection connection;

    public DataBaseConnection(){

        try {
            this.connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}
