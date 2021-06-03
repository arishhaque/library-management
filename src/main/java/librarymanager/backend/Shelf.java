package librarymanager.backend;

import java.util.*;

public class Shelf extends CatalogueItem {

	private static final long serialVersionUID = 1234567L;

	private Integer id;
	List<CatalogueItem> shelfContents;

	public Shelf(String name) {
		super(name);
		this.shelfContents = new ArrayList<CatalogueItem>();
	}
	
	public Shelf(ShelfBuilder builder) {
		super(builder);
		this.id = builder.getId();
		this.shelfContents = new ArrayList<CatalogueItem>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the shelfContents
	 */
	public List<CatalogueItem> getShelfContents() {
		return shelfContents;
	}
	
	@Override
	public void addNewShelfContent(CatalogueItem cItem) {
		boolean addedNewContent = false;
		for (CatalogueItem catItem: this.shelfContents) {
			if (catItem instanceof Shelf) {
				if (catItem.getGenre().toLowerCase().contains(cItem.getGenre().toLowerCase())) {
					((Shelf) catItem).addNewShelfContent(cItem);
					addedNewContent = true;
				}
			}
		}
		if (!addedNewContent) {
			this.shelfContents.add(cItem);
		}
	}
	
	@Override
	public void removeShelfContent(CatalogueItem cItem) {
		this.shelfContents.remove(cItem);
	}
	
	@Override
	public List<CatalogueItem> sortedShelfByName() {
		this.shelfContents.sort(Comparator.comparing(CatalogueItem::getName));
		return this.shelfContents;
	}
	
	@Override
	public List<CatalogueItem> sortedShelfByGenre() {
		this.shelfContents.sort(Comparator.comparing(CatalogueItem::getGenre));
		return this.shelfContents;
	}
	
	@Override
	public List<Book> sortedShelfBooksByRating() {
		List<Book> books = new ArrayList<Book>();
		for (CatalogueItem item: this.shelfContents) {
			if (item instanceof Book) {
				books.add((Book)item);
			} else {
				books.addAll(((Shelf) item).sortedShelfBooksByRating());
			}
		}
		books.sort(Comparator.comparing(Book::getRating));
		Collections.reverse(books);
		return books;
	}
	
	@Override
	public List<Book> getBooksByGenre(String genre) {
		List<Book> books = new ArrayList<Book>();
		for (CatalogueItem item: this.shelfContents) {
			if (item.getGenre().toLowerCase().contains(genre.toLowerCase())) {
				if (item instanceof Book) {
					books.add((Book) item);
				} else {
					books.addAll(((Shelf) item).getBooksByGenre(genre));
				}
			}
		}
		books.sort(Comparator.comparing(Book::getRating));
		Collections.reverse(books);
		return books;
	}
	
	@Override
	public CatalogueItem findItem(String name) {
		CatalogueItem found = null;
		for (CatalogueItem item: this.shelfContents) {
			if (item instanceof Book) {
				if (item.getName().toLowerCase().contains(name.toLowerCase())) {
					found = item;
				}
			} else {
				found = ((Shelf) item).findItem(name);
			}
		}
		return found;
	}


	@Override
	public List<Book> searchBooks(String name) {
		List<Book> books = new ArrayList<>();
		for (CatalogueItem item: this.shelfContents) {
			if (item instanceof Book) {
				if (item.getName().toLowerCase().contains(name.toLowerCase())) {
					books.add((Book) item);
				}
			} else{

				books.addAll(item.searchBooks(name));
			}
		}
		return books;
	}

	@Override
	public List<Book> searchBooksByAuthor(String author) {
		List<Book> books = new ArrayList<>();
		for (CatalogueItem item: this.shelfContents) {
			if (item instanceof Book) {
				if (((Book) item).getAuthor().toLowerCase().contains(author.toLowerCase())) {
					books.add((Book) item);
				}
			} else{

				books.addAll(item.searchBooksByAuthor(author));
			}
		}
		return books;
	}


}
