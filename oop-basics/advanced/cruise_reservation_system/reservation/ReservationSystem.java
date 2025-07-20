package java_oop.advanced.cruise_reservation_system.reservation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java_oop.advanced.cruise_reservation_system.cruise.Cabin;
import java_oop.advanced.cruise_reservation_system.cruise.CabinType;
import java_oop.advanced.cruise_reservation_system.cruise.CruiseShip;
import java_oop.advanced.cruise_reservation_system.passengers.Passenger;

public class ReservationSystem {
	private Map<String, Reservation> reservations;
	private PaymentProcessor paymentProcessor;
	private int nextReservationId;

	public ReservationSystem() {
		this.reservations = new HashMap<>();
		this.paymentProcessor = new PaymentProcessor();
		this.nextReservationId = 1;
	}

	public String createReservation(CruiseShip ship) {
		String reservationId = "RES" + String.format("%04d", nextReservationId++);
		Reservation reservation = new Reservation(reservationId, ship);
		reservations.put(reservationId, reservation);

		System.out.printf("📝 New reservation created: %s%n", reservationId);
		return reservationId;
	}

	public boolean addPassengerToReservation(String reservationId, Passenger passenger) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null) {
			return reservation.addPassenger(passenger);
		}
		return false;
	}

	public boolean assignCabinToReservation(String reservationId, CabinType cabinType) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation == null)
			return false;

		CruiseShip ship = reservation.getShip();
		List<Cabin> availableCabins = ship.getCabinsByType(cabinType);

		for (Cabin cabin : availableCabins) {
			if (cabin.hasSpace()) {
				reservation.assignCabin(cabin);

				// Assign passengers to cabin
				for (Passenger passenger : reservation.getPassengers()) {
					if (cabin.hasSpace()) {
						cabin.addOccupant(passenger);
					}
				}
				return true;
			}
		}

		System.out.printf("❌ No available %s cabins%n", cabinType);
		return false;
	}

	public boolean confirmReservation(String reservationId, PaymentProcessor.PaymentMethod paymentMethod,
			String paymentDetails) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation == null)
			return false;

		reservation.calculateTotalAmount();

		if (paymentProcessor.validatePaymentDetails(paymentMethod, paymentDetails)) {
			PaymentProcessor.PaymentStatus status = paymentProcessor.processPayment(reservation.getTotalAmount(),
					paymentMethod, paymentDetails);

			if (status == PaymentProcessor.PaymentStatus.APPROVED) {
				reservation.confirm();
				return true;
			}
		}

		return false;
	}

	public boolean cancelReservation(String reservationId) {
		Reservation reservation = reservations.get(reservationId);
		if (reservation != null) {
			reservation.cancel();
			return true;
		}
		return false;
	}

	public Reservation getReservation(String reservationId) {
		return reservations.get(reservationId);
	}

	public List<Reservation> getAllReservations() {
		return new ArrayList<>(reservations.values());
	}

	public void printReservationSummary() {
		System.out.println("\n📊 RESERVATION SUMMARY");
		System.out.println("=====================");
		for (Reservation reservation : reservations.values()) {
			System.out.println(reservation);
		}
	}
}
