package java_oop.medium.hotel_reservation_system.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import java_oop.medium.hotel_reservation_system.models.Guest;

public class GuestRepository {
	private final Map<String, Guest> guestsByID;
	private final Map<String, Guest> guestsByDocument;
	private final Map<String, Guest> guestsByEmail;

	public GuestRepository() {
		this.guestsByID = new HashMap<>();
		this.guestsByDocument = new HashMap<>();
		this.guestsByEmail = new HashMap<>();
	}

	public void save(Guest guest) {
		guestsByID.put(guest.getId(), guest);
		guestsByDocument.put(guest.getDocumentId(), guest);
		guestsByEmail.put(guest.getEmail().toLowerCase(), guest);
	}

	public Optional<Guest> findById(String id) {
		return Optional.ofNullable(guestsByID.get(id));
	}

	public Optional<Guest> findByDocument(String documentId) {
		return Optional.ofNullable(guestsByDocument.get(documentId));
	}

	public Optional<Guest> findByEmail(String email) {
		return Optional.ofNullable(guestsByEmail.get(email.toLowerCase()));
	}

	public List<Guest> findAll() {
		return new ArrayList<>(guestsByID.values());
	}

	public List<Guest> findByName(String name) {
		String lowerName = name.toLowerCase();
		return guestsByID.values().stream().filter(guest -> guest.getFullName().toLowerCase().contains(lowerName))
				.collect(Collectors.toList());
	}

	public List<Guest> findVipGuests() {
		return guestsByID.values().stream().filter(Guest::isVip).collect(Collectors.toList());
	}

	public List<Guest> findByLoyaltyPointsGreaterThan(int points) {
		return guestsByID.values().stream().filter(guest -> guest.getLoyaltyPoints() > points)
				.collect(Collectors.toList());
	}

	public boolean existsByDocument(String documentId) {
		return guestsByDocument.containsKey(documentId);
	}

	public boolean existsByEmail(String email) {
		return guestsByEmail.containsKey(email.toLowerCase());
	}

	public void delete(String id) {
		Guest guest = guestsByID.remove(id);
		if (guest != null) {
			guestsByDocument.remove(guest.getDocumentId());
			guestsByEmail.remove(guest.getEmail().toLowerCase());
		}
	}

	public int count() {
		return guestsByID.size();
	}

	public int countVipGuests() {
		return (int) guestsByID.values().stream().filter(Guest::isVip).count();
	}
}