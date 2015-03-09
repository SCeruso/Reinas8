package reinas.practica6.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;

public class QueenPositioning {
	private ChessBoard board;
	private ArrayList<ChessBoard> solutions;
	private ArrayList<Long> times;
	private Clock temporizador;
	
	public QueenPositioning() {
		board = new ChessBoard();
		board.addCriterion(new ClassicalCriterion()); 
		board.addCriterion(new NewCriterion());
		solutions = new ArrayList<ChessBoard>();
		times = new ArrayList<Long>();
		temporizador = new Clock();
	}
	
	public void run() {
		temporizador.start();
		positionNext(board);
	}

	public void positionNext(ChessBoard incompletedBoard) {
		ChessBoard newBoard;
		
		if (incompletedBoard.getQueens().size() == 8) {
			solutions.add(incompletedBoard);
			times.add(temporizador.elapsedTime());
		}
		else {
			for (int i = 0; i < ChessBoard.getColrownumber(); i++) {
				try {
					newBoard = new ChessBoard(incompletedBoard);
					newBoard.addQueen(new Point(incompletedBoard.getQueens().size(), i));
					positionNext(newBoard);
				}
				catch (IllegalArgumentException e) {
					;
				}
			
			}
			
			
		}
	}
	public ArrayList<ChessBoard> getSolutions() {
		return solutions;
	}
	public ArrayList<Long> getTimes() {
		return times;
	}
}
