package com.mycompany.prueba;

import javax.swing.JOptionPane;

public class proveedor extends javax.swing.JFrame {
    private int idUsuario;
    private Acciones_provedores acciones;

    public proveedor() {
        initComponents();
        acciones = new Acciones_provedores();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtLocacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(93, 111, 78));

        jPanel3.setBackground(new java.awt.Color(244, 235, 229));

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("CUENTA DE PROVEEDOR");

        jButton1.setBackground(new java.awt.Color(210, 228, 200));
        jButton1.setText("Notificaciones");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jButton2.setBackground(new java.awt.Color(210, 228, 200));
        jButton2.setText("Actualizar Locación");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        jButton3.setBackground(new java.awt.Color(210, 228, 200));
        jButton3.setText("Escribir Reseña");
        jButton3.addActionListener(evt -> jButton3ActionPerformed(evt));

        jButton4.setBackground(new java.awt.Color(210, 228, 200));
        jButton4.setText("Pedidos pendientes");
        jButton4.addActionListener(evt -> jButton4ActionPerformed(evt));

        jButton5.setBackground(new java.awt.Color(210, 228, 200));
        jButton5.setText("Cerrar sesión");
        jButton5.addActionListener(evt -> jButton5ActionPerformed(evt));

        txtLocacion.setToolTipText("Escribe tu nueva locación aquí");

        jLabel1.setText("Locación:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocacion))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        String resena = JOptionPane.showInputDialog(null, "Escribe tu reseña:");

        if (resena != null && !resena.trim().isEmpty()) {
            if (idUsuario > 0) {
                acciones.guardarReseña(resena.trim(), idUsuario);
                JOptionPane.showMessageDialog(null, "¡Reseña guardada con éxito!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: ID de usuario no válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "La reseña no puede estar vacía.");
        }
    }

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
        acciones.cerrarSesion(this);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        acciones.obtenerNotificaciones(idUsuario);
        JOptionPane.showMessageDialog(this, "Las notificaciones se han mostrado en consola.");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        String nuevaLocacion = txtLocacion.getText().trim();

        if (nuevaLocacion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Por favor escribe una locación.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            txtLocacion.requestFocus();
            return;
        }

        try {
            acciones.actualizarLocacion(nuevaLocacion, idUsuario);
            JOptionPane.showMessageDialog(this, "Locación actualizada correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al actualizar la locación: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
       acciones.verPedidosPendientes(idUsuario);
       JOptionPane.showMessageDialog(this, "Pedidos pendientes mostrados en consola.");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new proveedor().setVisible(true);
        });
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtLocacion;
}