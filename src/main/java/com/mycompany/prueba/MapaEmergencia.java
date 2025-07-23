/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prueba;

/**
 *
 * @author Ramon
 */
import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;

public class MapaEmergencia {
    public static void mostrarRuta(String origen, String destino, String modo) {
        try {
            // Codificar coordenadas para URL
            String origenCod = URLEncoder.encode(origen, "UTF-8");
            String destinoCod = URLEncoder.encode(destino, "UTF-8");
            
            String url = String.format(
                "https://www.openstreetmap.org/directions?engine=fossgis_osrm_%s&route=%s%%2C%s%%3B%s%%2C%s",
                modo.equals("bicicleta") ? "bike" : "car",
                origen.split(",")[0].trim(), origen.split(",")[1].trim(),
                destino.split(",")[0].trim(), destino.split(",")[1].trim()
            );

            // Método universal para abrir el navegador
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                // Alternativa para entornos sin GUI
                Runtime rt = Runtime.getRuntime();
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
                } else if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                    rt.exec("open " + url);
                } else {
                    rt.exec("xdg-open " + url); // Linux
                }
            }
        } catch (Exception e) {
            System.err.println("Error al abrir el mapa. Copia este enlace manualmente:");
            System.err.println(generarEnlace(origen, destino, modo));
        }
    }

    public static String generarEnlace(String origen, String destino, String modo) {
        return String.format(
            "https://www.openstreetmap.org/directions?engine=fossgis_osrm_%s&route=%s%%2C%s%%3B%s%%2C%s",
            modo.equals("bicicleta") ? "bike" : "car",
            origen.split(",")[0].trim(), origen.split(",")[1].trim(),
            destino.split(",")[0].trim(), destino.split(",")[1].trim()
        );
    }
}


