package librarymanager.backend;

public class BookBuilder extends CatalogueItemBuilder {
	double rating = 0.0;
	boolean isAvailable = true;
	
	public BookBuilder(String name) {
		super(name);
	}
	
	public BookBuilder setRating(double rating) {
		this.rating = rating;
		return this;
	}
	
	public BookBuilder setAvailability(boolean available) {
		this.isAvailable = available;
		return this;
	}
	
	public Book build() {
		return new Book(this);
	}

}
