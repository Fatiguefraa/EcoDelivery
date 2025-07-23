/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author Ramon
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsercionesBD {

    // --------- Tabla PEDIDOS ----------
    public static boolean insertarPedido(int id_cliente, String fecha_pedido, double peso_kg, String estado) {
        Connection conn = DB.conectar();
        String query = "INSERT INTO pedidos (id_cliente, fecha_pedido, peso_kg, estado) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_cliente);
            stmt.setString(2, fecha_pedido);
            stmt.setDouble(3, peso_kg);
            stmt.setString(4, estado);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar pedido");
            e.printStackTrace();
        }
        return false;
    }

    // --------- Tabla ENTREGAS ----------
    public static boolean insertarEntrega(int id_pedido, int id_repartidor, int id_ruta, String fecha_entrega, double energia_estim_kJ) {
        Connection conn = DB.conectar();
        String query = "INSERT INTO entregas (id_pedido, id_repartidor, id_ruta, fecha_entrega, energia_estim_kJ) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_pedido);
            stmt.setInt(2, id_repartidor);
            stmt.setInt(3, id_ruta);
            stmt.setString(4, fecha_entrega);
            stmt.setDouble(5, energia_estim_kJ);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar entrega");
            e.printStackTrace();
        }
        return false;
    }

    // Método para actualizar el estado de un pedido
    public static boolean actualizarEstadoPedido(int id_pedido, String nuevoEstado) {
        Connection conn = DB.conectar();
        String query = "UPDATE pedidos SET estado = ? WHERE id_pedido = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nuevoEstado);
            stmt.setInt(2, id_pedido);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar estado del pedido");
            e.printStackTrace();
        }
        return false;
    }

    // Método para actualizar la energía estimada de una entrega
    public static boolean actualizarEnergiaEntrega(int id_entrega, double nuevaEnergia) {
        Connection conn = DB.conectar();
        String query = "UPDATE entregas SET energia_estim_kJ = ? WHERE id_entrega = ?";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, nuevaEnergia);
            stmt.setInt(2, id_entrega);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar energía estimada de la entrega");
            e.printStackTrace();
        }
        return false;
    }
}
