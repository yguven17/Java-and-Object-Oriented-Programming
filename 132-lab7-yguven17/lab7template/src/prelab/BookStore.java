package prelab;

public class BookStore {

	public static void main(String[] args) {
		boolean continueLoop = true;
		do {
			try {
				BookStoreClerk clerk = new BookStoreClerk();

				Book tempBook = clerk.readAndValidateBook();

				System.out.println(tempBook.toString());

				System.out.println("BookStore Registration Program ended");
				continueLoop = false;
			} catch (NumberFormatException numberFormatException) {
				System.out.printf("Cannot create the book instance!%n");
				System.err.println(numberFormatException);
				System.out.printf("Please modify the input yearPublished argument%n%n");
			}

			catch (IllegalArgumentException illegalArgumentException) {
				System.out.printf("Cannot create the book instance!%n");
				System.err.println(illegalArgumentException);
				System.out.printf("Please modify the input arguments%n%n");
			}

		} while (continueLoop);
	}
}
