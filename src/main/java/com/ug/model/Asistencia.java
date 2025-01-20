package com.ug.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Asistencia {
    @Getter @Setter
    private int idAsistencia;
    @Getter @Setter
    private int idEstudiante;
    @Getter @Setter
    private int idCurso;
    @Getter @Setter
    private String fecha;
    @Getter @Setter
    private String observaciones;
    @Getter @Setter
    private String estado;

}
