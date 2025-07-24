/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author david
 */

import java.sql.*;
public class Acciones_provedores {



    //  Método privado para conectar con la base de datos
    private Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/tu_basededatos", "usuario", "contraseña");
        } catch (Exception e) {
            System.out.println("Error al conectar: " + e.getMessage());
            return null;
        }
    }

    //  Notificaciones
    public void obtenerNotificaciones(int usuarioId) {
        try (Connection con = conectar()) {
            PreparedStatement ps = con.prepareStatement("SELECT mensaje FROM notificaciones WHERE usuario_id = ?");
            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("🔔 " + rs.getString("mensaje"));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener notificaciones: " + e.getMessage());
        }
    }

    //  Locación
    public void actualizarLocacion(String nuevaLocacion, int usuarioId) {
        try (Connection con = conectar()) {
            PreparedStatement ps = con.prepareStatement("UPDATE usuarios SET locacion = ? WHERE id = ?");
            ps.setString(1, nuevaLocacion);
            ps.setInt(2, usuarioId);
            ps.executeUpdate();
            System.out.println("📍 Locación actualizada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al actualizar locación: " + e.getMessage());
        }
    }

    // Reseñas
    public void guardarReseña(String textoReseña, int usuarioId) {
        try (Connection con = conectar()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO reseñas(contenido, usuario_id) VALUES (?, ?)");
            ps.setString(1, textoReseña);
            ps.setInt(2, usuarioId);
            ps.executeUpdate();
            System.out.println("⭐ Reseña guardada.");
        } catch (Exception e) {
            System.out.println("Error al guardar reseña: " + e.getMessage());
        }
    }

    // Pedidos pendientes
    public void verPedidosPendientes(int usuarioId) {
        try (Connection con = conectar()) {
            PreparedStatement ps = con.prepareStatement("SELECT descripcion FROM pedidos WHERE estado = 'pendiente' AND usuario_id = ?");
            ps.setInt(1, usuarioId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("📦 Pedido pendiente: " + rs.getString("descripcion"));
            }
        } catch (Exception e) {
            System.out.println("Error al obtener pedidos: " + e.getMessage());
        }
    }

    //  Cerrar sesión
    public void cerrarSesion(javax.swing.JFrame ventanaActual) {
        if (ventanaActual != null) {
            ventanaActual.dispose(); // cierra la ventana actual
            System.out.println("✅ Sesión cerrada correctamente.");
            // Si tienes pantalla de login:
            // new LoginWindow().setVisible(true);
        } else {
            System.out.println("⚠️ No se pudo cerrar sesión: la ventana es nula.");
        }
    }
}
