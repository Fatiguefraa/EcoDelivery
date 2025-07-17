/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author Mento
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

public class peticiones1 {
    
    //Esta es para get
    public static List<Object[]> obtenerUsuarios(){
        
        List<Object[]> usuarios=new ArrayList<>();
        
        Connection conn=DB.conectar();
        
        if(conn != null){
            String query="SELECT * FROM usuarios";
            
            try(Statement stmt=conn.createStatement();
                ResultSet rs= stmt.executeQuery(query)){
                
               while(rs.next()){
                   Object[] fila = new Object[] {
                        rs.getInt("id"),
                        rs.getString("nombre_completo"),
                        rs.getString("rol"),
                        rs.getString("curp"),
                        rs.getString("correo"),
                        rs.getString("password")
                    };
                    usuarios.add(fila);
               }    
            }catch(SQLException e){
                System.out.println("Error al ejecutar consulta");
                e.printStackTrace();
            }
        }
        return usuarios;
    }
    
    //Otra peticion
    public static boolean insertarUsuario(String nombreCompleto, String rol, String curp, String correo, String password) {
    
    Connection conn = DB.conectar();

    if (conn != null) {
        
        String query = "INSERT INTO usuarios (nombre_completo, rol, curp, correo, password) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombreCompleto);
            stmt.setString(2, rol);
            stmt.setString(3, curp);
            stmt.setString(4, correo);
            stmt.setString(5, password);

            int filasAfectadas = stmt.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error al insertar usuario");
            e.printStackTrace();
        }
    }

    return false;
}

}
