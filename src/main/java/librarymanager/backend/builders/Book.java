package librarymanager.backend.builders;

public class Book extends CatalogueItem {

	private static final long serialVersionUID = 1234567L;

	String isbn;
	double rating;
	boolean isAvailable;
	String author;
	String publisher;
	Integer quantity;
	Integer shelfId;
	User borrower;
	
	Book(String name) {
		super(name);
		this.isAvailable = true;
	}
	
	public Book(BookBuilder builder) {
		super(builder);
		this.isbn = builder.isbn;
		this.rating = builder.rating;
		this.isAvailable = builder.isAvailable;
		this.publisher = builder.publisher;
		this.author = builder.author;
		this.quantity = builder.quantity;
		this.shelfId = builder.shelfId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getShelfId() {
		return shelfId;
	}

	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}

	public User getBorrower() {
		return borrower;
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


