package com.ug.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Carrera {
    
    public Carrera(String nombre){
        this.nombreCarrera = nombre;
    }

    private int idCarrera;
    private String nombreCarrera;
    private String descripcionCarrera;
    private String estadoCarrera;
    private String facultad;

    private List<Integer> cursos;
    private List<Integer> estudiantes;
    
    @Override
    public String toString() {
        return nombreCarrera;
    }
}
