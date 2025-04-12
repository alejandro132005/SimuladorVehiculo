/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;

/**
 * Modelo que permite representar un motor
 * @author Juan Jose Cardona 
 * @since 20250407
 * @version 1.0
 */

/**
 * Representa un motor con un tipo especifico.
 * Proporciona metodos para obtener el tipo, la velocidad maxima,
 * y para encender o apagar el motor.
 */
public class Motor {
    private String cilindraje;
    private double velocidadMaxima;
    private boolean encendido;

    /**
     * Constructor para inicializar el motor con un tipo especifico.
     * 
     * @param cilindraje tipo de motor (por ejemplo, 1.6L, 2.0L, etc.)
     * @param velocidadMaxima velocidad maxima que puede alcanzar
     */
    public Motor(String cilindraje, double velocidadMaxima) {    
        this.cilindraje = cilindraje;
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Obtiene el cilindraje del motor
     * 
     * @return cadena con el cilindraje
     */
    public String getCilindraje() {
        return cilindraje;
    }

    /**
     * Establece el cilindraje del motor
     * 
     * @param cilindraje nuevo valor de cilindraje
     */
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    /**
     * Obtiene la velocidad maxima del motor
     * 
     * @return velocidad maxima en km/h
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Establece la velocidad maxima del motor
     * 
     * @param velocidadMaxima nueva velocidad maxima en km/h
     */
    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Indica si el motor esta encendido
     * 
     * @return true si esta encendido, false si no
     */
    public boolean isEncendido() {
        return encendido;
    }

    /**
     * Cambia el estado de encendido del motor
     * 
     * @param encendido nuevo estado (true o false)
     */
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    /**
     * Verifica si el motor esta encendido
     * 
     * @return true si esta encendido, false si no
     */
    public boolean estaEncendido() {
        return encendido;
    }

    /**
     * Enciende el motor
     * 
     * @return mensaje confirmando que el motor fue encendido
     * @throws IllegalStateException si el motor ya esta encendido
     */
    public String encender() {
        if (encendido) {
            throw new IllegalStateException("el motor ya esta encendido.");
        }
        encendido = true;
        return "motor encendido correctamente.";
    }

    /**
     * Apaga el motor
     * 
     * @return mensaje confirmando que el motor fue apagado
     * @throws IllegalStateException si el motor ya esta apagado
     */
    public String apagar() {
        if (!encendido) {
            throw new IllegalStateException("el motor ya esta apagado.");
        }
        encendido = false;
        return "motor apagado correctamente.";
    }
}
