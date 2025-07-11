package java_oop.medium.hotel_reservation_system.exceptions;

import java.time.LocalDate;

public class InvalidDateRangeException extends Exception {
	private final LocalDate checkIn;
	private final LocalDate checkOut;

	public InvalidDateRangeException(LocalDate checkIn, LocalDate checkOut, String message) {
		super(String.format("Rango de fechas inválido [%s - %s]: %s", checkIn, checkOut, message));
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}
}