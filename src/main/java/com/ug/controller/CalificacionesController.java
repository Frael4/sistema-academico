package com.ug.controller;
import java.util.ArrayList;
import java.util.List;

import com.ug.model.Calificacion;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CalificacionesController {

    List<Calificacion> calificaciones = new ArrayList<Calificacion>();

    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
        System.out.println("Calificacion agregada correctamente");
    }

    public void eliminarCalificacion(Calificacion calificacion) {
        calificaciones.removeIf((calificacionActual) -> calificacionActual.getIdCalificacion() == calificacion.getIdCalificacion());
        System.out.println("Calificacion eliminada correctamente");
    }

    public void modificarCalificacion(Calificacion calificacion, Calificacion calificacionNueva) {
        calificaciones.set(calificaciones.indexOf(calificacion), calificacionNueva);
        System.out.println("Calificacion modificada correctamente");
    }

    public Calificacion buscarCalificacion(int idCalificacion) {
        return calificaciones.stream().filter(((calificacion) -> calificacion.getIdCalificacion() == idCalificacion)).findFirst()
                .orElse(null);
    }

    public void mostrarCalificaciones() {
        for (Calificacion calificacion : calificaciones) {
            System.out.println(calificacion);
        }
    }
}
