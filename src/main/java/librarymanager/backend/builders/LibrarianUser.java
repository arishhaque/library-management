package librarymanager.backend.builders;

public class LibrarianUser extends User {

	public LibrarianUser(String name, String password) {
		super(name, password);
		this.hasAdminAccess = true;
	}
	
	public LibrarianUser(UserBuilder builder) {
		super(builder);
		this.hasAdminAccess = true;
	}

}
