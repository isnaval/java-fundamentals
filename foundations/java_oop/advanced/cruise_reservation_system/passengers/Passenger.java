package java_oop.advanced.cruise_reservation_system.passengers;

public class Passenger {
	private String name;
	private String email;
	private String passportNumber;
	private int age;
	private String phoneNumber;

	public Passenger(String name, String email, String passportNumber, int age, String phoneNumber) {
		this.name = name;
		this.email = email;
		this.passportNumber = passportNumber;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public int getAge() {
		return age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return String.format("Passenger: %s (Age: %d, Email: %s)", name, age, email);
	}

}
