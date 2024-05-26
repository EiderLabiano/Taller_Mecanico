package org.example.demo5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    Connection connection;
    Statement statement;

    public Conexion() throws SQLException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
        statement = connection.createStatement();
    }
}
