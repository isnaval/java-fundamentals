package fundamentals.games;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

	private static final int MAX_NUMBER = 100;
	private static final int MAX_ATTEMPTS = 50;
	private static final String EASY_MODE = "N";
	private static final String HARD_MODE = "D";

	private final Random random;
	private final Scanner scanner;
	private int targetNumber;
	private int attempts;
	private String gameMode;

	public NumberGuessingGame() {
		this.random = new Random();
		this.scanner = new Scanner(System.in);
		this.attempts = 0;

	}

	public static void main(String[] args) {
		NumberGuessingGame game = new NumberGuessingGame();
		game.playGame();

	}

	private void playGame() {
		showWelcomeMessage();
		selectGameMode();
		initializeGame();

		switch (gameMode) {
		case EASY_MODE:
			playEasyMode();
			break;
		case HARD_MODE:
			playHardMode();
			break;
		default:
			System.out.println("❌ Modo de juego no válido.");
			return;
		}
		scanner.close();
	}

	private void showWelcomeMessage() {
		System.out.println("================================================================");
		System.out.println("        ¡Bienvenido al juego de adivinanza de números!");
		System.out.println("================================================================");
		System.out.println("  🎯 Tienes que adivinar un número entre 0 y " + (MAX_NUMBER - 1));
		System.out.println("  🎮 Tienes " + MAX_ATTEMPTS + " intentos máximo");
		System.out.println("================================================================");
	}

	private void selectGameMode() {
		System.out.println("¿Qué modalidad de juego quieres?");
		System.out.println("[N] Normal - Te diré si es mayor o menor");
		System.out.println("[D] Difícil - Solo te diré qué tan cerca estás");
		System.out.print("Elige tu opción (N/D): ");

		gameMode = scanner.nextLine().trim().toUpperCase();

		while (!gameMode.equals(EASY_MODE) && !gameMode.equals(HARD_MODE)) {
			System.out.println("⚠️  Por favor, ingresa 'N' para Normal o 'D' para Difícil.");
			System.out.print("Elige tu opción (N/D): ");
			gameMode = scanner.nextLine().trim().toUpperCase();
		}

	}

	private void playHardMode() {
		System.out.println("🔥 Solo te diré qué tan cerca estás del número.");
		System.out.println("================================================================");

		while (attempts < MAX_ATTEMPTS) {
			int userGuess = getUserInput();
			attempts++;

			int proximity = Math.abs(userGuess - targetNumber);

			if (proximity == 0) {
				showVictoryMessage();
				return;
			} else {
				showProximityFeedback(proximity);
			}

			showAttemptsRemaining();
		}

		showDefeatMessage();
	}

	private void playEasyMode() {
		System.out.println("💡 Te diré si el número es mayor o menor que tu intento.");
		System.out.println("================================================================");

		while (attempts < MAX_ATTEMPTS) {
			int userGuess = getUserInput();
			attempts++;

			if (userGuess == targetNumber) {
				showVictoryMessage();
				return;
			} else if (userGuess < targetNumber) {
				System.out.println("📈 El número es más grande. Intenta de nuevo.");
			} else {
				System.out.println("📉 El número es más pequeño. Intenta de nuevo.");
			}

			showAttemptsRemaining();
		}

		showDefeatMessage();

	}

	private void initializeGame() {
		targetNumber = random.nextInt(MAX_NUMBER);
		attempts = 0;

		String modeName = gameMode.equals(EASY_MODE) ? "NORMAL" : "DIFÍCIL";
		System.out.println("\n🎮 MODO DE JUEGO: " + modeName);
		System.out.println("================================================================");
	}

	private int getUserInput() {
		while (true) {
			System.out.print("🔢 Intento " + (attempts + 1) + "/" + MAX_ATTEMPTS + " - Ingresa un número (0-"
					+ (MAX_NUMBER - 1) + "): ");

			try {
				String input = scanner.nextLine().trim();
				int number = Integer.parseInt(input);

				if (number >= 0 && number < MAX_NUMBER) {
					return number;
				} else {
					System.out.println("⚠️  El número debe estar entre 0 y " + (MAX_NUMBER - 1) + ".");
				}
			} catch (NumberFormatException e) {
				System.out.println("⚠️  Por favor, ingresa un número válido.");
			}
		}
	}

	private void showProximityFeedback(int proximity) {
		if (proximity <= 2) {
			System.out.println("🔥 ¡ARDIENDO! Estás MUY MUY cerca");
		} else if (proximity <= 5) {
			System.out.println("🌡️  ¡CALIENTE! Estás MUY cerca");
		} else if (proximity <= 10) {
			System.out.println("☀️  Tibio... Estás cerca");
		} else if (proximity <= 20) {
			System.out.println("🌤️  Fresco. Estás un poco lejos");
		} else {
			System.out.println("❄️  Frío. Estás lejos");
		}
	}

	private void showAttemptsRemaining() {
		int remaining = MAX_ATTEMPTS - attempts;
		if (remaining <= 5 && remaining > 0) {
			System.out.println("⏰ ¡Cuidado! Solo te quedan " + remaining + " intentos.");
		}
		System.out.println();
	}

	private void showVictoryMessage() {
		System.out.println("\n🎉 ¡FELICIDADES! ¡Has adivinado el número!");
		System.out.println("🎯 El número era: " + targetNumber);
		System.out.println("💪 Lo lograste en " + attempts + " intentos.");
	}

	private void showDefeatMessage() {
		System.out.println("\n😔 ¡Se acabaron los intentos!");
		System.out.println("🔍 El número correcto era: " + targetNumber);
	}

}
