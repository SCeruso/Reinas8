package reinas.practica6.pai;

import javax.swing.JFrame;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ChessBoard tablero = new ChessBoard();
		
		//tablero.addCriterion(new ClassicalCriterion());
		//tablero.addCriterion(new NewCriterion());
		
		/*tablero.addQueen(new Point(2, 2));
		tablero.addQueen(new Point(1,0));
		tablero.addQueen(new Point(0, 3));
		tablero.addQueen(new Point(4, 5));
		tablero.addQueen(new Point(3, 7));*/
		//System.out.println(tablero);
		
		 GraphicSolutions frame = new GraphicSolutions();
		    frame.setTitle("8 Reinas");
		    frame.setSize(500, 500);
		    frame.setLocationRelativeTo(null); // Center the frame
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setVisible(true);
		    
	}

}
