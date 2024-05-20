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

    public void comprobarContra(ActionEvent event) throws IOException, SQLException {
        if (usuarioText.getText().isEmpty() || usuarioText.getText().length() > 20) {
            error1();
        } else if (contrapas.getText().isEmpty() || contrapas.getText().length() > 10) {
            error();
        } else if (!userExists(usuarioText.getText(), contrapas.getText())) {
            cerrarVentana(event);
            cambioPagina.pantalla2();
        } else {
            Informacion();
        }
    }
    public static void cerrarVentana(ActionEvent e) {
        Node source = (Node)e.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    public void error1() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText("Formato de usuario incorrecto.");
        alert.setTitle("IMPOSIBLE AÑADIR TRABAJADOR");
        alert.show();
    }


    public void error() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText("Formato de  contraseña incorrecta.");
        alert.setTitle("IMPOSIBLE AÑADIR TRABAJADOR");
        alert.show();
    }

    public void Informacion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Mensaje");
        alert.setContentText("Empleado " + usuarioText.getText() + " introducido en la base de datos");
        alert.setTitle("HECHO");
        alert.show();
    }

    public boolean userExists(String username, String password) throws SQLException {
        Connection conexion = conectarSql();
        PreparedStatement statment = conexion.prepareStatement("SELECT COUNT(*) FROM usuario WHERE nombre = ? AND contrasenya = ?");
        statment.setString(1, username);
        statment.setString(2, password);
        ResultSet resultSet = statment.executeQuery();
        resultSet.next();
        int count = resultSet.getInt(1);
        return count > 0;
    }

}
