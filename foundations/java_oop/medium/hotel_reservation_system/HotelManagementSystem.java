package java_oop.medium.hotel_reservation_system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java_oop.medium.hotel_reservation_system.exceptions.ReservationNotFoundException;
import java_oop.medium.hotel_reservation_system.exceptions.RoomNotAvailableException;
import java_oop.medium.hotel_reservation_system.models.Guest;
import java_oop.medium.hotel_reservation_system.models.Reservation;
import java_oop.medium.hotel_reservation_system.models.Room;
import java_oop.medium.hotel_reservation_system.models.enums.RoomStatus;
import java_oop.medium.hotel_reservation_system.models.enums.RoomType;
import java_oop.medium.hotel_reservation_system.repositories.GuestRepository;
import java_oop.medium.hotel_reservation_system.repositories.ReservationRepository;
import java_oop.medium.hotel_reservation_system.repositories.RoomRepository;
import java_oop.medium.hotel_reservation_system.services.ReservationService;
import java_oop.medium.hotel_reservation_system.services.RoomService;
import java_oop.medium.hotel_reservation_system.utils.PriceCalculator;

public class HotelManagementSystem {
	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final ReservationRepository reservationRepository;
	private final RoomService roomService;
	private final ReservationService reservationService;
	private final Scanner scanner;
	private final DateTimeFormatter dateFormatter;

	public HotelManagementSystem() {
		this.roomRepository = new RoomRepository();
		this.guestRepository = new GuestRepository();
		this.reservationRepository = new ReservationRepository();
		this.roomService = new RoomService(roomRepository, reservationRepository);
		this.reservationService = new ReservationService(reservationRepository, roomRepository, guestRepository,
				roomService);
		this.scanner = new Scanner(System.in);
		this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		initializeRooms();
	}

	private void initializeRooms() {
		// Piso 1 - Habitaciones estándar
		roomService.createRoom("101", RoomType.SINGLE, 1);
		roomService.createRoom("102", RoomType.SINGLE, 1);
		roomService.createRoom("103", RoomType.DOUBLE, 1);
		roomService.createRoom("104", RoomType.DOUBLE, 1);
		roomService.createRoom("105", RoomType.TWIN, 1);

		// Piso 2 - Habitaciones superiores
		roomService.createRoom("201", RoomType.DOUBLE, 2);
		roomService.createRoom("202", RoomType.JUNIOR_SUITE, 2);
		roomService.createRoom("203", RoomType.JUNIOR_SUITE, 2);
		roomService.createRoom("204", RoomType.FAMILY, 2);

		// Piso 3 - Suites
		roomService.createRoom("301", RoomType.SUITE, 3);
		roomService.createRoom("302", RoomType.SUITE, 3);
		roomService.createRoom("303", RoomType.PRESIDENTIAL_SUITE, 3);

		// Añadir características especiales
		Room room301 = roomRepository.findById("301").get();
		room301.setHasBalcony(true);
		room301.setHasSeaView(true);
		roomRepository.save(room301);

		Room room303 = roomRepository.findById("303").get();
		room303.setHasBalcony(true);
		room303.setHasSeaView(true);
		room303.addAmenity("Jacuzzi");
		room303.addAmenity("Sala de estar");
		room303.addAmenity("Cocina");
		roomRepository.save(room303);
	}

	public void run() {
		System.out.println("=== SISTEMA DE GESTIÓN HOTELERA ===");

		while (true) {
			showMainMenu();
			int option = getIntInput("Seleccione una opción: ");

			try {
				switch (option) {
				case 1:
					manageReservations();
					break;
				case 2:
					manageGuests();
					break;
				case 3:
					manageRooms();
					break;
				case 4:
					showReports();
					break;
				case 5:
					checkInCheckOut();
					break;
				case 0:
					System.out.println("¡Hasta luego!");
					return;
				default:
					System.out.println("Opción no válida");
				}
			} catch (Exception e) {
				System.err.println("Error: " + e.getMessage());
			}

			System.out.println("\nPresione Enter para continuar...");
			scanner.nextLine();
		}
	}

