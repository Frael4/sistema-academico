package com.ug.test_integracion;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ug.controller.EstudianteController;
import com.ug.excepciones.EstudianteException;
import com.ug.model.Estudiante;

public class EstudianteControllerTest {

    @Test
    @DisplayName("Test de Agregar Estudiante")
    public void testAgregarEstudiante(){
        String mensaje = "";
        Estudiante estudiante = new Estudiante(0, "Jose", "Anchundia", "0985698620", "jose@email.com", "0929362243", "Av. Rumichaca", "14/08/2000", "A", "12/01/2025", 1);

        try {
            mensaje = EstudianteController.agregarEstudiante(estudiante);

            assert mensaje.equals("Estudiante agregado con éxito");
        } catch (EstudianteException e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test de Eliminar Estudiante")
    public void testEliminarEstudiante(){
        String mensaje = "";
        
        mensaje = EstudianteController.eliminarEstudiante(2);

        assert mensaje.equals("Estudiante eliminado con éxito");
    }

    @Test
    @DisplayName("Test de Editar Estudiante")
    public void testEditarEstudiante(){
        String mensaje = "";

        Estudiante estudiante = new Estudiante(0, "Jose", "Soriano", "0985698620", "jose@email.com", "0929362243", "Av. Rumichaca", "14/08/2000", "A", "12/01/2025", 1);

        try {
            mensaje = EstudianteController.editarEstudiante(estudiante);

            assert mensaje.equals("Estudiante editado con éxito");
        } catch (EstudianteException e) {
            e.getMessage();
        }

    }

    @Test
    @DisplayName("Test de Listar Estudiantes")
    public void testListarEstudiantes(){
        List<Estudiante> estudiantes = EstudianteController.obtenerEstudiantes();

        assert estudiantes.size() > 0;
    }
}
