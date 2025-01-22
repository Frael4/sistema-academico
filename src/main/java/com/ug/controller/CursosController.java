package com.ug.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.ug.excepciones.CursoExcepcion;
import com.ug.model.Curso;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CursosController {

    /* 
     * 
     */
    private static int idCurso = 0;

    /*
     * Lista de cursos, con algunos seteados
     */
    private static List<Curso> cursos = new ArrayList<>(Arrays.asList(
            new Curso(1, "Matematicas", "Curso de matematicas", 5, 120, "Opcional", "A", 1, 30),
            new Curso(2, "Fisica", "Curso de fisica", 5, 120, "Opcional", "A", 1, 30),
            new Curso(3, "Quimica", "Curso de quimica", 5, 120, "Opcional", "A", 1, 30),
            new Curso(4, "Algebra", "Curso de Algebra 1", 8, 120, "Obligatorio", "A", 2, 35),
            new Curso(5, "Calculo Diferencial", "Curso de Calculo 1", 8, 120, "Obligatorio", "A", 3, 35)));

    /*
     * Agregar un curso
     */
    public static String agregarCurso(Curso curso) throws CursoExcepcion {

        if(curso.esValidoCantidadCuposMax())
            throw new CursoExcepcion("Cantidad de cupos no puede ser mayor a 40");

        curso.setIdCurso(++idCurso);
        cursos.add(curso);
        System.out.println("Curso agregado correctamente!");
        return "Curso agregado correctamente!";
    }

    /*
     * Eliminar un curso
     */
    public static String eliminarCurso(int idCurso) {
        cursos.removeIf((c) -> c.getIdCurso() == idCurso);
        System.out.println("Curso eliminado correctamente!");
        return "Curso eliminado correctamente!";
    }

    public static String editarCurso(Curso curso) throws CursoExcepcion {

        for (Curso c : cursos) {
            if (c.getIdCurso() == curso.getIdCurso()) {
                c.setNombreCurso(curso.getNombreCurso());
                c.setDescripcionCurso(curso.getDescripcionCurso());
                c.setCreditosCurso(curso.getCreditosCurso());
                c.setHorasCurso(curso.getHorasCurso());
                c.setTipoCurso(curso.getTipoCurso());
                c.setEstadoCurso(curso.getEstadoCurso());
                if (curso.getIdCarrera() != 0)
                    c.setIdCarrera(curso.getIdCarrera());
                c.setCuposCurso(curso.getCuposCurso());
                return "Curso modificado correctamente!";
            }
        }

        throw new CursoExcepcion("Curso no encontrado");
    }

    /*
     * Buscar un curso
     */
    public static Curso buscarCurso(int idCurso) {
        return cursos.stream().filter(((c) -> c.getIdCurso() == idCurso)).findFirst().orElse(null);
    }

    /*
     * Obtener cursos
     */
    public static List<Curso> obtenerCursos() {
        return new ArrayList<>(cursos);
    }

    /*
     * Obtener los cursos segun su un lista de ids
     */
    public static List<Curso> obtenerCursosPorId(List<Integer> idsCursos) {
        return cursos.stream().filter((c) -> idsCursos.contains(c.getIdCurso())).collect(Collectors.toList());
    }

    /*
     * Devolver el ultimo curso agregado
     */
    public static int devolverUltimoCursoId() {
        return cursos.get(cursos.size() - 1).getIdCurso();
    }

    /*
     * Actualizar cupos del curso
     */
    public static String actualizarCupos(int idCurso, int cupo) {
        for (Curso c : cursos) {
            if (c.getIdCurso() == idCurso) {
                c.setCuposCurso(c.getCuposCurso() - cupo);
                return "Se ha actualizado el cupo del curso: " + c.getCuposCurso();
            }
        }
        return "No se ha encontrado el curso para actualizar cupo";
    }

    public static String agregarEstudianteAlCurso() {
        // TODO: no implementado
        return "Estudiante agregado correctamente";
    }

}
