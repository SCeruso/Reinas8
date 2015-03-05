package reinas.practica6.pai;

import java.awt.Point;
import java.util.ArrayList;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public class ChessBoard {
	private State[][] board; 
	private ArrayList<Point> queens;
	private static final int COLROWNUMBER = 8;
	
	/**
	 * Crea un tablero 8x8 de casillas vacías.
	 * Inicializa el vector con la posicion de las 8 damas.
	 */
	public ChessBoard() {
		board = new State[8][8];
		queens = new ArrayList<Point>();
		
		for (int i = 0; i < COLROWNUMBER; i++)
			for (int j = 0; j < COLROWNUMBER; j++)
				board[i][j] = State.EMPTY;
	}

	public State getCellState(Point cell) throws ArrayIndexOutOfBoundsException {
		try {
			return board[cell.x][cell.y];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Añade una dama en la posición indicada.
	 * @param cell Posición de la dama.
	 * @throws IllegalArgumentException Si la posición es ilegal, lanza excepción.
	 */
	public void addQueen(Point cell) throws IllegalArgumentException{
		if (getCellState(cell) != State.EMPTY)
			throw new IllegalArgumentException("Posición ilegal para la dama.");
		else {
			queens.add(cell);
			disableCells(cell);
			setState(cell, State.QUEEN);
		}		
	}
	private void setState(Point cell, State state) throws ArrayIndexOutOfBoundsException{
		try {
			this.board[cell.x][cell.y] = state;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	/**
	 * Desabilita las casillas a las que puede amenazar la dama en cell
	 * y las que se encuentran el linea con esta dama y alguna otra. 
	 * @param cell
	 */
	public void disableCells(Point cell) {
		disableRow(cell);
		disableColumn(cell);
		disableDiagonals(cell);
		disableLines(cell);
	}
	
	/**
	 * Marca como ilegales las filas a las que puede amenazar la dama en cell.
	 * @param cell Posición de la dama.
	 */
	private void disableRow(Point cell){
		for (int i = 0; i < COLROWNUMBER; i++) 
			setState(new Point(i, cell.y), State.DISABLED);	
	}
	/**
	 * Marca como ilegales las columnas a las que puede amenazar la dama en cell.
	 * @param cell Posición de la dama.
	 */
	private void disableColumn(Point cell) {
		for (int i = 0; i < COLROWNUMBER; i++)
			setState(new Point(cell.x, i), State.DISABLED);
	}
	/**
	 * Marca como ilegales las diagonales a las que puede amenazar la dama en cell.
	 * @param cell Posición de la dama.
	 */
	private void disableDiagonals(Point cell) {//		Hacer con if-else para mejorar eficiencia??
		for (int i = 0; i < COLROWNUMBER; i++) {
			try {
				setState(new Point(cell.x - i, cell.y - i), State.DISABLED);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
			try {
				setState(new Point(cell.x + i, cell.y + i), State.DISABLED);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
			try {
				setState(new Point(cell.x + i, cell.y - i), State.DISABLED);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
			try {
				setState(new Point(cell.x - i, cell.y + i), State.DISABLED);
			}
			catch (ArrayIndexOutOfBoundsException e) {}
		}
	}
	/**
	 * Marca como ilegales las lineas que traza la dama en cell con las demás damas.
	 * @param cell Posición de la dama.
	 */
	private void disableLines(Point cell) {
		Line recta;
		Point toDisable;
		
		for (int i = 0; i < queens.size(); i++){
			if (cell != queens.get(i))
				recta = new Line(cell, queens.get(i));
			else
				continue;
			for (int j = 0; j < COLROWNUMBER; j++)
				if ((toDisable = recta.integerEvaluation(j)) != null)
					if ((toDisable.y < 8 && toDisable.y >= 0))
						if (getCellState(toDisable) == State.EMPTY)
							setState(toDisable, State.DISABLED);					
		}
	}
	
	public String toString() {
		String result = "";
		
		for (int i = 0; i < COLROWNUMBER; i++)
			result += i + "\t";
		result += "\n";
		for (int i = 0; i < COLROWNUMBER; i++) {
			for (int j = 0; j < COLROWNUMBER; j++) {
				if (getCellState(new Point(i, j)) == State.DISABLED)
					result += "X";
				else if (getCellState(new Point(i, j)) == State.QUEEN) 
					result += "Q";
				else 
					result += ".";
				result += "\t";
			}
			
			result += " " + i + "\n";
		}
		return result;
	}
}
