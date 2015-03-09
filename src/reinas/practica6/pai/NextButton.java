package reinas.practica6.pai;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class NextButton extends JButton implements MouseListener{

	private GraphicSolutions graphicSolutions;
	
	public NextButton(GraphicSolutions solutions) {
		this.setText("NEXT");
		graphicSolutions = solutions;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.graphicSolutions.nextSolution();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
