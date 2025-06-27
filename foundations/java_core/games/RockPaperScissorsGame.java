package java_core.games;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

	private static final String[] OPTIONS = { "piedra", "papel", "tijeras" };
	private static final int MAX_ROUNDS = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int wins = 0;
		int losses = 0;
		int ties = 0;

		showWelcome();

		for (int round = 1; round <= MAX_ROUNDS; round++) {
			System.out.println("\n" + "=".repeat(25));
			System.out.print("Ronda " + round + " - Tu elección: ");
			String playerChoice = scanner.nextLine().toLowerCase().trim();

			if (playerChoice.equals("exit")) {
				System.out.println("Gracias por jugar!");
				break;
			}

			if (!isValidChoice(playerChoice)) {
				System.out.println("Opción inválida. Usa: piedra, papel, tijeras o 'exit'");
				round--;
				continue;
			}

			String computerChoice = getComputerChoice(random);
			String result = determineWinner(playerChoice, computerChoice);

			showRoundResult(playerChoice, computerChoice, result);

			if (result.contains("Ganaste")) {
				wins++;
			} else if (result.contains("Perdiste")) {
				losses++;
			} else {
				ties++;
			}

			showCurrentStats(wins, losses, ties);
		}

		showFinalResults(wins, losses, ties);
		scanner.close();
	}

	private static void showWelcome() {
		System.out.println("=== PIEDRA, PAPEL O TIJERAS ===");
		System.out.println("Reglas:");
		System.out.println("- Piedra rompe Tijeras");
		System.out.println("- Papel envuelve Piedra");
		System.out.println("- Tijeras cortan Papel");
		System.out.println("\nEscribe: piedra, papel, tijeras o 'exit'");
		System.out.println("Objetivo: Gana más partidas que la computadora!");
	}

	private static boolean isValidChoice(String choice) {
		for (String option : OPTIONS) {
			if (option.equals(choice)) {
				return true;
			}
		}
		return false;
	}

	private static String getComputerChoice(Random random) {
		return OPTIONS[random.nextInt(3)];
	}

	private static String determineWinner(String player, String computer) {
		if (player.equals(computer)) {
			return "Empate! Ambos eligieron " + player;
		}

		switch (player) {
		case "piedra":
			return computer.equals("tijeras") ? "Ganaste! Piedra rompe tijeras" : "Perdiste! Papel envuelve piedra";
		case "papel":
			return computer.equals("piedra") ? "Ganaste! Papel envuelve piedra" : "Perdiste! Tijeras cortan papel";
		case "tijeras":
			return computer.equals("papel") ? "Ganaste! Tijeras cortan papel" : "Perdiste! Piedra rompe tijeras";
		default:
			return "Error en la lógica del juego";
		}
	}

	private static void showRoundResult(String player, String computer, String result) {
		System.out.println("\nResultado de la ronda:");
		System.out.println("Tu elección: " + player);
		System.out.println("Computadora: " + computer);
		System.out.println(result);
	}

	private static void showCurrentStats(int wins, int losses, int ties) {
		System.out.println("\nEstadísticas actuales:");
		System.out.println("Victorias: " + wins);
		System.out.println("Derrotas: " + losses);
		System.out.println("Empates: " + ties);
	}

	private static void showFinalResults(int wins, int losses, int ties) {
		System.out.println("\n" + "=".repeat(30));
		System.out.println("RESULTADO FINAL");
		System.out.println("=".repeat(30));
		System.out.println("Victorias: " + wins);
		System.out.println("Derrotas: " + losses);
		System.out.println("Empates: " + ties);
		System.out.println("Total partidas: " + (wins + losses + ties));

		if (wins > losses) {
			System.out.println("\nFELICIDADES! Ganaste la serie!");
		} else if (losses > wins) {
			System.out.println("\nLa computadora ganó la serie! Inténtalo de nuevo!");
		} else {
			System.out.println("\nSerie empatada! Muy reñido!");
		}

		if (wins + losses + ties > 0) {
			double winRate = (double) wins / (wins + losses + ties) * 100;
			System.out.println("Porcentaje de victorias: " + String.format("%.1f", winRate) + "%");
		}
	}
}