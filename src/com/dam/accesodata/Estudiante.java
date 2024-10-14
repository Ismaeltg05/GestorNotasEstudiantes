package com.dam.accesodata;

public class Estudiante {
    private String nombre;
    private double nota;

    // Constructor para inicializar un estudiante con nombre y nota
    public Estudiante(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    // Getters para acceder al nombre y la nota
    public String getNombre() {
        return nombre;
    }

    public double getNota() {
        return nota;
    }

    // Método toString para representar al estudiante como texto
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Nota: " + nota;
    }
}
