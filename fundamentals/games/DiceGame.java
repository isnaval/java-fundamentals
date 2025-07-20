package fundamentals.games;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {

	private static final int MAX_ROUNDS = 10;
	private static final int DOUBLE_BONUS = 10;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int totalScore = 0;
		int maxScore = 0;
		int bestRound = 0;
		int round = 0;

		showWelcome();

		while (round < MAX_ROUNDS) {
			System.out.print("\nRonda " + (round + 1) + " - Presiona ENTER para lanzar o 'exit' para salir: ");
			String input = scanner.nextLine();

			if (input.equals("exit")) {
				break;
			}

			int[] diceResults = rollDice(random);
			int roundScore = calculateScore(diceResults);

			showRoundResults(diceResults, roundScore);

			totalScore += roundScore;
			round++;

			if (roundScore > maxScore) {
				maxScore = roundScore;
				bestRound = round;
			}

			showCurrentStats(totalScore, round);

		}
		showFinalResults(totalScore, maxScore, bestRound, round);
		scanner.close();
	}

	private static void showWelcome() {
		System.out.println("=== JUEGO DE DADOS ===");
		System.out.println("📋 Reglas:");
		System.out.println("   - Lanza dos dados y suma puntos");
		System.out.println("   - Si obtienes dobles: +" + DOUBLE_BONUS + " puntos extra");
		System.out.println("   - Máximo " + MAX_ROUNDS + " rondas");
		System.out.println("   - ¡Consigue la puntuación más alta!");
	}

	private static int[] rollDice(Random random) {
		int dice1 = random.nextInt(6) + 1;
		int dice2 = random.nextInt(6) + 1;
		return new int[] { dice1, dice2 };
	}

	private static int calculateScore(int[] dice) {
		int score = dice[0] + dice[1];

		if (dice[0] == dice[1]) {
			score += DOUBLE_BONUS;
		}

		return score;
	}

	private static void showRoundResults(int[] dice, int score) {
		System.out.println("🎲 Dados: " + dice[0] + " y " + dice[1]);

		if (dice[0] == dice[1]) {
			System.out.println("🎉 ¡DOBLES! +" + DOUBLE_BONUS + " puntos extra");
		}

		System.out.println("📊 Puntos esta ronda: " + score);
	}

	private static void showCurrentStats(int totalScore, int round) {
		System.out.println("💯 Puntos totales: " + totalScore);
		System.out.println("🔄 Rondas jugadas: " + round + "/" + MAX_ROUNDS);
	}

	private static void showFinalResults(int totalScore, int maxScore, int bestRound, int roundsPlayed) {
		System.out.println("\n" + "=".repeat(30));
		System.out.println("🏆 RESULTADO FINAL");
		System.out.println("=".repeat(30));
		System.out.println("📈 Puntuación total: " + totalScore);
		System.out.println("⭐ Mejor ronda: " + maxScore + " puntos (Ronda " + bestRound + ")");
		System.out.println("🎮 Rondas jugadas: " + roundsPlayed + "/" + MAX_ROUNDS);

		if (roundsPlayed > 0) {
			double average = (double) totalScore / roundsPlayed;
			System.out.println("📊 Promedio por ronda: " + String.format("%.1f", average));
		}

		System.out.println("\n¡Gracias por jugar! 🎉");
	}

}
