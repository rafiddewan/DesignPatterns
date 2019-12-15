package src;
import java.awt.Point;
import javax.swing.JButton;

public class TicTacToeButton extends JButton{
	private Point coordinate;
	
	/**
	 * Create a JButton with its cooordinate in a grid saved
	 * @param p
	 */
	public TicTacToeButton(Point p) {
		this.coordinate = p;
	}

	/**
	 * @return the coordinate
	 */
	public Point getCoordinate() {
		return coordinate;
	}
	
}
