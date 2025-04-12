/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package autonoma.simuladorVehiculo.models;

/**
 * Modelo que permite representar un LectorArchivo
 * Autor: Alejandro
 * Desde: 20250407
 * Version: 1.0
 */
import java.io.IOException;
import java.util.ArrayList;

/**
 * Interfaz que define el contrato para la lectura de archivos de configuracion.
 */
public interface Lector {

    /**
     * Metodo abstracto para leer un archivo de configuracion desde una ruta dada.
     * 
     * @param localizacionArchivo ruta del archivo que se desea leer
     * @return una lista de lineas leidas desde el archivo
     * @throws IOException si ocurre un error al leer el archivo
     */
    public abstract ArrayList<String> leer(String localizacionArchivo) throws IOException;
}
