package com.dam.accesodata;

import java.util.Scanner;

public class GestorNotas {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ManejadorArchivos manejador = new ManejadorArchivos();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1:
                    añadirEstudiante();
                    break;
                case 2:
                    mostrarEstudiantes();
                    break;
                case 3:
                    buscarEstudiante();
                    break;
                case 4:
                    calcularMedia();
                    break;
                case 5:
                    System.out.println("Saliendo del programa... ¡Adiós!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();  // Cierra el scanner al finalizar el programa
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Gestor de Notas de Estudiantes ---");
        System.out.println("1. Añadir estudiante");
        System.out.println("2. Mostrar todos los estudiantes");
        System.out.println("3. Buscar estudiante");
        System.out.println("4. Calcular nota media");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();  // Descartar entrada inválida
        }
        return scanner.nextInt();
    }

    private static void añadirEstudiante() {
        scanner.nextLine();  // Limpiar el buffer
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la nota del estudiante: ");
        double nota = leerNotaValida();  // Validar que la nota sea un número válido

        Estudiante estudiante = new Estudiante(nombre, nota);
        manejador.añadirEstudiante(estudiante);
    }

    private static double leerNotaValida() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Por favor, ingrese un valor numérico para la nota.");
            scanner.next();  // Descartar entrada inválida
        }
        return scanner.nextDouble();
    }

    private static void mostrarEstudiantes() {
        System.out.println("\n--- Lista de Estudiantes ---");
        manejador.mostrarEstudiantes();
    }

    private static void buscarEstudiante() {
        scanner.nextLine();  // Limpiar el buffer
        System.out.print("Ingrese el nombre del estudiante a buscar: ");
        String nombre = scanner.nextLine();
        manejador.buscarEstudiante(nombre);
    }

    private static void calcularMedia() {
        System.out.println("\n--- Nota Media de los Estudiantes ---");
        manejador.calcularMedia();
    }
}
