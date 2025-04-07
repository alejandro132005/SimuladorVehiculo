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
public class ApagarException extends RuntimeException {
    
    /**
     * se crea la excepcion de no apagar el vehiculo si ya esta en este estado
     */
    public ApagarException(){
        super("No puede apagar el vehiculo, ya se encuentra apagado");
    }
}
