package org.example.demo5;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication   extends Application {

    public Stage stage;

    public HelloApplication()
    {
        stage = new Stage();
    }

    @Override

    public void start(Stage stage) throws IOException {
        this.stage = stage;
        pantallaPrincipal();
    }
    public void pantallaPrincipal() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void pantalla2() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Vacio.class.getResource("vacio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


}
