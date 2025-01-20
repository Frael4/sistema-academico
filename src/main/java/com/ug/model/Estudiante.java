package com.ug.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Estudiante {

    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String telefono;
    private String direccion;
    private String fechaNacimiento;
    private String estado;
    private String fechaIngreso;
}
