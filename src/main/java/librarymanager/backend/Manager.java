package librarymanager.backend;

import librarymanager.backend.builders.Book;
import librarymanager.backend.builders.Shelf;
import librarymanager.backend.builders.User;

import java.util.*;

public interface Manager {

 	 void addShelfToCatalogue(Shelf newShelf);
	 void addBookToCatalogue(Book newBook);
	 List<Shelf> getShelvesByGenre(String genre);
	 List<Book> getAllBooksByGenre(String genre);
	 List<Book> sortCatalogueByRating();
	 List<Book> searchBooks(String name);
	 List<Book> searchBooksByAuthor(String author);
	 Book findSpecificBook(String name);
	 List<Book> getAllIssuedBooks();
}
