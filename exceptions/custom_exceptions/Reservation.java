package exceptions.custom_exceptions;

import java.time.LocalDateTime;

public class Reservation {
	private String id;
	private Flight flight;
	private String passengerName;
	private LocalDateTime reservationDate;

	public Reservation(String id, Flight flight, String passengerName, LocalDateTime reservationDate) {
		super();
		this.id = id;
		this.flight = flight;
		this.passengerName = passengerName;
		this.reservationDate = reservationDate;
	}

	private String generateId(String flightCode, String passenger) {
		return flightCode + "-" + passenger.hashCode() + "-" + System.currentTimeMillis();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDateTime reservationDate) {
		this.reservationDate = reservationDate;
	}

	@Override
	public String toString() {
		return String.format("Reserva: %s - Vuelo: %s - Pasajero: %s", id, flight.getCode(), passengerName);
	}

}
