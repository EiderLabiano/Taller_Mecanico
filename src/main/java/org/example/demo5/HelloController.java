package org.example.demo5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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

public class HelloController implements Initializable{

    public HelloApplication cambioPagina;
    public TextField usuarioText;
    public TextField contrapas;
    public Button butSesion;
    public Button refreshButton;
    public ListView<String> componentes;
    public ComboBox<String> choice;
    public HelloController()
    {
        cambioPagina = new HelloApplication();
    }
    public Connection conectarSql() {
        String direccion = "jdbc:mysql://localhost:3306/TallerMecanico";
        String usuario = "root";
        String contrasenya = "root";
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(direccion, usuario, contrasenya);
            if (conexion != null) {
                return conexion;
            }
        } catch (SQLException e) {
            System.out.println("Error al acceder");
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
            cambioPagina.TABLA();
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

    public void refresh() {
        try {
            Connection connection = conectarSql();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from Componentes");
            componentes.getItems().clear();
            while (resultSet.next()) {
                componentes.getItems().add(resultSet.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al refrescar");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       
    }
}
