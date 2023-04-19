package knighttour;

public class FullKnightTour extends KnightTour {

	private int[] moveTotals;
	final int MAX_TOUR_ALLOWED = 200000;

	public FullKnightTour(int boardSize, String knightType) {
		super(boardSize, knightType);

		tour();
	}

	@Override
	public void tour() {
		FullTour();

	}

	@Override
	public void printResult() {
		System.out.print("#tours   tour_length\n\n");
		int totalTours = 0;
		for (int row = 0; row < board.getSize() * board.getSize(); row++) {
			System.out.printf("%-10d%-5d\n", moveTotals[row], row + 1);
			totalTours += moveTotals[row];
		}
		System.out.printf("It took %d tries to get a full tour.", totalTours);
	}

	private void FullTour() {

		while (!board.isFull()) {
			board.clear();
			singleTour();
		}

	}

}
