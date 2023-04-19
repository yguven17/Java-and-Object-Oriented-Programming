import java.util.Scanner;

public class Game {
	
	public void play() {
		Scanner input = new Scanner(System.in);

		System.out.printf("Enter number of cards:");
		int numberOfCards = input.nextInt();

		Computer computer = new Computer();
		computer.setNumber(numberOfCards);

		int mode = 0;

		while (true) {
			System.out.printf("Enter 0 if the computer plays in stupid mode, 1 for smart mode:");
			mode = input.nextInt();

			switch (mode) {

			case 1:
				System.out.printf("Computer is playing in smart mode\n");
				break;
			case 0:
				System.out.printf("Computer is playing in stupit mode\n");
				break;
			default:
				System.out.printf("Please enter valid integer\n");
				break;
			}
			if (mode == 1 || mode == 0) {
				break;
			}
		}

		int starter = 0;

		while (true) {
			System.out.printf("Enter 0 if the human stars,  1 if computer starts:");
			int start = input.nextInt();

			switch (start) {

			case 1:
				System.out.printf("Computer starts.\n");
				starter = 1;
				break;
			case 0:
				System.out.printf("Human starts.\n");
				starter = 0;
				break;
			default:
				System.out.printf("Please enter valid integer\n");
				break;
			}
			if (start == 1 || start == 0) {
				break;
			}
		}

		while (true) {
			System.out.printf("There are %d cards left.\n", computer.getNumber());

			if (starter == 1) {
				int removedCards = computer.numberGenerator(mode);
				computer.setNumber(computer.getNumber() - removedCards);
				System.out.printf("Computer removed %d cards.\n", computer.removedCards);

				if (computer.getNumber() == 1) {
					System.out.println("Computer Wins.");
					break;
				}
			} else {

				int temp;
				while (true) {
					System.out.printf("Your turn.  How many you want to remove:");
					temp = input.nextInt();
					if (temp >= computer.getNumber()) {
						System.out.printf("Please enter valid integer.\n");
					} else {
						break;
					}
				}

				computer.setNumber(computer.getNumber() - temp);
				if (computer.getNumber() == 1) {
					System.out.println("Human Wins.");
					break;
				}
			}
			switch (starter) {
			case 0:
				starter = 1;
				break;
			case 1:
				starter = 0;
				break;
			}

		}
	}

}