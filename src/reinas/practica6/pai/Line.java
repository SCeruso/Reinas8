package reinas.practica6.pai;

import java.awt.Point;

/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */

public class Line {
	private double pendiente;
	private double ordenadaEnElOrigen;
	
	/**
	 * Crea una recta.
	 * @param nuevaPendiente pendiente de la recta.
 	 * @param nuevaOrdenadaEnElOrigen ordenada en el origen de la recta.
	 */
	public Line(double nuevaPendiente, double nuevaOrdenadaEnElOrigen) {
		pendiente = nuevaPendiente;
		ordenadaEnElOrigen = nuevaOrdenadaEnElOrigen;
	}
	/**
	 * Crea una recta que pasa por "x" y por "y"
	 * @param x Primer punto.
	 * @param y Segundo punto.
	 */
	public Line (Point x, Point y) throws IllegalArgumentException {
		if (x.x == y.x)
			throw new IllegalArgumentException("No se puede formar una recta a partir de dos puntos iguales!");
		pendiente = ((double)(x.y - y.y)) / ((double)(x.x - y.x));
		ordenadaEnElOrigen = x.y - x.x * pendiente;
	}
	/**
	 * Evalua la recta para un determinado valor de "x", si el resultado de "y" no es un valor entero
	 * devuelve null.
	 * @return Punto para el valor de la variable independiente = "x"
	 * 			cuando la "y" es entera, null en otro caso.  
	 */ 
	public Point integerEvaluation(int x) {
		double y = x * getPendiente() + getOrdenadaEnElOrigen();
		
		if ((int)y == y) 	
			return new Point(x, (int)y);
		
		return null;
	}
	public double getPendiente() {
		return pendiente;
	}
	public double getOrdenadaEnElOrigen() {
		return ordenadaEnElOrigen;
	}
	
}
