package java_oop.medium.hotel_reservation_system.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java_oop.medium.hotel_reservation_system.models.Reservation;
import java_oop.medium.hotel_reservation_system.models.enums.ReservationStatus;

public class ReservationRepository {
	private final Map<String, Reservation> reservations;
	private final Map<String, List<Reservation>> reservationsByGuest;
	private final Map<String, List<Reservation>> reservationsByRoom;

	public ReservationRepository() {
		this.reservations = new HashMap<>();
		this.reservationsByGuest = new HashMap<>();
		this.reservationsByRoom = new HashMap<>();
	}

	public void save(Reservation reservation) {
		reservations.put(reservation.getId(), reservation);

		reservationsByGuest.computeIfAbsent(reservation.getGuestId(), k -> new ArrayList<>()).add(reservation);

		for (String roomNumber : reservation.getRoomNumbers()) {
			reservationsByRoom.computeIfAbsent(roomNumber, k -> new ArrayList<>()).add(reservation);
		}
	}

	public Optional<Reservation> findById(String id) {
		return Optional.ofNullable(reservations.get(id));
	}

	public List<Reservation> findAll() {
		return new ArrayList<>(reservations.values());
	}

	public List<Reservation> findByGuest(String guestId) {
		return reservationsByGuest.getOrDefault(guestId, new ArrayList<>());
	}

	public List<Reservation> findByRoom(String roomNumber) {
		return reservationsByRoom.getOrDefault(roomNumber, new ArrayList<>());
	}

	public List<Reservation> findByStatus(ReservationStatus status) {
		return reservations.values().stream().filter(reservation -> reservation.getStatus() == status)
				.collect(Collectors.toList());
	}

	public List<Reservation> findByDateRange(LocalDate startDate, LocalDate endDate) {
		return reservations.values().stream().filter(reservation -> !reservation.getCheckOutDate().isBefore(startDate)
				&& !reservation.getCheckInDate().isAfter(endDate)).collect(Collectors.toList());
	}

	public List<Reservation> findActiveReservations() {
		return reservations.values().stream().filter(Reservation::isActive).collect(Collectors.toList());
	}

	public List<Reservation> findByCheckInDate(LocalDate date) {
		return reservations.values().stream().filter(reservation -> reservation.getCheckInDate().equals(date))
				.collect(Collectors.toList());
	}

	public List<Reservation> findByCheckOutDate(LocalDate date) {
		return reservations.values().stream().filter(reservation -> reservation.getCheckOutDate().equals(date))
				.collect(Collectors.toList());
	}

	public List<Reservation> findConflictingReservations(String roomNumber, LocalDate checkIn, LocalDate checkOut) {
		return reservationsByRoom.getOrDefault(roomNumber, new ArrayList<>()).stream().filter(Reservation::isActive)
				.filter(reservation -> !reservation.getCheckOutDate().isBefore(checkIn)
						&& !reservation.getCheckInDate().isAfter(checkOut))
				.collect(Collectors.toList());
	}

	public boolean exists(String id) {
		return reservations.containsKey(id);
	}

	public void delete(String id) {
		Reservation reservation = reservations.remove(id);
		if (reservation != null) {
			List<Reservation> guestReservations = reservationsByGuest.get(reservation.getGuestId());
			if (guestReservations != null) {
				guestReservations.remove(reservation);
			}

			for (String roomNumber : reservation.getRoomNumbers()) {
				List<Reservation> roomReservations = reservationsByRoom.get(roomNumber);
				if (roomReservations != null) {
					roomReservations.remove(reservation);
				}
			}
		}
	}

	public int count() {
		return reservations.size();
	}

	public int countByStatus(ReservationStatus status) {
		return (int) reservations.values().stream().filter(reservation -> reservation.getStatus() == status).count();
	}
}