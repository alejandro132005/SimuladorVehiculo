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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Clase encargada de leer la configuracion de un vehiculo desde un archivo.
 * 
 * El archivo debe contener informacion sobre el tipo de motor y llantas.
 * Si faltan datos o el formato es incorrecto, se lanzan excepciones.
 */
public class LectorArchivo {

    private ArrayList<String> archivo;
    private Charset charset = Charset.forName("UTF-8");

    /**
     * Constructor que inicializa la lista donde se almacenaran las lineas del archivo
     */
    public LectorArchivo() {
        this.archivo = new ArrayList<>();
    }

    /**
     * Metodo que lee un archivo desde la ruta indicada y almacena su contenido en la lista
     * 
     * @param localizacionArchivo ruta del archivo que se va a leer
     * @return lista de lineas leidas
     * @throws IOException si ocurre un error al leer el archivo
     */
    public ArrayList<String> leer(String localizacionArchivo) throws IOException {
        archivo.clear();
        File file = new File(localizacionArchivo);
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);

        String linea;
        while ((linea = buffer.readLine()) != null) {
            agregarLinea(linea);
        }

        reader.close();
        return this.archivo;
    }

    /**
     * Agrega una linea leida del archivo a la lista
     * 
     * @param linea texto de una linea
     */
    public void agregarLinea(String linea) {
        archivo.add(linea);
    }

    /**
     * Elimina las lineas vacias del texto proporcionado
     * 
     * @param texto lista de lineas que sera limpiada
     */
    public void limpiarTexto(ArrayList<String> texto) {
        texto.removeIf(String::isEmpty);
    }

    /**
     * Devuelve la configuracion del vehiculo leida desde el archivo
     * 
     * @return lista con las lineas del archivo
     */
    public ArrayList<String> getConfiguracionVehiculo() {
        return archivo;
    }
}
