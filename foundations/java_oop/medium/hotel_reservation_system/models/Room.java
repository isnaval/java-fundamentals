package java_oop.medium.hotel_reservation_system.models;

import java.util.ArrayList;
import java.util.List;

import java_oop.medium.hotel_reservation_system.models.enums.RoomStatus;
import java_oop.medium.hotel_reservation_system.models.enums.RoomType;

public class Room {
	private final String roomNumber;
	private RoomType type;
	private RoomStatus status;
	private int floor;
	private List<String> amenities;
	private boolean hasBalcony;
	private boolean hasSeaView;
	private String description;
	private double customPrice;
	private String lastCleanedBy;
	private String currentGuestId;

	public Room(String roomNumber, RoomType type, int floor) {
		this.roomNumber = roomNumber;
		this.type = type;
		this.floor = floor;
		this.status = RoomStatus.AVAILABLE;
		this.amenities = new ArrayList<>();
		this.hasBalcony = false;
		this.hasSeaView = false;
		this.customPrice = -1;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public RoomStatus getStatus() {
		return status;
	}

	public void setStatus(RoomStatus status) {
		this.status = status;
	}

	public int getFloor() {
		return floor;
	}

	public List<String> getAmenities() {
		return new ArrayList<>(amenities);
	}

	public void addAmenity(String amenity) {
		if (!amenities.contains(amenity)) {
			amenities.add(amenity);
		}
	}

	public void removeAmenity(String amenity) {
		amenities.remove(amenity);
	}

	public boolean hasBalcony() {
		return hasBalcony;
	}

	public void setHasBalcony(boolean hasBalcony) {
		this.hasBalcony = hasBalcony;
	}

	public boolean hasSeaView() {
		return hasSeaView;
	}

	public void setHasSeaView(boolean hasSeaView) {
		this.hasSeaView = hasSeaView;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return customPrice > 0 ? customPrice : type.getBasePrice();
	}

	public void setCustomPrice(double customPrice) {
		this.customPrice = customPrice;
	}

	public String getLastCleanedBy() {
		return lastCleanedBy;
	}

	public void setLastCleanedBy(String lastCleanedBy) {
		this.lastCleanedBy = lastCleanedBy;
	}

	public String getCurrentGuestId() {
		return currentGuestId;
	}

	public void setCurrentGuestId(String currentGuestId) {
		this.currentGuestId = currentGuestId;
	}

	public boolean isAvailable() {
		return status == RoomStatus.AVAILABLE;
	}

	public int getMaxOccupancy() {
		return type.getMaxOccupancy();
	}

	@Override
	public String toString() {
		return String.format("Room[number=%s, type=%s, floor=%d, status=%s, price=%.2f]", roomNumber,
				type.getDisplayName(), floor, status.getDisplayName(), getPrice());
	}

}
