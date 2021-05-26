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
		this.shelfContents.add(cItem);
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
			} else if (item instanceof Shelf) {
				books.addAll(((Shelf) item).sortedShelfBooksByRating());
			}
		}
		books.sort(Comparator.comparing(Book::getName));
		return books;
	}
	
	public CatalogueItem findItem(String name) {
		CatalogueItem found = null;
		for (CatalogueItem item: this.shelfContents) {
			if (item instanceof Book) {
				if (item.getName().contains(name)) {
					found = item;
				}
			} else if (item instanceof Shelf) {
				found = ((Shelf) item).findItem(name);
			}
		}
		return found;
	}
	
}
