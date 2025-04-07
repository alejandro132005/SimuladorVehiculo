/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;

/**
 *Modelo que permite representar una Llanta
 *@author Alejandro
 *@since 20250407
 *@version 1.0
 */
public class Llanta {
    //atributos 
    /**
     * tipo de llanta 
     */
    private String tipo;
    /**
    *limite de velocidad permitido por las llantas  
    */
    private double limiteVelocidad;

    
    /**
     * inicializa los atributos de la case llanta 
     * @param tipo
     * @param limiteVelocidad 
     */
    public Llanta(String tipo, double limiteVelocidad) {
        this.tipo = tipo;
        this.limiteVelocidad = limiteVelocidad;
    }
    
    /**
     * retorna el tipo de llanta 
     * @return tipo
     */

    public String getTipo() {
        return tipo;
    }
    /**
     * modifica el tipo de llanta 
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * retorna el limite de velocidad permitido 
     * @return LimiteVelocidad 
     */
    public double getLimiteVelocidad() {
        return limiteVelocidad;
    }
    
    /**
     * modifica el limite de velocidad permitido 
     * @param limiteVelocidad 
     */

    public void setLimiteVelocidad(double limiteVelocidad) {
        this.limiteVelocidad = limiteVelocidad;
    }
    
    
   
    
    
}
