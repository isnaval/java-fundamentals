package exceptions.custom_exceptions;

import java.util.List;

public class FlightReservationMain {

	public static void main(String[] args) {
		FlightRepository repository = new FlightRepository();
		ReservationService service = new ReservationService(repository);

		try {
			System.out.println("Vuelos Disponibles:");
			List<Flight> flights = service.listAllFlights();
			for (Flight flight : flights) {
				System.out.println(flight);
			}
			System.out.println();

			System.out.println("Creando reservas...");
			Reservation res1 = service.createReservation("IB101", "Alice Smith");
			System.out.println("Reserva creada: " + res1);
			Reservation res2 = service.createReservation("RY202", "Bob Johnson");
			System.out.println("Reserva creada: " + res2);
			Reservation res3 = service.createReservation("IB101", "Charlie Brown");
			System.out.println("Reserva creada: " + res3);
			System.out.println();

			System.out.println("Reservas para Alice Smith:");
			List<Reservation> aliceReservations = service.listPassengerReservations("Alice Smith");
			for (Reservation res : aliceReservations) {
				System.out.println(res);
			}
			System.out.println();

			System.out.println("Cancelando reserva: " + res1.getId());
			service.cancelReservation(res1.getId());
			System.out.println("Reserva cancelada exitosamente.");
			System.out.println();

			System.out.println("Vuelos disponibles después de la cancelación:");
			flights = service.listAllFlights();
			for (Flight flight : flights) {
				System.out.println(flight);
			}
			System.out.println();

			System.out.println("Intentando reservar un vuelo inexistente...");
			service.createReservation("XX999", "David Wilson");
		} catch (FlightNotAvailableException e) {
			System.out.println("Error: " + e.getMessage() + " (Código de vuelo: " + e.getFlightCode() + ")");
		} catch (ReservationNotFoundException e) {
			System.out.println("Error: " + e.getMessage() + " (ID de reserva: " + e.getIdentifier() + ")");
		}

		try {
			System.out.println("\nIntentando cancelar una reserva inexistente...");
			service.cancelReservation("NON_EXISTENT_ID");
		} catch (ReservationNotFoundException e) {
			System.out.println("Error: " + e.getMessage() + " (ID de reserva: " + e.getIdentifier() + ")");
		}
	}
}