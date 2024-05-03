package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

import java.sql.*;

public class SQL {
    public static Connection conexion = null;

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


    @FXML
    private void mostrarAlertError(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText("Error en la aplicacion");
        alert.showAndWait();
    }
}