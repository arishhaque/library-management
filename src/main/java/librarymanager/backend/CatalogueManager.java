package librarymanager.backend;

import java.util.*;

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
			System.err.println("Error: Failed to Add Book " + newBook.getName() + " to the Catalogue.");
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
	
	public void issueBookToUser(String bookName, User user) {
		Book foundBook = this.findSpecificBook(bookName);
		if (foundBook == null) {
			System.err.println("Could not find book " + bookName + " in Catalogue.");
		} else {
			foundBook.issueBookToUser(user);
		}
	}
	
	public void returnBook(String bookName) {
		Book foundBook = this.findSpecificBook(bookName);
		if (foundBook == null) {
			System.err.println("Could not find book " + bookName + " in Catalogue.");
		} else {
			foundBook.returnBook();
		}
	}
	
	public List<Book> getAllIssuedBooks() {
		List<Book> books = new ArrayList<Book>();
		List<Book> issued = new ArrayList<Book>();
		for (Shelf shelf: this.catalogue) {
			books.addAll(shelf.sortedShelfBooksByRating());
		}
		for (Book b: books) {
			if (b.isAvailable() == false) {
				issued.add(b);
			}
		}
		return issued;
	}

}
