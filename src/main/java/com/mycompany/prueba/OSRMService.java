/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author Ramon
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class OSRMService {
    public static void getRutaInfo(double latOrigen, double lonOrigen, double latDestino, double lonDestino, String modo) {
        try {
            // Configurar perfil (car, bike, foot)
            String profile = modo.equals("bicicleta") ? "bike" : "car";
            
            // Construir URL de la API
            String urlStr = String.format(
                "https://router.project-osrm.org/route/v1/%s/%f,%f;%f,%f?overview=false",
                profile, lonOrigen, latOrigen, lonDestino, latDestino
            );

            // Hacer la solicitud HTTP
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Leer respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parsear JSON
            JSONObject json = new JSONObject(response.toString());
            JSONObject ruta = json.getJSONArray("routes").getJSONObject(0);
            
            // Extraer distancia (metros) y duración (segundos)
            double distanciaKm = ruta.getDouble("distance") / 1000.0;
            double duracionMin = ruta.getDouble("duration") / 60.0;

            System.out.println("Distancia: " + distanciaKm + " km");
            System.out.println("Duración: " + duracionMin + " minutos");

        } catch (Exception e) {
            System.err.println("Error al calcular la ruta: " + e.getMessage());
        }
    }
}