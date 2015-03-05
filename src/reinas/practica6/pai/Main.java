package reinas.practica6.pai;

import java.awt.Point;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChessBoard tablero = new ChessBoard();
		
		tablero.addQueen(new Point(2, 2));
		tablero.addQueen(new Point(1,0));
		tablero.addQueen(new Point(0, 3));
		tablero.addQueen(new Point(4, 5));
		tablero.addQueen(new Point(3, 7));
		System.out.println(tablero);

	}

}
