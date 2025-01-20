package com.ug;

import javax.swing.JOptionPane;
import com.ug.view.AsistenciaView;
import com.ug.view.EstudianteView;

/**
 * Sistema Academico
 *
 */
public class SistemaAcademico {
    public static void main(String[] args) {
        SistemaAcademico sistemaAcademico = new SistemaAcademico();
        sistemaAcademico.menuInicio();
    }

    public void menuInicio() {

        String opciones[] = { ("Estudiantes"),
                ("Cursos"),
                ("Calificaciones"),
                ("Asistencias"),
                ("Salir")
        };

        int opcion = JOptionPane.showOptionDialog(
                null,
                "Seleccione un menú:",
                "Sistema Academico",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opciones,
                opciones[0]);

        // int opcion = scanner.nextInt();

        switch (opcion) {
            case 0:
                EstudianteView estudianteView = new EstudianteView();
                estudianteView.setVisible(true);
                break;
            case 1:
                // eliminarContacto();
                break;
            case 2:
                // buscarContacto();
                break;
            case 3:
                AsistenciaView asistenciaView = new AsistenciaView();
                asistenciaView.setVisible(true);;
                break;
            case 4:
                System.out.println("Saliendo del menu ...");
                
                break;

            default:
                break;
        }

    }

}
