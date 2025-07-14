/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author Ramon
 */
public class LoginSistema {
    // Arrays de usuarios y contraseñas
    private String[] usuarios = {"alberto", "maria", "juan", "lucia"};
    private String[] contrasenas = {"1234", "pass123", "qwerty", "lucia2025"};

    // Método para verificar usuario y contraseña
    public boolean verificarAcceso(String usuarioIngresado, String contrasenaIngresada) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i].equals(usuarioIngresado) && contrasenas[i].equals(contrasenaIngresada)) {
                return true;
            }
        }
        return false;
    }
}