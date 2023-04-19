package knight;

import java.util.Random;

import knighttour.Board;

public class Knight {

	protected int currentRow;
	protected int currentColumn;
	protected Board board;

	static final int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static final int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static final Random random = new Random();

	public Knight(Board board) {
		this.board = board;
		currentRow = random.nextInt(board.getSize());
		currentColumn = random.nextInt(board.getSize());

		board.addMove(currentRow, currentColumn);

	}

	public void reset() {
		board.clear();
		currentRow = random.nextInt(board.getSize());
		currentColumn = random.nextInt(board.getSize());

		board.addMove(currentRow, currentColumn);
	}

	public boolean makeMove() {
		for (int i = 0; i < horizontal.length; i++) {
			if (board.isValid(currentRow + vertical[i], currentColumn + horizontal[i])) {
				board.addMove(currentRow, currentColumn);
				return true;
			}
		}
		return false;
	}

}
