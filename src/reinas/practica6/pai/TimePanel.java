package reinas.practica6.pai;

import java.awt.Graphics;

import javax.swing.JPanel;

public class TimePanel extends JPanel{
	private String labeltext;
	
	public TimePanel() {
		labeltext = "";
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString(labeltext, getWidth() / 2, getHeight() / 2);
	}
	
	public void setText(Long time) {
		labeltext = "Tiempo: " + (time / 1000);
		repaint();
	}

}
