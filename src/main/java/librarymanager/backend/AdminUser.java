package librarymanager.backend;

public class AdminUser extends LibrarianUser {

	public AdminUser(String name, String password) {
		super(name, password);
	}
	
	public AdminUser(UserBuilder builder) {
		super(builder);
	}

}
