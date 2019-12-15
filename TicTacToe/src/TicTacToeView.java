package src;
import java.awt.GridLayout;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TicTacToeView extends JFrame implements TicTacToeListener {
	private TicTacToeButton buttons[][];
	private JPanel panel;
	private GridLayout g;
	private int rows;
	private int cols;
	
	/**
	 * Create the GUI for the game and adds each button as a listener to the model
	 * @param model
	 */
	public TicTacToeView(TicTacToeModel model) {
		model.addListener(this);
		rows = TicTacToeModel.getNumRows();
		cols = TicTacToeModel.getNumColumns();
		buttons = new TicTacToeButton[rows][cols];
		g = new GridLayout(rows, cols, 0, 0);
		this.panel = new JPanel();
		panel.setLayout(g);
		for(int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				buttons[j][i] = new TicTacToeButton(new Point(i,j));
				panel.add(buttons[j][i]);
			}
		}
		
		this.add(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(800, 800);
		this.setVisible(true);
	}

	@Override
	/**
	 * Update the GUI whenever there is an update in the game
	 */
	public void handleEvent(TicTacToeEvent e) {
		switch(e.getState()) {
		case X_TURN:
			placeToken("X", e);
			break;
		case O_TURN:
			placeToken("O", e);
			break;
		case X_WON:
			placeToken("X", e);
			win("X won!");
			break;
		case O_WON:
			placeToken("O", e);
			win("O won!");
			break;
		case TIE:
			win("There was a tie :/");
			break;
		default:
			break;
		}
	}
	
	private void placeToken(String symbol, TicTacToeEvent e) {
		buttons[e.getCoordinate().y][e.getCoordinate().x].setText(symbol);
	}

	/**
	 * Close the screen and show which player won
	 */
	private void win(String e) {
		panel.removeAll();
		JOptionPane.showMessageDialog(null, e);
		SwingUtilities.getWindowAncestor(panel).dispose();
	}

	/**
	 * @return the buttons
	 */
	public TicTacToeButton[][] getButtons() {
		return buttons;
	}
	
	/**
	 * Display an error message - used for illegal moves
	 */
	public void displayError() {
		JOptionPane.showMessageDialog(null, "Sorry! That space is taken!");
	}
}
