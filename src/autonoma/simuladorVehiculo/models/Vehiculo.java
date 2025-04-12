/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simuladorVehiculo.models;

/**
 * Modelo que permite representar un vehiculo
 * @author Alejandro
 * @since 20250407
 * @version 1.0
 */

import autonoma.simuladorVehiculo.exceptions.AccidenteApagarDetenerException;
import autonoma.simuladorVehiculo.exceptions.AcelerarMasException;
import autonoma.simuladorVehiculo.exceptions.ApagarAltaVelocidadException;
import autonoma.simuladorVehiculo.exceptions.EncenderException;
import autonoma.simuladorVehiculo.exceptions.FrenarBruscamenteException;
import autonoma.simuladorVehiculo.exceptions.ApagarException;
import autonoma.simuladorVehiculo.exceptions.FrenarDetenidoException;
import autonoma.simuladorVehiculo.exceptions.FrenarMasException;
import autonoma.simuladorVehiculo.exceptions.NoUsarApagadoException;
import autonoma.simuladorVehiculo.models.Llanta;
import autonoma.simuladorVehiculo.models.Motor;

/**
 * Clase que representa un vehiculo con motor y llanta.
 * Permite realizar acciones como encender, apagar, acelerar y frenar,
 * gestionando el estado del vehiculo y posibles excepciones.
 */
public class Vehiculo {

    private Motor motor;
    private Llanta llanta;
    private boolean accidentado;
    private boolean patinando;
    private int velocidadActual;

    /**
     * Constructor para inicializar un vehiculo con motor y llanta.
     * 
     * @param motor   Motor del vehiculo.
     * @param llanta  Llanta del vehiculo.
     */
    public Vehiculo(int velocidadActual, Motor motor, Llanta llanta) {
        this.motor = motor;
        this.llanta = llanta;
        this.accidentado = false;
        this.patinando = false;
        this.velocidadActual = 0;
    }

    /**
     * Enciende el vehiculo usando el motor.
     * Verifica si esta accidentado y lanza una excepcion si es asi.
     * Si no, intenta encender el motor.
     * 
     * @return Mensaje de confirmacion
     * @throws EncenderException Si el motor ya esta encendido.
     * @throws AccidenteApagarDetenerException Si el vehiculo esta accidentado.
     */
    public String encender() throws EncenderException, AccidenteApagarDetenerException {
        if (accidentado) {
            throw new AccidenteApagarDetenerException("El vehiculo esta accidentado y no puede encenderse.");
        }
        try {
            motor.encender();
        } catch (IllegalStateException e) {
            throw new EncenderException();
        }
        return "Vehiculo encendido correctamente.";
    }

    /**
     * Apaga el vehiculo.
     * Si la velocidad es mayor a 60 km/h, se considera un accidente,
     * se apaga el motor y se lanza una excepcion.
     * Si no, simplemente apaga el motor.
     * 
     * @return Mensaje de confirmacion
     * @throws ApagarException Si el motor ya esta apagado.
     * @throws ApagarAltaVelocidadException Si se apaga a velocidad peligrosa.
     */
    public String apagar() throws ApagarException, ApagarAltaVelocidadException {
        if (velocidadActual > 60) {
            accidentado = true;
            velocidadActual = 0;
            try {
                motor.apagar();
            } catch (IllegalStateException ignored) {
                // Se ignora porque el motor ya esta apagado
            }
            throw new ApagarAltaVelocidadException();
        }
        try {
            motor.apagar();
        } catch (IllegalStateException e) {
            throw new ApagarException();
        }
        return "Vehiculo apagado correctamente.";
    }

    /**
     * Acelera el vehiculo aumentando la velocidad actual.
     * Verifica si el motor esta apagado o si se sobrepasa la velocidad maxima,
     * en cuyo caso se considera un accidente.
     * 
     * @param incremento Cantidad de km/h que se quiere aumentar.
     * @return Mensaje con la nueva velocidad o advertencia.
     * @throws NoUsarApagadoException Si el motor esta apagado.
     * @throws AcelerarMasException Si se supera la velocidad maxima.
     */
    public String acelerar(int incremento) throws NoUsarApagadoException, AcelerarMasException {
        StringBuilder mensaje = new StringBuilder();

        if (accidentado) {
            mensaje.append("El vehiculo esta accidentado y no puede acelerar.");
            return mensaje.toString();
        }

        if (!motor.estaEncendido()) {
            throw new NoUsarApagadoException();
        }

        int nuevaVelocidad = velocidadActual + incremento;
        if (nuevaVelocidad > motor.getVelocidadMaxima()) {
            accidentado = true;
            velocidadActual = 0;
            try {
                motor.apagar();
            } catch (IllegalStateException ignored) {
                // Ignorar
            }
            throw new AcelerarMasException();
        }

        velocidadActual = nuevaVelocidad;
        mensaje.append("Acelerando: ").append(incremento)
               .append(" km/h. Velocidad actual: ").append(velocidadActual).append(" km/h.");

        if (incremento > 30) {
            mensaje.append(" Aceleracion brusca detectada.");
        }

        return mensaje.toString();
    }

