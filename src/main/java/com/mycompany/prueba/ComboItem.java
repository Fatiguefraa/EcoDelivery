/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author maria
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// Clase para gestionar un combo y guardar en BD
public class ComboItem {
    private int cantidad;
    private final int precioUnitario;
    private final String nombreItem;

    // Constructor del combo
    public ComboItem(int precioUnitario, String nombreItem) {
        this.precioUnitario = precioUnitario;
        this.cantidad = 0;
        this.nombreItem = nombreItem;
    }

    // Sumar una unidad y guardar en BD
    public void incrementar() {
        cantidad++;
        guardarEnBD();
    }

    // Restar una unidad y guardar en BD
    public void decrementar() {
        if (cantidad > 0) {
            cantidad--;
            guardarEnBD();
        }
    }

    // Obtener el subtotal
    public int getSubtotal() {
        return cantidad * precioUnitario;
    }

    // Obtener cantidad actual
    public int getCantidad() {
        return cantidad;
    }

    // Guardar o actualizar datos en base temporal
    private void guardarEnBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/restaurante", "usuario", "contraseña"
            );

            PreparedStatement stmt = con.prepareStatement(
                "REPLACE INTO pedidos_temp (item, cantidad, subtotal) VALUES (?, ?, ?)"
            );
            stmt.setString(1, nombreItem);
            stmt.setInt(2, cantidad);
            stmt.setInt(3, getSubtotal());

            stmt.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println("Error al guardar en BD: " + e.getMessage());
        }
    }
}

    

