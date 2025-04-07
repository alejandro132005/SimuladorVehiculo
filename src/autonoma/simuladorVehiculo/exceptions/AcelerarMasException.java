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
public class AcelerarMasException extends RuntimeException {
    /**
    * se crea la excepcion para cuando se accidenta un vehiculo por aceleracion
    */
    public AcelerarMasException(){

        super("se ha accidentado debido a que ha acelerado mas de la capacidad del motor");
    }
    
}
