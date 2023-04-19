package inlab;

import java.util.Scanner;

public class BookStoreClerk {
	
	String name = "";
	String authorName = "";
	int yearPublished = 0;
	// Partitions the single input String into 3 substrings depending 
	// on the occurrences of '-' char and returns a String[] containing 3 elements:
	// First element is the substring from index 0 to first occurrence of '-' character
	// Second element contains the substring from the first occurrence of '-' character to its second
	// Third element contains the substring from the second occurrence of '-' character to the end of the input
	// In case of not finding enough '-' chars (2 in this case) in the input string, should throw Exception.
	private String[] partitionString(String input) throws InvalidBookException {

		String[] splitted = input.split("-");

		if (splitted.length != 3) {
			throw new InvalidBookException(
					"Invalid Input to partitionString method: Could not find seperator character '-'",
					new IllegalArgumentException());
		}

		else {
			if (splitted[1].equals(" ")) {
				throw new InvalidBookException("Input BookInfo is invalid!", new IllegalArgumentException());
			}

			else {
				name = splitted[0];
				authorName = splitted[1];
				yearPublished = Integer.parseInt(splitted[2]);
			}
		}

		return splitted;
	}
	
	// Reads input bookInfo using a ScannerObject
	// Note that bookInfo should be in desired format, as it is explained in Lab Assignment Document
	// First checks whether input book info is blank or null, throws necessary exceptions
	// Then, calls partitionString method to partition input bookInfo into pieces
	// Saves the partitioned pieces into necessary variables
	// Finally, if all necessary info is valid,i.e., bookName, authorName and yearPublished, creates
	// a new book instance and returns it. If even one of them is invalid, throws Exception

	public Book readAndValidateBook() throws InvalidBookException {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter information for book in required format:");
		String input = scanner.nextLine();

		if (input.equals("")) {
			throw new IllegalArgumentException("Input BookInfo is empty!");
		}

		partitionString(input);

		return new Book(name, authorName, yearPublished);
	}
}

