/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;


/**
 *Modelo que permite representar un motor
 *@author Alejandro
 *@since 20250407
 *@version 1.0
 */
public class Motor {
        //atributos 
    /**
     * tipo de motor
     */
    
    private String tipoMotor;
    /**
     * velocidad maxima permitida por el motor
     */
    private double velocidadMaximaMotor;

    
    /**
     * inicializa los atributos de la clase motor
     * @param tipoMotor
     * @param velocidadMaximaMotor 
     */
    public Motor(String tipoMotor, double velocidadMaximaMotor) {
        this.tipoMotor = tipoMotor;
        this.velocidadMaximaMotor = velocidadMaximaMotor;
    }
    /**
     * retorna el tipo de  motor 
     * @return tipoMotor
     */
    
    public String getTipoMotor() {
        return tipoMotor;
    }
    /**
     *modifica el tipo de motor  
     *@param tipoMotor 
     */
    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }
    /**
     * retorna la velocidad maxima del motor  
     * @return velocidadMaximaMotor
     */
    public double getVelocidadMaximaMotor() {
        return velocidadMaximaMotor;
    }
    /**
     * modifica la velocidad maxima del motor 
     * @param velocidadMaximaMotor
     */
    public void setVelocidadMaximaMotor(double velocidadMaximaMotor) {
        this.velocidadMaximaMotor = velocidadMaximaMotor;
    }
    
    
    
    
}
