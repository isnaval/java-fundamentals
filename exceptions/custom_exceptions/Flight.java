package exceptions.custom_exceptions;

import java.time.LocalDateTime;

public class Flight {
	private String code;
	private String origin;
	private String destination;
	private LocalDateTime departureTime;
	private int capacity;
	private boolean available;

	public Flight(String code, String origin, String destination, LocalDateTime departureTime, int capacity,
			boolean available) {
		super();
		this.code = code;
		this.origin = origin;
		this.destination = destination;
		this.departureTime = departureTime;
		this.capacity = capacity;
		this.available = available;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDateTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		String status = available ? "✅ Disponible" : "❌ Reservado";
		return String.format("Vuelo %s: %s → %s [%s]", code, origin, destination, status);
	}

}
