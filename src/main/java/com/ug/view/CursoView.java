package com.ug.view;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import com.ug.SistemaAcademico;
import com.ug.constantes.Encabezados;
import com.ug.controller.CarreraController;
import com.ug.controller.CursosController;
import com.ug.excepciones.CursoExcepcion;
import com.ug.model.Carrera;
import com.ug.model.Curso;

public class CursoView extends JFrame {

    // Edicion del registro de un curso
    private int id;
    private boolean isEdit;
    private int idCarrera = 0;

    // Botones
    private JButton btnGuardar = new JButton("Agregar");
    private JButton btnEliminar = new JButton("Eliminar");
    private JButton btnEditar = new JButton("Editar");
    private JButton btnNuevo = new JButton("Nuevo");
    // private JButton btnBuscar = new JButton("Buscar");
    private JButton btnVolver = new JButton("Volver");

    // Labels
    private JLabel lblNombreCurso = new JLabel("Nombre del Curso");
    private JLabel lblDescripcion = new JLabel("Descripción");
    private JLabel lblCreditos = new JLabel("Créditos");
    private JLabel lblHoras = new JLabel("Horas");
    private JLabel lblTipoCurso = new JLabel("Tipo Curso");
    private JLabel lblCarrera = new JLabel("Carrera");
    private JLabel lblCupos = new JLabel("Cupos");

    // TextFields
    private JTextField txtNombreCurso = new JTextField();
    private JTextField txtDescripcion = new JTextField();
    private JTextField txtCreditos = new JTextField();
    private JTextField txtHoras = new JTextField();
    private JTextField txtTipoCurso = new JTextField();
    private JComboBox<Carrera> cbCarrera = new JComboBox<>();
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
        panelPrincipal.setSize(800, 600);
        panelPrincipal.setBackground(new java.awt.Color(205, 205, 205));

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
        panelPrincipal.add(lblTipoCurso);
        lblTipoCurso.setBounds(10, 130, 150, 20);
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
        panelPrincipal.add(txtTipoCurso);
        txtTipoCurso.setBounds(170, 130, 200, 20);
        panelPrincipal.add(cbCarrera);
        cbCarrera.setBounds(170, 160, 200, 20);
        cbCarrera.addItem(new Carrera(0, "Seleeccione", "", "", "", null, null));
        panelPrincipal.add(txtCupos);
        txtCupos.setBounds(170, 190, 200, 20);

        // Agregar botones
        panelPrincipal.add(btnNuevo);
        btnNuevo.setBounds(400, 10, 100, 20);
        panelPrincipal.add(btnGuardar);
        btnEditar.setBounds(670, 190, 100, 20);
        panelPrincipal.add(btnEditar);
        btnGuardar.setBounds(400, 70, 100, 20);
        panelPrincipal.add(btnEliminar);
        btnEliminar.setBounds(400, 100, 100, 20);
        panelPrincipal.add(btnVolver);
        btnVolver.setBounds(670, 10, 100, 20);

        // Agregar Tabla
        panelPrincipal.add(panelTabla);
        panelTabla.setBounds(10, 220, 760, 300);
        panelTabla.setLayout(null);
        panelTabla.setBackground(new java.awt.Color(83, 104, 120));
        panelTabla.add(scrollPane);
        scrollPane.setBounds(5, 5, 750, 290);
        scrollPane.setBackground(new java.awt.Color(130, 161, 177));
        tablaCursos.getColumnModel().getColumn(0).setMaxWidth(30);

        // Cargar carreras
        cargarCarreras();

        // Eventos
        btnNuevo.addActionListener(e -> limpiarCampos());
        btnGuardar.addActionListener(e -> agregarOActualizarCurso());
        btnEditar.addActionListener(e -> modificarCurso());
        btnEliminar.addActionListener(e -> eliminarCurso());
        btnVolver.addActionListener(e -> {
            this.dispose();
            SistemaAcademico.main(null);
        });

