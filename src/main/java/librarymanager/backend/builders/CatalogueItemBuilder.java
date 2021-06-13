package librarymanager.backend.builders;


public class CatalogueItemBuilder {

	String name;
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
