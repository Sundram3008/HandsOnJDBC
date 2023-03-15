package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishConnectionDAO {

    private String url="jdbc:mysql://localhost:3306/student", userName="sundram", password="admin";
    public Connection makeConnection() throws SQLException {
        return DriverManager.getConnection(url, userName, password);
    }
}
