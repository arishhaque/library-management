package librarymanager.backend;

public abstract class CatalogueItemBuilder {
	String name = "";
	String genre = "";
	String location = "";
	
	public CatalogueItemBuilder(String name) {
		this.name = name;
	}
	
	public CatalogueItemBuilder addGenre(String genre) {
		this.genre = genre;
		return this;
	}
	
	public CatalogueItemBuilder addLocation(String location) {
		this.location = location;
		return this;
	}
	
}
