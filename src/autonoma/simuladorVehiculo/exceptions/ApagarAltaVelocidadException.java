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
public class ApagarAltaVelocidadException extends RuntimeException{
    
    /**
     * se crea la excepcion para un accidente gracias a apagar el vehiculo
     */
    public ApagarAltaVelocidadException(){
        super("se ha accidentado, ha acelerado el vehiculo a mas de 60 km/h y ha apagado el vehiculo");
    }
    
}
