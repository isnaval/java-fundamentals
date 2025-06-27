package java_core.games;

import java.util.Random;
import java.util.Scanner;

/**
 */
public class RockPaperScissorsAutomata {

	private static final String[] OPTIONS = { "piedra", "papel", "tijeras" };
	private static final int MAX_ROUNDS = 20;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int player1Wins = 0;
		int player2Wins = 0;
		int ties = 0;

		showWelcome();

		for (int round = 1; round <= MAX_ROUNDS; round++) {
			System.out.print("\nRonda " + round + " - Presiona ENTER para continuar o 'exit' para salir: ");
			String input = scanner.nextLine();

			if (input.equals("exit")) {
				System.out.println("Simulación terminada!");
				break;
			}

			String player1Choice = getRandomChoice(random);
			String player2Choice = getRandomChoice(random);
			String result = determineWinner(player1Choice, player2Choice);

			showRoundResult(round, player1Choice, player2Choice, result);

			if (result.contains("Jugador 1")) {
				player1Wins++;
			} else if (result.contains("Jugador 2")) {
				player2Wins++;
			} else {
				ties++;
			}

			showCurrentStats(player1Wins, player2Wins, ties);

			// pausa
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {

			}
		}

		showFinalResults(player1Wins, player2Wins, ties);
		scanner.close();
	}

	private static void showWelcome() {
		System.out.println("=== PIEDRA, PAPEL O TIJERAS - MODO AUTOMATA ===");
		System.out.println("Observa como dos IAs compiten entre sí!");
		System.out.println("Jugador 1 (IA-Alpha) vs Jugador 2 (IA-Beta)");
		System.out.println("Máximo " + MAX_ROUNDS + " rondas");
		System.out.println("Presiona ENTER para ver cada ronda...");
	}

	private static String getRandomChoice(Random random) {
		return OPTIONS[random.nextInt(3)];
	}

	private static String determineWinner(String choice1, String choice2) {
		if (choice1.equals(choice2)) {
			return "Empate! Ambos eligieron " + choice1;
		}

		boolean player1Wins = false;

		switch (choice1) {
		case "piedra":
			player1Wins = choice2.equals("tijeras");
			break;
		case "papel":
			player1Wins = choice2.equals("piedra");
			break;
		case "tijeras":
			player1Wins = choice2.equals("papel");
			break;
		}

		if (player1Wins) {
			return "Jugador 1 gana! " + choice1 + " vence a " + choice2;
		} else {
			return "Jugador 2 gana! " + choice2 + " vence a " + choice1;
		}
	}

	private static void showRoundResult(int round, String choice1, String choice2, String result) {
		System.out.println("\n" + "=".repeat(40));
		System.out.println("RONDA " + round);
		System.out.println("=".repeat(40));
		System.out.println("IA-Alpha (J1): " + choice1);
		System.out.println("IA-Beta  (J2): " + choice2);
		System.out.println("Resultado: " + result);
	}

	private static void showCurrentStats(int player1Wins, int player2Wins, int ties) {
		System.out.println("\nEstadísticas actuales:");
		System.out.println("IA-Alpha: " + player1Wins + " victorias");
		System.out.println("IA-Beta:  " + player2Wins + " victorias");
		System.out.println("Empates:  " + ties);

		int totalGames = player1Wins + player2Wins + ties;
		if (totalGames > 0) {
			System.out.println("Progreso: " + totalGames + "/" + MAX_ROUNDS + " partidas");
		}
	}

	private static void showFinalResults(int player1Wins, int player2Wins, int ties) {
		System.out.println("\n" + "=".repeat(50));
		System.out.println("RESULTADO FINAL DE LA SIMULACIÓN");
		System.out.println("=".repeat(50));
		System.out.println("IA-Alpha (Jugador 1): " + player1Wins + " victorias");
		System.out.println("IA-Beta  (Jugador 2): " + player2Wins + " victorias");
		System.out.println("Empates: " + ties);

		int totalGames = player1Wins + player2Wins + ties;
		System.out.println("Total de partidas: " + totalGames);

		if (player1Wins > player2Wins) {
			System.out.println("\nGANADOR: IA-Alpha!");
			System.out.println("Diferencia: +" + (player1Wins - player2Wins) + " victorias");
		} else if (player2Wins > player1Wins) {
			System.out.println("\nGANADOR: IA-Beta!");
			System.out.println("Diferencia: +" + (player2Wins - player1Wins) + " victorias");
		} else {
			System.out.println("\nEMPATE PERFECTO! Ambas IAs son igual de buenas!");
		}

		if (totalGames > 0) {
			double alpha_rate = (double) player1Wins / totalGames * 100;
			double beta_rate = (double) player2Wins / totalGames * 100;
			double tie_rate = (double) ties / totalGames * 100;

			System.out.println("\nPorcentajes:");
			System.out.printf("IA-Alpha: %.1f%%\n", alpha_rate);
			System.out.printf("IA-Beta:  %.1f%%\n", beta_rate);
			System.out.printf("Empates:  %.1f%%\n", tie_rate);
		}

		System.out.println("\nGracias por observar la simulación!");
	}
}