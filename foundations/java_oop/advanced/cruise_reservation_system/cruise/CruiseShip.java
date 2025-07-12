package java_oop.advanced.cruise_reservation_system.cruise;

import java.util.ArrayList;
import java.util.List;

public class CruiseShip {
	private String name;
	private int capacity;
	private List<Cabin> cabins;
	private Itinerary itinerary;
	private int totalCabins;

	public CruiseShip(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.cabins = new ArrayList<>();
		this.totalCabins = 0;
		initializeCabins();
	}

	private void initializeCabins() {
		int cabinNumber = 1;

		// Interior cabins (40% of capacity)
		for (int i = 0; i < capacity * 0.4 / 2; i++) {
			cabins.add(new Cabin(cabinNumber++, CabinType.INTERIOR, 2));
		}

		// Ocean view cabins (30% of capacity)
		for (int i = 0; i < capacity * 0.3 / 2; i++) {
			cabins.add(new Cabin(cabinNumber++, CabinType.OCEAN_VIEW, 2));
		}

		// Balcony cabins (25% of capacity)
		for (int i = 0; i < capacity * 0.25 / 2; i++) {
			cabins.add(new Cabin(cabinNumber++, CabinType.BALCONY, 2));
		}

		// Suites (5% of capacity)
		for (int i = 0; i < capacity * 0.05 / 4; i++) {
			cabins.add(new Cabin(cabinNumber++, CabinType.SUITE, 4));
		}

		totalCabins = cabins.size();
	}

	public List<Cabin> getAvailableCabins() {
		List<Cabin> available = new ArrayList<>();
		for (Cabin cabin : cabins) {
			if (cabin.hasSpace()) {
				available.add(cabin);
			}
		}
		return available;
	}

	public List<Cabin> getCabinsByType(CabinType type) {
		List<Cabin> filtered = new ArrayList<>();
		for (Cabin cabin : cabins) {
			if (cabin.getType() == type) {
				filtered.add(cabin);
			}
		}
		return filtered;
	}

	public Cabin getCabinByNumber(int cabinNumber) {
		for (Cabin cabin : cabins) {
			if (cabin.getCabinNumber() == cabinNumber) {
				return cabin;
			}
		}
		return null;
	}

	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public List<Cabin> getCabins() {
		return new ArrayList<>(cabins);
	}

	public Itinerary getItinerary() {
		return itinerary;
	}

	public int getTotalCabins() {
		return totalCabins;
	}

	@Override
	public String toString() {
		return String.format("Ship: %s (Capacity: %d, Cabins: %d)", name, capacity, totalCabins);
	}
}