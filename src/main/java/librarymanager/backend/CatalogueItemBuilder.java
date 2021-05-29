package librarymanager.backend;

public abstract class CatalogueItemBuilder {
	String name = "None";
	String genre = "None";
	String location = "None";
	
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
