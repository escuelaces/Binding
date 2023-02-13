package com.example.binding;

import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;

import java.io.IOException;
import java.util.stream.IntStream;


public class AlumnosController {

    // Tabla Alumnos
    public TableView<Alumno> tablaAlumnos;
    public TableColumn<Alumno,String> Nombre;
    public TableColumn<Alumno,String> Apellidos;
    public TableColumn<Alumno,Integer> Edad;
    public TableColumn<Alumno,Integer> NotaMedia;


    //Datos alumnos
    Alumnos alumnos = Alumnos.instance;

    // Filtros
    @FXML
    public TextField notaMediaTF;
    @FXML
    public TextField edadTF;



    @FXML
    void initialize()  {

        // Enlazar la lista con los datos de los alumnos
        tablaAlumnos.itemsProperty().bind(alumnos.filteredList);

        //Establecer el valor de la celda para cada columna
        Nombre.setCellValueFactory(cellData -> cellData.getValue().nombre);
        Apellidos.setCellValueFactory(cellData -> cellData.getValue().apellidos);
        Edad.setCellValueFactory(cellData -> cellData.getValue().edad.asObject());
        NotaMedia.setCellValueFactory(cellData -> cellData.getValue().notaMedia.asObject());

        // Imagenes para  representar la nota media
        Image star = new Image("https://miro.medium.com/max/1200/1*sz3x5iKbBV_iJ2-47CmfIA.jpeg", 20.0,20.0, true, true);
        Image blackStar = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Black_star.png/1200px-Black_star.png", 20.0,20.0, true, true);

        NotaMedia.setCellFactory(columna -> new TableCell<>() {

            @Override
            protected void updateItem(Integer notaMedia, boolean empty) {
                super.updateItem(notaMedia, empty);

                if (notaMedia == null || empty){
                    setGraphic(null);
                    return;
                }

                var starBox = new HBox();

                // Añadir una estrella por cada punto en la nota
                for (int n=0; n < 10; n++){
                    starBox.getChildren().add(new ImageView( (n < notaMedia) ? star : blackStar));
                }

                setGraphic(starBox);

            }
        });


        //Enlazamos el alumno seleccionado con la propiedad selected de la lista
        alumnos.seleccionado.bind(tablaAlumnos.getSelectionModel().selectedItemProperty());

        tablaAlumnos.getSelectionModel().selectedItemProperty().addListener((observableValue, oldAlumno, alumno)  -> {
            try {
                var loader = new FXMLLoader(getClass().getResource("alumno.fxml"));
                var newScene = new  Scene(loader.load(),1080,240);

                var alumnoController = (AlumnoController)loader.getController();
                alumnoController.preScene = tablaAlumnos.getScene();

                ((Stage)tablaAlumnos.getScene().getWindow()).setScene(newScene);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        //Enlazamos los cuadros de texto con las propiedades edad y notaMedia de alumnos
        edadTF.textProperty().bindBidirectional(alumnos.edad,new NumberStringConverter());
        notaMediaTF.textProperty().bindBidirectional(alumnos.notaMedia,new NumberStringConverter());




    }



}