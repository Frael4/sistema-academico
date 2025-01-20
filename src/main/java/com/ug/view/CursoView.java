package com.ug.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ug.constantes.Encabezados;

import lombok.Builder.Default;

public class CursoView extends JFrame {

    // Edicion del registro de un curso
    private int id;
    private boolean isEdit;

    // Botones
    private JButton btnGuardar = new JButton("Guardar");
    private JButton btnCancelar = new JButton("Cancelar");
    private JButton btnEliminar = new JButton("Eliminar");
    private JButton btnEditar = new JButton("Editar");
    private JButton btnNuevo = new JButton("Nuevo");
    private JButton btnBuscar = new JButton("Buscar");
    private JButton btnSalir = new JButton("Salir");

    // Labels
    private JLabel lblNombreCurso = new JLabel("Nombre del Curso");
    private JLabel lblDescripcion = new JLabel("Descripción");
    private JLabel lblCreditos = new JLabel("Créditos");
    private JLabel lblHoras = new JLabel("Horas");
    private JLabel lblCiclo = new JLabel("Ciclo");
    private JLabel lblCarrera = new JLabel("Carrera");
    private JLabel lblCupos = new JLabel("Cupos");

    // TextFields
    private JTextField txtNombreCurso = new JTextField();
    private JTextField txtDescripcion = new JTextField();
    private JTextField txtCreditos = new JTextField();
    private JTextField txtHoras = new JTextField();
    private JTextField txtCiclo = new JTextField();
    private JTextField txtCarrera = new JTextField();
    private JTextField txtCupos = new JTextField();
    

    // Panel principal
    private JPanel panelPrincipal = new JPanel();

    // Tablea de cursos
    private JPanel panelTabla = new JPanel();
    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, Encabezados.COL_CURSOS);
    private JTable tablaCursos = new JTable(modelo);
    private JScrollPane scrollPane = new JScrollPane(tablaCursos);

    // Constructor
    public CursoView() {
        setTitle("Menú de Cursos");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        add(panelPrincipal);
        panelPrincipal.setSize( 800, 600);
        panelPrincipal.setBackground(new java.awt.Color(250, 215, 255));

        // Panel principal
        panelPrincipal.setBounds(0, 0, 800, 600);
        panelPrincipal.setLayout(null);

        // Agregar labels
        panelPrincipal.add(lblNombreCurso);
        lblNombreCurso.setBounds(10, 10, 150, 20);
        panelPrincipal.add(lblDescripcion);
        lblDescripcion.setBounds(10, 40, 150, 20);
        panelPrincipal.add(lblCreditos);
        lblCreditos.setBounds(10, 70, 150, 20);
        panelPrincipal.add(lblHoras);
        lblHoras.setBounds(10, 100, 150, 20);
        panelPrincipal.add(lblCiclo);
        lblCiclo.setBounds(10, 130, 150, 20);
        panelPrincipal.add(lblCarrera);
        lblCarrera.setBounds(10, 160, 150, 20);
        panelPrincipal.add(lblCupos);
        lblCupos.setBounds(10, 190, 150, 20);

        // TextFields
        panelPrincipal.add(txtNombreCurso);
        txtNombreCurso.setBounds(170, 10, 200, 20);
        panelPrincipal.add(txtDescripcion);
        txtDescripcion.setBounds(170, 40, 200, 20);
        panelPrincipal.add(txtCreditos);
        txtCreditos.setBounds(170, 70, 200, 20);
        panelPrincipal.add(txtHoras);
        txtHoras.setBounds(170, 100, 200, 20);
        panelPrincipal.add(txtCiclo);
        txtCiclo.setBounds(170, 130, 200, 20);
        panelPrincipal.add(txtCarrera);
        txtCarrera.setBounds(170, 160, 200, 20);
        panelPrincipal.add(txtCupos);
        txtCupos.setBounds(170, 190, 200, 20);


        // Agregar botones
        panelPrincipal.add(btnNuevo);
        btnNuevo.setBounds(400, 10, 100, 20);
        panelPrincipal.add(btnGuardar);
        btnGuardar.setBounds(400, 40, 100, 20);
        panelPrincipal.add(btnCancelar);
        btnCancelar.setBounds(400, 70, 100, 20);
        panelPrincipal.add(btnEditar);
        btnEditar.setBounds(400, 100, 100, 20);
        panelPrincipal.add(btnEliminar);
        btnEliminar.setBounds(400, 130, 100, 20);
        panelPrincipal.add(btnBuscar);
        btnBuscar.setBounds(400, 160, 100, 20);
        panelPrincipal.add(btnSalir);
        btnSalir.setBounds(400, 190, 100, 20);

        // Agregar Tabla
        panelPrincipal.add(panelTabla);
        panelTabla.setBounds(20, 220, 700, 220);
        panelTabla.setLayout(null);
        panelTabla.setBackground(new java.awt.Color(210, 215, 250));
        panelTabla.add(scrollPane);
        scrollPane.setBounds(0, 0, 700, 220);
        scrollPane.setBackground(new java.awt.Color(250, 215, 250));

    }


    public static void main(String[] args) {
        CursoView cursoView = new CursoView();
        cursoView.setVisible(true);
    }
}
