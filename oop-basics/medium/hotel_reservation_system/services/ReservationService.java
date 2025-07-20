package java_oop.medium.hotel_reservation_system.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import java_oop.medium.hotel_reservation_system.exceptions.InvalidDateRangeException;
import java_oop.medium.hotel_reservation_system.exceptions.ReservationNotFoundException;
import java_oop.medium.hotel_reservation_system.exceptions.RoomNotAvailableException;
import java_oop.medium.hotel_reservation_system.models.Guest;
import java_oop.medium.hotel_reservation_system.models.Reservation;
import java_oop.medium.hotel_reservation_system.models.Room;
import java_oop.medium.hotel_reservation_system.models.enums.ReservationStatus;
import java_oop.medium.hotel_reservation_system.models.enums.RoomStatus;
import java_oop.medium.hotel_reservation_system.repositories.GuestRepository;
import java_oop.medium.hotel_reservation_system.repositories.ReservationRepository;
import java_oop.medium.hotel_reservation_system.repositories.RoomRepository;
import java_oop.medium.hotel_reservation_system.utils.DateValidator;
import java_oop.medium.hotel_reservation_system.utils.PriceCalculator;

public class ReservationService {
	private final ReservationRepository reservationRepository;
	private final RoomRepository roomRepository;
	private final GuestRepository guestRepository;
	private final RoomService roomService;

	public ReservationService(ReservationRepository reservationRepository, RoomRepository roomRepository,
			GuestRepository guestRepository, RoomService roomService) {
		this.reservationRepository = reservationRepository;
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.roomService = roomService;
	}

	public Reservation createReservation(String guestId, List<String> roomNumbers, LocalDate checkIn,
			LocalDate checkOut, int numberOfGuests) throws InvalidDateRangeException, RoomNotAvailableException {

		DateValidator.validateReservationDates(checkIn, checkOut);

		Guest guest = guestRepository.findById(guestId)
				.orElseThrow(() -> new IllegalArgumentException("Huésped no encontrado: " + guestId));

		List<Room> rooms = new ArrayList<>();
		for (String roomNumber : roomNumbers) {
			if (!roomService.isRoomAvailable(roomNumber, checkIn, checkOut)) {
				throw new RoomNotAvailableException(roomNumber, "No está disponible para las fechas seleccionadas");
			}
			Room room = roomRepository.findById(roomNumber)
					.orElseThrow(() -> new RoomNotAvailableException(roomNumber, "Habitación no encontrada"));
			rooms.add(room);
		}

		int totalCapacity = rooms.stream().mapToInt(Room::getMaxOccupancy).sum();
		if (numberOfGuests > totalCapacity) {
			throw new IllegalArgumentException("Número de huéspedes excede la capacidad de las habitaciones");
		}

		Reservation reservation = new Reservation(guestId, roomNumbers, checkIn, checkOut, numberOfGuests);

		double totalPrice = PriceCalculator.calculateTotalPrice(rooms, checkIn, checkOut, guest);
		reservation.setTotalPrice(totalPrice);
		reservation.setDeposit(PriceCalculator.calculateDeposit(totalPrice));

		// Guardar reserva
		reservationRepository.save(reservation);

		// Actualizar estado de habitaciones
		for (Room room : rooms) {
			room.setStatus(RoomStatus.RESERVED);
			roomRepository.save(room);
		}

		guest.addReservationId(reservation.getId());
		guestRepository.save(guest);

		return reservation;
	}

	public void confirmReservation(String reservationId) throws ReservationNotFoundException {
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ReservationNotFoundException(reservationId));

		if (reservation.getStatus() != ReservationStatus.PENDING) {
			throw new IllegalStateException("Solo se pueden confirmar reservas pendientes");
		}

		reservation.setStatus(ReservationStatus.CONFIRMED);
		reservationRepository.save(reservation);
	}

	public void checkIn(String reservationId) throws ReservationNotFoundException, RoomNotAvailableException {
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ReservationNotFoundException(reservationId));

		if (reservation.getStatus() != ReservationStatus.CONFIRMED) {
			throw new IllegalStateException("Solo se puede hacer check-in de reservas confirmadas");
		}

		LocalDate today = LocalDate.now();
		if (today.isBefore(reservation.getCheckInDate())) {
			throw new IllegalStateException("Aún no es la fecha de check-in");
		}

		for (String roomNumber : reservation.getRoomNumbers()) {
			roomService.checkInRoom(roomNumber, reservation.getGuestId());
		}

		reservation.setStatus(ReservationStatus.CHECKED_IN);
		reservation.setActualCheckInTime(LocalDateTime.now());
		reservationRepository.save(reservation);
	}

	public void checkOut(String reservationId) throws ReservationNotFoundException, RoomNotAvailableException {
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ReservationNotFoundException(reservationId));

		if (reservation.getStatus() != ReservationStatus.CHECKED_IN) {
			throw new IllegalStateException("Solo se puede hacer check-out de reservas con check-in realizado");
		}

		for (String roomNumber : reservation.getRoomNumbers()) {
			roomService.checkOutRoom(roomNumber);
		}

		reservation.setStatus(ReservationStatus.CHECKED_OUT);
		reservation.setActualCheckOutTime(LocalDateTime.now());
		reservationRepository.save(reservation);

		Guest guest = guestRepository.findById(reservation.getGuestId()).orElse(null);
		if (guest != null) {
			int points = (int) PriceCalculator.calculateLoyaltyPoints(reservation.getTotalPrice());
			guest.addLoyaltyPoints(points);
			guestRepository.save(guest);
		}
	}

	public void cancelReservation(String reservationId, String reason) throws ReservationNotFoundException {
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new ReservationNotFoundException(reservationId));

		if (reservation.getStatus() == ReservationStatus.CHECKED_IN
				|| reservation.getStatus() == ReservationStatus.CHECKED_OUT) {
			throw new IllegalStateException("No se puede cancelar una reserva con check-in realizado");
		}

		for (String roomNumber : reservation.getRoomNumbers()) {
			Room room = roomRepository.findById(roomNumber).orElse(null);
			if (room != null && room.getStatus() == RoomStatus.RESERVED) {
				room.setStatus(RoomStatus.AVAILABLE);
				roomRepository.save(room);
			}
		}

		reservation.setStatus(ReservationStatus.CANCELLED);
		reservation.setCancellationReason(reason);
		reservationRepository.save(reservation);
	}

	public List<Reservation> getTodayCheckIns() {
		return reservationRepository.findByCheckInDate(LocalDate.now()).stream()
				.filter(r -> r.getStatus() == ReservationStatus.CONFIRMED).collect(Collectors.toList());
	}

	public List<Reservation> getTodayCheckOuts() {
		return reservationRepository.findByCheckOutDate(LocalDate.now()).stream()
				.filter(r -> r.getStatus() == ReservationStatus.CHECKED_IN).collect(Collectors.toList());
	}

	public List<Reservation> getGuestHistory(String guestId) {
		return reservationRepository.findByGuest(guestId);
	}

	public Map<LocalDate, Double> getRevenueByDate(LocalDate startDate, LocalDate endDate) {
		Map<LocalDate, Double> revenueMap = new TreeMap<>();

		List<Reservation> reservations = reservationRepository.findByDateRange(startDate, endDate);
		for (Reservation reservation : reservations) {
			if (reservation.getStatus() != ReservationStatus.CANCELLED) {
				LocalDate date = reservation.getCheckInDate();
				revenueMap.merge(date, reservation.getTotalPrice(), Double::sum);
			}
		}

		return revenueMap;
	}
}