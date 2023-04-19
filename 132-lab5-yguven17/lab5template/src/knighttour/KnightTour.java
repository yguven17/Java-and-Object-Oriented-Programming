package knighttour;

import knight.HeuristicKnight;
import knight.Knight;
import knight.RandomKnight;

public class KnightTour {

	protected Board board = new Board();
	protected Knight knight;

	public KnightTour() {
		this(8, "regular");
	}

	public KnightTour(int boardSize, String knightType) {

		switch (knightType) {
		case "regular":
			knight = new Knight(board);
			break;
		case "heuristic":
			knight = new HeuristicKnight(board);
			break;
		case "random":
			knight = new RandomKnight(board);
			break;
		default:
			knight = new Knight(board);
		}

	}

	public void tour() {

		singleTour();
	}

	public void printResult() {
		System.out.printf("The tour ended with %d moves.\n", board.getMoveCount());
		if (board.getMoveCount() == board.getSize()) {
			System.out.printf("This was a full tour.\n");
		} else {
			System.out.printf("This was a not full tour.\n");
		}
		board.printBoard();
	}

	protected int singleTour() {
		while (!board.isFull()) {
			knight.makeMove();
		}
		return board.getMoveCount();
	}
}
