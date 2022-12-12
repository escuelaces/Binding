package com.example.binding;

public class Alumno {
        String nombre;
        String apellidos;
        Integer edad;
        Integer notaMedia;

    public Integer getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNotaMedia() {
        return notaMedia;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString() {
        return  String.format(" %s %s", nombre, apellidos);
    }


}
