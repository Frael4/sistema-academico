package com.ug.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AsistenciaView extends JFrame {
    // Panel principal    
    JPanel panel = new JPanel();

    // Constructor
    public AsistenciaView() {
        setTitle("Asistencia");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        add(panel);
        
    }

}
