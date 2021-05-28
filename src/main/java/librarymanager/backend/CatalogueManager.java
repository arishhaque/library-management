package librarymanager.backend;

import java.util.*;

/*
 * Shiva's Notes:
 * We should use this class to control the lists of Shelves and Books.
 * The UI can use it to interact with the rest of the back-end more easily,
 * So that the UI doesn't have to know all the implementation details.
 */

public class CatalogueManager implements Manager {
	List<Shelf> catalogue;
	
	public CatalogueManager() {
		this.catalogue = new ArrayList<Shelf>();
	}
	
	public void addShelfToCatalogue(Shelf newShelf) {
		boolean addedShelf = false;
		for (Shelf catItem: this.catalogue) {
			if (catItem.getGenre().toLowerCase().contains(newShelf.getGenre().toLowerCase())) {
				catItem.addNewShelfContent(newShelf);
				addedShelf = true;
			}
		}
		if (!addedShelf) {
			this.catalogue.add(newShelf);
		}
	}
	
	public void addBookToCatalogue(Book newBook) {
		boolean addedBook = false;
		for (Shelf catItem: this.catalogue) {
			if (catItem.getGenre().toLowerCase().contains(newBook.getGenre().toLowerCase())) {
				catItem.addNewShelfContent(newBook);
				addedBook = true;
			}
		}
		if (!addedBook) {
			//Some kind of error message should be thrown. Decide on that later?
		}
	}
	
	public List<Shelf> getShelvesByGenre(String genre) {
		List<Shelf> shelves = new ArrayList<Shelf>();
		for (Shelf catItem: this.catalogue) {
			if (catItem.getGenre().toLowerCase().contains(genre.toLowerCase())) {
				shelves.add((Shelf) catItem);
			}
		}
		return shelves;
	}
	
	public List<Book> getAllBooksByGenre(String genre) {
		List<Book> books = new ArrayList<Book>();
		for (Shelf genreShelves: this.getShelvesByGenre(genre)) {
			books.addAll(((Shelf) genreShelves).getBooksByGenre(genre));
		}
		books.sort(Comparator.comparing(Book::getRating));
		return books;
	}
	
	public List<Book> sortCatalogueByRating() {
		List<Book> books = new ArrayList<Book>();
		for (Shelf catItem: this.catalogue) {
			books.addAll(catItem.sortedShelfBooksByRating());
		}
		books.sort(Comparator.comparing(Book::getRating));
		return books;
	}
	
	public Book findSpecificBook(String name) {
		Book found = null;
		for (Shelf catItem: this.catalogue) {
			found = (Book)((Shelf) catItem).findItem(name);
		}
		return found;
	}

}
