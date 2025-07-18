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
            String query="SELECT * FROM usuarios2";
            
            try(Statement stmt=conn.createStatement();
                ResultSet rs= stmt.executeQuery(query)){
                
               while(rs.next()){
                   Object[] fila = new Object[] {
                        rs.getInt("id_usuario"),
                        rs.getString("nombre"),
                        rs.getString("correo"),
                        rs.getString("contraseña"),
                        rs.getString("tipo_usuario"),
                        rs.getString("telefono")
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
    public static boolean insertarUsuario(String nombre, String correo, String contraseña, String tipo_usuario, String telefono) {
    
    Connection conn = DB.conectar();

    if (conn != null) {
        
        String query = "INSERT INTO usuarios (nombre_completo, rol, curp, correo, password) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contraseña);
            stmt.setString(4, tipo_usuario);
            stmt.setString(5, telefono);

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