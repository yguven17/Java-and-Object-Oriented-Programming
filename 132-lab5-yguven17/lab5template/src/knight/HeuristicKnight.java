package knight;

import knighttour.Board;

public class HeuristicKnight extends Knight {

	int[][] access = { { 2, 3, 4, 4, 4, 4, 3, 2 }, { 3, 4, 6, 6, 6, 6, 4, 3 }, { 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 4, 6, 8, 8, 8, 8, 6, 4 }, { 4, 6, 8, 8, 8, 8, 6, 4 }, { 4, 6, 8, 8, 8, 8, 6, 4 },
			{ 3, 4, 6, 6, 6, 6, 4, 3 }, { 2, 3, 4, 4, 4, 4, 3, 2 } };

	public HeuristicKnight(Board board) {
		super(board);

		boolean done = false;
		int minRow = -1;
		int minColumn = -1;
		int accessNumber;
		while (!done) {
			accessNumber = 99;

			for (int moveType = 0; moveType < 8; moveType++) {

				int testRow = currentRow + vertical[moveType];
				int testColumn = currentColumn + horizontal[moveType];

				if (board.isValid(testRow, testColumn)) {

					if (access[testRow][testColumn] < accessNumber) {

						accessNumber = access[testRow][testColumn];

						minRow = testRow;
						minColumn = testColumn;
					}

					--access[testRow][testColumn];
				}
			}

			if (accessNumber == 99) {
				done = true;
			} else {
				currentRow = minRow;
				currentColumn = minColumn;
				board.addMove(currentRow, currentColumn);
			}
		}

	}

	@Override
	public void reset() {
		board.clear();
		currentRow = random.nextInt(board.getSize());
		currentColumn = random.nextInt(board.getSize());

		board.addMove(currentRow, currentColumn);
	}

	@Override
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
