/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class peticionesdb {
    
    // --------- Tabla PEDIDOS ----------
    public static List<Object[]> obtenerPedidos() {
        List<Object[]> pedidos = new ArrayList<>();
        
        try (Connection conn = DB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM pedidos")) {
            
            while (rs.next()) {
                Object[] fila = new Object[]{
                    rs.getInt("id_pedido"),
                    rs.getInt("id_cliente"),
                    rs.getString("fecha_pedido"),
                    rs.getDouble("peso_kg"),
                    rs.getString("estado")
                };
                pedidos.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener lista de pedidos: " + e.getMessage());
            e.printStackTrace();
        }
        
        return pedidos;
    }

    // --------- Tabla ENTREGAS ----------
    public static List<Object[]> obtenerEntregas() {
        List<Object[]> entregas = new ArrayList<>();
        
        try (Connection conn = DB.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM entregas")) {
            
            while (rs.next()) {
                Object[] fila = new Object[]{
                    rs.getInt("id_entrega"),
                    rs.getInt("id_pedido"),
                    rs.getInt("id_repartidor"),
                    rs.getInt("id_ruta"),
                    rs.getString("fecha_entrega"),
                    rs.getDouble("energia_estim_kJ")
                };
                entregas.add(fila);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener lista de entregas: " + e.getMessage());
            e.printStackTrace();
        }
        
        return entregas;
    }

    // Método para obtener un pedido específico por ID
    public static Object[] obtenerPedidoPorId(int id_pedido) {
        String query = "SELECT * FROM pedidos WHERE id_pedido = ?";
        
        try (Connection conn = DB.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id_pedido);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Object[]{
                        rs.getInt("id_pedido"),
                        rs.getInt("id_cliente"),
                        rs.getString("fecha_pedido"),
                        rs.getDouble("peso_kg"),
                        rs.getString("estado")
                    };
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener pedido con ID " + id_pedido + ": " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }

    // Método para obtener una entrega específica por ID
    public static Object[] obtenerEntregaPorId(int id_entrega) {
        String query = "SELECT * FROM entregas WHERE id_entrega = ?";
        
        try (Connection conn = DB.conectar();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id_entrega);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Object[]{
                        rs.getInt("id_entrega"),
                        rs.getInt("id_pedido"),
                        rs.getInt("id_repartidor"),
                        rs.getInt("id_ruta"),
                        rs.getString("fecha_entrega"),
                        rs.getDouble("energia_estim_kJ")
                    };
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener entrega con ID " + id_entrega + ": " + e.getMessage());
            e.printStackTrace();
        }
        
        return null;
    }
}
