package com.ug.controller;

import java.util.ArrayList;
import java.util.List;

import com.ug.model.Asistencia;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AsistenciaController {

    static List<Asistencia> asistencias = new ArrayList<Asistencia>();

    /**
     * Agrega una asistencia
     * @param asistencia
     */
    public static String agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
        System.out.println("Asistencia agregada con éxito");
        return "Asistencia agregada con éxito";
    }

    /**
     * Elimina una asistencia
     * @param asistencia
     */
    public static void eliminarAsistencia(Asistencia asistencia) {
        asistencias.removeIf((asistenciaActual) -> asistenciaActual.getIdAsistencia() == asistencia.getIdAsistencia());
        System.out.println("Asistencia eliminada correctamente");
    }

    /**
     * Modifica una asistencia
     * @param asistencia
     * @param asistenciaNueva
     */
    public static void modificarAsistencia(Asistencia asistencia, Asistencia asistenciaNueva) {
        asistencias.set(asistencias.indexOf(asistencia), asistenciaNueva);
        System.out.println("Asistencia modificada correctamente");
    }

    /**
     * Busca una asistencia por su id
     * @param idAsistencia
     * @return
     */
    public static Asistencia buscarAsistencia(int idAsistencia) {
        return asistencias.stream().filter(((asistencia) -> asistencia.getIdAsistencia() == idAsistencia)).findFirst()
                .orElse(null);
    }

    /* *
     *  Lista de asistencias
     */
    public static List<Asistencia> mostrarAsistencias() {
        return new ArrayList<>(asistencias);
    }

}
