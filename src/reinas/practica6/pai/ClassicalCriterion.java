package reinas.practica6.pai;

import java.awt.Point;

public class ClassicalCriterion implements IDisableCriterion{
	public void disable(ChessBoard board, Point cell) {
			disableRow(board, cell);
			disableColumn(board, cell);
			disableDiagonals(board, cell);
	}
	
	/**
	 * Marca como ilegales las filas a las que puede amenazar la dama en cell.
	 * @param cell Posición de la dama.
	 */
	private void disableRow(ChessBoard board, Point cell){
		for (int i = 0; i < ChessBoard.getColrownumber(); i++) 
			board.setState(new Point(i, cell.y), State.DISABLED);	
	}
	/**
	 * Marca como ilegales las columnas a las que puede amenazar la dama en cell.
	 * @param cell Posición de la dama.
	 */
	private void disableColumn(ChessBoard board, Point cell) {
		for (int i = 0; i < ChessBoard.getColrownumber(); i++)
			board.setState(new Point(cell.x, i), State.DISABLED);
	}
	/**
	 * Marca como ilegales las diagonales a las que puede amenazar la dama en cell.
	 * @param cell Posición de la dama.
	 */
	private void disableDiagonals(ChessBoard board, Point cell) {//		Hacer con if-else para mejorar eficiencia??
		for (int i = 0; i < ChessBoard.getColrownumber(); i++) {
			try {
				board.setState(new Point(cell.x - i, cell.y - i), State.DISABLED);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
			try {
				board.setState(new Point(cell.x + i, cell.y + i), State.DISABLED);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
			try {
				board.setState(new Point(cell.x + i, cell.y - i), State.DISABLED);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
			try {
				board.setState(new Point(cell.x - i, cell.y + i), State.DISABLED);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
		}
	}
}
