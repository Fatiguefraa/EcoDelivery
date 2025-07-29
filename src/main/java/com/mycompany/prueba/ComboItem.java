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

public class ComboItem {
    private int cantidad;
    private final int precioUnitario;
    private final String nombreItem;

    public ComboItem (int precioUnitario, String nombreItem) {
        this.precioUnitario = precioUnitario;
        this.cantidad = 0;
        this.nombreItem = nombreItem;
    }

    public void incrementar() {
        cantidad++;
        guardarEnBD();
    }

    public void decrementar() {
        if (cantidad > 0) {
            cantidad--;
            guardarEnBD();
        }
    }

    public int getSubtotal() {
        return cantidad * precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

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
