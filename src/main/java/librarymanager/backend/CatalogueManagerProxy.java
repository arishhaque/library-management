package librarymanager.backend;

import java.util.*;

public class CatalogueManagerProxy implements Manager {
	CatalogueManager cm;
	User user;
	List<User> validUsers; //need to discuss later about how to use this.
	
	public CatalogueManagerProxy(User user) {
		this.cm = new CatalogueManager();
		this.user = user;
		this.validUsers = new ArrayList<User>();
		this.validUsers.add(new AdminUser("admin", "PatternsRCool"));
	}

	@Override
	public void addShelfToCatalogue(Shelf newShelf) {
		if (user.isAdmin()) {
			cm.addShelfToCatalogue(newShelf);
		}
	}

	@Override
	public void addBookToCatalogue(Book newBook) {
		if (user.isAdmin()) {
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
	public Book findSpecificBook(String name) {
		return cm.findSpecificBook(name);
	}

}
