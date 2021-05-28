package librarymanager.backend;

import java.util.*;

public class Shelf extends CatalogueItem {
	private static final long serialVersionUID = 1234567L;
	List<CatalogueItem> shelfContents;

	public Shelf(String name) {
		super(name);
		this.shelfContents = new ArrayList<CatalogueItem>();
	}
	
	public Shelf(ShelfBuilder builder) {
		super(builder);
		this.shelfContents = new ArrayList<CatalogueItem>();
	}

	/**
	 * @return the shelfContents
	 */
	public List<CatalogueItem> getShelfContents() {
		return shelfContents;
	}
	
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
	
	public void removeShelfContent(CatalogueItem cItem) {
		this.shelfContents.remove(cItem);
	}
	
	public List<CatalogueItem> sortedShelfByName(){
		this.shelfContents.sort(Comparator.comparing(CatalogueItem::getName));
		return this.shelfContents;
	}
	
	public List<CatalogueItem> sortedShelfByGenre(){
		this.shelfContents.sort(Comparator.comparing(CatalogueItem::getGenre));
		return this.shelfContents;
	}
	
	public List<Book> sortedShelfBooksByRating(){
		List<Book> books = new ArrayList<Book>();
		for (CatalogueItem item: this.shelfContents) {
			if (item instanceof Book) {
				books.add((Book)item);
			} else {
				books.addAll(((Shelf) item).sortedShelfBooksByRating());
			}
		}
		books.sort(Comparator.comparing(Book::getRating));
		return books;
	}
	
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
		return books;
	}
	
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
	
}
