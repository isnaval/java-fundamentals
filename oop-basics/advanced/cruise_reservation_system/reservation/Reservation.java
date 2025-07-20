package java_oop.advanced.cruise_reservation_system.reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import java_oop.advanced.cruise_reservation_system.cruise.Cabin;
import java_oop.advanced.cruise_reservation_system.cruise.CruiseShip;
import java_oop.advanced.cruise_reservation_system.passengers.Passenger;

public class Reservation {
	private String reservationId;
	private List<Passenger> passengers;
	private List<Cabin> cabins;
	private CruiseShip ship;
	private LocalDateTime reservationDate;
	private double totalAmount;
	private ReservationStatus status;

	public enum ReservationStatus {
		PENDING, CONFIRMED, CANCELLED, COMPLETED
	}

	public Reservation(String reservationId, CruiseShip ship) {
		this.reservationId = reservationId;
		this.ship = ship;
		this.passengers = new ArrayList<>();
		this.cabins = new ArrayList<>();
		this.reservationDate = LocalDateTime.now();
		this.status = ReservationStatus.PENDING;
		this.totalAmount = 0.0;
	}

	public boolean addPassenger(Passenger passenger) {
		passengers.add(passenger);
		System.out.printf("✅ Passenger %s added to reservation %s%n", passenger.getName(), reservationId);
		return true;
	}

	public boolean assignCabin(Cabin cabin) {
		if (cabin.hasSpace()) {
			cabins.add(cabin);
			calculateTotalAmount();
			System.out.printf("🏠 Cabin %d assigned to reservation %s%n", cabin.getCabinNumber(), reservationId);
			return true;
		}
		return false;
	}

	public void calculateTotalAmount() {
		totalAmount = 0.0;
		for (Cabin cabin : cabins) {
			totalAmount += cabin.calculateTotalPrice(ship.getItinerary().getDuration());
		}
	}

	public void confirm() {
		status = ReservationStatus.CONFIRMED;
		System.out.printf("✅ Reservation %s confirmed! Total: €%.2f%n", reservationId, totalAmount);
	}

	public void cancel() {
		status = ReservationStatus.CANCELLED;
		for (Cabin cabin : cabins) {
			for (Passenger passenger : passengers) {
				cabin.removeOccupant(passenger);
			}
		}
		System.out.printf("❌ Reservation %s cancelled%n", reservationId);
	}

	public String getReservationId() {
		return reservationId;
	}

	public List<Passenger> getPassengers() {
		return new ArrayList<>(passengers);
	}

	public List<Cabin> getCabins() {
		return new ArrayList<>(cabins);
	}

	public CruiseShip getShip() {
		return ship;
	}

	public LocalDateTime getReservationDate() {
		return reservationDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public ReservationStatus getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return String.format("Reservation %s: %d passengers, %d cabins, €%.2f (%s)", reservationId, passengers.size(),
				cabins.size(), totalAmount, status);
	}
}
