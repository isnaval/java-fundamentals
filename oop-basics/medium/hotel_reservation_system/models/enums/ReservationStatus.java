package java_oop.medium.hotel_reservation_system.models.enums;

public enum ReservationStatus {
	PENDING("Pendiente"), CONFIRMED("Confirmada"), CHECKED_IN("Check-in realizado"), CHECKED_OUT("Check-out realizado"),
	CANCELLED("Cancelada"), NO_SHOW("No se presentó");

	private final String displayName;

	ReservationStatus(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
