package librarymanager.backend;

public class AdminUser extends User {

	public AdminUser(String name, String password) {
		super(name, password);
		this.isAdmin = true;
	}

}
