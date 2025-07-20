package java_oop.advanced.cruise_reservation_system;

import java.time.LocalDate;
import java.util.List;

import java_oop.advanced.cruise_reservation_system.cruise.Cabin;
import java_oop.advanced.cruise_reservation_system.cruise.CabinType;
import java_oop.advanced.cruise_reservation_system.cruise.CruiseShip;
import java_oop.advanced.cruise_reservation_system.cruise.Itinerary;
import java_oop.advanced.cruise_reservation_system.passengers.GroupPassenger;
import java_oop.advanced.cruise_reservation_system.passengers.Passenger;
import java_oop.advanced.cruise_reservation_system.passengers.VIPPassenger;
import java_oop.advanced.cruise_reservation_system.reservation.PaymentProcessor;
import java_oop.advanced.cruise_reservation_system.reservation.ReservationSystem;
import java_oop.advanced.cruise_reservation_system.services.DiningService;
import java_oop.advanced.cruise_reservation_system.services.EntertainmentService;
import java_oop.advanced.cruise_reservation_system.services.ExcursionService;

public class Main {
	public static void main(String[] args) {
		System.out.println("🚢 BIENVENIDO AL SISTEMA DE RESERVAS DE CRUCERO 🚢");
		System.out.println("==================================================\n");

		// 1. Crear itinerario
		Itinerary itinerary = new Itinerary("Mediterranean Explorer", "Barcelona", "Rome", LocalDate.of(2025, 8, 15),
				LocalDate.of(2025, 8, 22));
		itinerary.addPort("Nice");
		itinerary.addPort("Monaco");
		itinerary.addPort("Florence");

		System.out.println(itinerary.getItineraryDetails());
		System.out.println();

		// 2. Crear crucero
		CruiseShip ship = new CruiseShip("Royal Explorer", 200);
		ship.setItinerary(itinerary);

		System.out.println(ship);
		System.out.println("📊 Cabins available by type:");
		for (CabinType type : CabinType.values()) {
			List<Cabin> cabins = ship.getCabinsByType(type);
			System.out.printf("   %s: %d cabins%n", type, cabins.size());
		}
		System.out.println();

		// 3. Crear sistema de reservas
		ReservationSystem reservationSystem = new ReservationSystem();

		// 4. Crear pasajeros
		Passenger passenger1 = new Passenger("Ana García", "ana@email.com", "12345678A", 35, "+34600123456");
		Passenger passenger2 = new Passenger("Carlos López", "carlos@email.com", "87654321B", 42, "+34600654321");
		VIPPassenger vipPassenger = new VIPPassenger("María Rodríguez", "maria@email.com", "11111111C", 38,
				"+34600111111", "Gold", 15.0);

		// 5. Crear grupo
		GroupPassenger group = new GroupPassenger("Familia García", passenger1);
		group.addMember(passenger2);
		group.addMember(vipPassenger);
		group.addMember(new Passenger("Pedro García", "pedro@email.com", "22222222D", 8, "+34600222222"));
		group.addMember(new Passenger("Lucía García", "lucia@email.com", "33333333E", 12, "+34600333333"));

		System.out.println("👥 PASAJEROS CREADOS:");
		System.out.println(passenger1);
		System.out.println(passenger2);
		System.out.println(vipPassenger);
		System.out.println(group);
		System.out.println();

		// 6. Crear reservas
		String reservationId1 = reservationSystem.createReservation(ship);
		reservationSystem.addPassengerToReservation(reservationId1, passenger1);
		reservationSystem.addPassengerToReservation(reservationId1, passenger2);
		reservationSystem.assignCabinToReservation(reservationId1, CabinType.BALCONY);

		String reservationId2 = reservationSystem.createReservation(ship);
		reservationSystem.addPassengerToReservation(reservationId2, vipPassenger);
		reservationSystem.assignCabinToReservation(reservationId2, CabinType.SUITE);

		System.out.println();

		// 7. Procesar pagos y confirmar reservas
		boolean payment1 = reservationSystem.confirmReservation(reservationId1,
				PaymentProcessor.PaymentMethod.CREDIT_CARD, "1234567890123456");
		boolean payment2 = reservationSystem.confirmReservation(reservationId2,
				PaymentProcessor.PaymentMethod.CREDIT_CARD, "9876543210987654");

		System.out.println();

		// 8. Servicios adicionales
		demonstrateServices(passenger1, vipPassenger);

		// 9. Mostrar resumen final
		reservationSystem.printReservationSummary();

		// 10. Mostrar cabinas ocupadas
		System.out.println("\n🏠 ESTADO DE LAS CABINAS:");
		System.out.println("========================");
		List<Cabin> occupiedCabins = ship.getCabins();
		for (Cabin cabin : occupiedCabins) {
			if (cabin.getOccupancy() > 0) {
				System.out.println(cabin);
				System.out.println("   Ocupantes: " + cabin.getOccupants());
			}
		}

		System.out.println("\n🎉 ¡Demostración completada! ¡Que disfruten su crucero! 🎉");
	}

	private static void demonstrateServices(Passenger passenger1, VIPPassenger vipPassenger) {
		System.out.println("🍽️ SERVICIOS DE RESTAURACIÓN:");
		System.out.println("=============================");

		DiningService diningService = new DiningService();

		// Mostrar restaurantes disponibles
		System.out.println("Restaurantes disponibles:");
		for (DiningService.Restaurant restaurant : diningService.getRestaurants()) {
			System.out.println("   " + restaurant);
		}

		// Hacer reservas de cena
		diningService.makeDiningReservation(passenger1.getName(), "Main Dining Room", "7:00 PM", 2);
		diningService.makeDiningReservation(vipPassenger.getName(), "Specialty Steakhouse", "8:30 PM", 1);

		System.out.println("\n🎭 SERVICIOS DE ENTRETENIMIENTO:");
		System.out.println("===============================");

		EntertainmentService entertainmentService = new EntertainmentService();

		// Mostrar shows disponibles
		System.out.println("Shows disponibles:");
		for (EntertainmentService.Show show : entertainmentService.getShows()) {
			System.out.println("   " + show);
		}

		// Reservar shows
		entertainmentService.bookShow(passenger1.getName(), "Broadway Spectacular");
		entertainmentService.bookShow(vipPassenger.getName(), "Magic Show");

		// Mostrar actividades disponibles
		System.out.println("\nActividades disponibles:");
		for (EntertainmentService.Activity activity : entertainmentService.getActivities()) {
			System.out.println("   " + activity);
		}

		// Reservar actividades
		entertainmentService.bookActivity(passenger1.getName(), "Rock Climbing");
		entertainmentService.bookActivity(vipPassenger.getName(), "Spa Treatment");

		System.out.println("\n🏝️ SERVICIOS DE EXCURSIONES:");
		System.out.println("============================");

		ExcursionService excursionService = new ExcursionService();

		// Mostrar excursiones disponibles
		System.out.println("Excursiones disponibles:");
		for (ExcursionService.Excursion excursion : excursionService.getExcursions()) {
			System.out.println("   " + excursion);
		}

		// Reservar excursiones
		excursionService.bookExcursion(passenger1.getName(), "City Walking Tour", 2);
		excursionService.bookExcursion(vipPassenger.getName(), "Helicopter Tour", 1);

		System.out.println();
	}
}