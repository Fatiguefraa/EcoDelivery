package com.mycompany.prueba;
import javax.swing.*;
import java.awt.event.*;

public class CrearPedido extends JFrame {
    public CrearPedido(int idCliente) {
        setTitle("Crear Pedido");
        setSize(300, 200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblPeso = new JLabel("Peso del paquete (kg):");
        JTextField txtPeso = new JTextField();
        JButton btnCrear = new JButton("Crear Pedido");

        lblPeso.setBounds(30, 30, 150, 25);
        txtPeso.setBounds(30, 60, 200, 25);
        btnCrear.setBounds(30, 100, 150, 30);

        add(lblPeso); add(txtPeso); add(btnCrear);

        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double peso = Double.parseDouble(txtPeso.getText());
                peticiones1.crearPedido(idCliente, peso);
                JOptionPane.showMessageDialog(null, "Pedido creado");
            }
        });
    }
}