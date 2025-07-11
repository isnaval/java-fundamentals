package java_oop.medium.hotel_reservation_system.services;

import java_oop.medium.hotel_reservation_system.models.Reservation;
import java_oop.medium.hotel_reservation_system.repositories.ReservationRepository;

public class PaymentService {
	private final ReservationRepository reservationRepository;

	public PaymentService(ReservationRepository reservationRepository) {
		this.reservationRepository = reservationRepository;
	}

	public boolean processDeposit(String reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada: " + reservationId));

		double deposit = reservation.getDeposit();
		if (deposit <= 0) {
			throw new IllegalStateException("No se requiere depósito para esta reserva");
		}

		System.out.println(
				"Depósito de €" + String.format("%.2f", deposit) + " procesado para la reserva " + reservationId);
		reservation.setStatus(reservation.getStatus());
		reservationRepository.save(reservation);
		return true;
	}

	public boolean processFullPayment(String reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada: " + reservationId));

		double remainingAmount = reservation.getTotalPrice() - reservation.getDeposit();
		if (remainingAmount <= 0) {
			throw new IllegalStateException("No queda saldo pendiente para esta reserva");
		}

		System.out.println("Pago completo de €" + String.format("%.2f", remainingAmount) + " procesado para la reserva "
				+ reservationId);
		reservation.setStatus(reservation.getStatus());
		reservationRepository.save(reservation);
		return true;
	}

	public void refundDeposit(String reservationId) {
		Reservation reservation = reservationRepository.findById(reservationId)
				.orElseThrow(() -> new IllegalArgumentException("Reserva no encontrada: " + reservationId));

		if (reservation.getDeposit() <= 0) {
			throw new IllegalStateException("No hay depósito para reembolsar");
		}

		System.out.println("Reembolsando depósito de €" + String.format("%.2f", reservation.getDeposit())
				+ " para la reserva " + reservationId);
		reservation.setDeposit(0);
		reservationRepository.save(reservation);
	}
}