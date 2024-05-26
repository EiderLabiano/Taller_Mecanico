package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.*;

import static org.example.demo5.HelloController.cerrarVentana;

public class InsertarComponentes {
    public TextField nameID;
    public TextField modelID;
    public TextField quantityID;
    public TextField priceID;
    public Button listadoBTN;
    public HelloApplication cambioPagina;

    public InsertarComponentes(){
        cambioPagina = new HelloApplication();
    }

    public void verListado(ActionEvent event) throws IOException {
        cerrarVentana(event);
        cambioPagina.TABLA();
    }

    public void insertarDatos(ActionEvent event) throws SQLException, IOException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerMecanico", "root", "root");
        String nombre = nameID.getText();
        String modelo = modelID.getText();
        int stock = Integer.parseInt(quantityID.getText());
        int precio = Integer.parseInt(priceID.getText());

        String insertQuery = "INSERT INTO Componentes (Nombre, Modelo, Stock, Precio) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, modelo);
            preparedStatement.setInt(3, stock);
            preparedStatement.setInt(4, precio);

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Se ha insertado el componente.");
            } else {
                System.out.println("Insert failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
