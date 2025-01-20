package com.ug.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.ug.constantes.Encabezados;
import com.ug.controller.EstudianteController;
import com.ug.excepciones.EstudianteException;
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
    private boolean isEdit = false;

    // Panel principal
    JPanel panel = new JPanel();

    // Botones
    JButton btnAgregar = new JButton("Agregar");
    JButton btnEliminar = new JButton("Eliminar");
    JButton btnEditar = new JButton("Editar");
    JButton btnBuscar = new JButton("Buscar");
    JButton btnMostrar = new JButton("Mostrar");

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        // Agregar tabla
        panelTabla.setBounds(20, 220, 700, 250);
        panelTabla.setBackground(new Color(Color.LIGHT_GRAY.getRGB()));
        panelTabla.setLayout(new BorderLayout());
        panel.add(panelTabla);
        scroll.setPreferredSize(tablaEstudiantes.getPreferredSize());
        panelTabla.add(scroll);
        tablaEstudiantes.setFont(new Font("Serif", Font.PLAIN, 14));

        // Agregar botones
        btnAgregar.setBounds(20, 500, 100, 30);
        panel.add(btnAgregar);
        btnAgregar.addActionListener(e -> agregarOActualizarEstudiante());

        btnEliminar.setBounds(130, 500, 100, 30);
        panel.add(btnEliminar);
        btnEliminar.addActionListener(e -> eliminarEstudiante());

        btnEditar.setBounds(240, 500, 100, 30);
        panel.add(btnEditar);
        btnEditar.addActionListener(e -> modificarEstudiante());

        btnBuscar.setBounds(350, 500, 100, 30);
        panel.add(btnBuscar);

        btnMostrar.setBounds(460, 500, 100, 30);
        panel.add(btnMostrar);

        cargarListaEstudiantes();
    }

    /* 
     * Limpiar los campos de texto
     */
    public void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtFechaNacimiento.setText("");
        txtFechaIngreso.setText("");
    }


    /*
     * Agregar un nuevo estudiante
     */
    public void agregarOActualizarEstudiante() {
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
                || fechaNacimiento.isEmpty() || fechaIngreso.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos son requeridos");
            System.out.println("Todos los campos son requeridos");
        } else {

            if (!isEdit) {
                // Crear un nuevo estudiante
                Estudiante estudiante = new Estudiante(1, nombre, apellido, cedula, correo, telefono, direccion,
                        fechaNacimiento,
                        "Activo",
                        fechaIngreso);
                // Agregar el estudiante a la lista
                String mensaje = EstudianteController.agregarEstudiante(estudiante);
                cargarListaEstudiantes();
                JOptionPane.showMessageDialog(null, mensaje);
                limpiarCampos();
            } else {
                Estudiante estudiante = new Estudiante(id, nombre, apellido, cedula, correo, telefono, direccion,
                        fechaNacimiento,
                        "Activo",
                        fechaIngreso);
                try {
                    String mensaje = EstudianteController.editarEstudiante(estudiante);
                    cargarListaEstudiantes();
                    JOptionPane.showMessageDialog(null, mensaje);
                    limpiarCampos();
                    isEdit = false;
                    btnAgregar.setText("Agregar");
                } catch (EstudianteException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }

        }
    }

    /*
     * Eliminar un estudiante
     */
    public void eliminarEstudiante() {
        if (tablaEstudiantes.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un estudiante");
        } else {
            int id = (int) modelo.getValueAt(tablaEstudiantes.getSelectedRow(), 0);
            String mensaje = EstudianteController.eliminarEstudiante(id);
            cargarListaEstudiantes();
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    /*
     * Cargar la lista de estudiantes en la tabla
     */
    public void cargarListaEstudiantes() {
        modelo.setRowCount(0);
        for (Estudiante estudiante : EstudianteController.obtenerEstudiantes()) {
            modelo.addRow(new Object[] { estudiante.getIdEstudiante(), estudiante.getNombre(), estudiante.getApellido(),
                    estudiante.getCedula(), estudiante.getCorreo(), estudiante.getTelefono(), estudiante.getDireccion(),
                    estudiante.getFechaNacimiento(), estudiante.getEstado(), estudiante.getFechaIngreso() });
        }
    }

    /*
     * Modificar un estudiante
     */
    public void modificarEstudiante() {
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

        }
    }

    /* public static void main(String[] args) {
        EstudianteView estudianteView = new EstudianteView();
        estudianteView.setVisible(true);
    } */
}
