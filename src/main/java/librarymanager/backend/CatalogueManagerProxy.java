package librarymanager.backend;

import librarymanager.backend.builders.AdminUser;
import librarymanager.backend.builders.Book;
import librarymanager.backend.builders.Shelf;
import librarymanager.backend.builders.User;

import java.util.*;

public class CatalogueManagerProxy implements Manager {
	CatalogueManager cm;
	User user;
	public List<User> validUsers;
	
	public CatalogueManagerProxy(User user) {
		this.cm = new CatalogueManager();
		this.user = user;
		this.validUsers = new ArrayList<User>();
		this.validUsers.add(new AdminUser("admin", "admin@123"));
	}

	@Override
	public void addShelfToCatalogue(Shelf newShelf) {
		if (this.user.hasAdminAccess()) {
			cm.addShelfToCatalogue(newShelf);
		}
	}

	@Override
	public void addBookToCatalogue(Book newBook) {
		if (this.user.hasAdminAccess()) {
			cm.addBookToCatalogue(newBook);
		}
	}

	@Override
	public List<Shelf> getShelvesByGenre(String genre) {
		return cm.getShelvesByGenre(genre);
	}

	@Override
	public List<Book> getAllBooksByGenre(String genre) {
		return cm.getAllBooksByGenre(genre);
	}

	@Override
	public List<Book> sortCatalogueByRating() {
		return cm.sortCatalogueByRating();
	}

	@Override
	public List<Book> searchBooks(String name) {
		return cm.searchBooks(name);
	}

	@Override
	public List<Book> searchBooksByAuthor(String author) {
		return cm.searchBooksByAuthor(author);
	}

	@Override
	public Book findSpecificBook(String name) {
		return cm.findSpecificBook(name);
	}

	
	@Override
	public List<Book> getAllIssuedBooks() {
		return cm.getAllIssuedBooks();
	}
	
	public void addUserToLibrary(User newUser) {
		if (newUser.hasAdminAccess()) {
			if (this.user.hasAdminUserPrivilege()) {
				this.validUsers.add(newUser);
			} else {
				System.err.println("Error: Current User is not Admin. Denied permission to add a new Admin or Librarian to the Catalogue.");
				return;
			}
		} else if (this.user.hasAdminAccess()) {
			this.validUsers.add(newUser);
		} else {
			System.err.println("Error: Current User is not Librarian. Denied permission to add a new User to the Catalogue.");
		}
	}
	
	public void removeUserFromLibrary(String username) {
		if (this.user.hasAdminAccess()) {
			for (User vu: this.validUsers) {
				if (vu.getName().equalsIgnoreCase(username)) {
					if (vu.hasAdminAccess() && this.user.hasAdminUserPrivilege()) {
						this.validUsers.remove(vu);
					} else {
						System.err.println("Error: Current User is not Admin. Denied permission to remove an Admin or Librarion from the Catalogue.");
					}
				}
			}
		} else {
			System.err.println("Error: Current User is not Librarian. Denied permission to remove a User from the Catalogue.");
		}
	}

}
