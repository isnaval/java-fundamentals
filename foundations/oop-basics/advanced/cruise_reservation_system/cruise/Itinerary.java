package java_oop.advanced.cruise_reservation_system.cruise;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Itinerary {
	private String cruiseName;
	private String departurePort;
	private String destination;
	private LocalDate startDate;
	private LocalDate endDate;
	private List<String> ports;
	private int duration;

	public Itinerary(String cruiseName, String departurePort, String destination, LocalDate startDate,
			LocalDate endDate) {
		this.cruiseName = cruiseName;
		this.departurePort = departurePort;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.ports = new ArrayList<>();
		this.duration = calculateDuration();

		// Add departure and destination ports
		ports.add(departurePort);
		ports.add(destination);
	}

	private int calculateDuration() {
		return (int) startDate.until(endDate).getDays();
	}

	public void addPort(String port) {
		if (!ports.contains(port)) {
			ports.add(ports.size() - 1, port); // Add before destination
			System.out.printf("🏝️ Added port: %s to itinerary%n", port);
		}
	}

	public void removePort(String port) {
		if (!port.equals(departurePort) && !port.equals(destination)) {
			if (ports.remove(port)) {
				System.out.printf("❌ Removed port: %s from itinerary%n", port);
			}
		} else {
			System.out.println("❌ Cannot remove departure or destination port!");
		}
	}

	public boolean isActive() {
		LocalDate today = LocalDate.now();
		return !today.isAfter(endDate);
	}

	public boolean hasStarted() {
		LocalDate today = LocalDate.now();
		return !today.isBefore(startDate);
	}

	public String getItineraryDetails() {
		StringBuilder details = new StringBuilder();
		details.append("🚢 ").append(cruiseName).append("\n");
		details.append("📅 Duration: ").append(duration).append(" days\n");
		details.append("🗓️ ").append(startDate).append(" to ").append(endDate).append("\n");
		details.append("🏝️ Ports: ");
		for (int i = 0; i < ports.size(); i++) {
			details.append(ports.get(i));
			if (i < ports.size() - 1) {
				details.append(" → ");
			}
		}
		return details.toString();
	}

	public String getCruiseName() {
		return cruiseName;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public String getDestination() {
		return destination;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public List<String> getPorts() {
		return new ArrayList<>(ports);
	}

	public int getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return String.format("%s: %s → %s (%d days)", cruiseName, departurePort, destination, duration);
	}
}
