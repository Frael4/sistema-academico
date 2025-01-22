package com.ug.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private int idCarrera;

    /**
     * Valida correo
     * @return
     */
    public boolean esValidoCorreo() {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }
}
