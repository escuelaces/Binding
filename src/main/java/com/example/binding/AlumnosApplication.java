package com.example.binding;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AlumnosApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AlumnosApplication.class.getResource("alumnos.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 440);
        stage.setTitle("Hello!");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}