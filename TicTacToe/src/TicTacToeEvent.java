package src;
import java.awt.Point;
import java.util.EventObject;

import src.TicTacToeModel.gameStatus;

public class TicTacToeEvent extends EventObject {
	private Point coordinate;
	
	/**
	 * Object with the necessary information that will be passed on to TicTacToeListeners
	 * @param source - Object that created this event
	 * @param state - state of the game
	 * @param p - coordinate of where the symbol was placed on the board
	 */
	public TicTacToeEvent(TicTacToeModel source, Point p) {
		super(source);
		this.coordinate = p;
	}

	/**
	 * @return the coordinate
	 */
	public Point getCoordinate() {
		return coordinate;
	}

	/**
	 * @return the symbol
	 */
	public TicTacToeModel.gameStatus getState() {
		TicTacToeModel m = (TicTacToeModel)this.getSource();
		return m.getState();
	}
}
