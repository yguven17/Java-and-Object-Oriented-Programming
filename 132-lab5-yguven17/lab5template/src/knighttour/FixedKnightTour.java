package knighttour;

public class FixedKnightTour extends KnightTour {

	private int[] moveTotals;
	private static final int NUMBER_OF_TOURS = 1000;

	int boardSize;

	public FixedKnightTour(int boardSize, String knightType) {
		super(boardSize, knightType);

		this.boardSize = boardSize;
	}

	@Override
	public void tour() {
		fixedTour();
	}

	@Override
	public void printResult() {
		System.out.print("#tours   tour_length\n\n");
		int totalTours = 0;
		for (int row = 0; row < boardSize * boardSize; row++) {
			System.out.printf("%-10d%-5d\n", moveTotals[row], row + 1);
			totalTours += moveTotals[row];
		}
		System.out.printf("Total number of tours: %d", totalTours);
	}

	private void fixedTour() {

		board.clear();
		for (int i = 0; i < NUMBER_OF_TOURS; i++) {
			moveTotals[singleTour()]++;

		}
	}
}
