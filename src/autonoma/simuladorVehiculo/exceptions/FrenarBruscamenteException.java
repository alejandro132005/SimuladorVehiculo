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
public class FrenarBruscamenteException extends RuntimeException {
    
    /**
     * se crea la excepcion para cuando se encuantra patinando por que ha frenado bruscamente
     */
    public FrenarBruscamenteException(){
        super("El vehiculo se encuentra patinando por que ha frenado bruscamente");
        
    }
    
}
