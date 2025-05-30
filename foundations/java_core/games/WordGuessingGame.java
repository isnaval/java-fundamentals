package java_core.games;

import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

	final String WORDS[] = { "Antonio", "Carmen", "Pilar", "Juan Carlos", "Gabriel", "Milagros", "Pedro", "Laura",
			"Miguel", "Isabel", "Fernando", "Ana María", "Francisco", "María José", "José Luis", "Dolores", "Alejandro",
			"Esperanza", "Rafael", "Concepción", "Manuel", "Rosario", "David", "Amparo", "Daniel", "Mercedes", "Carlos",
			"Josefa", "Adrián", "Antonia", "Pablo", "Francisca", "Álvaro", "Isabella", "Sergio", "Remedios", "Andrés",
			"Encarnación", "Iván", "Montserrat", "Rubén", "Inmaculada", "Óscar", "Cristina", "Jorge", "Patricia",
			"Víctor", "Marta", "Héctor", "Silvia", "Raúl", "Rosa", "Emilio", "Teresa", "Gonzalo", "Lucía", "Guillermo",
			"Nuria", "Ignacio", "Soledad", "Salvador", "Beatriz", "Tomás", "Ángeles", "Eduardo", "Consuelo", "Lorenzo",
			"Guadalupe", "Ramón", "Asunción" };

	private static final char WILDCARD = '*';
	private static final char EMPTY_CHAR = '-';

	private final Random random;
	private final Scanner scanner;
	private String secretWord;
	private char[] guessWord;
	private int attempts;
	private int maxAttempts;
	private int wildcardsUsed;
	private int maxWildcards;

	public WordGuessingGame() {
		this.random = new Random();
		this.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		WordGuessingGame game = new WordGuessingGame();
		game.playGame();

	}

	private void playGame() {
		initializeGame();
		showWelcomeMessage();

		while (attempts < maxAttempts && !isWordGuessed()) {
			showCurrentState();
			processUserInput();
			attempts++;
		}

		showGameResult();
		scanner.close();

	}

	private void initializeGame() {
		secretWord = WORDS[random.nextInt(WORDS.length)].toLowerCase();
		guessWord = new char[secretWord.length()];
		maxAttempts = secretWord.length() + 1;
		maxWildcards = secretWord.length() / 2;
		attempts = 0;
		wildcardsUsed = 0;

		for (int i = 0; i < secretWord.length(); i++) {
			guessWord[i] = EMPTY_CHAR;
		}
	}

	private void showWelcomeMessage() {
		System.out.println("================================================================");
		System.out.println("  ¡Bienvenido al juego de adivinanza de nombres con comodines!");
		System.out.println("================================================================");
		System.out.println("               La palabra tiene " + secretWord.length() + " letras.");
		System.out.println("================================================================");
		System.out.println("  - Puedes introducir el * a modo de comodín");
		System.out.println("  - También puedes intentar escribir la palabra completa");
		System.out.println("  - Tienes " + maxWildcards + " comodines disponibles");
		System.out.println("================================================================");
	}

	private void showCurrentState() {
		System.out.println("\n Palabra actual: " + String.valueOf(guessWord));
		System.out.println("Intento " + (attempts + 1) + " / " + maxAttempts + " | Comodines restantes: "
				+ (maxWildcards - wildcardsUsed));
		System.out.println("Ingresa una letra, '*' para comodín, o la palabra completa: ");
	}

	private void processUserInput() {
		String input = scanner.nextLine().trim().toLowerCase();

		if (input.isEmpty()) {
			System.out.println("⚠️  Debes ingresar algo. Intenta de nuevo.");
			attempts--;
			return;
		}

		if (input.length() > 1) {
			if (input.equals(secretWord)) {
				for (int i = 0; i < secretWord.length(); i++) {
					guessWord[i] = secretWord.charAt(i);
				}
				System.out.println("🎉 ¡PERFECTO! Has adivinado la palabra completa: " + secretWord.toUpperCase());
				return;
			} else {
				System.out.println("❌ '" + input + "' no es la palabra correcta.");
				return;
			}
		}

		char guess = input.charAt(0);

		if (guess == WILDCARD) {
			useWildcard();
		} else if (Character.isLetter(guess)) {
			processLetterGuess(guess);
		} else {
			System.out.println("⚠️  Solo se permiten letras o '*' para comodín.");
		}

	}

	private void useWildcard() {
		if (wildcardsUsed >= maxWildcards) {
			System.out.println("❌ Ya has usado todos tus comodines.");
			return;
		}

		int[] hiddenPositions = getHiddenPositions();

		if (hiddenPositions.length == 0) {
			System.out.println("⚠️  No hay letras ocultas para revelar.");
			return;
		}

		int randomIndex = hiddenPositions[random.nextInt(hiddenPositions.length)];
		guessWord[randomIndex] = secretWord.charAt(randomIndex);
		wildcardsUsed++;

		System.out.println("✨ ¡Comodín usado! Se reveló una letra.");
	}

	private int[] getHiddenPositions() {
		int count = 0;
		for (int i = 0; i < guessWord.length; i++) {
			if (guessWord[i] == EMPTY_CHAR) {
				count++;
			}
		}

		int[] positions = new int[count];
		int index = 0;
		for (int i = 0; i < guessWord.length; i++) {
			if (guessWord[i] == EMPTY_CHAR) {
				positions[index++] = i;
			}
		}

		return positions;
	}

	private void processLetterGuess(char guess) {
		boolean letterFound = false;

		for (int i = 0; i < secretWord.length(); i++) {
			if (secretWord.charAt(i) == guess) {
				guessWord[i] = guess;
				letterFound = true;
			}
		}

		if (letterFound) {
			System.out.println("✅ ¡Correcto! La letra '" + guess + "' está en la palabra.");
		} else {
			System.out.println("❌ La letra '" + guess + "' no está en la palabra.");
		}
	}

	private boolean isWordGuessed() {
		return String.valueOf(guessWord).equals(secretWord);
	}

	private void showGameResult() {
		System.out.println("\n" + "=".repeat(50));

		if (isWordGuessed()) {
			System.out.println("🎉 ¡FELICIDADES! Has adivinado la palabra: " + secretWord.toUpperCase());
			System.out.println("💪 Lo lograste en " + (attempts) + " intentos.");
		} else {
			System.out.println("😔 ¡Se acabaron los intentos!");
			System.out.println("🔍 La palabra era: " + secretWord.toUpperCase());
		}

		System.out.println("📊 Estadísticas:");
		System.out.println("   - Intentos utilizados: " + attempts + "/" + maxAttempts);
		System.out.println("   - Comodines utilizados: " + wildcardsUsed + "/" + maxWildcards);
		System.out.println("=".repeat(50));
		System.out.println("¡Gracias por jugar!");
	}
}
