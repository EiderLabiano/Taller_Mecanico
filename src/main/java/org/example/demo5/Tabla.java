package org.example.demo5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class Tabla implements Initializable {
    public TableView<Componentes> tableView;
    public Button refreshButton;
    public TableColumn<Componentes, Integer> IDColumn;
    public TableColumn<Componentes, String> NombreClumn;
    public TableColumn<Componentes, String> ModeloColumn;
    public TableColumn<Componentes, Integer> StockColumn;
    public TableColumn<Componentes, Integer> PrecioColumn;
    ObservableList<Componentes> ListPiezas = FXCollections.observableArrayList();

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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setItems(ListPiezas);
        IDColumn.setCellValueFactory(new PropertyValueFactory<Componentes,Integer>("ID_Componente"));
        NombreClumn.setCellValueFactory(new PropertyValueFactory<Componentes,String>("Nombre"));
        ModeloColumn.setCellValueFactory(new PropertyValueFactory<Componentes,String>("modelo"));
        StockColumn.setCellValueFactory(new PropertyValueFactory<Componentes, Integer>("Stock"));
        PrecioColumn.setCellValueFactory(new PropertyValueFactory<Componentes, Integer>("precio"));
        tableView.setItems(ListPiezas);
    }

    private String getRowStyle(int stock) {
        if (stock == 0) {
            return "-fx-control-inner-background: red;";
        } else if (stock <= 5) {
            return "-fx-control-inner-background: yellow;";
        } else {
            return ""; // Sin estilo para stocks normales
        }
    }

    public ObservableList<Componentes> refrescarDatos() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerMecanico", "root", "root")) {
            String selectSQL = "SELECT * FROM Componentes";
            try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int ID = resultSet.getInt("ID_Componente");
                    String Nombre = resultSet.getString("Nombre");
                    String Modelo = resultSet.getString("Modelo");
                    int stock = resultSet.getInt("stock");
                    int precio = resultSet.getInt("precio");


                    Componentes nuevoComponente = new Componentes(ID, Nombre, Modelo, stock, precio);
                    ListPiezas.add(nuevoComponente);
                }
                return ListPiezas;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
}
