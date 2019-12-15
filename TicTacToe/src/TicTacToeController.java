package src;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TicTacToeController implements ActionListener {
	private TicTacToeModel model; 
	private TicTacToeView view;
	
	/**
	 * The controller takes in user input and calls the model or view accordingly 
	 * @param model - Keeps track of the game board
	 * @param view - The GUI of the game
	 */
	public TicTacToeController(TicTacToeModel model, TicTacToeView view) {
		this.model = model; 
		this.view = view;
		for(JButton[] bts: view.getButtons()) {
			for(JButton b : bts) {
				b.addActionListener(this);
			}
		}
	}

	@Override
	/**
	 * When a button is clicked see if user can take a turn there. 
	 * Display an error if it is an illegal move
	 */
	public void actionPerformed(ActionEvent e) {
		TicTacToeButton j = (TicTacToeButton)e.getSource();
		if(!model.takeTurn(j.getCoordinate())) {
			view.displayError();
		}
	}
}
