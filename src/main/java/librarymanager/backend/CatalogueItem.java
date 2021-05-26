package librarymanager.backend;

import java.io.Serializable;

public abstract class CatalogueItem implements Serializable {
	private static final long serialVersionUID = 1234567L;
	String name;
	String genre;
	String location;
	
	CatalogueItem(String name) {
		this.name = name;
	}
	
	public CatalogueItem(CatalogueItemBuilder cib) {
		this.name = cib.name;
		this.genre = cib.genre;
		this.location = cib.location;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
}
