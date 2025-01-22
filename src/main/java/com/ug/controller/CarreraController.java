package com.ug.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ug.model.Carrera;

public class CarreraController {

    private static int idCarrera = 0;

    private static List<Carrera> carreras = new ArrayList<>(Arrays.asList(
            new Carrera(1, "Ingenieria en Sistemas", "Carrera de Ingenieria en Sistemas", "Activa",
                    "Ciencias Matermaticas y de la Computacion", new ArrayList<Integer>(Arrays.asList(1, 2, 3)),
                    new ArrayList<>()),
            new Carrera(2, "Ingenieria en Mecatronica", "Carrera de Ingenieria en Mecatronica", "Activa",
                    "Ingenieria Mecanica", new ArrayList<>(Arrays.asList(4)), new ArrayList<>()),
            new Carrera(3, "Ingenieria en Electronica", "Carrera de Ingenieria en Electronica", "Activa",
                    "Ingenieria Electrica", new ArrayList<>(Arrays.asList(5)), new ArrayList<>())));

    public static String agregarCarrera(Carrera carrera) {
        carrera.setIdCarrera(++idCarrera);
        carreras.add(carrera);
        System.out.println("Carrera agregada correctamente!");
        return "Carrera agregada correctamente!";
    }

    /*
     * Eliminar una carrera
     */
    public static String eliminarCarrera(int idCarrera) {
        carreras.removeIf((c) -> c.getIdCarrera() == idCarrera);
        System.out.println("Carrera eliminada correctamente!");
        return "Carrera eliminada correctamente!";
    }

    /*
     * Modificar una carrera
     */
    public static String modificarCarrera(Carrera carrera, Carrera carreraNueva) {
        carreras.set(carreras.indexOf(carrera), carreraNueva);
        System.out.println("Carrera modificada correctamente!");
        return "Carrera modificada correctamente!";
    }

    /*
     * Buscar una carrera
     */
    public static Carrera buscarCarrera(int idCarrera) {
        return carreras.stream().filter(((c) -> c.getIdCarrera() == idCarrera)).findFirst().orElse(null);
    }

    /*
     * Obtener todas las carreras
     */
    public static List<Carrera> obtenerCarreras() {
        return new ArrayList<>(carreras);
    }

    /* 
     * Agregar curso a carrera
     */
    public static String agregarCursoACarrera(int idCarrera, int idCurso) {

        for (Carrera carrera : carreras) {
            if (carrera.getIdCarrera() == idCarrera)
                carrera.getCursos().add(idCurso);
            return "Curso agregado a la carrera correctamente";
        }
        return "No se pudo agregar el curso a la carrera";
    }

    /* 
     * Agregar estudiante a carrera
     */
    public static String agregarEstudianteACarrera(int idCarrera, int idEstudiante) {

        for (Carrera carrera : carreras) {
            if (carrera.getIdCarrera() == idCarrera)
                carrera.getEstudiantes().add(idEstudiante);
            return "Estudiante agregado a la carrera correctamente";
        }
        return "No se pudo agregar el estudiante a la carrera";
    }
}
