package exceptions.custom_exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightRepository {

	private Map<String, Flight> flights;
	private Map<String, Reservation> reservations;
	private Map<String, List<Reservation>> passengerReservations;
	private Map<String, Integer> flightReservationCount;

	public FlightRepository() {
		this.flights = new HashMap<>();
		this.reservations = new HashMap<>();
		this.passengerReservations = new HashMap<>();
		this.flightReservationCount = new HashMap<>();
		initializeFlights();
	}

	private void initializeFlights() {
		addFlight(new Flight("IB101", "Madrid", "Barcelona", null, 150, true));
		addFlight(new Flight("RY202", "Barcelona", "Valencia", null, 120, true));
		addFlight(new Flight("VY303", "Madrid", "Sevilla", null, 100, true));
		addFlight(new Flight("UX404", "Bilbao", "Madrid", null, 140, true));
		addFlight(new Flight("IB505", "Valencia", "Palma", null, 110, true));
	}

	public void addFlight(Flight flight) {
		flights.put(flight.getCode(), flight);
		flightReservationCount.put(flight.getCode(), 0);
	}

	public Flight getFlight(String code) {
		return flights.get(code);
	}

	public boolean flightExists(String code) {
		return flights.containsKey(code);
	}

	public List<Flight> getAllFlights() {
		return new ArrayList<>(flights.values());
	}

	public void addReservation(Reservation reservation) throws FlightNotAvailableException {
		Flight flight = reservation.getFlight();
		String flightCode = flight.getCode();

		if (!flightExists(flightCode)) {
			throw new FlightNotAvailableException("El vuelo no existe: " + flightCode, flightCode);
		}

		int currentReservations = flightReservationCount.getOrDefault(flightCode, 0);
		if (!flight.isAvailable() || currentReservations >= flight.getCapacity()) {
			throw new FlightNotAvailableException("El vuelo no está disponible o está lleno: " + flightCode,
					flightCode);
		}

		reservations.put(reservation.getId(), reservation);
		passengerReservations.computeIfAbsent(reservation.getPassengerName(), k -> new ArrayList<>()).add(reservation);
		flightReservationCount.put(flightCode, currentReservations + 1);

		if (currentReservations + 1 >= flight.getCapacity()) {
			flight.setAvailable(false);
		}
	}

	public void cancelReservation(String reservationId) throws ReservationNotFoundException {
		Reservation reservation = reservations.get(reservationId);
		if (reservation == null) {
			throw new ReservationNotFoundException("Reserva no encontrada: " + reservationId, reservationId);
		}

		reservations.remove(reservationId);

		String passengerName = reservation.getPassengerName();
		List<Reservation> passengerRes = passengerReservations.get(passengerName);
		if (passengerRes != null) {
			passengerRes.remove(reservation);
			if (passengerRes.isEmpty()) {
				passengerReservations.remove(passengerName);
			}
		}

		String flightCode = reservation.getFlight().getCode();
		int currentCount = flightReservationCount.get(flightCode);
		flightReservationCount.put(flightCode, currentCount - 1);
		Flight flight = flights.get(flightCode);
		if (flight != null && currentCount - 1 < flight.getCapacity()) {
			flight.setAvailable(true);
		}
	}

	public List<Reservation> getReservationsByPassenger(String passengerName) {
		return passengerReservations.getOrDefault(passengerName, new ArrayList<>());
	}

	public Reservation getReservation(String reservationId) {
		return reservations.get(reservationId);
	}
}