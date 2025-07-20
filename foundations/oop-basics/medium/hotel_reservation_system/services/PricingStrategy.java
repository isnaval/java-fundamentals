package java_oop.medium.hotel_reservation_system.services;

import java.time.LocalDate;

import java_oop.medium.hotel_reservation_system.models.Guest;
import java_oop.medium.hotel_reservation_system.models.Room;
import java_oop.medium.hotel_reservation_system.models.enums.RoomType;

public class PricingStrategy {
	private static final double PRICE_PER_NIGHT_SINGLE = 80.0;
	private static final double PRICE_PER_NIGHT_DOUBLE = 120.0;
	private static final double PRICE_PER_NIGHT_SUITE = 200.0;
	private static final double LOYALTY_DISCOUNT_RATE = 0.01;

	public double calculatePrice(Room room, LocalDate checkIn, LocalDate checkOut, Guest guest) {
		if (room == null || checkIn == null || checkOut == null || checkIn.isAfter(checkOut)) {
			throw new IllegalArgumentException("Datos de reserva inválidos");
		}

		long nights = checkIn.until(checkOut).getDays();
		if (nights <= 0) {
			throw new IllegalArgumentException("El rango de fechas debe ser válido");
		}

		double basePricePerNight = getBasePricePerNight(room.getType());
		double baseTotal = basePricePerNight * nights;

		double loyaltyDiscount = Math.min(guest.getLoyaltyPoints() * LOYALTY_DISCOUNT_RATE, 0.10) * baseTotal;
		double finalPrice = baseTotal - loyaltyDiscount;

		return Math.max(finalPrice, 0);
	}

	private double getBasePricePerNight(RoomType roomType) {
		switch (roomType) {
		case SINGLE:
			return PRICE_PER_NIGHT_SINGLE;
		case DOUBLE:
			return PRICE_PER_NIGHT_DOUBLE;
		case SUITE:
			return PRICE_PER_NIGHT_SUITE;
		default:
			throw new IllegalArgumentException("Tipo de habitación no soportado: " + roomType);
		}
	}
}