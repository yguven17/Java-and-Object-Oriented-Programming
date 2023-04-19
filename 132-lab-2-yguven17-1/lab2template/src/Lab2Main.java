
public class Lab2Main {

	// This is the lab2 driver class
	// main method makes necessary calls for problems that you need to solve
	// comment out the part that you want work

	public static void main(String[] args) {

		// prelab(); // uncomment for testing before lab
		// inlabCardDeck(); // uncomment for testing in lab
		 inlabArrays(); // uncomment for testing in lab

	}

	// PART1 prelab DeckOfCards problems
	private static void prelab() {

		/*
		 * PART1 COMMENT BLOCK - REMOVE THE COMMENT BLOCK TO TEST prelab
		 */
		System.out.printf("Number of Card instances should be zero: %d%n", Card.getCardCount());
		DeckOfCards myDeckOfCards = new DeckOfCards();

		myDeckOfCards.printDeck();

		System.out.printf("Number of Card instances should be 52 now: %d%n", Card.getCardCount());

		System.out.printf("Is the first five cards is a flush? %b%n", myDeckOfCards.isFlush(0));

		// shuffle cards
		myDeckOfCards.shuffle();
		myDeckOfCards.printDeck();

		System.out.printf("Is the first five cards is a flush? %b%n", myDeckOfCards.isFlush(0));

		/*****************
		 * 
		 * END OF PRELAB PART1 COMMENT BLOCK
		 */

	}

	// NOTE THE FOLLOWING TESTS WILL BE RUN AFTER INLAB PROBLEMS SOLVED
	// NOW THEY ARE COMMENTED OUT

	// PART2 inlab DeckOfCards problem tests
	private static void inlabCardDeck() {

		/*
		 * REMOVE PART2 COMMENT BLOCK DURING THE LAB
		 */

		// Create a new Deck
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.printDeck();

		// get a shuffled Card array, DeckOfCards still not shuffled
		Card[] cardArray = myDeckOfCards.shuffle2();
		myDeckOfCards.printDeck(cardArray);

		// This must be true, myDeckOfCards not shuffled yet
		System.out.println(myDeckOfCards.isFlush(0));

		// This is probably false, newDeck is shuffled
		System.out.println(myDeckOfCards.isFlush(cardArray, 0));
		// get a hand from the unshuffled one
		Card[] hand = myDeckOfCards.deal5();

		// This should be true
		System.out.println(myDeckOfCards.isFlush(hand));

		System.out.printf("Number of Card instances should be still 52: %d%n", Card.getCardCount());

		DeckOfCards secondDeckOfCards = new DeckOfCards();
		secondDeckOfCards.shuffle();
		hand = secondDeckOfCards.deal5();
		myDeckOfCards.printDeck(hand);

		// This is probably false
		System.out.println(myDeckOfCards.isFlush(hand));

		System.out.printf("Number of Card instances should be 104: %d%n", Card.getCardCount());
		/*****
		 * 
		 * END OF PART2 COMMENT BLOCK
		 */
	}

	// PART3 inlab Array problems tests
	private static void inlabArrays() {

		/*
		 * REMOVE PART3 COMMENT BLOCK DURING THE LAB
		 * 
		 */
		// Part3.1

		int[] arr = { 2, 6, 4, 2, 1, 2, 3, 1 };
		System.out.printf("This should be true: %b%n", isArraySpecial(arr, 0));
		arr[1] = 8;
		System.out.printf("This should be false: %b%n", isArraySpecial(arr, 0));

		// Part 3.2
		char[] pattern1 = { 'E', 'L', 'L', '\0' };

		char[] str = new char[10];

		printStr(pattern1);
		System.out.println();
		System.out.println(lenStr(pattern1));

		insert(str, 'O', 0);
		insert(str, 'L', 0);
		insert(str, 'L', 0);
		insert(str, 'E', 0);
		insert(str, 'H', 0);

		printStr(str);
		System.out.println();

		delete(str, 'E');

		printStr(str);
		System.out.println();

		insert(str, 'E', lenStr(str));

		printStr(str);
		System.out.println();

		/*
		 * END OF PART3 COMMENT BLOCK
		 */

	}

	// ADD methods for PART3 below

	// PART 3.1 recursive method

	// An array of integers is special (for lab2 at least;) if it satisfies:
	// Array arr is special if arr[i] is twice of arr[n-i-1]
	// for all i=0..n-1 (inclusive) where n is the length of the array.
	// An empty array or one element array is also special.
	// Example: 4,2,1,2 4,1,2 are special, 8,2,1,3 not special
	// Write a recursive method that returns if an array is special
	// otherwise returns false.
	// The first call the method is like: isArraySpecial(arr,0)
	// (no loops, no additional arrays)
	public static boolean isArraySpecial(int[] arr, int index) {
		if (index >= arr.length / 2 - 1 && arr[index] == 2 * arr[arr.length - index - 1]) {
			return true;
		}
		if (arr[index] != 2 * arr[arr.length - index - 1]) {
			return false;
		}

		return isArraySpecial(arr, index + 1);
	}

	// PART 3.2 char array methods

	// delete the first occurrence of c from str
	// does nothing if c is not in str
	// modifies array str
	public static void delete(char[] str, char c) {
		int deletedIndex = -1;
		for (int i = 0; i < str.length; i++) {
			if (str[i] == c) {
				deletedIndex = i;
				break;
			}
		}
		if (deletedIndex == -1) {
			return;
		}
		for (int i = deletedIndex; i < str.length - 1; i++) {
			str[i] = str[i + 1];
		}
	}

	// insert c at position index
	// example inserting X at position 2 in "ABCD" results in "ABXCD"
	// inserting X at position 4 in "ACBC" results in "ABCDX"
	// inserting X at position 0 in "" results in "X"
	// if there is no space in the array str
	// or index is greater than length of str, do nothing
	// modifies array str
	public static void insert(char[] str, char c, int index) {
		char temp = str[index];
		for (int i = index; i < str.length - 1; i++) {
			char temp2;
			temp2 = str[i + 1];
			str[i + 1] = temp;
			temp = temp2;

		}
		str[index] = c;

	}

	/////// DO NOT CHANGE BELOW

	// return length of the string str
	public static int lenStr(char[] str) {
		int i;
		for (i = 0; i < str.length && (str[i] != '\0'); i++)
			;
		return i;
	}

	// print the string str
	public static void printStr(char[] str) {
		for (int i = 0; i < str.length && (str[i] != '\0'); i++)
			System.out.print(str[i]);
	}

}
