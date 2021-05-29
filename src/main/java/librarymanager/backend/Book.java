package librarymanager.backend;

public class Book extends CatalogueItem {
	private static final long serialVersionUID = 1234567L;
	double rating;
	boolean isAvailable;
	String author;
	User borrower;
	
	Book(String name) {
		super(name);
		this.isAvailable = true;
	}
	
	public Book(BookBuilder builder) {
		super(builder);
		this.rating = builder.rating;
		this.isAvailable = builder.isAvailable;
		this.author = builder.author;
	}
	
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the isAvailable
	 */
	public boolean isAvailable() {
		return isAvailable;
	}

	/**
	 * @param isAvailable the isAvailable to set
	 */
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void issueBookToUser(User borrower) {
		this.borrower = borrower;
		this.setAvailable(false);
	}
	
	public void returnBook() {
		this.borrower = null;
		this.setAvailable(true);
	}
}
