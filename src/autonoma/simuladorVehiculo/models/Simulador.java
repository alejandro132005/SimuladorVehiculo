/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;
import autonoma.simuladorVehiculo.exceptions.AccidenteApagarDetenerException;
import autonoma.simuladorVehiculo.exceptions.AcelerarMasException;
import autonoma.simuladorVehiculo.exceptions.ApagarAltaVelocidadException;
import autonoma.simuladorVehiculo.exceptions.ApagarException;
import autonoma.simuladorVehiculo.exceptions.EncenderException;
import autonoma.simuladorVehiculo.exceptions.FrenarBruscamenteException;
import autonoma.simuladorVehiculo.exceptions.FrenarDetenidoException;
import autonoma.simuladorVehiculo.exceptions.FrenarMasException;
import autonoma.simuladorVehiculo.exceptions.NoUsarApagadoException;

/**
 *Modelo que permite representar un simulador
 *@author Alejandro
 *@since 20250407
 *@version 1.0
 */

/**
 * Clase que simula la conducción de un vehículo, permitiendo al usuario interactuar
 * con el vehículo a través de un menú de opciones.
 * 
 * Gestiona las acciones de encender, apagar, acelerar y frenar el vehículo,
 * manejando las excepciones correspondientes.
 */
public class Simulador {
   

    private Vehiculo vehiculo;
    private ConfiguradorVehiculo configuradorVehiculo;

   public Simulador(ConfiguradorVehiculo configuradorVehiculo) {
    this.configuradorVehiculo = configuradorVehiculo;
    this.vehiculo = configuradorVehiculo.getVehiculo(); // 👈 Asigna el vehículo aquí
}


    public ConfiguradorVehiculo getConfiguradorVehiculo() {
        return configuradorVehiculo;
    }

    public void setConfiguradorVehiculo(ConfiguradorVehiculo configuradorVehiculo) {
        this.configuradorVehiculo = configuradorVehiculo;
    }
    
   
    public String encender() throws EncenderException, AccidenteApagarDetenerException {
        try {
            return this.vehiculo.encender();
        } catch (EncenderException e) {
            throw e;
        } catch (AccidenteApagarDetenerException e) {
            throw e;
        }
    }

        
    public String apagar() throws ApagarException, ApagarAltaVelocidadException {
        try {
            return this.vehiculo.apagar();
        } catch (ApagarException e) {
            throw e;
        } catch (ApagarAltaVelocidadException e) {
            throw e;
        }
    }

    public String acelerar(int incremento) throws NoUsarApagadoException, AcelerarMasException {
        try {
            return this.vehiculo.acelerar(incremento);
        } catch (NoUsarApagadoException e) {
            throw e;
        } catch (AcelerarMasException e) {
            throw e;
        }
    }

    public String frenar(int decremento) throws NoUsarApagadoException, FrenarDetenidoException, FrenarMasException, FrenarBruscamenteException {
        try {
            return this.vehiculo.frenar(decremento);
        } catch (NoUsarApagadoException e) {
            throw e;
        } catch (FrenarDetenidoException e) {
            throw e;
        } catch (FrenarMasException e) {
            throw e;
        } catch (FrenarBruscamenteException e) {
            throw e;
        }
    }

    public String frenarBruscamente(int decremento) throws NoUsarApagadoException, FrenarDetenidoException, FrenarMasException, FrenarBruscamenteException {
        try {
            return this.vehiculo.frenarBruscamente(decremento);
        } catch (NoUsarApagadoException e) {
            throw e;
        } catch (FrenarDetenidoException e) {
            throw e;
        } catch (FrenarMasException e) {
            throw e;
        } catch (FrenarBruscamenteException e) {
            throw e;
        }
    }

    // Métodos de consulta
    public int getVelocidad() {
        return vehiculo.getVelocidadActual();
    }
    

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    
    

    public String getEstadoVehiculo() {
        return vehiculo.getEstado();
    }

    public boolean estaEncendido() {
        return vehiculo.estaEncendido();
    }

    public boolean estaAccidentado() {
        return vehiculo.estaAccidentado();
    }

    public boolean estaPatinando() {
        return vehiculo.estaPatinando();
    }
}