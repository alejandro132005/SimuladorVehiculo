/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.exceptions;

/**
 *Modelo que permite representar una excepcion
 *@author Alejandro
 *@since 20250406
 *@version 1.0
 */
public class EncenderException extends RuntimeException {
    
    /**
     * se crea la excepcion para cuando se quiere encender un vehiculo cuando ya esta encendido
     */
    public EncenderException(){
        super("No puede encender el vehiculo, ya se encuentra encendido");
    }
    
}
