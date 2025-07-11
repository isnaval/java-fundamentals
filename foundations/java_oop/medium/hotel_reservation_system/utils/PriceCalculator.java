package java_oop.medium.hotel_reservation_system.utils;

import java.time.LocalDate;
import java.util.List;

import java_oop.medium.hotel_reservation_system.models.Guest;
import java_oop.medium.hotel_reservation_system.models.Room;

public class PriceCalculator {

	private static final double WEEKEND_SURCHARGE = 1.2;
	private static final double HIGH_SEASON_SURCHARGE = 1.5;
	private static final double VIP_DISCOUNT = 0.9;
	private static final double LONG_STAY_DISCOUNT = 0.85;
	private static final double EARLY_BOOKING_DISCOUNT = 0.95;

	private PriceCalculator() {
	}

	public static double calculateTotalPrice(List<Room> rooms, LocalDate checkIn, LocalDate checkOut, Guest guest) {
		long nights = DateValidator.calculateNights(checkIn, checkOut);
		double totalPrice = 0.0;

		for (Room room : rooms) {
			double roomTotal = calculateRoomPrice(room, checkIn, checkOut);
			totalPrice += roomTotal;
		}

		if (guest != null && guest.isVip()) {
			totalPrice *= VIP_DISCOUNT;
		}

		if (nights > 7) {
			totalPrice *= LONG_STAY_DISCOUNT;
		}

		if (checkIn.isAfter(LocalDate.now().plusDays(30))) {
			totalPrice *= EARLY_BOOKING_DISCOUNT;
		}

		return Math.round(totalPrice * 100.0) / 100.0;
	}

	public static double calculateRoomPrice(Room room, LocalDate checkIn, LocalDate checkOut) {
		double totalPrice = 0.0;
		LocalDate currentDate = checkIn;

		while (currentDate.isBefore(checkOut)) {
			double nightPrice = room.getPrice();

			if (DateValidator.isWeekend(currentDate)) {
				nightPrice *= WEEKEND_SURCHARGE;
			}

			if (DateValidator.isHighSeason(currentDate)) {
				nightPrice *= HIGH_SEASON_SURCHARGE;
			}

			totalPrice += nightPrice;
			currentDate = currentDate.plusDays(1);
		}

		return totalPrice;
	}

	public static double calculateDeposit(double totalPrice) {
		return Math.round(totalPrice * 0.3 * 100.0) / 100.0;
	}

	public static double calculateCancellationFee(double totalPrice, LocalDate cancellationDate,
			LocalDate checkInDate) {
		long daysBeforeCheckIn = DateValidator.calculateNights(cancellationDate, checkInDate);

		if (daysBeforeCheckIn >= 7) {
			return 0.0;
		} else if (daysBeforeCheckIn >= 3) {
			return totalPrice * 0.25;
		} else if (daysBeforeCheckIn >= 1) {
			return totalPrice * 0.5;
		} else {
			return totalPrice;
		}
	}

	public static double calculateLoyaltyPoints(double totalPrice) {
		return Math.floor(totalPrice / 10);
	}
}