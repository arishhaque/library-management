package librarymanager.backend;

public class CatalogueHCBuildTest {


	CatalogueManagerProxy cmp;

	public CatalogueHCBuildTest() {
		AdminUser admin = new UserBuilder("admin", "admin@123").buildAdminUser();
		this.cmp = new CatalogueManagerProxy(admin);
		this.buildCMPShelves();
		this.buildCMPBooks();
		this.buildUsers();
	}
	
	public void buildCMPShelves() {
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf A1-0").addGenre("Action / Adventure / Mystery").addLocation("West Wing Floor 1").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf A1-1").addGenre("Action").addLocation("West Wing Floor 1 - Shelf A1").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf A1-2").addGenre("Adventure").addLocation("West Wing Floor 1 - Shelf A1").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf A1-3").addGenre("Mystery").addLocation("West Wing Floor 1 - Shelf A1").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf B2-0").addGenre("Romance / Drama / Tragedy").addLocation("West Wing Floor 2").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf B2-1").addGenre("Romance").addLocation("West Wing Floor 2 - Shelf B2").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf B2-2").addGenre("Drama").addLocation("West Wing Floor 2 - Shelf B2").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf B2-3").addGenre("Tragedy").addLocation("West Wing Floor 2 - Shelf B2").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf C3-0").addGenre("Science Fiction / Fantasy").addLocation("West Wing Floor 3").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf C3-1").addGenre("Science Fiction").addLocation("West Wing Floor 3 - Shelf C3").build());
		this.cmp.addShelfToCatalogue(new ShelfBuilder("Shelf C3-2").addGenre("Fantasy").addLocation("West Wing Floor 3 - Shelf C3").build());
	}
	
	public void buildCMPBooks() {
		this.cmp.addBookToCatalogue(new BookBuilder("The Bourne Identity").addGenre("Action").addAuthor("Robert Ludlum").
				addRating(4.3).addPublisher("Richard Marek").setIsbn("0-399-90070-5").build());
		this.cmp.addBookToCatalogue(new BookBuilder("First Blood").addGenre("Action").addAuthor("David Morell").
				addRating(4.5).addPublisher("Rowman & Littlefield").setIsbn("0-214-66814-2").build());
		this.cmp.addBookToCatalogue(new BookBuilder("Treasure Island").addGenre("Adventure").addAuthor("Robert Louis Stevenson").
				addRating(3.8).addPublisher("Casell & Company").build());
		this.cmp.addBookToCatalogue(new BookBuilder("Into Thin Air").addGenre("Adventure").addAuthor("John Krakauer").
				addRating(4.2).addPublisher("Villard Books").setIsbn("978-0385494786").build());
		this.cmp.addBookToCatalogue(new BookBuilder("The Adventures of Sherlock Holmes").addGenre("Mystery").addAuthor("Sir Arthur Conan Doyle").
				addRating(4.3).addPublisher("George Newnes").build());
		this.cmp.addBookToCatalogue(new BookBuilder("Murder on the Orient Express").addGenre("Mystery").addAuthor("Agatha Christie").
				addRating(4.7).addPublisher("Collins Crime Clube").build());
		this.cmp.addBookToCatalogue(new BookBuilder("The Duke and I").addGenre("Romance").addAuthor("Julia Quinn").
				addRating(3.9).addPublisher("Harper Collins").setIsbn("9780062353597").build());
		this.cmp.addBookToCatalogue(new BookBuilder("The Fault in Our Stars").addGenre("Romance").addAuthor("John Green").
				addRating(4.6).addPublisher("Dutton Books").setIsbn("0-525-47881-7").build());
		this.cmp.addBookToCatalogue(new BookBuilder("To Kill a Mockingbird").addGenre("Drama").addAuthor("Harper Lee").
				addRating(4.6).addPublisher("J.B. Lippincott & Co.").build());
		this.cmp.addBookToCatalogue(new BookBuilder("The Kite Runner").addGenre("Drama").addAuthor("Khaled Hosseini").
				addRating(4.3).addPublisher("Riverhead Books").setIsbn("1-57322-245-3").build());
		this.cmp.addBookToCatalogue(new BookBuilder("Hamlet").addGenre("Tragedy").addAuthor("William Shakespeare").
				addRating(4.1).build());
		this.cmp.addBookToCatalogue(new BookBuilder("Bridge to Terabithia").addGenre("Tragedy").addAuthor("Katherine Patterson").
				addRating(4.5).addPublisher("Thomas Y. Crowell Co.").setIsbn("0-690-01359-0").build());
		this.cmp.addBookToCatalogue(new BookBuilder("The Hitchhiker's Guide to the Galaxy").addGenre("Science Fiction").addAuthor("Douglas Adams").
				addRating(4.8).addPublisher("Pan Books").setIsbn("0-330-25864-8").build());
		this.cmp.addBookToCatalogue(new BookBuilder("Ender's Game").addGenre("Science Fiction").addAuthor("Orson Scott Card").
				addRating(4.3).addPublisher("Tor Books").setIsbn("0-312-93208-1").build());
		this.cmp.addBookToCatalogue(new BookBuilder("Harry Potter and the Philosopher's Stone").addGenre("Fantasy").addAuthor("J.K. Rowling").
				addRating(4.8).addPublisher("Bloomsbury").setIsbn("0-7475-3269-9").build());
		this.cmp.addBookToCatalogue(new BookBuilder("The Colour of Magic").addGenre("Fantasy").addAuthor("Terry Pratchett").
				addRating(4.9).addPublisher("Colin Smythe").setIsbn("0-86140-324-X").build());
	}
	
	public void buildUsers() {
		this.cmp.addUserToLibrary(new UserBuilder("abhi", "abhi").buildLibrarianUser());
		this.cmp.addUserToLibrary(new UserBuilder("sgovindaraju", "PatternsRCool").addEmail("sgovindaraju@scu.edu").buildLibrarianUser());
		this.cmp.addUserToLibrary(new UserBuilder("ahaque", "GoSCU").addEmail("mhaque@scu.edu").buildLibrarianUser());
		this.cmp.addUserToLibrary(new UserBuilder("john", "bestprof").addEmail("john.doe@scu.edu").buildLibrarianUser());
		this.cmp.addUserToLibrary(new UserBuilder("studenta", "password").buildUser());
		this.cmp.addUserToLibrary(new UserBuilder("studentb", "password").buildUser());
		this.cmp.addUserToLibrary(new UserBuilder("studentc", "password").buildUser());
		this.cmp.addUserToLibrary(new UserBuilder("studentd", "password").buildUser());
		this.cmp.addUserToLibrary(new UserBuilder("studente", "password").buildUser());
		this.cmp.addUserToLibrary(new UserBuilder("studentf", "password").buildUser());
	}
	
	public CatalogueManagerProxy getCMP() {
		return this.cmp;
	}
	


}
