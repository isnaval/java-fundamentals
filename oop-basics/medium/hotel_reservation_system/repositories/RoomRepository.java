package java_oop.medium.hotel_reservation_system.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java_oop.medium.hotel_reservation_system.models.Room;
import java_oop.medium.hotel_reservation_system.models.enums.RoomStatus;
import java_oop.medium.hotel_reservation_system.models.enums.RoomType;

public class RoomRepository {
	private final Map<String, Room> rooms;

	public RoomRepository() {
		this.rooms = new HashMap<>();
	}

	public void save(Room room) {
		rooms.put(room.getRoomNumber(), room);
	}

	public Optional<Room> findById(String roomNumber) {
		return Optional.ofNullable(rooms.get(roomNumber));
	}

	public List<Room> findAll() {
		return new ArrayList<>(rooms.values());
	}

	public List<Room> findByStatus(RoomStatus status) {
		return rooms.values().stream().filter(room -> room.getStatus() == status).collect(Collectors.toList());
	}

	public List<Room> findByType(RoomType type) {
		return rooms.values().stream().filter(room -> room.getType() == type).collect(Collectors.toList());
	}

	public List<Room> findAvailableRooms() {
		return findByStatus(RoomStatus.AVAILABLE);
	}

	public List<Room> findByFloor(int floor) {
		return rooms.values().stream().filter(room -> room.getFloor() == floor).collect(Collectors.toList());
	}

	public List<Room> findByPriceRange(double minPrice, double maxPrice) {
		return rooms.values().stream().filter(room -> room.getPrice() >= minPrice && room.getPrice() <= maxPrice)
				.collect(Collectors.toList());
	}

	public List<Room> findAvailableByTypeAndCapacity(RoomType type, int minCapacity) {
		return rooms.values().stream().filter(room -> room.isAvailable()).filter(room -> room.getType() == type)
				.filter(room -> room.getMaxOccupancy() >= minCapacity).collect(Collectors.toList());
	}

	public boolean exists(String roomNumber) {
		return rooms.containsKey(roomNumber);
	}

	public void delete(String roomNumber) {
		rooms.remove(roomNumber);
	}

	public int count() {
		return rooms.size();
	}

	public int countByStatus(RoomStatus status) {
		return (int) rooms.values().stream().filter(room -> room.getStatus() == status).count();
	}
}