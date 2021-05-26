package librarymanager.backend;

import java.util.*;

public class ShelfBuilder extends CatalogueItemBuilder {
	List<CatalogueItem> shelfContents;

	public ShelfBuilder(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	public ShelfBuilder addCItem(CatalogueItem cItem) {
		this.shelfContents.add(cItem);
		return this;
	}

	public Shelf build() {
		Shelf newShelf = new Shelf(this);
		for (CatalogueItem cItem: this.shelfContents) {
			newShelf.addNewShelfContent(cItem);
		}
		return newShelf;
	}
}
