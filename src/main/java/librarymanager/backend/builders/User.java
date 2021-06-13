package librarymanager.backend.builders;

public class User {
	private String name;
	private String password;
	String email;
	String address;
	String contact;
	boolean hasAdminAccess;
	boolean hasAdminUserPrivilege;

	public User(String name, String password) {
		this.name = name;
		this.password = password;
		this.email = "";
		this.address = "";
		this.contact = "";
		this.hasAdminAccess = false;
		this.hasAdminUserPrivilege = false;
	}

	public User(UserBuilder builder) {
		this.name = builder.name;
		this.password = builder.password;
		this.email = builder.email;
		this.address = builder.address;
		this.contact = builder.contact;
		this.hasAdminAccess = false;
		this.hasAdminUserPrivilege = false;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
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
	 * @return the hasAdminAccess
	 */
	public boolean hasAdminAccess() {
		return hasAdminAccess;
	}
	
	/**
	 * @return the hasAdminUserPrivilege
	 */
	public boolean hasAdminUserPrivilege() {
		return hasAdminUserPrivilege;
	}
}
