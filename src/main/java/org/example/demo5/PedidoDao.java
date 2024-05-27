package org.example.demo5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PedidoDao implements Initializable {

    public TableColumn<Averia, Integer> IDAveria;
    public TableColumn<Averia, String> IDNombre;
    public TableColumn<Averia, String> IDApellidos;
    public TableColumn<Averia, String> IDDireccion;
    public TableColumn<Averia, String> IDComponentes;
    public TableColumn<Averia, Integer> IDPrecio;
    public TableView<Averia> TablaAveria;
    private HelloApplication a;
    public PedidoDao()
    {
        a = new HelloApplication();
    }
    ObservableList<Averia> ListAveria = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TablaAveria.setItems(ListAveria);
        IDAveria.setCellValueFactory(new PropertyValueFactory<Averia, Integer>("IdPedido"));
        IDNombre.setCellValueFactory(new PropertyValueFactory<Averia, String>("Nombre"));
        IDApellidos.setCellValueFactory(new PropertyValueFactory<Averia, String>("apellido"));
        IDDireccion.setCellValueFactory(new PropertyValueFactory<Averia, String>("direccion"));
        IDComponentes.setCellValueFactory(new PropertyValueFactory<Averia, String>("Componentes"));
        IDPrecio.setCellValueFactory(new PropertyValueFactory<Averia, Integer>("Precio"));
        TablaAveria.setItems(ListAveria);
    }
    public ObservableList<Averia> refrescar()
    {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerMecanico", "root", "root")) {
            String selectSQL = "SELECT * FROM Averias";
            try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int ID = resultSet.getInt("IdPedido");
                    String Nombre = resultSet.getString("NombreUsuario");
                    String Apellido = resultSet.getString("apellido");
                    String Direccion = resultSet.getString("direccion");
                    String Componentes = resultSet.getString("componentes");
                    int precio = resultSet.getInt("Precio");


                    Averia averia = new Averia(ID, Nombre, Apellido, Direccion, Componentes, precio);
                    ListAveria.add(averia);
                }
                return ListAveria;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }
    public static void cerrarVentana(ActionEvent e) {
        Node source = (Node)e.getSource();
        Stage stage = (Stage)source.getScene().getWindow();
        stage.close();
    }
    public void cambio() throws IOException {
        a.pantallaPrincipal();
    }
}
