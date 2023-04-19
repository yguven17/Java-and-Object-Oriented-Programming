package prelab;

public class Book {

	// Instance variables:
	// name
	// authorName
	// yearPublished
	String name;
	String authorName;
	int yearPublished;
	
	// Methods:
	// Constructor
	// toString
	
	public Book(String name, String authorName, int yearPublished) {
		this.name = name;
		this.authorName = authorName;
		this.yearPublished = yearPublished;
		
	}
	
	public String toString() {
		return "Book Name: "+ getName()+"\n"+"Autor Name: "+getAuthorName()+" \n"+"Year Published: "+getYearPublished()+"\n";
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}
}
