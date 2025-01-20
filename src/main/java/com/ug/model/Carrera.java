package com.ug.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Carrera {
    
    private int idCarrera;
    private String nombreCarrera;
    private String descripcionCarrera;
    private String estadoCarrera;
    private int idFacultad;
}
