package com.ug.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Curso {

    public Curso(String nombre){
        this.nombreCurso = nombre;
    }

    private int idCurso;
    private String nombreCurso;
    private String descripcionCurso;
    private int creditosCurso;
    private int horasCurso;
    private String tipoCurso;
    private String estadoCurso;
    private int idCarrera;
    private int cuposCurso;

    /**
     * Valida cantidad maxima de cupos = 40
     * @return true or false
     */
    public boolean esValidoCantidadCuposMax(){
        return (cuposCurso > 40);
    }
    //private List<Integer> estudiantes;

    @Override
    public String toString() {
        return this.nombreCurso;
    }
}
