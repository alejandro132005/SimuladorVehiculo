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
public class NoUsarApagadoException extends RuntimeException{
    /**
     * se crea la excepcion para cuando se intenta frenar o acelerar con el carro apagado 
     */
    public NoUsarApagadoException(){
         super("El vehiculo esta apagado, no frene ni acelere ");
        
    }
    
}
