package org.example.demo5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

import java.io.IOException;
import java.sql.*;

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
        String direccion = "jdbc:mysql://localhost:3306/programacion";
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



}
