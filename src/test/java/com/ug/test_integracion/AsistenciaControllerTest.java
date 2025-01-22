package com.ug.test_integracion;

import org.junit.jupiter.api.Test;

import com.ug.controller.AsistenciaController;
import com.ug.model.Asistencia;

public class AsistenciaControllerTest {

    @Test
    public void testAgregarAsistencia() {
        String mensaje = "";
        Asistencia asistencia = new Asistencia(0, 1, 1, "14/02/2018", "", "Activo");
        mensaje = AsistenciaController.agregarAsistencia(asistencia);
        assert mensaje.equals("Asistencia agregada con éxito");
    }
}
