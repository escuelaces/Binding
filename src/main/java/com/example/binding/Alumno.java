package com.example.binding;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Alumno {
        public SimpleStringProperty nombre;
        public SimpleStringProperty apellidos;
        public SimpleIntegerProperty edad;
        public SimpleIntegerProperty notaMedia;



    @Override
    public String toString() {
        return  String.format(" %s %s", nombre, apellidos);
    }

    public Alumno(String nombre, String apellidos, Integer edad, Integer notaMedia) {
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.edad = new SimpleIntegerProperty(edad);
        this.notaMedia = new SimpleIntegerProperty(notaMedia);
    }
}
