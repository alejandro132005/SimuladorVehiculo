/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Modelo que permite representar un EscritorArchivo
 * Autor: Alejandro
 * Desde: 20250407
 * Version: 1.0
 */

/**
 * Clase encargada de escribir y gestionar la configuracion de un vehiculo en un archivo.
 * Permite al usuario crear o seleccionar un archivo de configuracion.
 */
public class EscritorArchivo implements Escritor {

    private final Charset charset = Charset.forName("UTF-8");
    private String filePath;

    /**
     * Constructor que recibe la ruta del archivo donde se guardara la configuracion.
     * 
     * @param filePath ruta del archivo donde se guardara la configuracion
     */
    public EscritorArchivo(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Metodo para escribir el contenido del archivo en la ruta indicada.
     * 
     * @param archivo lista de lineas a escribir en el archivo
     * @throws IOException si ocurre un error al escribir el archivo
     */
    @Override
    public void escribir(ArrayList<String> archivo) throws IOException {

        // Crea o abre el archivo en la ruta indicada
        File fichero = new File(this.filePath);
        FileWriter writer = new FileWriter(fichero, false);
        PrintWriter pw = new PrintWriter(writer);

        // Escribe cada linea en el archivo
        for (String linea : archivo) {
            pw.println(linea);
        }

        writer.close();
    }
}
