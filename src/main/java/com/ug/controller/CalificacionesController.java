package com.ug.controller;
import java.util.ArrayList;
import java.util.List;

import com.ug.model.Calificacion;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CalificacionesController {

    /**
     * Lista de calificaciones
     */
    static List<Calificacion> calificaciones = new ArrayList<Calificacion>();

    /**
     * Agrega una calificacion
     * @param calificacion
     */
    public static void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
        System.out.println("Calificacion agregada correctamente");
    }

    /**
     * Elimina una calificacion
     * @param calificacion
    */
    public static void eliminarCalificacion(Calificacion calificacion) {
        calificaciones.removeIf((calificacionActual) -> calificacionActual.getIdCalificacion() == calificacion.getIdCalificacion());
        System.out.println("Calificacion eliminada correctamente");
    }

    /**
     * Modifica una calificacion
     * @param calificacion
     * @param calificacionNueva
     */
    public static void modificarCalificacion(Calificacion calificacion) {
        for (Calificacion calificacionActual : calificaciones) {
            if (calificacionActual.getIdCalificacion() == calificacion.getIdCalificacion()) {
                calificacionActual.setNota(calificacion.getNota());
                calificacionActual.setFecha(calificacion.getFecha());
                calificacionActual.setIdCurso(calificacion.getIdCurso());
                calificacionActual.setObservaciones(calificacion.getObservaciones());
                System.out.println("Calificacion modificada correctamente");
                return;
            }
        }
    }

    /**
     * Busca una calificacion por su id
     * @param idCalificacion
     * @return
    */
    public static Calificacion buscarCalificacion(int idCalificacion) {
        return calificaciones.stream().filter(((calificacion) -> calificacion.getIdCalificacion() == idCalificacion)).findFirst()
                .orElse(null);
    }

    /**
     * Muestra todas las calificaciones
     */
    public void mostrarCalificaciones() {
        for (Calificacion calificacion : calificaciones) {
            System.out.println(calificacion);
        }
    }
}
