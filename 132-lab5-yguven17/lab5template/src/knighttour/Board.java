package knighttour;

public class Board {

	private int[][] chessBoard;
	private int moveCount;
	private int size;

	public Board() {
		this(8);
	}

	public Board(int size) {
		this.size = size;
		this.chessBoard = new int[size][size];
		moveCount = 0;

	}

	public int getMoveCount() {
		return moveCount;
	}

	public int getSize() {
		return size;
	}

	public boolean isValid(int row, int column) {
		if (-1 < row && row < size && -1 < column && column < size && chessBoard[row][column] == 0) {
			return true;
		}
		return false;
	}

	public void clear() {

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {
				chessBoard[i][j] = 0;
			}
		}
		moveCount = 0;
	}

	public void addMove(int row, int column) {
		moveCount++;
		chessBoard[row][column] = moveCount;
	}

	public boolean isFull() {

		if (moveCount == size * size) {
			return true;
		} else {
			return false;
		}
	}

	public void printBoard() {

		System.out.printf("\t");
		for (int i = 0; i < chessBoard.length; i++) {
			System.out.printf("%d\t", i);
		}
		System.out.printf("\n\n");
		for (int i = 0; i < chessBoard.length; i++) {
			System.out.printf("%d\t", i);
			for (int j = 0; j < chessBoard.length; j++) {
				System.out.printf("%d\t", chessBoard[i][j]);
			}
			System.out.printf("\n");
		}
	}
}
