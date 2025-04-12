/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Modelo que permite representar un ConfiguradorVehiculo
 * Autor: Juan Jose Cardona
 * Desde: 20250407
 * Version: 1.0
 */
public class ConfiguradorVehiculo {

    private LectorArchivo lector;  // Objeto que lee el archivo de configuración
    private Vehiculo vehiculo;  // Objeto que representa el vehículo configurado
    private EscritorArchivo escritor;  // Objeto que escribe la configuración en el archivo

    // Constructor que recibe un objeto LectorArchivo para leer el archivo de configuración
    public ConfiguradorVehiculo(LectorArchivo lector) {
        this.lector = lector;
        this.vehiculo = null;
    }

    // Getter para obtener el vehículo configurado
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    // Setter para cambiar el vehículo configurado
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Configura el vehículo leyendo el archivo de configuración y creando un nuevo vehículo.
     * 
     * @return Vehiculo configurado con los parámetros del archivo.
     * @throws IOException si no se puede leer el archivo de configuración.
     */
    public Vehiculo configurar() throws IOException {
        // Lee las configuraciones del archivo
        ArrayList<String> datosConfiguracion = lector.leer("cambiarVehiculo.txt");

        // Crea un nuevo vehículo según los datos leídos
        this.vehiculo = vehiculoNuevo(datosConfiguracion);
        return vehiculo;
    }

    /**
     * Retorna el límite de velocidad de las llantas según su tipo.
     * 
     * @param tipoLlanta tipo de la llanta para determinar el límite de velocidad.
     * @return el límite de velocidad según el tipo de llanta.
     */
    public float limitePorLlanta(String tipoLlanta) {
        switch (tipoLlanta.toLowerCase()) {
            case "bonitas": return 70;
            case "buenas": return 110;
            case "baratas": return 50;
            default: return 0;  // Si el tipo no está en los casos definidos, se retorna 0
        }
    }

    /**
     * Retorna la velocidad máxima del motor según su cilindraje.
     * 
     * @param cilindrajeMotor cilindraje del motor para determinar su velocidad máxima.
     * @return la velocidad máxima según el cilindraje del motor.
     */
    public float velocidadPorMotor(String cilindrajeMotor) {
        switch (cilindrajeMotor) {
            case "3000": return 220;
            case "2000": return 160;
            case "1000": return 100;
            default: return 0;  // Si el cilindraje no está en los casos definidos, se retorna 0
        }
    }

    /**
     * Crea un nuevo vehículo con la configuración proporcionada en el archivo.
     * 
     * @param configuracion lista con los datos de configuración leídos del archivo.
     * @return un nuevo objeto Vehiculo configurado con los datos.
     */
    private Vehiculo vehiculoNuevo(ArrayList<String> configuracion) {
        String tipoLlanta = "";  // Tipo de llanta extraído del archivo
        String cilindraje = "";  // Cilindraje del motor extraído del archivo

        // Itera sobre cada línea del archivo para extraer la configuración del vehículo
        for (String linea : configuracion) {
            String[] partes = linea.split(";");
            if (partes.length < 2) continue;  // Si la línea no tiene el formato esperado, la ignora

            // Asigna el tipo de llanta o cilindraje según el contenido de la línea
            if (partes[0].equalsIgnoreCase("llantas")) {
                tipoLlanta = partes[1];
            } else if (partes[0].equalsIgnoreCase("motor")) {
                cilindraje = partes[1];
            }
        }

        // Calcula la velocidad máxima y el límite de velocidad según el motor y las llantas
        float velocidadMaxima = velocidadPorMotor(cilindraje);
        float limiteVelocidad = limitePorLlanta(tipoLlanta);

        // Crea instancias de motor y llanta con los valores configurados
        Motor motor = new Motor(cilindraje, velocidadMaxima);
        Llanta llanta = new Llanta(tipoLlanta, limiteVelocidad);

        // Devuelve un nuevo vehículo con los componentes configurados
        return new Vehiculo(0, motor, llanta);
    }

    /**
     * Muestra las configuraciones disponibles para llantas y motores.
     * 
     * @return una cadena con las opciones de configuración disponibles.
     */
    public String mostrarConfiguraciones() {
        StringBuilder sb = new StringBuilder("       CONFIGURACIONES DISPONIBLES       \n");
        sb.append("Llantas:\n");
        sb.append("- Buenas: 110 Km/h\n");
        sb.append("- Bonitas: 70 Km/h\n");
        sb.append("- Baratas: 50 Km/h\n\n");

        sb.append("Motor (cilindraje):\n");
        sb.append("- 1000 cc: 100 Km/h\n");
        sb.append("- 2000 cc: 160 Km/h\n");
        sb.append("- 3000 cc: 220 Km/h\n");

        return sb.toString();  // Devuelve la cadena con las configuraciones disponibles
    }

    /**
     * Muestra la configuración actual del vehículo basado en el archivo de configuración.
     * 
     * @return una cadena con la configuración actual del vehículo.
     * @throws IOException si no se puede leer el archivo de configuración.
     */
    public String mostrarConfiActual() throws IOException {
        ArrayList<String> config = lector.leer("cambiarVehiculo.txt");
        String tipoLlanta = "";  // Tipo de llanta configurado
        String cilindraje = "";  // Cilindraje del motor configurado

        // Extrae la configuración actual del archivo
        for (String linea : config) {
            String[] partes = linea.split(";");
            if (partes.length < 2) continue;  // Si la línea no tiene el formato esperado, la ignora

            if (partes[0].equalsIgnoreCase("llantas")) {
                tipoLlanta = partes[1];
            } else if (partes[0].equalsIgnoreCase("motor")) {
                cilindraje = partes[1];
            }
        }

        // Calcula la velocidad máxima y el límite de velocidad
        float velocidadMax = velocidadPorMotor(cilindraje);
        float limiteVel = limitePorLlanta(tipoLlanta);

        // Muestra la configuración actual del vehículo en una cadena
        StringBuilder sb = new StringBuilder("   CONFIGURACION ACTUAL DEL VEHICULO   \n");
        sb.append("Llantas: ").append(tipoLlanta).append(" - Limite: ").append(limiteVel).append(" Km/h\n");
        sb.append("Motor: ").append(cilindraje).append(" cc - Maxima: ").append(velocidadMax).append(" Km/h\n");

        return sb.toString();  // Devuelve la configuración actual del vehículo
    }

    /**
     * Permite cambiar la configuración del vehículo guardando los nuevos valores en el archivo.
     * 
     * @param nuevoTipoLlanta nuevo tipo de llanta para el vehículo.
     * @param nuevoCilindrajeMotor nuevo cilindraje para el motor del vehículo.
     * @throws IOException si no se puede escribir en el archivo de configuración.
     */
    public void cambiarConfiguracion(String nuevoTipoLlanta, String nuevoCilindrajeMotor) throws IOException {
        ArrayList<String> nuevaConfig = new ArrayList<>();
        nuevaConfig.add("llantas;" + nuevoTipoLlanta);  // Agrega la nueva configuración de llantas
        nuevaConfig.add("motor;" + nuevoCilindrajeMotor);  // Agrega la nueva configuración del motor

        // Crea el escritor para guardar la nueva configuración
        escritor = new EscritorArchivo("cambiarVehiculo.txt");
        escritor.escribir(nuevaConfig);  // Escribe la configuración en el archivo
    }
}
