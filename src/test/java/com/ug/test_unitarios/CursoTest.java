package com.ug.test_unitarios;

import org.junit.jupiter.api.*;

import com.ug.model.Curso;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CursoTest {
    @Test
    @DisplayName("Test de Curso")
    public void testCurso() {
        Curso curso = new Curso(1, "Matemáticas", "Curso de matemáticas", 4, 4, "Teórico", "Activo", 1, 30);
        assertEquals(1, curso.getIdCurso());
        assertEquals("Matemáticas", curso.getNombreCurso());
        assertEquals("Curso de matemáticas", curso.getDescripcionCurso());
        assertEquals(4, curso.getCreditosCurso());
        assertEquals(4, curso.getHorasCurso());
        assertEquals("Teórico", curso.getTipoCurso());
        assertEquals("Activo", curso.getEstadoCurso()); 
        assertEquals(1, curso.getIdCarrera());
        assertEquals(30, curso.getCuposCurso());
    }
    
}
