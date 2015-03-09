package reinas.practica6.pai;

/**
 * 	@author Sabato Ceruso
 *	mail: sab7093@gmail.com
 *  asignatura: Programación de aplicaciones interactivas.
 *  Universidad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.util.Calendar;

public class Clock {
	
	private long startTime;
	private long stopTime;
	private boolean started;
	
	public Clock() {
		started = false;
		startTime = 0;
		stopTime = 0;
	}
	/**
	 * Inicia el reloj.
	 */
	public void start() {
		if (!started) {
			startTime = System.nanoTime();
			started = true;
			stopTime = startTime;
		}
	}
	/**
	 * Para el reloj.
	 */
	public void stop() {
		if (started) {
			started = false;
			stopTime = System.nanoTime();
		}
	}
	/**
	 * 
	 * @return devuelve la diferencia de tiempo entre el inicio y la parada. Si no se ha parado es la diferencia
	 * entre el tiempo de inicio y el actual.
	 */
	public long  elapsedTime() {
		if (!started)
			return stopTime - startTime;
		else 
			return System.nanoTime() - startTime;
	}
	
}