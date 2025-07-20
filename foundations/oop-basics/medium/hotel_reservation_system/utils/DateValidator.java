package java_oop.medium.hotel_reservation_system.utils;

import java.time.LocalDate;

import java_oop.medium.hotel_reservation_system.exceptions.InvalidDateRangeException;

public class DateValidator {

	private DateValidator() {
	}

	public static void validateReservationDates(LocalDate checkIn, LocalDate checkOut)
			throws InvalidDateRangeException {
		if (checkIn == null || checkOut == null) {
			throw new InvalidDateRangeException(checkIn, checkOut, "Las fechas no pueden ser nulas");
		}

		LocalDate today = LocalDate.now();

		if (checkIn.isBefore(today)) {
			throw new InvalidDateRangeException(checkIn, checkOut, "La fecha de check-in no puede ser en el pasado");
		}

		if (checkOut.isBefore(checkIn)) {
			throw new InvalidDateRangeException(checkIn, checkOut,
					"La fecha de check-out debe ser posterior al check-in");
		}

		if (checkIn.equals(checkOut)) {
			throw new InvalidDateRangeException(checkIn, checkOut, "La estancia mínima es de una noche");
		}

		if (checkIn.isAfter(today.plusYears(1))) {
			throw new InvalidDateRangeException(checkIn, checkOut,
					"No se pueden hacer reservas con más de un año de anticipación");
		}

		if (checkIn.plusDays(30).isBefore(checkOut)) {
			throw new InvalidDateRangeException(checkIn, checkOut, "La estancia máxima es de 30 noches");
		}
	}

	public static boolean isDateRangeOverlapping(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
		return !end1.isBefore(start2) && !end2.isBefore(start1);
	}

	public static long calculateNights(LocalDate checkIn, LocalDate checkOut) {
		return checkOut.toEpochDay() - checkIn.toEpochDay();
	}

	public static boolean isWeekend(LocalDate date) {
		return date.getDayOfWeek().getValue() >= 6;
	}

	public static boolean isHighSeason(LocalDate date) {
		int month = date.getMonthValue();
		return month == 7 || month == 8 || month == 12;
	}

}
