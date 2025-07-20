package fundamentals.games;

import java.util.Random;
import java.util.Scanner;

public class TreasureHuntGame {
	public static final int GRID_SIZE = 5;
	public static final int MAX_ATTEMPTS = 15;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] board = new String[GRID_SIZE][GRID_SIZE];

		initializeBoard(board);

		Random random = new Random();
		int treasureRow = random.nextInt(GRID_SIZE) + 1;
		int treasureColumn = random.nextInt(GRID_SIZE) + 1;

		System.out.println("=== BÚSQUEDA DEL TESORO ===");
		System.out.println("Encuentra el tesoro en " + MAX_ATTEMPTS + " intentos");
		System.out.println("Coordenadas del 1 al " + GRID_SIZE);

		displayBoard(board);

		for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
			System.out.println("\nIntento " + attempt + " de " + MAX_ATTEMPTS);

			System.out.print("Fila (1-" + GRID_SIZE + "): ");
			int guessRow = scanner.nextInt();
			System.out.print("Columna (1-" + GRID_SIZE + "): ");
			int guessColumn = scanner.nextInt();

			if (guessRow < 1 || guessRow > GRID_SIZE || guessColumn < 1 || guessColumn > GRID_SIZE) {
				System.out.println("❌ Coordenadas inválidas");
				attempt--;
				continue;
			}

			if (treasureRow == guessRow && treasureColumn == guessColumn) {
				System.out.println("\n🎉 ¡Has encontrado el tesoro!");
				break;
			} else {
				board[guessRow - 1][guessColumn - 1] = "X";
				System.out.println("❌ Fallaste. Sigue buscando...");
				displayBoard(board);

				if (attempt == MAX_ATTEMPTS) {
					System.out.println("\n💀 ¡Se acabaron los intentos!");
					System.out.println("El tesoro estaba en: " + treasureRow + "," + treasureColumn);
				}
			}
		}

		scanner.close();

	}

	private static void initializeBoard(String[][] board) {
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				board[i][j] = "?";
			}
		}
	}

	private static void displayBoard(String[][] board) {
		System.out.println("\nTablero:");
		for (int i = 0; i < GRID_SIZE; i++) {
			for (int j = 0; j < GRID_SIZE; j++) {
				System.out.print("[" + board[i][j] + "] ");
			}
			System.out.println();
		}
	}
}
