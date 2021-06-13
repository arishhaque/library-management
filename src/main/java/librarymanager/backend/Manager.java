package librarymanager.backend;

import librarymanager.backend.builders.Book;
import librarymanager.backend.builders.Shelf;
import librarymanager.backend.builders.User;

import java.util.*;

public interface Manager {
	public void addShelfToCatalogue(Shelf newShelf);
	public void addBookToCatalogue(Book newBook);
	public List<Shelf> getShelvesByGenre(String genre);
	public List<Book> getAllBooksByGenre(String genre);
	public List<Book> sortCatalogueByRating();
	public List<Book> searchBooks(String name);
	public List<Book> searchBooksByAuthor(String author);
	public Book findSpecificBook(String name);
	public void issueBookToUser(String bookName, User user);
	public void returnBook(String bookName);
	public List<Book> getAllIssuedBooks();
}
