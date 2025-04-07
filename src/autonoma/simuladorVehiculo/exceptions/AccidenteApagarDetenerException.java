/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.exceptions;

/**
 *Modelo que permite representar una excepcion
 *@author aleja
 *@since 20250406
 *@version 1.0
 */
public class AccidenteApagarDetenerException extends RuntimeException {
    /**
     * se crea la excepcion si se apaga y detiene el vehiculo
     */
    public AccidenteApagarDetenerException(){
        super("se detuvo y apago el vehiculo debido a su accidente");
    }
    
}
