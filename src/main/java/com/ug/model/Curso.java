package com.ug.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Curso {
    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private int creditosCurso;
    private int horasCurso;
    private String tipoCurso;
    private String estadoCurso;
    private int idCarrera;
    private int cuposCurso;
}
