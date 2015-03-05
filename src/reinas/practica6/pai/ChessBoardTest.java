package reinas.practica6.pai;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.awt.Point;

import org.junit.Test;

public class ChessBoardTest {

	@Test
	public void testGetCellState() {
		ChessBoard board = new ChessBoard();
		
		assertEquals(board.getCellState(new Point(0, 0)), State.EMPTY);
	}
	/**
	 * Probamos que coloca bien las damas, además que debe deshabilitar las casillas
	 * que pueden ser amenazadas por dicha dama y las que están en línea con otras damas.
	 */
	@Test
	public void testAddQueen() {
		ChessBoard board = new ChessBoard();
		
		board.addQueen(new Point(0, 0));
		
		assertEquals(board.getCellState(new Point(0, 0)), State.QUEEN);
		assertEquals(board.getCellState(new Point(0, 1)), State.DISABLED);
		assertEquals(board.getCellState(new Point(1, 0)), State.DISABLED);
		assertEquals(board.getCellState(new Point(1, 1)), State.DISABLED);
		assertEquals(board.getCellState(new Point(1, 2)), State.EMPTY);
	
		board.addQueen(new Point(2, 1));
		
		assertEquals(board.getCellState(new Point(2, 1)), State.QUEEN);
		assertEquals(board.getCellState(new Point(0,0)), State.QUEEN);
		assertEquals(board.getCellState(new Point(2, 3)), State.DISABLED);
		assertEquals(board.getCellState(new Point(3, 2)), State.DISABLED);
		assertEquals(board.getCellState(new Point(2, 2)), State.DISABLED);
		assertEquals(board.getCellState(new Point(3, 2)), State.DISABLED);
		assertEquals(board.getCellState(new Point(4, 2)), State.DISABLED);

		try {
			board.addQueen(new Point(0,0));
			fail("Se esperaba excepsión");
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Posición ilegal para la dama.");
		}
		try {
			board.addQueen(new Point(4,2));
			fail("Se esperaba excepsión");
		}
		catch (IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Posición ilegal para la dama.");
		}
	}

	@Test
	public void testDisableCells() {
		//fail("Not yet implemented");
	}

}
