package com.ug.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ug.SistemaAcademico;

public class CalificacionView extends JFrame {

    // Panel
    JPanel panel = new JPanel();

    // Botones
    JButton btnVolver = new JButton("Volver");

    public CalificacionView(){
        setTitle("Menú de Calificaciones");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panel);

        panel.setBounds(0,0, getWidth(), getHeight());
        panel.setLayout(null);

        // Botones
        btnVolver.setBounds(470, 10, 100, 20);
        panel.add(btnVolver);

        // Eventos
        btnVolver.addActionListener(e -> {
            dispose();
            SistemaAcademico.main(null);
        });
    }
}
