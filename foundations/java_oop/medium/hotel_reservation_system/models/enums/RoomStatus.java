package java_oop.medium.hotel_reservation_system.models.enums;

public enum RoomStatus {
	AVAILABLE("Disponible"), OCCUPIED("Ocupada"), RESERVED("Reservada"), MAINTENANCE("En mantenimiento"),
	CLEANING("En limpieza");

	private final String displayName;

	RoomStatus(String displayName) {
		this.displayName = displayName;
	}

	public String getDisplayName() {
		return displayName;
	}

}
