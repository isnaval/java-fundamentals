package java_oop.medium.hotel_reservation_system.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import java_oop.medium.hotel_reservation_system.models.enums.ReservationStatus;

public class Reservation {
	private final String id;
	private final String guestId;
	private final List<String> roomNumbers;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private LocalDateTime actualCheckInTime;
	private LocalDateTime actualCheckOutTime;
	private ReservationStatus status;
	private int numberOfGuests;
	private double totalPrice;
	private double deposit;
	private List<String> specialRequests;
	private String cancellationReason;
	private LocalDateTime createdAt;
	private LocalDateTime lastModified;

	public Reservation(String guestId, List<String> roomNumbers, LocalDate checkInDate, LocalDate checkOutDate,
			int numberOfGuests) {
		this.id = UUID.randomUUID().toString();
		this.guestId = guestId;
		this.roomNumbers = new ArrayList<>(roomNumbers);
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.numberOfGuests = numberOfGuests;
		this.status = ReservationStatus.PENDING;
		this.specialRequests = new ArrayList<>();
		this.createdAt = LocalDateTime.now();
		this.lastModified = LocalDateTime.now();
		this.totalPrice = 0.0;
		this.deposit = 0.0;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public String getGuestId() {
		return guestId;
	}

	public List<String> getRoomNumbers() {
		return new ArrayList<>(roomNumbers);
	}

	public void addRoom(String roomNumber) {
		if (!roomNumbers.contains(roomNumber)) {
			roomNumbers.add(roomNumber);
			updateLastModified();
		}
	}

	public void removeRoom(String roomNumber) {
		roomNumbers.remove(roomNumber);
		updateLastModified();
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
		updateLastModified();
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
		updateLastModified();
	}

	public LocalDateTime getActualCheckInTime() {
		return actualCheckInTime;
	}

	public void setActualCheckInTime(LocalDateTime actualCheckInTime) {
		this.actualCheckInTime = actualCheckInTime;
		updateLastModified();
	}

	public LocalDateTime getActualCheckOutTime() {
		return actualCheckOutTime;
	}

	public void setActualCheckOutTime(LocalDateTime actualCheckOutTime) {
		this.actualCheckOutTime = actualCheckOutTime;
		updateLastModified();
	}

	public ReservationStatus getStatus() {
		return status;
	}

	public void setStatus(ReservationStatus status) {
		this.status = status;
		updateLastModified();
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
		updateLastModified();
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
		updateLastModified();
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
		updateLastModified();
	}

	public List<String> getSpecialRequests() {
		return new ArrayList<>(specialRequests);
	}

	public void addSpecialRequest(String request) {
		specialRequests.add(request);
		updateLastModified();
	}

	public String getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
		updateLastModified();
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	private void updateLastModified() {
		this.lastModified = LocalDateTime.now();
	}

	public long getNumberOfNights() {
		return ChronoUnit.DAYS.between(checkInDate, checkOutDate);
	}

	public boolean isActive() {
		return status == ReservationStatus.CONFIRMED || status == ReservationStatus.CHECKED_IN;
	}

	public double getBalance() {
		return totalPrice - deposit;
	}

	@Override
	public String toString() {
		return String.format("Reservation[id=%s, guest=%s, rooms=%s, dates=%s to %s, status=%s, total=%.2f]", id,
				guestId, roomNumbers, checkInDate, checkOutDate, status.getDisplayName(), totalPrice);
	}
}