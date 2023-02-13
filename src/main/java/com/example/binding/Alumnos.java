package com.example.binding;

import javafx.beans.property.ReadOnlyProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

public class Alumnos {
    public static Alumnos instance = new Alumnos();

    // Lista alumnos
    SimpleObjectProperty<ObservableList<Alumno>> list = new SimpleObjectProperty<>(
            FXCollections.observableArrayList(
                    new Alumno("Rodrigo","Alvarez",18, 5 ),
                    new Alumno("Aaron","Blanco",19, 9 ),
                    new Alumno("Alfonso","Caballero",20, 6 ),
                    new Alumno("Alvaro","Gonzalo",18, 6 ),
                    new Alumno("Ismael","Dominguez",21, 5 ),
                    new Alumno("Juan Fernando","Falla",20, 5 ),
                    new Alumno("Claudia","Fernandez",20, 7 )
            )
    );

    //Lista filtrada de alumnos
    ReadOnlyProperty<FilteredList<Alumno>> filteredList = new SimpleObjectProperty<>(
            new FilteredList<>(list.get())
    );


    //Filtros
    SimpleIntegerProperty edad = new SimpleIntegerProperty(){{
        addListener((observableValue, oldEdad, edad) -> {
            filteredList.getValue().setPredicate(alumno ->
                ((edad.intValue() != 0) ? (alumno.edad.getValue() == edad) : true) &&
                        ((notaMedia.get() != 0) ? (alumno.notaMedia.get() == notaMedia.get()) : true)
            );
        });
    }};
    SimpleIntegerProperty notaMedia = new SimpleIntegerProperty(){{
        addListener((observableValue, oldEdad, notaMedia )->
            filteredList.getValue().setPredicate( alumno ->
                    ((notaMedia.intValue() != 0 ) ? (alumno.notaMedia.getValue() == notaMedia): true) &&
                            ((edad.get() != 0) ? (alumno.edad.get() == edad.get()) : true)
            )
        );
    }};



    SimpleObjectProperty<Alumno> seleccionado = new SimpleObjectProperty<>(){{
        addListener((observableValue, alumno, newAlumno) -> {
            if (newAlumno != null)
                System.out.println("Alumno Seleccionado: " + newAlumno.nombre.get());
        });

    }};





}
