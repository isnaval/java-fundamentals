package exceptions.custom_exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ReservationService {

	private FlightRepository repository;

	public ReservationService(FlightRepository repository) {
		this.repository = repository;
	}

	// Crea una nueva reserva para un vuelo y pasajero
	public Reservation createReservation(String flightCode, String passengerName) throws FlightNotAvailableException {
		Flight flight = repository.getFlight(flightCode);
		if (flight == null || !repository.flightExists(flightCode)) {
			throw new FlightNotAvailableException("El vuelo no existe: " + flightCode, flightCode);
		}
		String reservationId = generateId(flightCode, passengerName);
		Reservation reservation = new Reservation(reservationId, flight, passengerName, LocalDateTime.now());
		repository.addReservation(reservation);
		return reservation;
	}

	// Cancela una reserva por su ID
	public void cancelReservation(String reservationId) throws ReservationNotFoundException {
		repository.cancelReservation(reservationId);
	}

	// Lista todos los vuelos disponibles
	public List<Flight> listAllFlights() {
		return repository.getAllFlights();
	}

	// Lista las reservas de un pasajero
	public List<Reservation> listPassengerReservations(String passengerName) {
		return repository.getReservationsByPassenger(passengerName);
	}

	// Genera un ID único para una reserva
	private String generateId(String flightCode, String passengerName) {
		return flightCode + "-" + passengerName.hashCode() + "-" + System.currentTimeMillis();
	}
}