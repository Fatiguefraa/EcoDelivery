/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author Ramon
 */
import java.util.List;

public class LoginSistema {

    // Método para verificar usuario y contraseña desde la base de datos
    public boolean verificarAcceso(String nombre, String contrasena) {
        List<Object[]> usuarios = peticiones1.obtenerUsuarios();

        for (Object[] usuario : usuarios) {
            String nombreUsuario = (String) usuario[1];     // columna 1 = nombre
            String password = (String) usuario[3];          // columna 3 = contraseña

            if (nombreUsuario.equals(nombre) && password.equals(contrasena)) {
                return true;
            }
        }

        return false;
    }
}
