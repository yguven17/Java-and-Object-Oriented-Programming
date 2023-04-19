import java.util.Scanner;

public class Lab1Main {
	private static final int SUM = 15; // for in-lab exercise

	public static void main(String[] args) {
		gameDemo();
		extraDemo();
	}

	public static void gameDemo() {
		// uncomment below to test your Game class
//		 Game game = new Game();
//		 game.play();
		

	}

	public static void extraDemo() {
		// In-lab assignments.
		// add method calls to test your in-lab questions.

		puzzle1();
		puzzle2();

	}

	// add methods for in-lab questions below

	public static void puzzle1() {
		int count = 0;
		for (int i = 1001; i <= 9999; i++) {
			int a = i;
			int b = a / 1000;
			a = a % 1000;
			int c = a / 100;
			a = a % 100;
			int d = a / 10;
			a = a % 10;
			int e = a;
			int sum = b + c + d + e;

			if (e % 2 != 0 && b == 3 * d && sum == SUM && b != c && b != d && b != e && c != d && c != e && d != e) {
				System.out.println(i);
				count++;
			}
		}
		System.out.printf("Number of Solutions %d\n", count);
	}

	public static void puzzle2() {

		int count = 0;
		int count2 = 0;

		for (int i = 1; i <= 9; i += 2) {

			for (int j = 1; j <= 9; j++) {

				if (j == i) {
					continue;
				} else {

					for (int k = 0; k <= 9; k++) {
						if (k == i || k == j) {

							continue;
						} else {
							int l = 3 * j;

							if (l == i || l == k || l > 9) {

								continue;
							} else {

								int sum = i + j + k + l;
								count2++;
								if (sum == SUM) {
									System.out.println(l + "" + k + "" + j + "" + i);
									count++;

								}

							}
						}

					}
				}
			}

		}
		System.out.printf("Number of Solutions %d\n", count);
		System.out.printf("Innermost Loop body is executed %d times. \n", count2);
	}

}
