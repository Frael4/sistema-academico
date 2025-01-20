package com.ug.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Calificacion {
    private int idCalificacion;
    private int idEstudiante;
    private int idCurso;
    private int nota;
    private String observaciones;
    private String fecha;
    private String tipo;
    private String estado;
}
