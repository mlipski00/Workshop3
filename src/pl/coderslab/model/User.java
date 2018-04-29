package pl.coderslab.model;


import pl.coderslab.utils.BCrypt;

public class User {

	private int id;
	private String username;
	private String email;
	private String password;
	private int person_group_id;

	public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPerson_group_id() {
		return person_group_id;
	}

	public void setPerson_group_id(int person_group_id) {
		this.person_group_id = person_group_id;
	}

	public User(String username, String email, String password) {

		this.username = username;
		this.email = email;
		this.setPassword(password);
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());

	}

	public User() {
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", person_group_id=" + person_group_id + "]\n";
	}


}
