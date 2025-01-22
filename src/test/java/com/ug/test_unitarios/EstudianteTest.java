package com.ug.test_unitarios;

import org.junit.jupiter.api.Test;

import com.ug.model.Estudiante;

public class EstudianteTest {

    @Test
    public void testAgregarEstudiante() {
        Estudiante estudiante = new Estudiante(1, "Juan", "Perez", "0956986020", "jose@email.com", "0939262243",
                "Olmedo", "04/07/1998", "Activo", "01/01/2021", 1);
        assert estudiante != null;
        assert estudiante.getIdEstudiante() == 1;
        assert estudiante.getNombre().equals("Juan");
        assert estudiante.getApellido().equals("Perez");
        assert estudiante.getCedula().equals("0956986020");
    }
}
