package java_oop.medium.hotel_reservation_system.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Guest {
	private final String id;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String documentId;
	private LocalDate birthDate;
	private String address;
	private List<String> reservationIds;
	private LocalDate registrationDate;
	private boolean isVip;
	private int loyaltyPoints;

	public Guest(String firstName, String lastName, String email, String phoneNumber, String documentId) {
		this.id = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.documentId = documentId;
		this.reservationIds = new ArrayList<>();
		this.registrationDate = LocalDate.now();
		this.isVip = false;
		this.loyaltyPoints = 0;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getReservationIds() {
		return new ArrayList<>(reservationIds);
	}

	public void addReservationId(String reservationId) {
		this.reservationIds.add(reservationId);
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public boolean isVip() {
		return isVip;
	}

	public void setVip(boolean vip) {
		isVip = vip;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void addLoyaltyPoints(int points) {
		this.loyaltyPoints += points;
		if (this.loyaltyPoints >= 1000 && !isVip) {
			this.isVip = true;
		}
	}

	@Override
	public String toString() {
		return String.format("Guest[id=%s, name=%s, email=%s, VIP=%s, points=%d]", id, getFullName(), email, isVip,
				loyaltyPoints);
	}

}
