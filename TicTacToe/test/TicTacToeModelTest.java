package test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import src.TicTacToeModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicTacToeModelTest {
	private TicTacToeModel model;
	private String[][] board;
	
	@BeforeEach
	void setUp() throws Exception {
		model = new TicTacToeModel();
		board = new String[TicTacToeModel.getNumRows()][TicTacToeModel.getNumColumns()];
		initializeBoard("");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	public void initializeBoard(String symbol) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = symbol;
			}
		}
	}
	
	public void setBoard(boolean O) {
		if(O) model.setState(TicTacToeModel.gameStatus.O_TURN);
		model.setBoard(board);
		model.checkWin();
	}
	
	public void checkXWins() {
		
	}
	
	@Test
	void testConstructor() {
		assertNotNull(model);
	}
	
	@Test 
	void testGetGameboard() {
		assertNotNull(model.getBoard());
		assertTrue(model.getBoard()[0][0].equals(""));
	}
	
	@Test 
	void testAddListener() {
		ListenerExample e = new ListenerExample();
		model.addListener(e);
		assertTrue(model.getListeners().size() == 1);
	}
	
	@Test
	void testGetListener() {
		assertNotNull(model.getListeners());
	}
	
	@Test
	void testGetState() {
		assertEquals(model.getState(), TicTacToeModel.gameStatus.X_TURN);
	}
	
	@Test 
	void testSetState() {
		model.setState(TicTacToeModel.gameStatus.TIE);
		assertEquals(model.getState(), TicTacToeModel.gameStatus.TIE);
	}
	
	@Test 
	void testGetNumRows() {
		assertEquals(TicTacToeModel.getNumRows(), 3);
	}
	
	@Test 
	void testGetNumColumns() {
		assertEquals(TicTacToeModel.getNumColumns(), 3);
	}

	@Test 
	void testGetNumToWin() {
		assertEquals(TicTacToeModel.getNumToWin(), 3);
	}
	
	@Test
	void testTakeTurn() {
		model.takeTurn(new Point(0,0));
		assertTrue(model.getBoard()[0][0].equals("X"));
		assertTrue(model.getState().equals(TicTacToeModel.gameStatus.O_TURN));
	}
	
	@Test
	void testXWinsRow() {
		board[0][0] = "X";
		board[1][0] = "X";
		board[2][0] = "X";
		setBoard(false);
		assertTrue(model.getState().equals(TicTacToeModel.gameStatus.X_WON));
	}
	
	@Test
	void testOWinsRow() {
		board[0][1] = "O";
		board[1][1] = "O";
		board[2][1] = "O";
		setBoard(true);
		assertTrue(model.getState().equals(TicTacToeModel.gameStatus.O_WON));
	}
	
	@Test
	void testXWinsColumn() {
		board[0][0] = "X";
		board[0][1] = "X";
		board[0][2] = "X";
		setBoard(false);
		assertTrue(model.getState().equals(TicTacToeModel.gameStatus.X_WON));
	}
	
	@Test 
	void testOWinsColum() {
		board[2][0] = "O";
		board[2][1] = "O";
		board[2][2] = "O";
		setBoard(true);
		assertTrue(model.getState().equals(TicTacToeModel.gameStatus.O_WON));
	}
	
	@Test
	void testXWinsRDiagonal() {
		board[0][2] = "X";
		board[1][1] = "X";
		board[2][0] = "X";
		setBoard(false);
		assertTrue(model.getState().equals(TicTacToeModel.gameStatus.X_WON));
	}
	
	@Test
	void testOWinsLDiagonal() {
		board[0][0] = "O";
		board[1][1] = "O";
		board[2][2] = "O";
		setBoard(true);
		assertTrue(model.getState().equals(TicTacToeModel.gameStatus.O_WON));
	}
	
	@Test
	void testTie() {
		initializeBoard("E");
		setBoard(false);
		System.out.println(model.toString());
		assertTrue(model.getState().equals(TicTacToeModel.gameStatus.TIE));
	}
}
