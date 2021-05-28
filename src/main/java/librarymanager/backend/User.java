package librarymanager.backend;

public class User {
	private String name;
	private String password;
	boolean isAdmin;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.isAdmin = false;
	}
	
	public boolean verifyCredentials(String password) {
		return this.password.equalsIgnoreCase(password);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
}
