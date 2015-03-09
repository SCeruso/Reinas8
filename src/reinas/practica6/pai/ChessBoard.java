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
	private CriterionList criterions;
	
	/**
	 * Crea un tablero 8x8 de casillas vacías.
	 * Inicializa el vector con la posicion de las 8 damas.
	 */
	public ChessBoard() {
		board = new State[COLROWNUMBER][COLROWNUMBER];
		queens = new ArrayList<Point>();
		criterions = new CriterionList();
		
		for (int i = 0; i < COLROWNUMBER; i++)
			for (int j = 0; j < COLROWNUMBER; j++)
				board[i][j] = State.EMPTY;
	}
	
	public ChessBoard(ChessBoard other) {
		this.board = new State[COLROWNUMBER][COLROWNUMBER];
		this.queens = new ArrayList<Point>();
		this.criterions = other.criterions;
		
		for (int i = 0; i < COLROWNUMBER; i++)
			for (int j = 0; j < COLROWNUMBER; j++)
				this.board[i][j]= other.board[i][j];
		for (int i = 0; i < other.getQueens().size(); i++)
			this.queens.add(other.getQueens().get(i));
	}
	public State getCellState(Point cell) throws ArrayIndexOutOfBoundsException {
		try {
			return board[cell.x][cell.y];
		}
		catch(ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public ArrayList<Point> getQueens() {
		return queens;
	}

	public void setQueens(ArrayList<Point> queens) {
		this.queens = queens;
	}

	public static int getColrownumber() {
		return COLROWNUMBER;
	}

	public void addCriterion(IDisableCriterion criterion) {
		criterions.addCriterion(criterion);
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
	public void setState(Point cell, State state) throws ArrayIndexOutOfBoundsException{
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
		/*disableRow(cell);
		disableColumn(cell);
		disableDiagonals(cell);
		disableLines(cell);*/
		criterions.applyCriterions(this, cell);
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
