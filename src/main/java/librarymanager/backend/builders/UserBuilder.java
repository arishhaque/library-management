package librarymanager.backend.builders;


public class UserBuilder {
	String name;
	String password;
	String email = "No Email";
	String address = "None Listed";
	String contact = "None Listed";
	
	public UserBuilder(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public UserBuilder addEmail(String email) {
		this.email = email;
		return this;
	}
	
	public UserBuilder addAddress(String address) {
		this.address = address;
		return this;
	}
	
	public UserBuilder addContact(String contact) {
		this.contact = contact;
		return this;
	}
	
	public User buildUser() {
		return new User(this);
	}
	
	public LibrarianUser buildLibrarianUser() {
		return new LibrarianUser(this);
	}
	
	public AdminUser buildAdminUser() {
		return new AdminUser(this);
	}

}
