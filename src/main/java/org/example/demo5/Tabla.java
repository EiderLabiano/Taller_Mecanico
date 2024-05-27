package org.example.demo5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static org.example.demo5.HelloController.cerrarVentana;

public class Tabla implements Initializable {
    public TableView<Componentes> tableView;
    public Button refreshButton;
    public TableColumn<Componentes, Integer> IDColumn;
    public TableColumn<Componentes, String> NombreClumn;
    public TableColumn<Componentes, String> ModeloColumn;
    public TableColumn<Componentes, Integer> StockColumn;
    public TableColumn<Componentes, Integer> PrecioColumn;
    public Button idComponente;
    public ListView<Componentes> compos;
    public HelloApplication cambioPagina;
    ObservableList<Componentes> ListPiezas = FXCollections.observableArrayList();

    public Tabla()
    {
        cambioPagina = new HelloApplication();
        compos = new ListView<>();
    }

    public void insertarComponente(ActionEvent event) throws IOException {
        cerrarVentana(event);
        cambioPagina.insertar();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setItems(ListPiezas);
        IDColumn.setCellValueFactory(new PropertyValueFactory<Componentes,Integer>("ID_Componente"));
        NombreClumn.setCellValueFactory(new PropertyValueFactory<Componentes,String>("Nombre"));
        ModeloColumn.setCellValueFactory(new PropertyValueFactory<Componentes,String>("modelo"));
        StockColumn.setCellValueFactory(new PropertyValueFactory<Componentes, Integer>("Stock"));
        PrecioColumn.setCellValueFactory(new PropertyValueFactory<Componentes, Integer>("precio"));
        tableView.setItems(ListPiezas);
        tableView.setRowFactory(tv -> new TableRow<Componentes>() {
            @Override
            protected void updateItem(Componentes item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setStyle("");
                } else {
                    setStyle(getRowStyle(item.getStock()));
                }
            }
        });
    }
    private String getRowStyle(int stock) {
        if (stock == 0) {
            return "-fx-background-color:#FF0000";
        } else if (stock <= 5) {
            return "-fx-background-color:#FFFF00";
        } else {
            return "";
        }
    }

    public ObservableList<Componentes> refrescarDatos() {
        ListPiezas.clear();
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
            return null;
        }
    }
}
