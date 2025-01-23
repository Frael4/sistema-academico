package com.ug.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ug.SistemaAcademico;
import com.ug.constantes.Encabezados;
import com.ug.controller.CarreraController;
import com.ug.controller.CursosController;
import com.ug.model.Carrera;
import com.ug.model.Curso;

public class AsistenciaView extends JFrame {

    // Edicion del registro
    private int id;
    private boolean isEdit;

    // Botones
    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnEliminar = new JButton("Eliminar");

    private JButton btnVolver = new JButton("Volver");

    // Etiquetas
    private JLabel lblCarrera = new JLabel("Carrera");
    private JLabel lblCurso = new JLabel("Curso");
    private JLabel lblFecha = new JLabel("Fecha");
    private JLabel lblObservaciones = new JLabel("Observaciones");
    // private JLabel lblEstado = new JLabel("Estado");

    // Campos de texto
    private JComboBox<Carrera> cbCarrera = new JComboBox<Carrera>();
    private JComboBox<Curso> cbCurso = new JComboBox<Curso>();
    private JTextField txtFecha = new JTextField();
    private JTextField txtObservaciones = new JTextField();
    // private JTextField txtEstado = new JTextField();

    // Panel principal
    JPanel panel = new JPanel();

    // Tabla
    private JPanel panelTabla = new JPanel();
    private DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, Encabezados.COL_ASISTENCIAS);
    private JTable tabla = new JTable(modelo);
    private JScrollPane scroll = new JScrollPane(tabla);

    // Constructor
    public AsistenciaView() {
        setTitle("Menú de Asistencias");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        // setVisible(true);
        add(panel);

        panel.setBounds(0, 0, getWidth(), getHeight());
        panel.setLayout(null);

        // Etiquetas

        lblCarrera.setBounds(10, 10, 100, 20);
        panel.add(lblCarrera);

        lblCurso.setBounds(10, 40, 100, 20);
        panel.add(lblCurso);
        lblFecha.setBounds(10, 70, 100, 20);
        panel.add(lblFecha);
        lblObservaciones.setBounds(10, 100, 100, 20);
        panel.add(lblObservaciones);

        // Campos de texto y combos
        cbCarrera.setBounds(120, 10, 150, 20);
        panel.add(cbCarrera);
        cbCurso.setBounds(120, 40, 150, 20);
        panel.add(cbCurso);
        txtFecha.setBounds(120, 70, 150, 20);
        panel.add(txtFecha);
        txtObservaciones.setBounds(120, 100, 150, 20);
        panel.add(txtObservaciones);

        // Botones
        btnGuardar.setBounds(470, 120, 100, 20);
        panel.add(btnGuardar);

        btnVolver.setBounds(470, 10, 100, 20);
        panel.add(btnVolver);

        // Tabla
        panelTabla.setBounds(10, 150, 560, getHeight() - 200);
        panel.add(panelTabla);
        panelTabla.setLayout(null);
        panelTabla.setBackground(new java.awt.Color(83, 104, 120));
        panelTabla.add(scroll);
        scroll.setBounds(5, 5, 550, getHeight() - 210);
        tabla.getColumnModel().getColumn(0).setMaxWidth(30);

        // Eventos
        btnEliminar.addActionListener((e) -> {
            // eliminar();
        });
        btnVolver.addActionListener(e -> {
            this.dispose();
            SistemaAcademico.main(null);
        });

        // On Change Curso
        /*
         * cbCurso.addActionListener(e -> {
         * cargarTablaEstudiantesCurso();
         * });
         */
        cbCarrera.addItemListener(e -> {
            Carrera c = (Carrera) cbCarrera.getSelectedItem();
            cargarComboCursos(c);
        });

        // Cargar combos
        cargarComboCarreras();
        // cargarComboCursos();
    }

    /**
     * Cargar combo cursos
     */
    private void cargarComboCursos(Carrera carrera) {
        cbCurso.removeAllItems();
        cbCurso.addItem(new Curso("Seleccione un curso"));
        if (carrera.getIdCarrera() != 0) {
            for (Curso curso : CursosController.obtenerCursosPorId(carrera.getCursos())) {
                cbCurso.addItem(curso);
            }
        }

    }

    /**
     * Cargar combo carreras
     */
    private void cargarComboCarreras() {
        cbCarrera.addItem(new Carrera("Seleccione una carrera"));
        for (Carrera c : CarreraController.obtenerCarreras()) {
            cbCarrera.addItem(c);
        }
    }

    private void cargarTablaEstudiantesCurso() {
        modelo.setRowCount(0);
        /*
         * if (cbCurso.getSelectedIndex() > 0) {
         * Curso curso = CursosController.obtenerCursos(cbCurso.getSelectedIndex());
         * for (Estudiante e :
         * EstudianteController.obtenerEstudiantesCurso(curso.getId())) {
         * modelo.addRow(new Object[] { e.getId(), e.getNombre(), e.getApellido(),
         * e.getEdad() });
         * }
         * }
         */
    }

    /* public static void main(String[] args) {
        AsistenciaView a = new AsistenciaView();
        a.setVisible(true);
    } */

}
