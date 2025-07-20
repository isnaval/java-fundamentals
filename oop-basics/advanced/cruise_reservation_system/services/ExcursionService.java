package java_oop.advanced.cruise_reservation_system.services;

import java.util.ArrayList;
import java.util.List;

public class ExcursionService {
	private List<Excursion> excursions;
	private List<ExcursionBooking> bookings;

	public ExcursionService() {
		this.excursions = new ArrayList<>();
		this.bookings = new ArrayList<>();
		initializeExcursions();
	}

	private void initializeExcursions() {
		excursions.add(new Excursion("City Walking Tour", "Historical", 3, 25.0, 30));
		excursions.add(new Excursion("Snorkeling Adventure", "Water Sports", 4, 65.0, 20));
		excursions.add(new Excursion("Museum Visit", "Cultural", 2, 20.0, 40));
		excursions.add(new Excursion("Beach Day", "Relaxation", 6, 15.0, 50));
		excursions.add(new Excursion("Helicopter Tour", "Adventure", 1, 150.0, 8));
	}

	public boolean bookExcursion(String passengerName, String excursionName, int participants) {
		Excursion excursion = findExcursion(excursionName);
		if (excursion != null && excursion.hasAvailability(participants)) {
			ExcursionBooking booking = new ExcursionBooking(passengerName, excursionName, participants);
			bookings.add(booking);
			excursion.bookSpots(participants);
			System.out.printf("🏝️ Excursion booked: %s for %s (%d participants)%n", excursionName, passengerName,
					participants);
			return true;
		}
		System.out.printf("❌ Unable to book excursion: %s%n", excursionName);
		return false;
	}

	private Excursion findExcursion(String name) {
		for (Excursion excursion : excursions) {
			if (excursion.getName().equals(name)) {
				return excursion;
			}
		}
		return null;
	}

	public List<Excursion> getExcursions() {
		return new ArrayList<>(excursions);
	}

	public List<ExcursionBooking> getBookings() {
		return new ArrayList<>(bookings);
	}

	// Inner classes
	public static class Excursion {
		private String name;
		private String category;
		private int durationHours;
		private double pricePerPerson;
		private int maxParticipants;
		private int availableSpots;

		public Excursion(String name, String category, int durationHours, double pricePerPerson, int maxParticipants) {
			this.name = name;
			this.category = category;
			this.durationHours = durationHours;
			this.pricePerPerson = pricePerPerson;
			this.maxParticipants = maxParticipants;
			this.availableSpots = maxParticipants;
		}

		public boolean hasAvailability(int participants) {
			return availableSpots >= participants;
		}

		public void bookSpots(int participants) {
			availableSpots -= participants;
		}

		public String getName() {
			return name;
		}

		public String getCategory() {
			return category;
		}

		public int getDurationHours() {
			return durationHours;
		}

		public double getPricePerPerson() {
			return pricePerPerson;
		}

		public int getAvailableSpots() {
			return availableSpots;
		}

		@Override
		public String toString() {
			return String.format("%s (%s) - %dh, €%.2f/person - %d/%d spots available", name, category, durationHours,
					pricePerPerson, availableSpots, maxParticipants);
		}
	}

	public static class ExcursionBooking {
		private String passengerName;
		private String excursionName;
		private int participants;
		private double totalCost;

		public ExcursionBooking(String passengerName, String excursionName, int participants) {
			this.passengerName = passengerName;
			this.excursionName = excursionName;
			this.participants = participants;
		}

		public String getPassengerName() {
			return passengerName;
		}

		public String getExcursionName() {
			return excursionName;
		}

		public int getParticipants() {
			return participants;
		}

		public double getTotalCost() {
			return totalCost;
		}

		@Override
		public String toString() {
			return String.format("Excursion Booking: %s - %s (%d participants)", passengerName, excursionName,
					participants);
		}
	}
}