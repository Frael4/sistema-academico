package com.ug.test_integracion;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ug.controller.CursosController;
import com.ug.excepciones.CursoExcepcion;
import com.ug.model.Curso;

public class CursoControllerTest {

    @Test
    @DisplayName("Test de Agregar Curso")
    public void testAgregarCurso() {
        String mensaje = "";

        Curso curso = new Curso(0, "Literatura", "Curso de literatura", 4, 80, "Teorico", "Activo", 2, 25);

        try {
            mensaje = CursosController.agregarCurso(curso);

            assert mensaje.equals("Curso agregado con éxito");
        } catch (CursoExcepcion e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test de Eliminar Curso")
    public void testEliminarCurso() {
        String mensaje = "";

        mensaje = CursosController.eliminarCurso(3);

        assert mensaje.equals("Curso eliminado con éxito");
    }

    @Test
    @DisplayName("Test de Editar Curso")
    public void testEditarCurso() {
        String mensaje = "";
        Curso curso = new Curso(2, "Literatura", "Curso de literatura", 4, 80, "Teorico", "Activo", 2, 25);

        try {
            mensaje = CursosController.editarCurso(curso);

            assert mensaje.equals("Curso editado con éxito");
        } catch (CursoExcepcion e) {
            e.getMessage();
        }

    }

    @Test
    @DisplayName("Test de Listar Cursos")
    public void testListarCursos() {
        List<Curso> cursos = CursosController.obtenerCursos();
        System.out.println("Number of cursos: " + cursos.getLast().getNombreCurso() + " " + cursos.size());
        assert cursos.size() > 0;
    }
}
