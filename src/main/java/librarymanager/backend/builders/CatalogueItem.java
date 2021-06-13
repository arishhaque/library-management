package librarymanager.backend.builders;


import java.io.Serializable;
import java.util.*;

public abstract class CatalogueItem implements Serializable {
	private static final long serialVersionUID = 1234567L;
	String name;
	String genre;
	String location;

	public CatalogueItem(String name) {
		this.name = name;
	}
	
	public CatalogueItem(CatalogueItemBuilder cib) {
		this.name = cib.name;
		this.genre = cib.genre;
		this.location = cib.location;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void addNewShelfContent(CatalogueItem cItem) {}
	
	public void removeShelfContent(CatalogueItem cItem) {}
	
	public List<CatalogueItem> sortedShelfByName() { return null; }
	
	public List<CatalogueItem> sortedShelfByGenre() { return null; }
	
	public List<Book> sortedShelfBooksByRating() { return null; }
	
	public List<Book> getBooksByGenre(String genre) { return null; }
	
	public CatalogueItem findItem(String name) { return null; }

	public List<Book> searchBooks(String name) {return null;}

	public List<Book> searchBooksByAuthor(String author) {return null;}
	
}
