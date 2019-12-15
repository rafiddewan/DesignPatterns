package src;
import java.awt.Point;
import java.util.ArrayList;


/**
 * @author Aashna Narang
 *
 */
public class TicTacToeModel {
	private String[][] board;
	private ArrayList<TicTacToeListener> listeners;
	private static final int NUM_ROWS = 3;
	private static final int NUM_COLUMNS = 3;
	private static final int NUM_TO_WIN = 3;
	public static enum gameStatus { X_WON, O_WON, TIE, X_TURN, O_TURN};
	private gameStatus state;
	
	/**
	 * TicTacToe holds the gameBoard and state of the game
	 */
	public TicTacToeModel() {
		board = new String[NUM_ROWS][NUM_COLUMNS];
		listeners = new ArrayList<TicTacToeListener>();
		state = gameStatus.X_TURN;
		for(int i = 0; i < NUM_ROWS; i ++) {
			for(int j = 0; j < NUM_COLUMNS; j++) {
				board[j][i] = "";
			}
		}
	}
	
	/**
	 * Add a listener to the model. Will call their handle event method 
	 * whenever model has been updated. 
	 * @param t TicTacToeListener the user would like to add 
	 */
	public void addListener(TicTacToeListener t) {
		listeners.add(t);
	}
	
	
	/**
	 * @return the listeners
	 */
	public ArrayList<TicTacToeListener> getListeners() {
		return listeners;
	}

	/**
	 * The current game board
	 * @return 2d string array of the game board
	 */
	public String[][] getBoard(){
		return board;
	}
	
	/**
	 * The current game board
	 * @return 2d string array of the game board
	 */
	public void setBoard(String[][] board){
		this.board = board;
	}
	
	
	/**
	 * @return the state of the game
	 */
	public gameStatus getState() {
		return state;
	}

	/**
	 * @param state - the state of the game
	 */
	public void setState(gameStatus state) {
		this.state = state;
	}
	
	/**
	 * @return number of rows
	 */
	public static int getNumRows() {
		return NUM_ROWS;
	}

	/**
	 * @return the numColumns
	 */
	public static int getNumColumns() {
		return NUM_COLUMNS;
	}

	/**
	 * @return the number of Xs or Os in order needed to win
	 */
	public static int getNumToWin() {
		return NUM_TO_WIN;
	}

	/**
	 * Take a turn at a specific point. Place an X at the given point
	 * if it is X's turn or place an O for o's turn
	 * @param p
	 * @return
	 */
	public boolean takeTurn(Point p) {
		if(board[p.y][p.x].equals("")) {
			switch(this.state) {
			case X_TURN:
				takeTurnHelper("X", p);
				break;
			case O_TURN:
				takeTurnHelper("O", p);
				break;
			default:
				return false;
			}
			
			return true;
		}
		return false;
	}
	
	/**
	 * Helper function to reduce repeated code. Places the symbol on the board, make necessary updates,
	 * and notify listeners
	 * @param symbol - Symbol that will be placed on the board
	 * @param p - coordinate on the board where the symbol will be placed
	 */
	private void takeTurnHelper(String symbol, Point p) {
		board[p.y][p.x] = symbol;
		notifyViews(p);
		checkWin();
		this.state = symbol.equals("X") ? gameStatus.O_TURN : gameStatus.X_TURN; 
	}
	
	/**
	 * Check if there is a win on the board and update the state
	 */
	public void checkWin() {
		if(this.state.equals(gameStatus.X_TURN)) checkWinHelper("X");
		else if(this.state.equals(gameStatus.O_TURN)) checkWinHelper("O");
	}
	
	/**
	 * Notify listeners of any game updates
	 * @param symbol - symbol that was just placed on the board
	 * @param p - coordinate of where the symbol was placed
	 */
	private void notifyViews(Point p) {
		for(TicTacToeListener t : listeners) {
			t.handleEvent(new TicTacToeEvent(this, p ));
		}
	}
	
	/**
	 * Helper function that calls a method to go through the board and checks if there is a win 
	 * for the given symbol; either X or O
	 * @param symbol Either X or O - check if there is a win for the given symbol
	 */
	private void checkWinHelper(String symbol) {
		if(iterateThroughBoard(symbol)) {
			this.state = symbol.equals("X") ? gameStatus.X_WON : gameStatus.O_WON;
			notifyViews(new Point());
		}
	}
	
	/**
	 * Iterate through the board to find a win for a given symbol
	 * @param symbol - check if there is a win for this symbol, either X or O
	 * @return true if there is a win
	 */
	private boolean iterateThroughBoard(String symbol) {
		// Check for a win in rows and columns or if there is a tie
		int countRow = 0;
		int countCol = 0;
		boolean notTie = false;
		for(int i = 0; i < NUM_ROWS; i++) {
			countRow = 0;
			countCol = 0;
			for(int j = 0; j < NUM_COLUMNS; j++) {
				if(board[i][j].equals(symbol)) countRow++;
				if(board[j][i].equals(symbol)) countCol++;
				if(board[i][j].equals("")) notTie = true;
			}
			if(countRow == NUM_TO_WIN || countCol == NUM_TO_WIN) break;
		}
		
		// Check for diagonals
		int countRDiag = 0; // From 02, 11, 20
		int countLDiag = 0; // From 00, 11, 22
		int x = 0;
		for (int i = 0; i < NUM_ROWS; i++) {
			if(board[i][i].equals(symbol)) countLDiag++;
		}
		for (int i = NUM_ROWS - 1; i >= 0; i--) {
			if(board[x][i].equals(symbol)) countRDiag++;
			x++;
		}
		
		if(!notTie) {
			this.state = gameStatus.TIE;
			notifyViews(new Point());
		}
		
		if(countRow == NUM_TO_WIN || countCol == NUM_TO_WIN || countRDiag == NUM_TO_WIN || countLDiag == NUM_TO_WIN) return true;
		return false;
	}
	
	/**
	 * Print out the game board
	 */
	public String toString() {
		String s = "";
		for (int i = 0; i < NUM_ROWS; i++) {
			s += "----------------\n";
			for (int j = 0; j < NUM_COLUMNS; j++) {
				s += String.format("|%4s", this.board[j][i]);
			}
			s += "|\n";
		}
		s += "----------------\n";
		return s;
	}
	
	/**
	 * Create the model, view, and controller
	 * @param args
	 */
	public static void main(String[] args) {
		TicTacToeModel m = new TicTacToeModel();
		TicTacToeView v = new TicTacToeView(m);
		TicTacToeController c = new TicTacToeController(m,v);
	}
}

