package java_oop.advanced.cruise_reservation_system.services;

import java.util.ArrayList;
import java.util.List;

public class DiningService {
	private List<Restaurant> restaurants;
	private List<DiningReservation> diningReservations;

	public DiningService() {
		this.restaurants = new ArrayList<>();
		this.diningReservations = new ArrayList<>();
		initializeRestaurants();
	}

	private void initializeRestaurants() {
		restaurants.add(new Restaurant("Main Dining Room", 200, "Formal", 0.0));
		restaurants.add(new Restaurant("Specialty Steakhouse", 50, "Premium", 35.0));
		restaurants.add(new Restaurant("Sushi Bar", 30, "Premium", 25.0));
		restaurants.add(new Restaurant("Buffet", 150, "Casual", 0.0));
	}

	public boolean makeDiningReservation(String passengerName, String restaurantName, String time, int guests) {
		Restaurant restaurant = findRestaurant(restaurantName);
		if (restaurant != null && restaurant.hasAvailability(guests)) {
			DiningReservation reservation = new DiningReservation(passengerName, restaurantName, time, guests);
			diningReservations.add(reservation);
			restaurant.reduceCapacity(guests);
			System.out.printf("🍽️ Dining reservation confirmed for %s at %s (%s, %d guests)%n", passengerName,
					restaurantName, time, guests);
			return true;
		}
		System.out.printf("❌ Unable to make reservation at %s%n", restaurantName);
		return false;
	}

	private Restaurant findRestaurant(String name) {
		for (Restaurant restaurant : restaurants) {
			if (restaurant.getName().equals(name)) {
				return restaurant;
			}
		}
		return null;
	}

	public List<Restaurant> getRestaurants() {
		return new ArrayList<>(restaurants);
	}

	public List<DiningReservation> getDiningReservations() {
		return new ArrayList<>(diningReservations);
	}

	public static class Restaurant {
		private String name;
		private int capacity;
		private String type;
		private double surcharge;

		public Restaurant(String name, int capacity, String type, double surcharge) {
			this.name = name;
			this.capacity = capacity;
			this.type = type;
			this.surcharge = surcharge;
		}

		public boolean hasAvailability(int guests) {
			return capacity >= guests;
		}

		public void reduceCapacity(int guests) {
			capacity -= guests;
		}

		public String getName() {
			return name;
		}

		public int getCapacity() {
			return capacity;
		}

		public String getType() {
			return type;
		}

		public double getSurcharge() {
			return surcharge;
		}

		@Override
		public String toString() {
			return String.format("%s (%s) - Capacity: %d, Surcharge: €%.2f", name, type, capacity, surcharge);
		}
	}

	public static class DiningReservation {
		private String passengerName;
		private String restaurantName;
		private String time;
		private int guests;

		public DiningReservation(String passengerName, String restaurantName, String time, int guests) {
			this.passengerName = passengerName;
			this.restaurantName = restaurantName;
			this.time = time;
			this.guests = guests;
		}

		public String getPassengerName() {
			return passengerName;
		}

		public String getRestaurantName() {
			return restaurantName;
		}

		public String getTime() {
			return time;
		}

		public int getGuests() {
			return guests;
		}

		@Override
		public String toString() {
			return String.format("Dining: %s at %s (%s, %d guests)", passengerName, restaurantName, time, guests);
		}
	}
}