    /**
     * Frena el vehiculo reduciendo la velocidad actual.
     * Lanza excepciones si se intenta frenar estando detenido, 
     * si se frena mas de lo que se puede, o si el frenado es brusco
     * y excede el limite de las llantas.
     * 
     * @param decremento Cantidad de km/h a disminuir.
     * @return Mensaje con el resultado del frenado.
     * @throws NoUsarApagadoException Si el motor esta apagado.
     * @throws FrenarDetenidoException Si ya esta detenido.
     * @throws FrenarMasException Si se intenta frenar mas de la velocidad actual.
     * @throws FrenarBruscamenteException Si el frenado brusco excede limites de seguridad.
     */
    public String frenar(int decremento) throws NoUsarApagadoException, FrenarDetenidoException, FrenarMasException, FrenarBruscamenteException {
        if (accidentado) {
            return "El vehiculo esta accidentado y no puede frenar.";
        }

        if (!motor.estaEncendido()) {
            throw new NoUsarApagadoException();
        }

        if (velocidadActual == 0) {
            throw new FrenarDetenidoException();
        }

        boolean frenaBruscamente = decremento > 30;
        boolean excedeLimiteLlanta = velocidadActual > llanta.getLimiteVelocidad();

        if (decremento > velocidadActual) {
            patinando = true;
            throw new FrenarMasException();
        }

        if (frenaBruscamente && excedeLimiteLlanta) {
            patinando = true;
            throw new FrenarBruscamenteException();
        }

        velocidadActual -= decremento;

        StringBuilder mensaje = new StringBuilder();
        mensaje.append("Frenando: ").append(decremento)
               .append(" km/h. Velocidad actual: ").append(velocidadActual).append(" km/h");

        if (frenaBruscamente) {
            mensaje.append("\nFrenado brusco detectado");
        }

        if (velocidadActual == 0) {
            patinando = false;
            mensaje.append("\nVehiculo detenido completamente");
        }

        return mensaje.toString();
    }

    /**
     * Metodo simplificado para frenar bruscamente.
     * Actualmente esta mal implementado: no valida correctamente el decremento.
     * Siempre devuelve el mismo mensaje si el decremento es mayor a 30.
     * 
     * @param decremento Valor de frenado
     * @return Texto indicando frenado brusco
     * @throws NoUsarApagadoException
     * @throws FrenarDetenidoException
     * @throws FrenarMasException
     * @throws FrenarBruscamenteException
     */
    public String frenarBruscamente(int decremento) throws NoUsarApagadoException, FrenarDetenidoException, FrenarMasException, FrenarBruscamenteException {
        if (decremento > 30) {
            return "freno bruscamente";
        }
        return "frenado no es suficientemente brusco";
    }

    // METODOS DE ACCESO

    /**
     * Devuelve la velocidad actual del vehiculo.
     * 
     * @return Velocidad en km/h.
     */
    public int getVelocidadActual() {
        return velocidadActual;
    }

    /**
     * Establece la velocidad actual del vehiculo.
     * 
     * @param velocidadActual Nueva velocidad en km/h.
     */
    public void setVelocidadActual(int velocidadActual) {
        this.velocidadActual = velocidadActual;
    }

    /**
     * Indica si el motor esta encendido.
     * 
     * @return true si esta encendido, false si no.
     */
    public boolean estaEncendido() {
        return motor.estaEncendido();
    }

    /**
     * Indica si el vehiculo esta accidentado.
     * 
     * @return true si tuvo un accidente, false si no.
     */
    public boolean estaAccidentado() {
        return accidentado;
    }

    /**
     * Indica si el vehiculo esta patinando.
     * 
     * @return true si esta patinando, false si no.
     */
    public boolean estaPatinando() {
        return patinando;
    }

    /**
     * Devuelve el motor que tiene el vehiculo.
     * 
     * @return Objeto Motor.
     */
    public Motor getMotor() {
        return motor;
    }

    /**
     * Devuelve la llanta que tiene el vehiculo.
     * 
     * @return Objeto Llanta.
     */
    public Llanta getLlanta() {
        return llanta;
    }

    /**
     * Devuelve una representacion del estado del vehiculo,
     * incluyendo si esta encendido, su velocidad, y si esta accidentado o patinando.
     * 
     * @return Cadena con el estado del vehiculo.
     */
    public String getEstado() {
        StringBuilder estado = new StringBuilder();
        estado.append("Estado del vehiculo:\n");
        estado.append("- Encendido: ").append(motor.estaEncendido() ? "Si" : "No").append("\n");
        estado.append("- Velocidad actual: ").append(velocidadActual).append(" km/h\n");
        estado.append("- Accidentado: ").append(accidentado ? "Si" : "No").append("\n");
        estado.append("- Patinando: ").append(patinando ? "Si" : "No").append("\n");
        return estado.toString();
    }
}
