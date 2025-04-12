/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.main;

import autonoma.simuladorVehiculo.models.ConfiguradorVehiculo;
import autonoma.simuladorVehiculo.models.LectorArchivo;
import autonoma.simuladorVehiculo.models.Simulador;
import autonoma.simuladorVehiculo.models.Vehiculo;
import autonoma.simuladorVehiculo.views.VentanaPrincipal;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *Modelo que permite representar un simulador
 *@author Alejandro
 *@since 20250407
 *@version 1.0
 */

public class Main {
    public static void main(String[] args) {
        
     LectorArchivo l = new LectorArchivo();
     
     Vehiculo vehiculo = null;
     
     try{
         
         ConfiguradorVehiculo c = new ConfiguradorVehiculo(l);
         vehiculo = c.configurar();
         
         c.setVehiculo(vehiculo);
         
         Simulador simulador = new Simulador(c);
         
         VentanaPrincipal ventana = new VentanaPrincipal(simulador);
         ventana.setVisible(true);
    }catch(IOException ex){
         System.out.println("archivo no encontrado");
         JOptionPane.showMessageDialog(null, "No se puede acceder al archivo cambiarVehiculo.txt", "Error", JOptionPane.ERROR_MESSAGE);

         
     }
     
    }
}