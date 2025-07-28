package com.mycompany.prueba;
import javax.swing.*;
import java.awt.event.*;

public class AsignarEntrega extends JFrame {
    public AsignarEntrega() {
        setTitle("Asignar Entrega");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblPedido = new JLabel("ID Pedido:");
        JTextField txtPedido = new JTextField();
        JLabel lblRepartidor = new JLabel("ID Repartidor:");
        JTextField txtRepartidor = new JTextField();
        JLabel lblRuta = new JLabel("ID Ruta:");
        JTextField txtRuta = new JTextField();
        JButton btnAsignar = new JButton("Asignar");

        lblPedido.setBounds(30, 30, 100, 25); txtPedido.setBounds(150, 30, 200, 25);
        lblRepartidor.setBounds(30, 70, 100, 25); txtRepartidor.setBounds(150, 70, 200, 25);
        lblRuta.setBounds(30, 110, 100, 25); txtRuta.setBounds(150, 110, 200, 25);
        btnAsignar.setBounds(150, 160, 120, 30);

        add(lblPedido); add(txtPedido);
        add(lblRepartidor); add(txtRepartidor);
        add(lblRuta); add(txtRuta);
        add(btnAsignar);

        btnAsignar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idPedido = Integer.parseInt(txtPedido.getText());
                int idRepartidor = Integer.parseInt(txtRepartidor.getText());
                int idRuta = Integer.parseInt(txtRuta.getText());

                peticiones1.asignarEntrega(idPedido, idRepartidor, idRuta);
                JOptionPane.showMessageDialog(null, "Entrega asignada correctamente");
            }
        });
    }
}