	private void showMainMenu() {
		System.out.println("\n=== MENÚ PRINCIPAL ===");
		System.out.println("1. Gestión de Reservas");
		System.out.println("2. Gestión de Huéspedes");
		System.out.println("3. Gestión de Habitaciones");
		System.out.println("4. Reportes");
		System.out.println("5. Check-in/Check-out");
		System.out.println("0. Salir");
	}

	private void manageReservations() throws Exception {
		System.out.println("\n=== GESTIÓN DE RESERVAS ===");
		System.out.println("1. Nueva reserva");
		System.out.println("2. Ver reserva");
		System.out.println("3. Cancelar reserva");
		System.out.println("4. Listar reservas activas");
		System.out.println("0. Volver");

		int option = getIntInput("Seleccione una opción: ");

		switch (option) {
		case 1:
			createNewReservation();
			break;
		case 2:
			viewReservation();
			break;
		case 3:
			cancelReservation();
			break;
		case 4:
			listActiveReservations();
			break;
		}
	}

	private void createNewReservation() throws Exception {
		System.out.println("\n=== NUEVA RESERVA ===");

		// Buscar o crear huésped
		System.out.print("Email del huésped: ");
		String email = scanner.nextLine();

		Guest guest = guestRepository.findByEmail(email).orElse(null);
		if (guest == null) {
			System.out.println("Huésped no encontrado. Creando nuevo huésped...");
			System.out.print("Nombre: ");
			String firstName = scanner.nextLine();
			System.out.print("Apellido: ");
			String lastName = scanner.nextLine();
			System.out.print("Teléfono: ");
			String phone = scanner.nextLine();
			System.out.print("Documento (DNI/Pasaporte): ");
			String document = scanner.nextLine();

			guest = new Guest(firstName, lastName, email, phone, document);
			guestRepository.save(guest);
			System.out.println("Huésped creado exitosamente");
		} else {
			System.out.println("Huésped encontrado: " + guest.getFullName());
		}

		// Fechas
		System.out.print("Fecha de entrada (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(scanner.nextLine(), dateFormatter);
		System.out.print("Fecha de salida (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(scanner.nextLine(), dateFormatter);

		// Mostrar habitaciones disponibles
		List<Room> availableRooms = roomService.findAvailableRooms(checkIn, checkOut);
		if (availableRooms.isEmpty()) {
			System.out.println("No hay habitaciones disponibles para esas fechas");
			return;
		}

		System.out.println("\nHabitaciones disponibles:");
		for (Room room : availableRooms) {
			System.out.printf("%s - %s (Piso %d) - €%.2f/noche - Capacidad: %d%n", room.getRoomNumber(),
					room.getType().getDisplayName(), room.getFloor(), room.getPrice(), room.getMaxOccupancy());
		}

		// Seleccionar habitaciones
		List<String> selectedRooms = new ArrayList<>();
		System.out.print("¿Cuántas habitaciones desea reservar? ");
		int numRooms = getIntInput("");

		for (int i = 0; i < numRooms; i++) {
			System.out.print("Número de habitación " + (i + 1) + ": ");
			selectedRooms.add(scanner.nextLine());
		}

		System.out.print("Número de huéspedes: ");
		int numGuests = getIntInput("");

		// Crear reserva
		Reservation reservation = reservationService.createReservation(guest.getId(), selectedRooms, checkIn, checkOut,
				numGuests);

		System.out.println("\n¡Reserva creada exitosamente!");
		System.out.println("ID de reserva: " + reservation.getId());
		System.out.printf("Precio total: €%.2f%n", reservation.getTotalPrice());
		System.out.printf("Depósito requerido: €%.2f%n", reservation.getDeposit());

		// Confirmar reserva
		System.out.print("¿Confirmar reserva? (S/N): ");
		if (scanner.nextLine().equalsIgnoreCase("S")) {
			reservationService.confirmReservation(reservation.getId());
			System.out.println("Reserva confirmada");
		}
	}

	private void viewReservation() throws ReservationNotFoundException {
		System.out.print("ID de reserva: ");
		String reservationId = scanner.nextLine();

		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ReservationNotFoundException(reservationId));

		Guest guest = guestRepository.findById(reservation.getGuestId()).orElse(null);

		System.out.println("\n=== DETALLES DE LA RESERVA ===");
		System.out.println("ID: " + reservation.getId());
		System.out.println("Huésped: " + (guest != null ? guest.getFullName() : "Desconocido"));
		System.out.println("Habitaciones: " + String.join(", ", reservation.getRoomNumbers()));
		System.out.println("Check-in: " + reservation.getCheckInDate().format(dateFormatter));
		System.out.println("Check-out: " + reservation.getCheckOutDate().format(dateFormatter));
		System.out.println("Número de noches: " + reservation.getNumberOfNights());
		System.out.println("Número de huéspedes: " + reservation.getNumberOfGuests());
		System.out.println("Estado: " + reservation.getStatus().getDisplayName());
		System.out.printf("Precio total: €%.2f%n", reservation.getTotalPrice());
		System.out.printf("Depósito: €%.2f%n", reservation.getDeposit());
		System.out.printf("Saldo pendiente: €%.2f%n", reservation.getBalance());
	}

	private void cancelReservation() throws ReservationNotFoundException {
		System.out.print("ID de reserva a cancelar: ");
		String reservationId = scanner.nextLine();
		System.out.print("Motivo de cancelación: ");
		String reason = scanner.nextLine();

		reservationService.cancelReservation(reservationId, reason);
		System.out.println("Reserva cancelada exitosamente");
	}

	private void listActiveReservations() {
		List<Reservation> activeReservations = reservationRepository.findActiveReservations();

		if (activeReservations.isEmpty()) {
			System.out.println("No hay reservas activas");
			return;
		}

		System.out.println("\n=== RESERVAS ACTIVAS ===");
		for (Reservation reservation : activeReservations) {
			Guest guest = guestRepository.findById(reservation.getGuestId()).orElse(null);
			System.out.printf("%s | %s | %s | %s a %s | %s%n", reservation.getId().substring(0, 8),
					guest != null ? guest.getFullName() : "Desconocido",
					String.join(", ", reservation.getRoomNumbers()), reservation.getCheckInDate().format(dateFormatter),
					reservation.getCheckOutDate().format(dateFormatter), reservation.getStatus().getDisplayName());
		}
	}

	private void manageGuests() {
		System.out.println("\n=== GESTIÓN DE HUÉSPEDES ===");
		System.out.println("1. Buscar huésped");
		System.out.println("2. Listar huéspedes VIP");
		System.out.println("3. Historial de huésped");
		System.out.println("0. Volver");

		int option = getIntInput("Seleccione una opción: ");

		switch (option) {
		case 1:
			searchGuest();
			break;
		case 2:
			listVipGuests();
			break;
		case 3:
			showGuestHistory();
			break;
		}
	}

	private void searchGuest() {
		System.out.print("Buscar por email o documento: ");
		String search = scanner.nextLine();

		Guest guest = guestRepository.findByEmail(search).or(() -> guestRepository.findByDocument(search)).orElse(null);

		if (guest == null) {
			System.out.println("Huésped no encontrado");
			return;
		}

		System.out.println("\n=== INFORMACIÓN DEL HUÉSPED ===");
		System.out.println("Nombre: " + guest.getFullName());
		System.out.println("Email: " + guest.getEmail());
		System.out.println("Teléfono: " + guest.getPhoneNumber());
		System.out.println("Documento: " + guest.getDocumentId());
		System.out.println("VIP: " + (guest.isVip() ? "Sí" : "No"));
		System.out.println("Puntos de lealtad: " + guest.getLoyaltyPoints());
		System.out.println("Fecha de registro: " + guest.getRegistrationDate().format(dateFormatter));
	}

	private void listVipGuests() {
		List<Guest> vipGuests = guestRepository.findVipGuests();

		if (vipGuests.isEmpty()) {
			System.out.println("No hay huéspedes VIP");
			return;
		}

		System.out.println("\n=== HUÉSPEDES VIP ===");
		for (Guest guest : vipGuests) {
			System.out.printf("%s | %s | %d puntos%n", guest.getFullName(), guest.getEmail(), guest.getLoyaltyPoints());
		}
	}

	private void showGuestHistory() {
		System.out.print("Email del huésped: ");
		String email = scanner.nextLine();

		Guest guest = guestRepository.findByEmail(email).orElse(null);
		if (guest == null) {
			System.out.println("Huésped no encontrado");
			return;
		}

		List<Reservation> history = reservationService.getGuestHistory(guest.getId());

		System.out.println("\n=== HISTORIAL DE " + guest.getFullName().toUpperCase() + " ===");
		for (Reservation reservation : history) {
			System.out.printf("%s | %s a %s | %s | €%.2f%n", reservation.getId().substring(0, 8),
					reservation.getCheckInDate().format(dateFormatter),
					reservation.getCheckOutDate().format(dateFormatter), reservation.getStatus().getDisplayName(),
					reservation.getTotalPrice());
		}
	}

	private void manageRooms() {
		System.out.println("\n=== GESTIÓN DE HABITACIONES ===");
		System.out.println("1. Ver estado de habitaciones");
		System.out.println("2. Cambiar estado de habitación");
		System.out.println("3. Marcar habitación como limpia");
		System.out.println("0. Volver");

		int option = getIntInput("Seleccione una opción: ");

		switch (option) {
		case 1:
			showRoomStatus();
			break;
		case 2:
			changeRoomStatus();
			break;
		case 3:
			markRoomAsClean();
			break;
		}
	}

	private void showRoomStatus() {
		System.out.println("\n=== ESTADO DE HABITACIONES ===");

		List<Room> rooms = roomRepository.findAll();
		rooms.sort(Comparator.comparing(Room::getRoomNumber));

		for (Room room : rooms) {
			System.out.printf("%s | %s | Piso %d | %s | €%.2f%n", room.getRoomNumber(), room.getType().getDisplayName(),
					room.getFloor(), room.getStatus().getDisplayName(), room.getPrice());
		}

		System.out.println("\n=== RESUMEN ===");
		Map<RoomStatus, Long> statusCount = roomService.getRoomCountByStatus();
		for (Map.Entry<RoomStatus, Long> entry : statusCount.entrySet()) {
			System.out.printf("%s: %d%n", entry.getKey().getDisplayName(), entry.getValue());
		}
		System.out.printf("Tasa de ocupación: %.1f%%%n", roomService.getOccupancyRate());
	}

	private void changeRoomStatus() {
		System.out.print("Número de habitación: ");
		String roomNumber = scanner.nextLine();

		System.out.println("Estados disponibles:");
		for (int i = 0; i < RoomStatus.values().length; i++) {
			System.out.printf("%d. %s%n", i + 1, RoomStatus.values()[i].getDisplayName());
		}

		int statusIndex = getIntInput("Seleccione el nuevo estado: ") - 1;
		if (statusIndex < 0 || statusIndex >= RoomStatus.values().length) {
			System.out.println("Estado no válido");
			return;
		}

		try {
			roomService.updateRoomStatus(roomNumber, RoomStatus.values()[statusIndex]);
			System.out.println("Estado actualizado exitosamente");
		} catch (RoomNotAvailableException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private void markRoomAsClean() {
		System.out.print("Número de habitación: ");
		String roomNumber = scanner.nextLine();
		System.out.print("Nombre del personal de limpieza: ");
		String cleanedBy = scanner.nextLine();

		try {
			roomService.markRoomAsClean(roomNumber, cleanedBy);
			System.out.println("Habitación marcada como limpia");
		} catch (RoomNotAvailableException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private void showReports() {
		System.out.println("\n=== REPORTES ===");
		System.out.println("1. Ingresos por período");
		System.out.println("2. Ocupación por tipo de habitación");
		System.out.println("3. Reservas del día");
		System.out.println("0. Volver");

		int option = getIntInput("Seleccione una opción: ");

		switch (option) {
		case 1:
			showRevenueReport();
			break;
		case 2:
			showOccupancyByType();
			break;
		case 3:
			showTodayReservations();
			break;
		}
	}

	private void showRevenueReport() {
		System.out.print("Fecha inicio (dd/MM/yyyy): ");
		LocalDate startDate = LocalDate.parse(scanner.nextLine(), dateFormatter);
		System.out.print("Fecha fin (dd/MM/yyyy): ");
		LocalDate endDate = LocalDate.parse(scanner.nextLine(), dateFormatter);

		Map<LocalDate, Double> revenue = reservationService.getRevenueByDate(startDate, endDate);

		System.out.println("\n=== INGRESOS POR DÍA ===");
		double total = 0;
		for (Map.Entry<LocalDate, Double> entry : revenue.entrySet()) {
			System.out.printf("%s: €%.2f%n", entry.getKey().format(dateFormatter), entry.getValue());
			total += entry.getValue();
		}
		System.out.printf("\nTOTAL: €%.2f%n", total);
	}

	private void showOccupancyByType() {
		System.out.println("\n=== OCUPACIÓN POR TIPO ===");
		Map<RoomType, Long> roomsByType = roomService.getRoomCountByType();

		for (Map.Entry<RoomType, Long> entry : roomsByType.entrySet()) {
			System.out.printf("%s: %d habitaciones%n", entry.getKey().getDisplayName(), entry.getValue());
		}
	}

	private void showTodayReservations() {
		System.out.println("\n=== RESERVAS DE HOY ===");

		List<Reservation> checkIns = reservationService.getTodayCheckIns();
		System.out.println("\nCheck-ins pendientes: " + checkIns.size());
		for (Reservation reservation : checkIns) {
			Guest guest = guestRepository.findById(reservation.getGuestId()).orElse(null);
			System.out.printf("- %s | %s | Habitaciones: %s%n", reservation.getId().substring(0, 8),
					guest != null ? guest.getFullName() : "Desconocido",
					String.join(", ", reservation.getRoomNumbers()));
		}

		List<Reservation> checkOuts = reservationService.getTodayCheckOuts();
		System.out.println("\nCheck-outs pendientes: " + checkOuts.size());
		for (Reservation reservation : checkOuts) {
			Guest guest = guestRepository.findById(reservation.getGuestId()).orElse(null);
			System.out.printf("- %s | %s | Habitaciones: %s%n", reservation.getId().substring(0, 8),
					guest != null ? guest.getFullName() : "Desconocido",
					String.join(", ", reservation.getRoomNumbers()));
		}
	}

	private void checkInCheckOut() {
		System.out.println("\n=== CHECK-IN / CHECK-OUT ===");
		System.out.println("1. Realizar Check-in");
		System.out.println("2. Realizar Check-out");
		System.out.println("0. Volver");

		int option = getIntInput("Seleccione una opción: ");

		try {
			switch (option) {
			case 1:
				performCheckIn();
				break;
			case 2:
				performCheckOut();
				break;
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private void performCheckIn() throws Exception {
		System.out.print("ID de reserva: ");
		String reservationId = scanner.nextLine();

		reservationService.checkIn(reservationId);
		System.out.println("Check-in realizado exitosamente");
	}

	private void performCheckOut() throws Exception {
		System.out.print("ID de reserva: ");
		String reservationId = scanner.nextLine();

		reservationService.checkOut(reservationId);

		Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
		if (reservation != null) {
			System.out.println("Check-out realizado exitosamente");
			System.out.printf("Balance pendiente: €%.2f%n", reservation.getBalance());

			Guest guest = guestRepository.findById(reservation.getGuestId()).orElse(null);
			if (guest != null) {
				System.out.printf("Puntos de lealtad ganados: %.0f%n",
						PriceCalculator.calculateLoyaltyPoints(reservation.getTotalPrice()));
				System.out.printf("Total de puntos: %d%n", guest.getLoyaltyPoints());
			}
		}
	}

	private int getIntInput(String prompt) {
		while (true) {
			try {
				System.out.print(prompt);
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Por favor, ingrese un número válido");
			}
		}
	}

	public static void main(String[] args) {
		new HotelManagementSystem().run();
	}
}