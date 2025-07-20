package java_oop.advanced.cruise_reservation_system.cruise;

import java.util.ArrayList;
import java.util.List;

import java_oop.advanced.cruise_reservation_system.passengers.Passenger;

public class Cabin {
	private int cabinNumber;
	private CabinType type;
	private int maxOccupancy;
	private List<Passenger> occupants;
	private boolean isAvailable;
	private double pricePerNight;

	public Cabin(int cabinNumber, CabinType type, int maxOccupancy) {
		this.cabinNumber = cabinNumber;
		this.type = type;
		this.maxOccupancy = maxOccupancy;
		this.occupants = new ArrayList<>();
		this.isAvailable = true;
		this.pricePerNight = type.getBasePrice();
	}

	public boolean addOccupant(Passenger passenger) {
		if (occupants.size() >= maxOccupancy) {
			System.out.printf("❌ Cabin %d is full! (Max: %d)%n", cabinNumber, maxOccupancy);
			return false;
		}

		occupants.add(passenger);

		if (occupants.size() == maxOccupancy) {
			isAvailable = false;
		}

		System.out.printf("✅ %s assigned to cabin %d%n", passenger.getName(), cabinNumber);
		return true;
	}

	public boolean removeOccupant(Passenger passenger) {
		if (occupants.remove(passenger)) {
			isAvailable = true;
			System.out.printf("🚪 %s removed from cabin %d%n", passenger.getName(), cabinNumber);
			return true;
		}
		return false;
	}

	public double calculateTotalPrice(int nights) {
		return pricePerNight * nights;
	}

	public boolean hasSpace() {
		return occupants.size() < maxOccupancy;
	}

	public int getAvailableSpace() {
		return maxOccupancy - occupants.size();
	}

	public int getCabinNumber() {
		return cabinNumber;
	}

	public CabinType getType() {
		return type;
	}

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

	public List<Passenger> getOccupants() {
		return new ArrayList<>(occupants);
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public int getOccupancy() {
		return occupants.size();
	}

	// Setters
	public void setAvailable(boolean available) {
		this.isAvailable = available;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	@Override
	public String toString() {
		return String.format("Cabin %d (%s) - %d/%d occupants - €%.2f/night - %s", cabinNumber, type, occupants.size(),
				maxOccupancy, pricePerNight, isAvailable ? "Available" : "Full");
	}

}
