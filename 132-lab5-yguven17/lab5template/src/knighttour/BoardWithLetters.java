package knighttour;

import java.util.Random;

public class BoardWithLetters extends Board {

	private char[][] letterBoards;
	private String comp = "COMP";
	static final Random random = new Random();
	private int moveCount;

	public BoardWithLetters(int size) {
		super(size);

		for (int i = 0; i < letterBoards.length; i++) {
			for (int j = 0; j < letterBoards[i].length; j++) {
				int x = random.nextInt(comp.length());
				letterBoards[i][j] = comp.charAt(x);
			}

		}
		printLetterBoard();
	}

	private void printLetterBoard() {

		System.out.printf("\t");
		for (int i = 0; i < letterBoards.length; i++) {
			System.out.printf("%d\t", i);
		}
		System.out.printf("\n\n");
		for (int i = 0; i < letterBoards.length; i++) {
			System.out.printf("%d\t", i);
			for (int j = 0; j < letterBoards.length; j++) {
				System.out.printf("%d\t", letterBoards[i][j]);
			}
			System.out.printf("\n");
		}
	}

	private boolean checkCOMP(int row, int column) {

		if(toString().equals(letterBoards.toString())) {
			
		}
		return false;

	}

	public void addMove(int row, int column) {

		if (-1 < row && row < letterBoards.length && -1 < column && column < letterBoards.length  && letterBoards[row][column] == 0) {
			
		}
	}


}
