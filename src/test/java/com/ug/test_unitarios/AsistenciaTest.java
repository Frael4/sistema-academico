package com.ug.test_unitarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.ug.model.Asistencia;

public class AsistenciaTest {
    @Test
    @DisplayName("Test de Asistencia")
    public void testAsistencia() {
        Asistencia asistencia = new Asistencia(1, 1, 1, "2021-10-10", "Asistencia completa", "Activa");
        assertEquals(1, asistencia.getIdAsistencia());
        assertEquals(1, asistencia.getIdEstudiante());
        assertEquals(1, asistencia.getIdCurso());
        assertEquals("2021-10-10", asistencia.getFecha());
        assertEquals("Asistencia completa", asistencia.getObservaciones());
        assertEquals("Activa", asistencia.getEstado());
    }
}
