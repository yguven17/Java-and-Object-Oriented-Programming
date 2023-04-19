package inlab;

public class BookStore {

	public static void main(String[] args) throws Exception {
		boolean continueLoop = true;
		do {
			try {
				BookStoreClerk clerk = new BookStoreClerk();

				Book tempBook = clerk.readAndValidateBook();

				System.out.println(tempBook.toString());

				System.out.println("BookStore Registration Program ended");
				continueLoop = false;
			}

			catch (Exception InvalidBookException) {
				System.out.printf("Cannot create the book instance!%n");
				System.err.println(InvalidBookException);
				System.out.println("caused by " + InvalidBookException.getCause());
				System.out.println("Please modify the input arguments");
				System.out.println();
			}

		} while (continueLoop);
	}

}
