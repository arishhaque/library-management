package librarymanager.backend;

import java.util.*;

public interface Manager {
	public void addShelfToCatalogue(Shelf newShelf);
	public void addBookToCatalogue(Book newBook);
	public List<Shelf> getShelvesByGenre(String genre);
	public List<Book> getAllBooksByGenre(String genre);
	public List<Book> sortCatalogueByRating();
	public Book findSpecificBook(String name);
}
