package com.example.binding;

import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;

import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.util.*;



public class HelloController {
    @FXML
    public Label alumnoActual;
    public TextField notaMediaTF;

    SimpleObjectProperty<ObservableList<Alumno>> alumnosProperty = new SimpleObjectProperty<>(
            FXCollections.observableArrayList()
    );

    ReadOnlyProperty<FilteredList<Alumno>> alumnosFiltradosProperty = new SimpleObjectProperty<>(
            new FilteredList<>(alumnosProperty.get())
    );

    @FXML
    public ChoiceBox clase;
    public ListView listaAlumnos;
    public TextField edadTF;
    public TextField notaMedia;

    SimpleIntegerProperty edadProperty = new SimpleIntegerProperty(){{
        addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {

            }
        });
    }};
    SimpleIntegerProperty notaMediaProperty = new SimpleIntegerProperty();

    List<Alumno> alumnos = new ArrayList<Alumno>(){{
      add(new Alumno(){{ nombre = "Rodrigo"; apellidos= "Alvarez"; edad=20; notaMedia=6; }});
        add(new Alumno(){{ nombre = "Aaron"; apellidos= "Blanco"; edad=19; notaMedia=7; }});
        add(new Alumno(){{ nombre = "Alfonso"; apellidos= "Caballero"; edad=20; notaMedia=5; }});
        add(new Alumno(){{ nombre = "Alvaro"; apellidos= "Gonzalo"; edad=19; notaMedia=6; }});
        add(new Alumno(){{ nombre = "Ismael"; apellidos= "Dominguez"; edad=21; notaMedia=5; }});
        add(new Alumno(){{ nombre = "Juan Fernando"; apellidos= "Falla"; edad=20; notaMedia=7; }});
        add(new Alumno(){{ nombre = "Claudia"; apellidos= "Fernandez"; edad=21; notaMedia=8; }});

    }};

    @FXML
    void initialize(){
        clase.getItems().addAll(alumnos);
        clase.setValue(alumnos.stream().findFirst().get());


        edadTF.textProperty().bindBidirectional(edadProperty,new NumberStringConverter());
        notaMediaTF.textProperty().bindBidirectional(notaMediaProperty,new NumberStringConverter());
        //Lista
        alumnosProperty.get().addAll(alumnos);
        listaAlumnos.itemsProperty().bind(alumnosFiltradosProperty);

    }


    public void onAlumnoSelec(ActionEvent actionEvent) {
        alumnoActual.setText(clase.getValue().toString());
    }
}