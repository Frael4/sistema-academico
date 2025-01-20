package com.ug.test_unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ug.model.Calificacion;

public class CalificacionTest {
    @Test
    @DisplayName("Test de Calificacion")
    public void testCalificacion() {
        Calificacion calificacion = new Calificacion(1, 1, 1, 100, "Excelente", "2021-10-10", "Parcial", "Activa");
        assertEquals(1, calificacion.getIdCalificacion());
        assertEquals(1, calificacion.getIdEstudiante());
        assertEquals(1, calificacion.getIdCurso());
        assertEquals(100, calificacion.getNota());
        assertEquals("Excelente", calificacion.getObservaciones());
        assertEquals("2021-10-10", calificacion.getFecha());
        assertEquals("Parcial", calificacion.getTipo());
        assertEquals("Activa", calificacion.getEstado());
    }
}
