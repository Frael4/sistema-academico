package com.ug.test_integracion;

import java.util.ArrayList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ug.controller.CarreraController;
import com.ug.model.Carrera;

public class CarreraControllerTest {

    @Test
    @DisplayName("Test de Agregar Carrera")
    public void testAgregarCarrera() {
        String mensaje = "";
        Carrera carrera = new Carrera(0, "Ingenieria en Sistemas", "Ingenieria en Sistemas", "Activo",
                "Facultad de Ciencias Matematicas", new ArrayList<Integer>(), new ArrayList<Integer>());

        mensaje = CarreraController.agregarCarrera(carrera);

        assert mensaje.equals("Carrera agregada con éxito");

    }

    @Test
    @DisplayName("Test agregar curso a carrera")
    public void testAgregarCursoACarrera(){
        String mensaje = "";
        
        int idCarrera = CarreraController.obtenerCarreras().get(0).getIdCarrera();

        mensaje = CarreraController.agregarCursoACarrera(idCarrera, 1);

        assert mensaje.equals("Curso agregado a la carrera con éxito");
    }

    @Test
    @DisplayName("Test agregar estudiante a carrera")
    public void testAgregarEstudianteACarrera(){
        String mensaje = "";
        
        int idCarrera = CarreraController.obtenerCarreras().get(0).getIdCarrera();

        mensaje = CarreraController.agregarEstudianteACarrera(idCarrera, 1);

        assert mensaje.equals("Estudiante agregado a la carrera con éxito");
    }
}
