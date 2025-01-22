package com.ug.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ug.excepciones.EstudianteException;
import com.ug.model.Estudiante;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EstudianteController {

    /*
     * Id del estudiante
     */
    private static int idEstudiante = 0;
    /*
     * Lista de estudiantes, con algunos seteados
     */
    static List<Estudiante> estudiantes = new ArrayList<>(Arrays.asList(
            new Estudiante(++idEstudiante, "Juan", "Perez", "0956986020", "jose@email.com", "0939262243", "Olmedo",
                    "04/07/1998",
                    "Activo", "01/01/2021", 1),
            new Estudiante(++idEstudiante, "Juan", "Perez", "0956986020", "jose@email.com", "0939262243", "Olmedo",
                    "04/07/1998",
                    "Activo", "01/01/2021", 2)));

    /*
     * Agregar un estudiante
     */
    public static String agregarEstudiante(Estudiante estudiante) throws EstudianteException {

        if(!estudiante.esValidoCorreo())
            throw new EstudianteException("Correo no valido");

        estudiante.setIdEstudiante(++idEstudiante);
        estudiantes.add(estudiante);

        return "Estudiante agregado con éxito";
    }

    /*
     * Eliminar un estudiante
     */
    public static String eliminarEstudiante(int id) {
        estudiantes.removeIf(estudiante -> estudiante.getIdEstudiante() == id);
        System.out.println("Estudiante eliminado");
        return "Estudiante eliminado con éxito";
    }

    /*
     * Editar un estudiante
     */
    public static String editarEstudiante(Estudiante estudiante) throws EstudianteException {
        for (Estudiante e : estudiantes) {
            if (e.getIdEstudiante() == estudiante.getIdEstudiante()) {
                e.setNombre(estudiante.getNombre());
                e.setApellido(estudiante.getApellido());
                e.setCorreo(estudiante.getCorreo());
                e.setTelefono(estudiante.getTelefono());
                e.setDireccion(estudiante.getDireccion());
                e.setFechaNacimiento(estudiante.getFechaNacimiento());
                e.setFechaIngreso(estudiante.getFechaIngreso());
                if(estudiante.getIdCarrera() != 0)
                    e.setIdCarrera(estudiante.getIdCarrera());

                System.out.println("Estudiante editado con éxito");
                return "Estudiante editado con éxito";
            }
        }
        throw new EstudianteException("Estudiante no encontrado");

    }

    /*
     * Buscar un estudiante por nombre
     */
    public static Estudiante buscarEstudiante(String nombre) {
        return estudiantes.stream().filter(((c) -> c.getNombre().equals(nombre))).findFirst().orElse(null);
    }

    /*
     * Obtener la lista de estudiantes
     */
    public static List<Estudiante> obtenerEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

}
