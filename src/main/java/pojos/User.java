package pojos;

public class User {

	private int personid;
	private String lastname;
	private String firstname;
	private String username;
	private String password;
	private String wavier;
	
	
	public User(int id, String last, String first, String username, String password, String wavier){
		this.personid = id;
		this.lastname = last;
		this.firstname = first;
		this.username = username;
		this.password = password;
		this.wavier = wavier;
	}
	
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getWavier() {
		return wavier;
	}
	public void setWavier(String wavier) {
		this.wavier = wavier;
	}
	
	
	
	
}
