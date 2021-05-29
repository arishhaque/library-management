package librarymanager.backend;

public class BookBuilder extends CatalogueItemBuilder {
	double rating = 0.0;
	boolean isAvailable = true;
	String author = "Author Not Listed";
	
	public BookBuilder(String name) {
		super(name);
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
	
	public Book build() {
		return new Book(this);
	}

}
