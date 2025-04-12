/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;

/**
 * Modelo que permite representar una Llanta
 * Autor: Juan Jose Cardona 
 * Desde: 20250407
 * Version: 1.0
 */

/**
 * Representa un conjunto de llantas con un tipo especifico.
 * Proporciona metodos para obtener el tipo y el limite de velocidad de las llantas.
 */
public class Llanta {

    private String tipoLlanta;
    private double limiteVelocidad;

    /**
     * Constructor que inicializa una llanta con su tipo y limite de velocidad
     * 
     * @param tipoLlanta tipo o clasificacion de la llanta (por ejemplo, deportiva, todo terreno)
     * @param limiteVelocidad velocidad maxima que soporta la llanta en km/h
     */
    public Llanta(String tipoLlanta, double limiteVelocidad) {
        this.tipoLlanta = tipoLlanta;
        this.limiteVelocidad = limiteVelocidad;
    }

    /**
     * Obtiene el tipo de la llanta
     * 
     * @return tipo de llanta como cadena
     */
    public String getTipoLlanta() {
        return tipoLlanta;
    }

    /**
     * Establece el tipo de la llanta
     * 
     * @param tipoLlanta nuevo tipo de llanta
     */
    public void setTipoLlanta(String tipoLlanta) {
        this.tipoLlanta = tipoLlanta;
    }

    /**
     * Obtiene el limite de velocidad de la llanta
     * 
     * @return velocidad maxima en km/h
     */
    public double getLimiteVelocidad() {
        return limiteVelocidad;
    }

    /**
     * Establece el limite de velocidad de la llanta
     * 
     * @param limiteVelocidad nueva velocidad maxima en km/h
     */
    public void setLimiteVelocidad(double limiteVelocidad) {
        this.limiteVelocidad = limiteVelocidad;
    }
}
