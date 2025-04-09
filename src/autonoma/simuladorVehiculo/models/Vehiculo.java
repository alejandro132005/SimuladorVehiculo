/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;

import autonoma.simuladorVehiculo.exceptions.EncenderException;

/**
 *Modelo que permite representar un vehiculo
 *@author Alejandro
 *@since 20250407
 *@version 1.0
 */
public class Vehiculo {
    private boolean encendido = false;
    
    private double velocidadActual;
    
    private boolean patinando = false;
    
    private boolean accidentado = false;
    
    private Motor motor;
    
    private Llanta llanta;

    
    
    public Vehiculo(double VelocidadActual, Motor motor, Llanta llanta) {
        this.velocidadActual = VelocidadActual;
        this.motor = motor;
        this.llanta = llanta;
    }

    
    
    
    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public double getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(double VelocidadActual) {
        this.velocidadActual = VelocidadActual;
    }

    public boolean isPatinando() {
        return patinando;
    }

    public void setPatinando(boolean Patinando) {
        this.patinando = Patinando;
    }

    public boolean isAccidentado() {
        return accidentado;
    }

    public void setAccidentado(boolean accidentado) {
        this.accidentado = accidentado;
    }
    
   
    
    
    
    
    
    public String encender() throws EncenderException{
        if (this.encendido == true){
            throw new EncenderException();
        }
        this.encendido = true;
        return "el carro se encendio";
        
    }
    
    
    public String apagar (){
        this.encendido= false;
        this.velocidadActual = 0;
        return "el carro se ha apagado";
    }
    
    
    
    public String acelerar(double indiceAcelerar){
        this.velocidadActual += indiceAcelerar;
        return "ha acelerado";
    }
    public String frenar(double indiceFrenado){
        this.velocidadActual -= indiceFrenado;
        return "ha frenado";
    }
    
    
    public boolean frenarBruscamente(double indice){
        if (indice > 30){
            return true;
        }
        return false;
    }
    
    public boolean recuperarControl(){
        if (this.patinando && this.velocidadActual == 0){
            return true;
        }
        return false;
    }
    
    
}

