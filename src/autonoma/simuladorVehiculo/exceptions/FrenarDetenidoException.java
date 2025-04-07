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
public class FrenarDetenidoException extends RuntimeException{
    
    /**
     * se crea la excepcion para cuando se frena con el vehiculo ya detenido
     */
    public FrenarDetenidoException(){
         super("El vehiculo ya esta detenido");
        
    }
    
}
