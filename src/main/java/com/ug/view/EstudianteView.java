package com.ug.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ug.SistemaAcademico;
import com.ug.constantes.Encabezados;
import com.ug.controller.CarreraController;
import com.ug.controller.CursosController;
import com.ug.controller.EstudianteController;
import com.ug.excepciones.EstudianteException;
import com.ug.model.Carrera;
import com.ug.model.Estudiante;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EstudianteView extends JFrame {

    // Edicion del registro
    private int id;
    private int idCarrera;
    private boolean isEdit = false;

    // Panel principal
    JPanel panel = new JPanel();

    // Botones
    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("Eliminar");
    JButton btnEditar = new JButton("Editar");
    // JButton btnBuscar = new JButton("Buscar");
    // JButton btnMostrar = new JButton("Mostrar");
    JButton btnNuevo = new JButton("Nuevo");
    JButton btnVolver = new JButton("Volver");

    // Campos de texto
    JTextField txtNombre = new JTextField();
    JTextField txtApellido = new JTextField();
    JTextField txtCedula = new JTextField();
    JTextField txtCorreo = new JTextField();
    JTextField txtTelefono = new JTextField();
    JTextField txtDireccion = new JTextField();
    JTextField txtFechaNacimiento = new JTextField();
    JTextField txtEstado = new JTextField();
    JTextField txtFechaIngreso = new JTextField();
    JComboBox<Carrera> cbCarrera = new JComboBox<Carrera>();

    // Labels
    JLabel lblNombre = new JLabel("Nombre");
    JLabel lblApellido = new JLabel("Apellido");
    JLabel lblCedula = new JLabel("Cedula");
    JLabel lblCorreo = new JLabel("Correo");
    JLabel lblTelefono = new JLabel("Telefono");
    JLabel lblDireccion = new JLabel("Direccion");
    JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento");
    JLabel lblEstado = new JLabel("Estado");
    JLabel lblFechaIngreso = new JLabel("Fecha de Ingreso");
    private JLabel lblCarrera = new JLabel("Carrera");

    // Tabla de estudiantes
    JPanel panelTabla = new JPanel();
    DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, Encabezados.COL_ESTUDIANTES);
    JTable tablaEstudiantes = new JTable(modelo);
    JScrollPane scroll = new JScrollPane(tablaEstudiantes);

    // Constructor
    public EstudianteView() {
        // Configuración de la ventana
        setTitle("Menú de Estudiantes");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        add(panel);
        panel.setSize(800, 600);
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);

        // Agregar labels
        lblNombre.setBounds(20, 20, 200, 30);
        panel.add(lblNombre);
        lblApellido.setBounds(230, 20, 200, 30);
        panel.add(lblApellido);
        lblCedula.setBounds(440, 20, 200, 30);
        panel.add(lblCedula);
        lblCorreo.setBounds(20, 80, 200, 30);
        panel.add(lblCorreo);
        lblTelefono.setBounds(230, 80, 200, 30);
        panel.add(lblTelefono);
        lblDireccion.setBounds(440, 80, 200, 30);
        panel.add(lblDireccion);
        lblFechaNacimiento.setBounds(20, 140, 200, 30);
        panel.add(lblFechaNacimiento);
        lblFechaIngreso.setBounds(230, 140, 200, 30);
        panel.add(lblFechaIngreso);
        lblCarrera.setBounds(440, 140, 200, 30);
        panel.add(lblCarrera);

        // Agregar campos de texto
        txtNombre.setBounds(20, 50, 200, 30);
        panel.add(txtNombre);
        txtApellido.setBounds(230, 50, 200, 30);
        panel.add(txtApellido);
        txtCedula.setBounds(440, 50, 200, 30);
        panel.add(txtCedula);
        txtCorreo.setBounds(20, 110, 200, 30);
        panel.add(txtCorreo);
        txtTelefono.setBounds(230, 110, 200, 30);
        panel.add(txtTelefono);
        txtDireccion.setBounds(440, 110, 200, 30);
        panel.add(txtDireccion);
        txtFechaNacimiento.setBounds(20, 170, 200, 30);
        panel.add(txtFechaNacimiento);
        txtFechaIngreso.setBounds(230, 170, 200, 30);
        panel.add(txtFechaIngreso);
        cbCarrera.setBounds(440, 170, 200, 30);
        panel.add(cbCarrera);

        // Agregar tabla
        panel.add(panelTabla);
        panelTabla.setBounds(20, 220, 750, 300);
        panelTabla.setLayout(null);
        panelTabla.setBackground(new java.awt.Color(130, 161, 177));
        // scroll.setPreferredSize(tablaEstudiantes.getPreferredSize());
        panelTabla.add(scroll);
        scroll.setBounds(5, 5, 740, 290);
        scroll.setBackground(new java.awt.Color(130, 161, 177));
        tablaEstudiantes.getColumnModel().getColumn(0).setMaxWidth(30);

        // Fuente tabla
        tablaEstudiantes.setFont(new Font("Serif", Font.PLAIN, 14));
        // Configurar el scroll solo en el eje X (horizontal)
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Agregar botones
        btnNuevo.setBounds(670, 60, 100, 30);
        panel.add(btnNuevo);
        btnAgregar.setBounds(670, 100, 100, 30);
        panel.add(btnAgregar);
        btnEliminar.setBounds(670, 140, 100, 30);
        panel.add(btnEliminar);
        btnEditar.setBounds(670, 180, 100, 30);
        panel.add(btnEditar);
        btnVolver.setBounds(670, 20, 100, 30);
        panel.add(btnVolver);

        // Eventos de los botones
        btnAgregar.addActionListener(e -> agregarOActualizarEstudiante());
        btnEditar.addActionListener(e -> modificarEstudiante());
        btnEliminar.addActionListener(e -> eliminarEstudiante());
        btnNuevo.addActionListener(e -> limpiarCampos());
        btnVolver.addActionListener(e -> {
            this.dispose();
            SistemaAcademico.main(null);
        });

        // Cargar la lista de estudiantes
        cargarListaEstudiantes();
        cargarComboCarerras();
    }

    /**
     * Limpiar los campos de texto
     */
    void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtFechaNacimiento.setText("");
        txtFechaIngreso.setText("");
        cbCarrera.setSelectedIndex(0);
    }

    /**
     * Agregar un nuevo estudiante
     */
    void agregarOActualizarEstudiante() {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().strip();
        String cedula = txtCedula.getText().strip();
        String correo = txtCorreo.getText().strip();
        String telefono = txtTelefono.getText().strip();
        String direccion = txtDireccion.getText().strip();
        String fechaNacimiento = txtFechaNacimiento.getText().strip();
        String fechaIngreso = txtFechaIngreso.getText().strip();

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() || correo.isEmpty() || telefono.isEmpty()
                || direccion.isEmpty()
                || fechaNacimiento.isEmpty() || fechaIngreso.isEmpty() ) {
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
            return;
        } else {

            String mensaje = "";

            if (!isEdit) {
                // Crear un nuevo estudiante
                idCarrera = ((Carrera) cbCarrera.getSelectedItem()).getIdCarrera();

                if(cbCarrera.getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Seleccione una carrera");
                    return;
                }

                Estudiante estudiante = new Estudiante(1, nombre, apellido, cedula, correo, telefono, direccion,
                        fechaNacimiento,
                        "Activo",
                        fechaIngreso, idCarrera);

                for (int idCurso : CarreraController.buscarCarrera(idCarrera).getCursos()) {
                    CursosController.actualizarCupos(idCurso, 1);
                }

                // Agregar el estudiante a la lista
                try {
                    mensaje = EstudianteController.agregarEstudiante(estudiante);
                    JOptionPane.showMessageDialog(null, mensaje);
                    mensaje = CarreraController.agregarEstudianteACarrera(idCarrera, id);
                    JOptionPane.showMessageDialog(null, mensaje);

                } catch (EstudianteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    return;
                }

                cargarListaEstudiantes();
                limpiarCampos();
            } else {
                Estudiante estudiante = new Estudiante(id, nombre, apellido, cedula, correo, telefono, direccion,
                        fechaNacimiento,
                        "Activo",
                        fechaIngreso, 0);
                try {
                    mensaje = EstudianteController.editarEstudiante(estudiante);
                    cargarListaEstudiantes();
                    JOptionPane.showMessageDialog(null, mensaje);
                    limpiarCampos();
                    isEdit = false;
                    btnAgregar.setText("Agregar");
                    cbCarrera.setEnabled(false);
                } catch (EstudianteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        }
    }

    /**
     * Eliminar un estudiante
     */
    void eliminarEstudiante() {
        if (tablaEstudiantes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un estudiante");
        } else {
            int id = (int) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 0);
            String mensaje = EstudianteController.eliminarEstudiante(id);
            cargarListaEstudiantes();
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    /**
     * Cargar la lista de estudiantes en la tabla
     */
    void cargarListaEstudiantes() {
        modelo.setRowCount(0);
        for (Estudiante estudiante : EstudianteController.obtenerEstudiantes()) {
            modelo.addRow(new Object[] { estudiante.getIdEstudiante(), estudiante.getNombre(), estudiante.getApellido(),
                    estudiante.getCedula(), estudiante.getCorreo(), estudiante.getTelefono(), estudiante.getDireccion(),
                    estudiante.getFechaNacimiento(), devolverNombreCarrera(estudiante.getIdCarrera()),
                    estudiante.getFechaIngreso() });
        }
    }

    /**
     * Modificar un estudiante
     */
    void modificarEstudiante() {
        if (tablaEstudiantes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un estudiante");
        } else {
            id = (int) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 0);
            txtNombre.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 1));
            txtApellido.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 2));
            txtCedula.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 3));
            txtCorreo.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 4));
            txtTelefono.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 5));
            txtDireccion.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 6));
            txtFechaNacimiento.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 7));
            txtEstado.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 8));
            txtFechaIngreso.setText((String) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 9));
            isEdit = true;
            btnAgregar.setText("Actualizar");
            cbCarrera.setEnabled(false);

        }
    }

    /**
     * Cargar carreras
     */
    private void cargarComboCarerras() {
        cbCarrera.addItem(new Carrera("Seleccione una carrera"));
        for (Carrera carrera : CarreraController.obtenerCarreras()) {
            cbCarrera.addItem(carrera);
        }
    }

    /**
     * Obtener el nombre de la carrera segun el id
     */
    private String devolverNombreCarrera(int idCarrera) {
        for (Carrera carrera : CarreraController.obtenerCarreras()) {
            if (carrera.getIdCarrera() == idCarrera)
                return carrera.getNombreCarrera();
        }
        return "Carrera no existe";
    }

    /*
     * public static void main(String[] args) {
     * EstudianteView estudianteView = new EstudianteView();
     * estudianteView.setVisible(true);
     * }
     */

}
