package java_oop.medium.hotel_reservation_system.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java_oop.medium.hotel_reservation_system.exceptions.RoomNotAvailableException;
import java_oop.medium.hotel_reservation_system.models.Reservation;
import java_oop.medium.hotel_reservation_system.models.Room;
import java_oop.medium.hotel_reservation_system.models.enums.RoomStatus;
import java_oop.medium.hotel_reservation_system.models.enums.RoomType;
import java_oop.medium.hotel_reservation_system.repositories.ReservationRepository;
import java_oop.medium.hotel_reservation_system.repositories.RoomRepository;

public class RoomService {
	private final RoomRepository roomRepository;
	private final ReservationRepository reservationRepository;

	public RoomService(RoomRepository roomRepository, ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.reservationRepository = reservationRepository;
	}

	public Room createRoom(String roomNumber, RoomType type, int floor) {
		Room room = new Room(roomNumber, type, floor);
		roomRepository.save(room);
		return room;
	}

	public Optional<Room> findRoom(String roomNumber) {
		return roomRepository.findById(roomNumber);
	}

	public List<Room> findAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
		List<Room> allRooms = roomRepository.findAll();
		List<Room> availableRooms = new ArrayList<>();

		for (Room room : allRooms) {
			if (isRoomAvailable(room.getRoomNumber(), checkIn, checkOut)) {
				availableRooms.add(room);
			}
		}

		return availableRooms;
	}

	public List<Room> findAvailableRoomsByType(RoomType type, LocalDate checkIn, LocalDate checkOut) {
		return findAvailableRooms(checkIn, checkOut).stream().filter(room -> room.getType() == type)
				.collect(Collectors.toList());
	}

	public boolean isRoomAvailable(String roomNumber, LocalDate checkIn, LocalDate checkOut) {
		Optional<Room> roomOpt = roomRepository.findById(roomNumber);
		if (!roomOpt.isPresent()) {
			return false;
		}

		Room room = roomOpt.get();

		if (room.getStatus() != RoomStatus.AVAILABLE && room.getStatus() != RoomStatus.RESERVED) {
			return false;
		}

		List<Reservation> conflicts = reservationRepository.findConflictingReservations(roomNumber, checkIn, checkOut);
		return conflicts.isEmpty();
	}

	public void updateRoomStatus(String roomNumber, RoomStatus newStatus) throws RoomNotAvailableException {
		Room room = roomRepository.findById(roomNumber)
				.orElseThrow(() -> new RoomNotAvailableException(roomNumber, "Habitación no encontrada"));

		room.setStatus(newStatus);
		roomRepository.save(room);
	}

	public void checkInRoom(String roomNumber, String guestId) throws RoomNotAvailableException {
		Room room = roomRepository.findById(roomNumber)
				.orElseThrow(() -> new RoomNotAvailableException(roomNumber, "Habitación no encontrada"));

		if (room.getStatus() != RoomStatus.RESERVED && room.getStatus() != RoomStatus.AVAILABLE) {
			throw new RoomNotAvailableException(roomNumber, "La habitación no está disponible para check-in");
		}

		room.setStatus(RoomStatus.OCCUPIED);
		room.setCurrentGuestId(guestId);
		roomRepository.save(room);
	}

	public void checkOutRoom(String roomNumber) throws RoomNotAvailableException {
		Room room = roomRepository.findById(roomNumber)
				.orElseThrow(() -> new RoomNotAvailableException(roomNumber, "Habitación no encontrada"));

		room.setStatus(RoomStatus.CLEANING);
		room.setCurrentGuestId(null);
		roomRepository.save(room);
	}

	public void markRoomAsClean(String roomNumber, String cleanedBy) throws RoomNotAvailableException {
		Room room = roomRepository.findById(roomNumber)
				.orElseThrow(() -> new RoomNotAvailableException(roomNumber, "Habitación no encontrada"));

		room.setStatus(RoomStatus.AVAILABLE);
		room.setLastCleanedBy(cleanedBy);
		roomRepository.save(room);
	}

	public Map<RoomType, Long> getRoomCountByType() {
		return roomRepository.findAll().stream().collect(Collectors.groupingBy(Room::getType, Collectors.counting()));
	}

	public Map<RoomStatus, Long> getRoomCountByStatus() {
		return roomRepository.findAll().stream().collect(Collectors.groupingBy(Room::getStatus, Collectors.counting()));
	}

	public double getOccupancyRate() {
		long totalRooms = roomRepository.count();
		long occupiedRooms = roomRepository.countByStatus(RoomStatus.OCCUPIED);

		if (totalRooms == 0)
			return 0.0;
		return (double) occupiedRooms / totalRooms * 100;
	}
}