package librarymanager.backend;

import java.util.*;

public class ShelfBuilder extends CatalogueItemBuilder {
	List<CatalogueItem> shelfContents;

	public ShelfBuilder(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public ShelfBuilder addGenre(String genre) {
		this.genre = genre;
		return this;
	}
	
	public ShelfBuilder addLocation(String location) {
		this.location = location;
		return this;
	}
	
	public ShelfBuilder addCItem(CatalogueItem cItem) {
		this.shelfContents.add(cItem);
		return this;
	}
	
	public Shelf build() {
		Shelf newShelf = new Shelf(this);
		if (this.shelfContents != null) {
			for (CatalogueItem cItem: this.shelfContents) {
				newShelf.addNewShelfContent(cItem);
			}
		}
		return newShelf;
	}
}
