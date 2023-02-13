package com.example.binding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AlumnoController {

    public Button back;
    public Label nombre;
    public Label apellidos;

    Alumnos alumnos = Alumnos.instance;
    public Scene preScene;

    @FXML
    void initialize(){
        nombre.textProperty().bind(alumnos.seleccionado.get().nombre);
        apellidos.textProperty().bind(alumnos.seleccionado.get().apellidos);
    }

    public void onBack(ActionEvent event) {
            ((Stage)back.getScene().getWindow()).setScene(preScene);
    }
}
