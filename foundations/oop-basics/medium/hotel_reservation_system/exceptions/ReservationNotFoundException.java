package java_oop.medium.hotel_reservation_system.exceptions;

public class ReservationNotFoundException extends Exception {
	private final String reservationId;

	public ReservationNotFoundException(String reservationId) {
		super(String.format("No se encontró la reserva con ID: %s", reservationId));
		this.reservationId = reservationId;
	}

	public String getReservationId() {
		return reservationId;
	}
}