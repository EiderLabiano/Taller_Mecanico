package org.example.demo5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQL {
    public static void main(String[] args) {
        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tallerCoches", "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Almacen");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("ID_Almacen"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
