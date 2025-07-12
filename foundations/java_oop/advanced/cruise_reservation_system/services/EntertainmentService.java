package java_oop.advanced.cruise_reservation_system.services;

import java.util.ArrayList;
import java.util.List;

public class EntertainmentService {
	private List<Show> shows;
	private List<Activity> activities;

	public EntertainmentService() {
		this.shows = new ArrayList<>();
		this.activities = new ArrayList<>();
		initializeEntertainment();
	}

	private void initializeEntertainment() {
		shows.add(new Show("Broadway Spectacular", "Theater", "8:00 PM", 500, 0.0));
		shows.add(new Show("Comedy Night", "Comedy Club", "10:00 PM", 100, 0.0));
		shows.add(new Show("Magic Show", "Theater", "6:00 PM", 500, 0.0));
		activities.add(new Activity("Rock Climbing", "Adventure Deck", 20, 15.0));
		activities.add(new Activity("Spa Treatment", "Spa", 10, 80.0));
		activities.add(new Activity("Cooking Class", "Kitchen", 15, 25.0));
		activities.add(new Activity("Pool Games", "Pool Deck", 50, 0.0));
	}

	public boolean bookShow(String passengerName, String showName) {
		Show show = findShow(showName);
		if (show != null && show.hasSeats()) {
			show.bookSeat();
			System.out.printf("🎭 Show booking confirmed: %s for %s%n", showName, passengerName);
			return true;
		}
		System.out.printf("❌ Unable to book show: %s%n", showName);
		return false;
	}

	public boolean bookActivity(String passengerName, String activityName) {
		Activity activity = findActivity(activityName);
		if (activity != null && activity.hasSpots()) {
			activity.bookSpot();
			System.out.printf("🎪 Activity booking confirmed: %s for %s%n", activityName, passengerName);
			return true;
		}
		System.out.printf("❌ Unable to book activity: %s%n", activityName);
		return false;
	}

	private Show findShow(String name) {
		for (Show show : shows) {
			if (show.getName().equals(name)) {
				return show;
			}
		}
		return null;
	}

	private Activity findActivity(String name) {
		for (Activity activity : activities) {
			if (activity.getName().equals(name)) {
				return activity;
			}
		}
		return null;
	}

	public List<Show> getShows() {
		return new ArrayList<>(shows);
	}

	public List<Activity> getActivities() {
		return new ArrayList<>(activities);
	}

	// Inner classes
	public static class Show {
		private String name;
		private String venue;
		private String time;
		private int totalSeats;
		private int availableSeats;
		private double cost;

		public Show(String name, String venue, String time, int totalSeats, double cost) {
			this.name = name;
			this.venue = venue;
			this.time = time;
			this.totalSeats = totalSeats;
			this.availableSeats = totalSeats;
			this.cost = cost;
		}

		public boolean hasSeats() {
			return availableSeats > 0;
		}

		public void bookSeat() {
			availableSeats--;
		}

		public String getName() {
			return name;
		}

		public String getVenue() {
			return venue;
		}

		public String getTime() {
			return time;
		}

		public int getAvailableSeats() {
			return availableSeats;
		}

		public double getCost() {
			return cost;
		}

		@Override
		public String toString() {
			return String.format("%s at %s (%s) - %d/%d seats available", name, venue, time, availableSeats,
					totalSeats);
		}
	}

	public static class Activity {
		private String name;
		private String location;
		private int maxParticipants;
		private int availableSpots;
		private double cost;

		public Activity(String name, String location, int maxParticipants, double cost) {
			this.name = name;
			this.location = location;
			this.maxParticipants = maxParticipants;
			this.availableSpots = maxParticipants;
			this.cost = cost;
		}

		public boolean hasSpots() {
			return availableSpots > 0;
		}

		public void bookSpot() {
			availableSpots--;
		}

		public String getName() {
			return name;
		}

		public String getLocation() {
			return location;
		}

		public int getAvailableSpots() {
			return availableSpots;
		}

		public double getCost() {
			return cost;
		}

		@Override
		public String toString() {
			return String.format("%s at %s - %d/%d spots available (€%.2f)", name, location, availableSpots,
					maxParticipants, cost);
		}
	}
}