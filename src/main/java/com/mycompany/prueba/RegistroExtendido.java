package com.mycompany.prueba;
import javax.swing.*;
import java.awt.event.*;

public class RegistroExtendido extends JFrame {
    public RegistroExtendido() {
        setTitle("Registro de Usuario");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblCorreo = new JLabel("Correo:");
        JTextField txtCorreo = new JTextField();
        JLabel lblPass = new JLabel("Contraseña:");
        JPasswordField txtPass = new JPasswordField();
        JLabel lblTelefono = new JLabel("Teléfono:");
        JTextField txtTelefono = new JTextField();
        JLabel lblTipo = new JLabel("Tipo Usuario:");
        String[] tipos = {"cliente", "repartidor"};
        JComboBox<String> cmbTipo = new JComboBox<>(tipos);

        JLabel lblDireccion = new JLabel("Dirección:");
        JTextField txtDireccion = new JTextField();
        JLabel lblVehiculo = new JLabel("Tipo Vehículo:");
        JTextField txtVehiculo = new JTextField();
        JLabel lblCapacidad = new JLabel("Capacidad (kg):");
        JTextField txtCapacidad = new JTextField();

        JButton btnRegistrar = new JButton("Registrar");

        lblNombre.setBounds(30, 30, 100, 25); txtNombre.setBounds(150, 30, 200, 25);
        lblCorreo.setBounds(30, 60, 100, 25); txtCorreo.setBounds(150, 60, 200, 25);
        lblPass.setBounds(30, 90, 100, 25); txtPass.setBounds(150, 90, 200, 25);
        lblTelefono.setBounds(30, 120, 100, 25); txtTelefono.setBounds(150, 120, 200, 25);
        lblTipo.setBounds(30, 150, 100, 25); cmbTipo.setBounds(150, 150, 200, 25);
        lblDireccion.setBounds(30, 180, 100, 25); txtDireccion.setBounds(150, 180, 200, 25);
        lblVehiculo.setBounds(30, 210, 100, 25); txtVehiculo.setBounds(150, 210, 200, 25);
        lblCapacidad.setBounds(30, 240, 100, 25); txtCapacidad.setBounds(150, 240, 200, 25);
        btnRegistrar.setBounds(150, 280, 120, 30);

        add(lblNombre); add(txtNombre);
        add(lblCorreo); add(txtCorreo);
        add(lblPass); add(txtPass);
        add(lblTelefono); add(txtTelefono);
        add(lblTipo); add(cmbTipo);
        add(lblDireccion); add(txtDireccion);
        add(lblVehiculo); add(txtVehiculo);
        add(lblCapacidad); add(txtCapacidad);
        add(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String correo = txtCorreo.getText();
                String pass = new String(txtPass.getPassword());
                String telefono = txtTelefono.getText();
                String tipo = cmbTipo.getSelectedItem().toString();
                String direccion = txtDireccion.getText();
                String vehiculo = txtVehiculo.getText();
                double capacidad = Double.parseDouble(txtCapacidad.getText());

                peticiones1.insertarUsuarioExtendido(nombre, correo, pass, tipo, telefono, direccion, vehiculo, capacidad);
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            }
        });
    }
}