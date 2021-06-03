package librarymanager.backend;

public class BookBuilder extends CatalogueItemBuilder {

	String isbn;
	double rating = 0.0;
	boolean isAvailable = true;
	String author = "Author Not Listed";
	String publisher = "Publisher Not Listed";
	Integer quantity = Integer.valueOf(1);
	Integer shelfId;
	
	public BookBuilder(String name) {
		super(name);
	}
	
	public BookBuilder addGenre(String genre) {
		this.genre = genre;
		return this;
	}
	
	public BookBuilder addLocation(String location) {
		this.location = location;
		return this;
	}

	public BookBuilder setIsbn(String isbn) {

		this.isbn = isbn;
		return this;
	}

	public BookBuilder addRating(double rating) {
		this.rating = rating;
		return this;
	}
	
	public BookBuilder addAvailability(boolean available) {
		this.isAvailable = available;
		return this;
	}
	
	public BookBuilder addAuthor(String author) {
		this.author = author;
		return this;
	}

	public BookBuilder addPublisher(String publisher) {
		this.publisher = publisher;
		return this;
	}

	public BookBuilder setQuantity(Integer quantity) {
		this.quantity = quantity;
		return this;
	}

	public BookBuilder setShelfId(Integer shelfId) {

		this.shelfId = shelfId;
		return this;
	}
	public Book build() {
		return new Book(this);
	}

}
