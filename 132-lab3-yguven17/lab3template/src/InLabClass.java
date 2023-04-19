import java.util.Random;

public class InLabClass {
	
	static int currentRow, tempRow;
	static int currentColumn, tempColumn;
	static int moveNumber = 0;
	static int n = 8;
	static int currentNumber;
	static int trialNumbers;

	static int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };
	private static int[][] access =
		{{2, 3, 4, 4, 4, 4, 3, 2},
		{3, 4, 6, 6, 6, 6, 4, 3},
		{4, 6, 8, 8, 8, 8, 6, 4},
		{4, 6, 8, 8, 8, 8, 6, 4},
		{4, 6, 8, 8, 8, 8, 6, 4},
		{4, 6, 8, 8, 8, 8, 6, 4},
		{3, 4, 6, 6, 6, 6, 4, 3},
		{2, 3, 4, 4, 4, 4, 3, 2}};

	public static void inLabProblem(String[] args) {

		int a = Integer.parseInt(args[1]); 
		Random rand = new Random();
		 rand.setSeed(a);
		int n = Integer.parseInt(args[0]);
		currentRow = rand.nextInt(n);
		currentColumn = rand.nextInt(n);
		int chessboard[][] = new int[n][n];
		knightTour4(chessboard, currentRow, currentColumn);

	}

	public static void knightTour4(int[][] chessboard, int currentRow, int currentColumn) {
		
		int counter = 0;

		int tourNumber[] = new int[n * n];

		int tourLenght[] = new int[n * n];
		for (int i = 0; i < n * n; i++) {
			tourLenght[i] = i + 1;
		}


		while (counter<1000) {
			moveNumber= 1;
			Random rand = new Random();
			currentRow = rand.nextInt(n);
			currentColumn = rand.nextInt(n);
			chessboard[currentRow][currentColumn] = 1;

			for (int currentNumber = 0; currentNumber < horizontal.length; currentNumber++) {

				currentRow += vertical[currentNumber];
				currentColumn += horizontal[currentNumber];

				if (isValid(currentRow, currentColumn, chessboard)&&isAccessible( currentRow, currentColumn)) {
					moveNumber++;
					currentNumber--;
					chessboard[currentRow][currentColumn] = moveNumber;
					
				} else {
					currentRow -= vertical[currentNumber];
					currentColumn -= horizontal[currentNumber];
				}
				
			}
			tourNumber[moveNumber - 1] = tourNumber[moveNumber - 1] + 1;

			counter++;
			if (moveNumber == 64) {
				trialNumbers++;
				print3(chessboard,trialNumbers);
			}
			counter++;

		}

		
		System.out.printf("It took %d tries to get a full tour", trialNumbers);
		
	}
	
	public static boolean isValid(int currentRow, int currentColumn, int[][] chessboard) {
		if (currentRow < n && currentRow >= 0 && currentColumn < n && currentColumn >= 0
				&& chessboard[currentRow][currentColumn] == 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isAccessible( int currentRow , int currentColumn) {
		if(getAccess(currentRow,currentColumn)<=getAccess(currentRow,currentColumn)) {
			return false;
		}
		return true;
		
		
	}
	
	public static void print3(int[][] chessboard, int triaNumbers) {
		System.out.printf("Tria no %d .\n", triaNumbers);
		System.out.printf("The tour ended with %d moves.\n", moveNumber);

		System.out.print(" ");
		for (int i = 0; i < n; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.printf("%d", i);
			for (int j = 0; j < n; j++) {
				System.out.printf("%4d", chessboard[i][j]);
			}
			System.out.println();
		}

	}

	public static int getAccess(int row, int column) {
		return access[row][column];
	}

	
}
