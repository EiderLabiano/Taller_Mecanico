package org.example.demo5;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;
import static org.example.demo5.HelloController.cerrarVentana;

public class PedidoController implements Initializable {

    public TableView<Componentes> tableView;
    public TableColumn<Componentes, Integer> IDColumn;
    public TableColumn<Componentes, String> NombreClumn;
    public TableColumn<Componentes, String> ModeloColumn;
    public TableColumn<Componentes, Integer> StockColumn;
    public TableColumn<Componentes, Integer> PrecioColumn;
    public HelloApplication cambioPagina;
    public Button BotonRealizarPedido;
    public TableColumn<Pedidos, String> PedidoProducto;
    public TableColumn<Pedidos, Integer> CantidadProducto;
    public TableColumn<Pedidos, Integer> PrecioProducto;
    public TableView<Pedidos> TableProducto;
    public TextField CantidadPedidos;
    public TextField nameTxt;
    public TextField apelidoTxt;
    public TextField direccionTxt;
    private HelloApplication a;

    public PedidoController() {
        a = new HelloApplication();
    }

    ObservableList<Componentes> ListPiezas = FXCollections.observableArrayList();
    ObservableList<Pedidos> ListPedidos = FXCollections.observableArrayList();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setItems(ListPiezas);
        TableProducto.setItems(ListPedidos);
        IDColumn.setCellValueFactory(new PropertyValueFactory<Componentes, Integer>("ID_Componente"));
        NombreClumn.setCellValueFactory(new PropertyValueFactory<Componentes, String>("Nombre"));
        ModeloColumn.setCellValueFactory(new PropertyValueFactory<Componentes, String>("modelo"));
        StockColumn.setCellValueFactory(new PropertyValueFactory<Componentes, Integer>("Stock"));
        PrecioColumn.setCellValueFactory(new PropertyValueFactory<Componentes, Integer>("precio"));
        PedidoProducto.setCellValueFactory(new PropertyValueFactory<Pedidos, String>("nombreComponente"));
        CantidadProducto.setCellValueFactory(new PropertyValueFactory<Pedidos, Integer>("cantidad"));
        PrecioProducto.setCellValueFactory(new PropertyValueFactory<Pedidos, Integer>("precio"));
        TableProducto.setItems(ListPedidos);
        tableView.setItems(ListPiezas);
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Componentes> observableValue, Componentes componentes, Componentes t1) {
                String componente = tableView.getSelectionModel().getSelectedItem().getNombre();
                int precio = tableView.getSelectionModel().getSelectedItem().getPrecio();
            }
        });
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

    public void anadir() throws SQLException {
        String componente = tableView.getSelectionModel().getSelectedItem().getNombre();
        int precio = tableView.getSelectionModel().getSelectedItem().getPrecio();
        anadirALaBolsa(componente, precio);
    }

    public void anadirALaBolsa(String nombre, int precio) throws SQLException {
        int cantidad = parseInt(CantidadPedidos.getText());
        System.out.println(cantidad);
        int precioTotal = cantidad * precio;
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerMecanico", "root", "root")) {
            String insertQuery = "INSERT INTO Pe (NombreC, Cantidad, Precio) VALUES (?, ?, ?)";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, nombre);
                preparedStatement.setInt(2, cantidad);
                preparedStatement.setInt(3, precioTotal);
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
        }
        return null;
    }

    public ObservableList<Pedidos> refrescarPedidos() {
        ListPedidos.clear();
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerMecanico", "root", "root")) {
            String selectSQL = "SELECT * FROM Pe";
            try (PreparedStatement statement = connection.prepareStatement(selectSQL)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String Nombre = resultSet.getString("NombreC");
                    int cantidad = resultSet.getInt("Cantidad");
                    int precio = resultSet.getInt("Precio");

                    Pedidos Pedido = new Pedidos(Nombre, cantidad, precio);
                    ListPedidos.add(Pedido);
                }
                return ListPedidos;
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    public void realizarPedidio() throws SQLException {
        StringBuilder componentes = new StringBuilder();
        int precioTotal = 0;
        for (Pedidos listPedido : ListPedidos) {
            quitar(listPedido.getCantidad(), listPedido.getNombreComponente());
            precioTotal = precioTotal + listPedido.getPrecio();
            componentes.append(" ").append(listPedido.getNombreComponente());
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerMecanico", "root", "root")) {
            String insertQuery = "INSERT INTO Averias (NombreUsuario, apellido, direccion, componentes, Precio) VALUES (?, ?, ?, ?, ?)";

            try {
                PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                preparedStatement.setString(1, nameTxt.getText());
                preparedStatement.setString(2, apelidoTxt.getText());
                preparedStatement.setString(3, direccionTxt.getText());
                preparedStatement.setString(4, componentes.toString());
                preparedStatement.setInt(5, precioTotal);
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerMecanico", "root", "root")) {
            Statement statement = connection.createStatement();

            // Ejecutar la consulta de eliminación
            String deleteQuery = "DELETE FROM pe";
            statement.executeUpdate(deleteQuery);
        }
    }

    public static void cerrarVentana(ActionEvent e) {
        Node source = (Node) e.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void quitar(int cantidad, String nombre) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerMecanico", "root", "root")) {
            String selectSQL = "SELECT stock FROM Componentes WHERE nombre = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            selectStatement.setString(1, nombre);
            ResultSet resultado = selectStatement.executeQuery();
            if (resultado.next()) {
                int stockActual = resultado.getInt("stock");
                String updateSQL = "UPDATE COMPONENTES SET STOCK = ? WHERE nombre = ?";
                int resta = stockActual - cantidad;
                if (resta <0)
                {
                    System.out.println("No se puede hacer la compra");
                }
                else {
                    PreparedStatement updateStatement = connection.prepareStatement(updateSQL);
                    updateStatement.setInt(1, resta);
                    updateStatement.setString(2, nombre);
                    updateStatement.execute();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
