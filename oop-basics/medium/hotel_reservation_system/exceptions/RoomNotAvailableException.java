package java_oop.medium.hotel_reservation_system.exceptions;

public class RoomNotAvailableException extends Exception {
	private final String roomNumber;
	private final String reason;

	public RoomNotAvailableException(String roomNumber, String reason) {
		super(String.format("La habitación %s no está disponible: %s", roomNumber, reason));
		this.roomNumber = roomNumber;
		this.reason = reason;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getReason() {
		return reason;
	}
}