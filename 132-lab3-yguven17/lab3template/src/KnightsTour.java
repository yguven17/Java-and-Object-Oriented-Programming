import java.util.Random;

public class KnightsTour {

	static int currentRow, tempRow;
	static int currentColumn, tempColumn;
	static int moveNumber = 0;
	static int n = 8;
	static int currentNumber;
	static int trialNumbers;

	static int[] horizontal = { 2, 1, -1, -2, -2, -1, 1, 2 };
	static int[] vertical = { -1, -2, -2, -1, 1, 2, 2, 1 };
	

	public static void singleTour(String[] args) {

		
		int a = Integer.parseInt(args[1]); 
		Random rand = new Random();
		rand.setSeed(a);
		int n = Integer.parseInt(args[0]);
		currentRow = rand.nextInt(n);
		currentColumn = rand.nextInt(n);
		int chessboard[][] = new int[n][n];
		chessboard[currentRow][currentColumn] = 1;
		knightTour(chessboard, currentRow, currentColumn, 1);

	}

	public static boolean knightTour(int[][] chessboard, int currentRow, int currentColumn, int first) {

		for (int currentNumber = 0; currentNumber < horizontal.length; currentNumber++) {
			currentRow += vertical[currentNumber];
			currentColumn += horizontal[currentNumber];

			if (isValid(currentRow, currentColumn, chessboard)) {
				moveNumber++;
				currentNumber = -1;
				chessboard[currentRow][currentColumn] = moveNumber;
			} else {
				currentRow -= vertical[currentNumber];
				currentColumn -= horizontal[currentNumber];
			}
		}
		print(chessboard);
		return false;

	}

	public static void print(int[][] chessboard) {
		System.out.printf("The tour ended with %d moves.\n", moveNumber);

		int counter = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (chessboard[i][j] != 0) {
					counter++;
				}
			}
		}
		if (counter == n * n) {
			System.out.printf("This was a full tour.\n");
		} else {
			System.out.printf("This was not a full tour.\n");
		}
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

	public static boolean isValid(int currentRow, int currentColumn, int[][] chessboard) {
		if (currentRow < n && currentRow >= 0 && currentColumn < n && currentColumn >= 0
				&& chessboard[currentRow][currentColumn] == 0) {
			return true;
		}
		return false;
	}

	public static void thousandTours(String[] args) {

		int a = Integer.parseInt(args[1]); 
		Random rand = new Random();
		rand.setSeed(a);
		int n = Integer.parseInt(args[0]);
		currentRow = rand.nextInt(n);
		currentColumn = rand.nextInt(n);
		int chessboard[][] = new int[n][n];
		knightTour2(chessboard, currentRow, currentColumn);
	}

	public static void knightTour2(int[][] chessboard, int currentRow, int currentColumn) {

		
		int counter = 0;
		int tourNumber[] = new int[n * n];

		int tourLenght[] = new int[n * n];
		for (int i = 0; i < n * n; i++) {
			tourLenght[i] = i + 1;
		}
		Random rand = new Random();

		while (counter < 1000) {

			moveNumber= 1;
			
			currentRow = rand.nextInt(n);
			currentColumn = rand.nextInt(n);
			chessboard[currentRow][currentColumn] = 1;
			int temp = rand.nextInt(n);

			for (int move = 0; move < horizontal.length; move++) {

				if(temp == n) {
					temp = 0;
				}

				currentRow += vertical[temp];
				currentColumn += horizontal[temp];

				if (isValid(currentRow, currentColumn, chessboard)) {
					moveNumber++;
					move=-1;
					chessboard[currentRow][currentColumn] = moveNumber;
					temp =0;
					temp = rand.nextInt(n);
				} else {
					currentRow -= vertical[temp];
					currentColumn -= horizontal[temp];
					temp++;
				}
				
			}

			tourNumber[moveNumber - 1] = tourNumber[moveNumber - 1] + 1;

			counter++;
			

		}

		print2(tourNumber, tourLenght);

	}

	public static void print2(int[] tourNumber, int[] tourLenght) {
		System.out.println("#tours   tour length");
		for (int i = 0; i < n * n; i++) {

			System.out.printf("%4d\t%4d", tourNumber[i], tourLenght[i]);
			System.out.println();

		}

	}

	public static void newBoard(int[][] chessboard) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				chessboard[i][j] = 0;
			}
		}

	}

	public static void fullTour(String[] args) {

		int a = Integer.parseInt(args[1]); 
		Random rand = new Random();
		rand.setSeed(a);
		int n = Integer.parseInt(args[0]);
		currentRow = rand.nextInt(n);
		currentColumn = rand.nextInt(n);
		int chessboard[][] = new int[n][n];
		knightTour3(chessboard, currentRow, currentColumn);
	}

	public static void knightTour3(int[][] chessboard, int currentRow, int currentColumn) {

		int counter = 0;

		int tourNumber[] = new int[n * n];

		int tourLenght[] = new int[n * n];
		for (int i = 0; i < n * n; i++) {
			tourLenght[i] = i + 1;
		}


		while (true) {
			moveNumber= 1;
			Random rand = new Random();
			currentRow = rand.nextInt(n);
			currentColumn = rand.nextInt(n);
			chessboard[currentRow][currentColumn] = 1;
			int temp = rand.nextInt(n);

			for (int currentNumber = 0; currentNumber < horizontal.length; currentNumber++) {

				if(temp == n) {
					temp = 0;
				}

				currentRow += vertical[temp];
				currentColumn += horizontal[temp];

				if (isValid(currentRow, currentColumn, chessboard)) {
					moveNumber++;
					temp--;
					chessboard[currentRow][currentColumn] = moveNumber;
					temp =0;
					temp = rand.nextInt(n);
				} else {
					currentRow -= vertical[temp];
					currentColumn -= horizontal[temp];
					temp++;
				}
				
			}
			tourNumber[moveNumber - 1] = tourNumber[moveNumber - 1] + 1;

			counter++;
			if (moveNumber == 64) {
				break;
			}
			counter++;

		}

		print2(tourNumber, tourLenght);
		System.out.printf("It took %d tries to get a full tour", counter);

	}

}
