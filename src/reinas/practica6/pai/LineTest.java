package reinas.practica6.pai;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

public class LineTest {

	/**
	 * Probamos que funcione bien el calculo de recta que pasa por dos puntos.
	 */
	
	@Test
	public void LinePointPoint() {
		Point first = new Point (0, 0);
		Point second = new Point (2, 1);
		Point third = new Point (1, 4);
		Point fourth = new Point (3, 5);
		Line recta1 = new Line(first, second);
		Line recta2 = new Line(second, first);
		Line recta3 = new Line(third, fourth);
		Line recta4 = new Line(fourth, third);
		
		assertEquals(recta1.getPendiente(), 0.5, 0);
		assertEquals(recta1.getOrdenadaEnElOrigen(), 0.0, 0);
		
		assertEquals(recta2.getPendiente(), 0.5, 0);
		assertEquals(recta2.getOrdenadaEnElOrigen(), 0.0, 0);
		
		assertEquals(recta3.getPendiente(), 0.5, 0);
		assertEquals(recta3.getOrdenadaEnElOrigen(), 3.5, 0);
	
		assertEquals(recta4.getPendiente(), 0.5, 0);
		assertEquals(recta4.getOrdenadaEnElOrigen(), 3.5, 0);
	}
	/**
	 * Probamos que la evaluación unicamente con enteros 
	 * para la "y" se haga correctamente.
	 */
	@Test
	public void testIntegerEvaluation() {
		Line recta = new Line(0.5, 3.5);
		Point result;
		
		result = recta.integerEvaluation(2);
		
		assertTrue(result == null);
		
		result = recta.integerEvaluation(1);
		
		assertEquals(result.x, 1);
		assertEquals(result.y, 4);
		
		result = recta.integerEvaluation(3);
		
		assertEquals(result.x, 3);
		assertEquals(result.y, 5);
	}

}
