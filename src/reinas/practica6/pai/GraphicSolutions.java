package reinas.practica6.pai;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GraphicSolutions extends JFrame implements ActionListener{
	private ArrayList<ChessBoard> solutions;
	private int indx;
	private GraphicBoard BoardPanel;
	private ArrayList<Long> times;
	private TimePanel time;
	
	public GraphicSolutions() {
		time = new TimePanel();
		JPanel bottom = new JPanel();
		JButton botonNext = new JButton("NEXT");
		QueenPositioning problem = new QueenPositioning();
		
		problem.run();
		solutions = problem.getSolutions();
		times = problem.getTimes();
		indx = 0;
		BoardPanel = new GraphicBoard();		
		add(BoardPanel, BorderLayout.CENTER);
		
		bottom.setLayout(new BorderLayout());
		
		botonNext.addActionListener(this);
		
		bottom.add(botonNext, BorderLayout.WEST);
		bottom.add(time, BorderLayout.CENTER);
		
		add(bottom, BorderLayout.SOUTH);
		
		
		

	}
	
	public void nextSolution() {
		if (indx < solutions.size()) {
			BoardPanel.setBoard(solutions.get(indx));
			time.setText(times.get(indx));
			indx++;
		}
		else {
			JOptionPane.showMessageDialog(null, "No hay mas soluciones");
		}
			
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		nextSolution();
	}


}
