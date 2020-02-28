/**
 * This class sets up the pack1.Board and allows for the placement of X or O,
 * clears the board, and lays the mechanics for the game of TicTacToe
 */
public class Board implements Constants {

	/**
	 * Array that holds the position of each element for the board
	 */
	private char theBoard[][];
	private int markCount;

	public int getMarkCount() {
		return markCount;
	}
	public void setMarkCount(int markCount) {
		this.markCount = markCount;
	}


	/**
	 * The pack1.Board function creates a 3x3 empty board filling it with empty spaces
	 */
	public Board() {
		markCount = 0;
		theBoard = new char[3][];
		for (int i = 0; i < 3; i++) {
			theBoard[i] = new char[3];
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = Constants.SPACE_CHAR;
		}
	}

	/**
	 * This function returns the character value at the point specified by the row and col
	 * @param row the row of the board
	 * @param col the col of the board
	 * @return the character that is placed at that point
	 */
	public char getMark(int row, int col) {
		return theBoard[row][col];
	}

	/**
	 * Checks if the board is filled up
	 * @return a boolean, True if all 9 spots are full, False if they're not
	 */

	public boolean isFull() {
		return markCount == 9;
	}

	/**
	 * Checks if X won the game
	 * @return true if they did, false if they did not
	 */
	public boolean xWins() {
		if (checkWinner(Constants.LETTER_X) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Checks if O won the game
	 * @return true if they did, false if they did not
	 */
	public boolean oWins() {
		if (checkWinner(Constants.LETTER_O) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Displays the current game board
	 */
	public void display() {
		displayColumnHeaders();
		addHyphens();
		for (int row = 0; row < 3; row++) {
			addSpaces();
			System.out.print("    row " + row + ' ');
			for (int col = 0; col < 3; col++)
				System.out.print("|  " + getMark(row, col) + "  ");
			System.out.println("|");
			addSpaces();
			addHyphens();
		}
	}

	/**
	 * Adds the given mark at the row or col specified
	 * @param row the row to which to place the mark
	 * @param col the col to which to place the mark
	 * @param mark either X or O
	 */
	public void addMark(int row, int col, char mark) {
		
		theBoard[row][col] = mark;
		markCount++;
	}

	/**
	 * Clears the board filling the char spots with spaces and resets the mark count to 0
	 */
	public void clear() {
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				theBoard[i][j] = Constants.SPACE_CHAR;
		markCount = 0;
	}

	/**
	 * Checks to see if the given mark has won
	 * @param mark either X or O
	 * @return 1 if won, 0 if lost
	 */
	int checkWinner(char mark) {
		int row, col;
		int result = 0;

		for (row = 0; result == 0 && row < 3; row++) {
			int row_result = 1;
			for (col = 0; row_result == 1 && col < 3; col++)
				if (theBoard[row][col] != mark)
					row_result = 0;
			if (row_result != 0)
				result = 1;
		}

		
		for (col = 0; result == 0 && col < 3; col++) {
			int col_result = 1;
			for (row = 0; col_result != 0 && row < 3; row++)
				if (theBoard[row][col] != mark)
					col_result = 0;
			if (col_result != 0)
				result = 1;
		}

		if (result == 0) {
			int diag1Result = 1;
			for (row = 0; diag1Result != 0 && row < 3; row++)
				if (theBoard[row][row] != mark)
					diag1Result = 0;
			if (diag1Result != 0)
				result = 1;
		}
		if (result == 0) {
			int diag2Result = 1;
			for (row = 0; diag2Result != 0 && row < 3; row++)
				if (theBoard[row][3 - 1 - row] != mark)
					diag2Result = 0;
			if (diag2Result != 0)
				result = 1;
		}
		return result;
	}

	/**
	 * Creates the column headers with their respective col numbers
	 */
	void displayColumnHeaders() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|col " + j);
		System.out.println();
	}

	/**
	 * Adds the spaces and empty ---- to denote that another row is about to start at the bottom
	 */
	void addHyphens() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("+-----");
		System.out.println("+");
	}

	/**
	 * Adds the empty spaces for the row and fills in the column pillars
	 */
	void addSpaces() {
		System.out.print("          ");
		for (int j = 0; j < 3; j++)
			System.out.print("|     ");
		System.out.println("|");
	}
}