        // Cargar lista de cursos
        cargarListaCursos();
        // Validacion para solo numeros en campos numericos
        DocumentFilter filtro = new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr)
                    throws BadLocationException {
                // Verificar que el texto insertado sea numérico
                if (str.matches("[0-9]*")) { // Solo permite dígitos
                    super.insertString(fb, offset, str, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attr)
                    throws BadLocationException {
                // Verificar que el texto reemplazado sea numérico
                if (str.matches("[0-9]*")) { // Solo permite dígitos
                    super.replace(fb, offset, length, str, attr);
                }
            }
        };
        ((AbstractDocument) txtCreditos.getDocument()).setDocumentFilter(filtro);
        ((AbstractDocument) txtHoras.getDocument()).setDocumentFilter(filtro);
        ((AbstractDocument) txtCupos.getDocument()).setDocumentFilter(filtro);
        // Validaciones para limite de caracteres
        KeyAdapter keyAdapter = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() > 2)
                    e.consume();
            }
        };

        KeyAdapter keyAdapterCreditos = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() > 2)
                    e.consume();
            }
        };
        txtHoras.addKeyListener(keyAdapter);
        txtCupos.addKeyListener(keyAdapter);
        txtCreditos.addKeyListener(keyAdapterCreditos);

    }

    /**
     * Limpiar campos
     */
    void limpiarCampos() {
        txtNombreCurso.setText("");
        txtDescripcion.setText("");
        txtCreditos.setText("");
        txtHoras.setText("");
        txtTipoCurso.setText("");
        cbCarrera.setSelectedIndex(0);
        txtCupos.setText("");
    }

    /**
     * Agregar o actualizar curso
     */
    void agregarOActualizarCurso() {
        String mensaje = "";
        String nombreCurso = txtNombreCurso.getText().strip();
        String descripcion = txtDescripcion.getText().strip();
        int creditos = Integer.parseInt(txtCreditos.getText().strip());
        int horas = Integer.parseInt(txtHoras.getText().strip());
        String tipoCurso = txtTipoCurso.getText().strip();

        int cupos = Integer.parseInt(txtCupos.getText().strip());

        if (nombreCurso.isEmpty() || descripcion.isEmpty() || creditos == 0 || horas == 0 || tipoCurso.isEmpty()
                || cbCarrera.getSelectedIndex() == 0 || cupos == 0) {
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
            return;
        } else {
            Carrera carrera = (Carrera) cbCarrera.getSelectedItem();
            // Agregar nuevo curso
            if (!isEdit) {
                idCarrera = carrera.getIdCarrera();
                try {
                    mensaje = CursosController.agregarCurso(
                            new Curso(0, nombreCurso, descripcion, creditos, horas, tipoCurso, "A", idCarrera, cupos));
                    JOptionPane.showMessageDialog(null, mensaje);
                    mensaje = CarreraController.agregarCursoACarrera(idCarrera,
                            CursosController.devolverUltimoCursoId());
                    JOptionPane.showMessageDialog(null, mensaje);

                    cargarListaCursos();
                    limpiarCampos();
                } catch (CursoExcepcion e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                }

            } else {
                try {
                    mensaje = CursosController.editarCurso(
                            new Curso(id, nombreCurso, descripcion, creditos, horas, tipoCurso, "A", idCarrera, cupos));
                    cargarListaCursos();
                    JOptionPane.showMessageDialog(null, mensaje);
                    limpiarCampos();
                    isEdit = false;
                    btnGuardar.setText("Agregar");
                    cbCarrera.setEnabled(false);

                } catch (CursoExcepcion e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }

    /**
     * Eliminar un curso
     */
    void eliminarCurso() {
        int fila = tablaCursos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un curso");
        } else {
            int id = (int) tablaCursos.getValueAt(fila, 0);
            String mensaje = CursosController.eliminarCurso(id);
            cargarListaCursos();
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    /**
     * Cargar carreras
     */
    void cargarCarreras() {
        CarreraController.obtenerCarreras().forEach(carrera -> {
            cbCarrera.addItem(carrera);
        });
    }

    /**
     * Cargar lista de cursos en la tabla
     */
    void cargarListaCursos() {
        modelo.setRowCount(0);
        for (Curso curso : CursosController.obtenerCursos()) {
            modelo.addRow(new Object[] { curso.getIdCurso(), curso.getNombreCurso(), curso.getDescripcionCurso(),
                    curso.getCreditosCurso(), curso.getHorasCurso(), curso.getTipoCurso(),
                    devolverCarreraNombre(curso.getIdCarrera()),
                    curso.getCuposCurso() });
        }
    }

    /**
     * Devolver nombre de carrera
     * 
     * @params idCarrera
     */
    private String devolverCarreraNombre(int idCarrera) {
        for (Carrera carrera : CarreraController.obtenerCarreras()) {
            if (carrera.getIdCarrera() == idCarrera)
                return carrera.getNombreCarrera();

        }
        return "Carrera no encontrada";
    }

    /**
     * Modificar un curso
     */
    void modificarCurso() {
        int fila = tablaCursos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un curso");
        } else {
            id = (int) tablaCursos.getValueAt(fila, 0);
            txtNombreCurso.setText((String) tablaCursos.getValueAt(fila, 1));
            txtDescripcion.setText((String) tablaCursos.getValueAt(fila, 2));
            txtCreditos.setText(String.valueOf(tablaCursos.getValueAt(fila, 3)));
            txtHoras.setText(String.valueOf(tablaCursos.getValueAt(fila, 4)));
            txtTipoCurso.setText((String) tablaCursos.getValueAt(fila, 5));
            cbCarrera.setSelectedItem(tablaCursos.getValueAt(fila, 6));
            txtCupos.setText(String.valueOf(tablaCursos.getValueAt(fila, 7)));
            isEdit = true;
            btnGuardar.setText("Actualizar");
            cbCarrera.setEnabled(false);
        }
    }

    /*
     * public static void main(String[] args) {
     * CursoView cursoView = new CursoView();
     * cursoView.setVisible(true);
     * }
     */
}
