/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Modelo que permite representar un Escritor
 * Autor: Alejandro
 * Desde: 20250407
 * Version: 1.0
 */
public interface Escritor {

    /**
     * Metodo abstracto para escribir el contenido en un archivo.
     * 
     * @param archivo lista de lineas a escribir en el archivo
     * @throws IOException si ocurre un error al escribir el archivo
     */
    public abstract void escribir(ArrayList<String> archivo) throws IOException;

}
