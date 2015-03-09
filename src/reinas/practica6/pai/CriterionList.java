package reinas.practica6.pai;

import java.awt.Point;
import java.util.ArrayList;

public class CriterionList {
	private ArrayList<IDisableCriterion> criterions;
	
	public CriterionList() {
		criterions = new ArrayList<IDisableCriterion>();
	}
	
	public void addCriterion(IDisableCriterion criterion)  {
		criterions.add(criterion);
	}
	
	public void applyCriterions(ChessBoard board, Point cell) {
		for (int i = 0; i < criterions.size(); i++) {
			criterions.get(i).disable(board, cell);
		}
	}
}
