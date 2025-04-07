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
    private String tipoLlanta;
    /**
    *limite de velocidad permitido por las llantas  
    */
    private double limiteVelocidadLlanta;

    
    /**
     * inicializa los atributos de la case llanta 
     * @param tipoLlanta
     * @param limiteVelocidadLlanta
     */
    public Llanta(String tipoLlanta, double limiteVelocidadLlanta) {
        this.tipoLlanta = tipoLlanta;
        this.limiteVelocidadLlanta = limiteVelocidadLlanta;
    }
    
    /**
     * retorna el tipo de llanta 
     * @return tipoLlanta
     */

    public String getTipoLlanta() {
        return tipoLlanta;
    }
    /**
     * modifica el tipo de llanta 
     * @param tipoLlanta
     */
    public void setTipo(String tipoLlanta) {
        this.tipoLlanta = tipoLlanta;
    }
    /**
     * retorna el limite de velocidad permitido 
     * @return LimiteVelocidad 
     */
    public double getLimiteVelocidadLlanta() {
        return limiteVelocidadLlanta;
    }
    
    /**
     * modifica el limite de velocidad permitido 
     * @param limiteVelocidadLlanta 
     */

    public void setLimiteVelocidadLlanta(double limiteVelocidadLlanta) {
        this.limiteVelocidadLlanta = limiteVelocidadLlanta;
    }
    
    
   
    
    
}
