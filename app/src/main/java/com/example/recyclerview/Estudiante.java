package com.example.recyclerview;

import java.io.Serializable;

public class Estudiante implements Serializable {
    private String nombre;
    private String apellido;
    private String carrera;
    private String sexo;

    public Estudiante(String nombre, String apellido, String carrera, String sexo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.sexo = sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
