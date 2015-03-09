package reinas.practica6.pai;

import java.awt.Point;

public class NewCriterion implements IDisableCriterion{
	public void disable(ChessBoard board, Point cell) {
		disableLines(board, cell);
	}

	/**
	 * Marca como ilegales las lineas que traza la dama en cell con las demás damas.
	 * @param cell Posición de la dama.
	 */
	private void disableLines(ChessBoard board, Point cell) {
		Line recta;
		Point toDisable;
		
		for (int i = 0; i < board.getQueens().size(); i++){
			if (cell != board.getQueens().get(i))
				recta = new Line(cell, board.getQueens().get(i));
			else
				continue;
			for (int j = 0; j < ChessBoard.getColrownumber(); j++)
				if ((toDisable = recta.integerEvaluation(j)) != null)
					if ((toDisable.y < 8 && toDisable.y >= 0))
						if (board.getCellState(toDisable) == State.EMPTY)
							board.setState(toDisable, State.DISABLED);					
		}
	}
}
