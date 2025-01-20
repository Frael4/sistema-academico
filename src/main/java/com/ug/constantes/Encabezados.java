package com.ug.constantes;

public class Encabezados {
    public final static String COL_ESTUDIANTES [] = {
        "ID",
        "Nombre",
        "Apellido",
        "Cedula",
        "Correo",
        "Telefono",
        "Direccion",
        "Fecha Nacimiento",
        "Estado",
        "Fecha Ingreso"
    };

    public final static String COL_ASISTENCIAS [] = {
        "ID",
        "ID Estudiante",
        "ID Curso",
        "Fecha",
        "Asistencia"
    };

    public final static String COL_CURSOS [] = {
        "ID",
        "Nombre",
        "Descripcion",
        "Creditos",
        "Horas",
        "Tipo",
        "Estado",
        "ID Carrera",
        "Cupos"
    };
}
