package librarymanager.backend;

public class Book extends CatalogueItem {
	private static final long serialVersionUID = 1234567L;
	double rating;
	boolean isAvailable;
	
	Book(String name) {
		super(name);
		this.isAvailable = true;
	}
	
	public Book(BookBuilder builder) {
		super(builder);
		this.rating = builder.rating;
		this.isAvailable = builder.isAvailable;
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
}
