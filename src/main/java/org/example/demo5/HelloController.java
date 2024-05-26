package org.example.demo5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.Timer;

public class HelloController {

    public HelloApplication cambioPagina;
    public TextField usuarioText;
    public PasswordField contrapas;
    public Button butSesion;
    public Button refreshButton;
    public ListView<String> componentes = new ListView<>();
    public ComboBox<String> choice;
    private ObservableList<String> piezas = FXCollections.observableArrayList();

    public HelloController()
    {
        cambioPagina = new HelloApplication();
    }
    public void cambio(ActionEvent event) throws IOException {
        cerrarVentana(event);
        cambioPagina.TABLA();
    }
    public boolean conectarSql(ActionEvent event) throws SQLException, IOException {
        Conexion connection = new Conexion();

        connection.statement.execute("use TallerMecanico");
        String nombre = usuarioText.getText();
        String contrasenya = contrapas.getText();

        ResultSet resultSet = connection.statement.executeQuery("select Nombre, Contraseña from usuarios where Nombre = '" + nombre + "' AND Contraseña = '" + contrasenya + "'");
        if (resultSet.next()) {
            String nombreEnBaseDeDatos = resultSet.getString("Nombre");
            if (nombreEnBaseDeDatos.equals(nombre))
            {
                cambio(event);
                return true;
            }
        } else {
            error1();
            return false;
        }
        return false;
    }

    public static void cerrarVentana(ActionEvent e) {
        Node source = (Node)e.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    public void error1() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Error");
        alert.setContentText("El usuario con el que está intentando logearse no tiene permisos para acceder a la aplicación, contacte con el CAU para poder solucionarlo.");
        alert.setTitle("IMPOSIBLE INICIAR SESION");
        alert.show();
    }
}
