package reinas.practica6.pai;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GraphicBoard extends JPanel{
	private ChessBoard board;
	public  int IMAGESIZE;
	
	public GraphicBoard() {
		board = new ChessBoard();
		setLayout(new GridLayout(ChessBoard.getColrownumber(), ChessBoard.getColrownumber()));
	}
	 
	public void setBoard(ChessBoard newBoard) {
		board = newBoard;
		setLayout(new GridLayout(ChessBoard.getColrownumber(), ChessBoard.getColrownumber()));
		repaint();
	}

	protected void paintComponent(Graphics g) {
		IMAGESIZE = Math.min(this.getWidth(), this.getHeight()) / 8;
		super.paintComponent(g);
		for (int i = 0; i < ChessBoard.getColrownumber(); i++)  {
			for (int j = 0; j < ChessBoard.getColrownumber(); j++) {
				if (((i + j) % 2) == 0) {
					if (board.getCellState(new Point(i, j)) != State.QUEEN) 
						g.drawImage((new ImageIcon("resources/casillaBlanca.png")).getImage(), i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
					else 
						g.drawImage((new ImageIcon("resources/damaBlanco.png")).getImage(), i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
					
				}
				else {
					if (board.getCellState(new Point(i, j)) != State.QUEEN) 
						g.drawImage((new ImageIcon("resources/casillaNegra.png")).getImage(), i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
					else 
						g.drawImage((new ImageIcon("resources/damaNegro.png")).getImage(), i * IMAGESIZE, j * IMAGESIZE, IMAGESIZE, IMAGESIZE, this);
				}
							
			}
		}
	}
}
