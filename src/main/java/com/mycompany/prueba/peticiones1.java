package com.mycompany.prueba;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class peticiones1 {

    // --------- Tabla USUARIOS2 ----------
    public static List<Object[]> obtenerUsuarios() {
        List<Object[]> usuarios = new ArrayList<>();
        Connection conn = DB.conectar();

        if (conn != null) {
            String query = "SELECT * FROM usuarios2";
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    Object[] fila = new Object[]{
                            rs.getInt("id_usuario"),
                            rs.getString("nombre"),
                            rs.getString("correo"),
                            rs.getString("contraseña"),
                            rs.getString("tipo_usuario"),
                            rs.getString("telefono")
                    };
                    usuarios.add(fila);
                }
            } catch (SQLException e) {
                System.out.println("Error al ejecutar consulta");
                e.printStackTrace();
            }
        }
        return usuarios;
    }

    public static boolean insertarUsuario(String nombre, String correo, String contraseña, String tipo_usuario, String telefono) {
        Connection conn = DB.conectar();

        if (conn != null) {
            String query = "INSERT INTO usuarios2 (nombre, correo, contraseña, tipo_usuario, telefono) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, nombre);
                stmt.setString(2, correo);
                stmt.setString(3, contraseña);
                stmt.setString(4, tipo_usuario);
                stmt.setString(5, telefono);
                return stmt.executeUpdate() > 0;
            } catch (SQLException e) {
                System.out.println("❌ Error al insertar usuario");
                e.printStackTrace();
            }
        }
        return false;
    }

    // --------- Tabla REPARTIDORES ----------
    public static boolean insertarRepartidor(int id_usuario, String tipo_vehiculo, double capacidad_kg) {
        Connection conn = DB.conectar();
        String query = "INSERT INTO repartidores (id_usuario, tipo_vehiculo, capacidad_kg) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id_usuario);
            stmt.setString(2, tipo_vehiculo);
            stmt.setDouble(3, capacidad_kg);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar repartidor");
            e.printStackTrace();
        }
        return false;
    }

    // --------- Tabla RUTAS ----------
    public static boolean insertarRuta(String origen, String destino, double distancia_km, double pendiente_grados) {
        Connection conn = DB.conectar();
        String query = "INSERT INTO rutas (origen, destino, distancia_km, pendiente_grados) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, origen);
            stmt.setString(2, destino);
            stmt.setDouble(3, distancia_km);
            stmt.setDouble(4, pendiente_grados);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar ruta");
            e.printStackTrace();
        }
        return false;
    }

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
}
