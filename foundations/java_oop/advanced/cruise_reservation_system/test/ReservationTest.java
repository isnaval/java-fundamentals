package java_oop.advanced.cruise_reservation_system.test;

import java.time.LocalDate;

import java_oop.advanced.cruise_reservation_system.cruise.CabinType;
import java_oop.advanced.cruise_reservation_system.cruise.CruiseShip;
import java_oop.advanced.cruise_reservation_system.cruise.Itinerary;
import java_oop.advanced.cruise_reservation_system.passengers.Passenger;
import java_oop.advanced.cruise_reservation_system.reservation.PaymentProcessor;
import java_oop.advanced.cruise_reservation_system.reservation.Reservation;
import java_oop.advanced.cruise_reservation_system.reservation.ReservationSystem;

public class ReservationTest {
	public static void runTests() {
		System.out.println("🧪 EJECUTANDO PRUEBAS DE RESERVAS");
		System.out.println("================================");

		// Setup
		CruiseShip ship = new CruiseShip("Test Ship", 50);
		Itinerary itinerary = new Itinerary("Test Cruise", "Test Port", "Test Destination",
				LocalDate.now().plusDays(30), LocalDate.now().plusDays(37));
		ship.setItinerary(itinerary);

		ReservationSystem system = new ReservationSystem();
		Passenger passenger = new Passenger("Test User", "test@email.com", "12345678", 30, "+34600000000");

		// Test 1: Crear reserva
		String reservationId = system.createReservation(ship);
		assert reservationId != null : "No se pudo crear la reserva";
		assert reservationId.startsWith("RES") : "ID de reserva con formato incorrecto";

		// Test 2: Agregar pasajero
		boolean added = system.addPassengerToReservation(reservationId, passenger);
		assert added : "No se pudo agregar el pasajero a la reserva";

		// Test 3: Asignar cabina
		boolean assigned = system.assignCabinToReservation(reservationId, CabinType.INTERIOR);
		assert assigned : "No se pudo asignar la cabina";

		// Test 4: Confirmar reserva
		boolean confirmed = system.confirmReservation(reservationId, PaymentProcessor.PaymentMethod.CREDIT_CARD,
				"1234567890123456");
		assert confirmed : "No se pudo confirmar la reserva";

		Reservation reservation = system.getReservation(reservationId);
		assert reservation.getStatus() == Reservation.ReservationStatus.CONFIRMED : "Estado de reserva incorrecto";

		System.out.println("✅ Todas las pruebas de reservas pasaron");
	}

	public static void main(String[] args) {
		CruiseShipTest.runTests();
		PassengerTest.runTests();
		ReservationTest.runTests();

		System.out.println("\n🎉 ¡TODAS LAS PRUEBAS COMPLETADAS EXITOSAMENTE! 🎉");
	}
}