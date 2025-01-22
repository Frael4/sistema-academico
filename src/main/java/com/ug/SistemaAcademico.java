package com.ug;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ug.view.AsistenciaView;
import com.ug.view.CalificacionView;
import com.ug.view.CursoView;
import com.ug.view.EstudianteView;

/**
 * Sistema Academico
 *
 */
public class SistemaAcademico extends JFrame {

    final ImageIcon FONDO = new ImageIcon(getClass().getResource("/images/sistema-academico.png"));
    final JLabel lblFondo = new JLabel(FONDO);

    /*
     * Main
     */
    public static void main(String[] args) {
        SistemaAcademico sistemaAcademico = new SistemaAcademico();
        sistemaAcademico.setVisible(true);
    }

    // Panel principal
    JPanel panel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Establecer la opacidad para todo el panel
            Graphics2D g2d = (Graphics2D) g;
            AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f); // 70% de opacidad
            g2d.setComposite(alpha);
            g2d.fillRect(0, 0, getWidth(), getHeight()); // Rellenar con el fondo semi-transparente
        }
    };

    JButton btnEstudiantes = new JButton("Estudiantes");
    JButton btnCursos = new JButton("Cursos");
    JButton btnCalificaciones = new JButton("Calificaciones");
    JButton btnAsistencias = new JButton("Asistencias");

    SistemaAcademico() {
        setTitle("Sistema Academico");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(null);

        panel.setLayout(null);
        panel.setBounds(0, 0, getWidth(), getHeight());
        add(panel);
        panel.setOpaque(false);

        // Fondo
        lblFondo.setBounds(0, 0, getWidth(), getHeight());
        add(lblFondo);

        panel.add(btnEstudiantes);
        btnEstudiantes.setBounds(50, 50, 150, 30);
        panel.add(btnCursos);
        btnCursos.setBounds(50, 100, 150, 30);
        panel.add(btnCalificaciones);
        btnCalificaciones.setBounds(50, 150, 150, 30);
        panel.add(btnAsistencias);
        btnAsistencias.setBounds(50, 200, 150, 30);

        // Eventos
        btnEstudiantes.addActionListener((e) -> {
            this.dispose();
            EstudianteView estudianteView = new EstudianteView();
            estudianteView.setVisible(true);
        });

        btnCursos.addActionListener((e) -> {
            this.dispose();
            CursoView cursoView = new CursoView();
            cursoView.setVisible(true);
        });

        btnCalificaciones.addActionListener((e) -> {
            this.dispose();
            CalificacionView calificacionView = new CalificacionView();
            calificacionView.setVisible(true);
        });

        btnAsistencias.addActionListener((e) -> {
            this.dispose();
            AsistenciaView asistenciaView = new AsistenciaView();
            asistenciaView.setVisible(true);
        });

    }

}
