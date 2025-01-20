package com.ug.controller;

import java.util.ArrayList;
import java.util.List;

import com.ug.model.Asistencia;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AsistenciaController {

    List<Asistencia> asistencias = new ArrayList<Asistencia>();

    public void agregarAsistencia(Asistencia asistencia) {
        asistencias.add(asistencia);
        System.out.println("Asistencia agregada correctamente");
    }

    public void eliminarAsistencia(Asistencia asistencia) {
        asistencias.removeIf((asistenciaActual) -> asistenciaActual.getIdAsistencia() == asistencia.getIdAsistencia());
        System.out.println("Asistencia eliminada correctamente");
    }

    public void modificarAsistencia(Asistencia asistencia, Asistencia asistenciaNueva) {
        asistencias.set(asistencias.indexOf(asistencia), asistenciaNueva);
        System.out.println("Asistencia modificada correctamente");
    }

    public Asistencia buscarAsistencia(int idAsistencia) {
        return asistencias.stream().filter(((asistencia) -> asistencia.getIdAsistencia() == idAsistencia)).findFirst()
                .orElse(null);
    }

    public void mostrarAsistencias() {
        for (Asistencia asistencia : asistencias) {
            System.out.println(asistencia);
        }
    }

}
