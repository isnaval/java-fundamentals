package java_oop.medium.email_generator;

public class User {
	private String name;
	private String firstSurname;
	private String secondSurname;
	private String email;

	public User(String name, String firstSurname, String secondSurname) {
		this.name = name;
		this.firstSurname = firstSurname;
		this.secondSurname = secondSurname;
	}

	public User(String name, String firstSurname, String secondSurname, String email) {
		this(name, firstSurname, secondSurname);
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getFirstSurname() {
		return firstSurname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return name + " " + firstSurname + (secondSurname != null ? " " + secondSurname : "");
	}
}