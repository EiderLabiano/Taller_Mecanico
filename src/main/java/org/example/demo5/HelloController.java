package org.example.demo5;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Timer;

public class HelloController {

    public HelloApplication cambioPagina;
    public TextField usuarioText;
    public TextField contrapas;
    public Button butSesion;

    public HelloController()
    {
        cambioPagina = new HelloApplication();
    }
    public Connection conectarSql() throws SQLException {
        String direccion = "jdbc:mysql://localhost:3306/usuarios";
        String usuario = "root";
        String contrasenya = "root";
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(direccion, usuario, contrasenya);
            String contra= contrapas.getText();
            String nomb = usuarioText.getText();
            cambioPagina.pantalla2();
            if (conexion != null) {
                return conexion;
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public void comprobarContra(ActionEvent event) throws IOException {
        if (usuarioText.getText().isEmpty()) {
            error();
        } else {
            cerrarVentana(event);
            cambioPagina.pantalla2();
        }
    }
    public static void cerrarVentana(ActionEvent e) {
        Node source = (Node)e.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    public void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText("Si no rellena los campos no se puede añadir a la lista de los usuarios");
        alert.setTitle("IMPOSIBLE AÑADIR USUARIO");
        alert.show();
    }

    public void Informacion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje");
        alert.setContentText("Empleado " + usuarioText.getText() + " introducido en la base de datos");
        alert.setTitle("HECHO");
        alert.show();
    }

}
