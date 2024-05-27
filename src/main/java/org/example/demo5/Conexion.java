package org.example.demo5;

import java.sql.*;

public class Conexion {
    private Connection connection;
    private Statement statement;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Conexion() throws SQLException, SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "root");
        statement = connection.createStatement();
    }
}
