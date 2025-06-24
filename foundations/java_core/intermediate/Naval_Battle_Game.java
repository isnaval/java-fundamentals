package java_core.intermediate;

import java.util.Random;
import java.util.Scanner;

public class Naval_Battle_Game {

	private static final int BOARD_SIZE = 6;
	private static final int SHIPS_PER_TEAM = 3;
	private static final char WATER = '~';
	private static final char SHIP = 'B';
	private static final char HIT = 'X';
	private static final char MISS = 'O';

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("🚢 ¡Bienvenido a la Batalla Naval! 🚢");
		System.out.println("Tres equipos compiten para hundir los barcos enemigos\n");

		char[][] oceanTeam1 = createOceanTeam1();
		char[][] oceanTeam2 = createRandomOcean();
		char[][] oceanTeam3 = createOceanTeam3();

		int shipsTeam1 = SHIPS_PER_TEAM;
		int shipsTeam2 = SHIPS_PER_TEAM;
		int shipsTeam3 = SHIPS_PER_TEAM;

		displayInitialBoards();
		int round = 1;

		while (shipsTeam1 > 0 && shipsTeam2 > 0 && shipsTeam3 > 0) {
			System.out.println("\n🎯 ===== RONDA " + round + " =====");

			if (shipsTeam1 > 0 && shipsTeam2 > 0) {
				System.out.println("\n⚓ Turno Equipo 1 - Ataque a Equipo 2:");
				if (performAttack(scanner, oceanTeam2, "Equipo 1", "Equipo 2")) {
					shipsTeam2--;
					System.out.println("💥 ¡IMPACTO! Barcos restantes Equipo 2: " + shipsTeam2);
				} else {
					System.out.println("💦 Agua... ¡Fallaste!");
				}
				displayBoard(oceanTeam2, "Equipo 2", false);
			}

			if (shipsTeam2 == 0)
				break;

			if (shipsTeam2 > 0 && shipsTeam3 > 0) {
				System.out.println("\n⚓ Turno Equipo 2 - Ataque a Equipo 3:");
				if (performAttack(scanner, oceanTeam3, "Equipo 2", "Equipo 3")) {
					shipsTeam3--;
					System.out.println("💥 ¡IMPACTO! Barcos restantes Equipo 3: " + shipsTeam3);
				} else {
					System.out.println("💦 Agua... ¡Fallaste!");
				}
				displayBoard(oceanTeam3, "Equipo 3", false);
			}

			if (shipsTeam3 == 0)
				break;

			if (shipsTeam3 > 0 && shipsTeam1 > 0) {
				System.out.println("\n⚓ Turno Equipo 3 - Ataque a Equipo 1:");
				if (performAttack(scanner, oceanTeam1, "Equipo 3", "Equipo 1")) {
					shipsTeam1--;
					System.out.println("💥 ¡IMPACTO! Barcos restantes Equipo 1: " + shipsTeam1);
				} else {
					System.out.println("💦 Agua... ¡Fallaste!");
				}
				displayBoard(oceanTeam1, "Equipo 1", false);
			}

			round++;

		}
		announceWinner(shipsTeam1, shipsTeam2, shipsTeam3);
		scanner.close();
	}

	// ======================================================

	public static void displayInitialBoards() {
		System.out.println("🌊 ===== OCÉANOS INICIALES =====");
		System.out.println("(Los barcos enemigos están ocultos)\n");

		for (int team = 1; team <= 3; team++) {
			System.out.println("🌊 Océano Equipo " + team + ":");
			displayWaterOnly();
		}
	}

	public static void displayWaterOnly() {
		System.out.print("   ");
		for (int j = 1; j <= BOARD_SIZE; j++) {
			System.out.print(" " + j + " ");
		}
		System.out.println();

		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print((i + 1) + "  ");
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(" " + WATER + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// ======================================================

	public static char[][] createOceanTeam1() {
		char[][] ocean = new char[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				ocean[i][j] = WATER;
			}
		}
		ocean[2][0] = SHIP;
		ocean[3][1] = SHIP;
		ocean[5][3] = SHIP;

		return ocean;
	}

	public static char[][] createOceanTeam3() {
		char[][] ocean = new char[BOARD_SIZE][BOARD_SIZE];

		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				ocean[i][j] = WATER;
			}
		}

		ocean[3][5] = SHIP;
		ocean[4][3] = SHIP;
		ocean[1][2] = SHIP;

		return ocean;
	}

	public static char[][] createRandomOcean() {
		char[][] ocean = new char[BOARD_SIZE][BOARD_SIZE];
		Random random = new Random();
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				ocean[i][j] = WATER;
			}
		}

		int shipsPlaced = 0;
		while (shipsPlaced < SHIPS_PER_TEAM) {
			int row = random.nextInt(BOARD_SIZE);
			int col = random.nextInt(BOARD_SIZE);

			if (ocean[row][col] == WATER) {
				ocean[row][col] = SHIP;
				shipsPlaced++;
			}
		}

		return ocean;
	}

	// ======================================================

	public static boolean performAttack(Scanner scanner, char[][] targetOcean, String attackerTeam, String targetTeam) {
		System.out.println("🎯 " + attackerTeam + ", selecciona coordenadas para atacar a " + targetTeam + ":");

		int row = getValidCoordinate(scanner, "FILA", BOARD_SIZE);
		int col = getValidCoordinate(scanner, "COLUMNA", BOARD_SIZE);

		// Verificar si ya se atacó esta posición
		if (targetOcean[row][col] == HIT || targetOcean[row][col] == MISS) {
			System.out.println("⚠️ ¡Ya atacaste esta posición! Pierdes el turno.");
			return false;
		}

		// Verificar si hay un barco
		if (targetOcean[row][col] == SHIP) {
			targetOcean[row][col] = HIT;
			return true;
		} else {
			targetOcean[row][col] = MISS;
			return false;
		}
	}

	// ======================================================
	public static int getValidCoordinate(Scanner scanner, String axis, int max) {
		int coord;
		boolean valid = false;

		do {
			System.out.print("Coordenada " + axis + " (1-" + max + "): ");
			if (scanner.hasNextInt()) {
				coord = scanner.nextInt();
				if (coord >= 1 && coord <= max) {
					valid = true;
				} else {
					System.out.println("❌ Error: Coordenada debe estar entre 1 y " + max);
				}
			} else {
				System.out.println("❌ Error: Debes introducir un número");
				scanner.next();
				coord = 0;
			}
		} while (!valid);

		return coord - 1;
	}
	// ======================================================

	public static void displayBoard(char[][] ocean, String teamName, boolean showShips) {
		System.out.println("🌊 Océano " + teamName + " (después del ataque):");
		System.out.print("   ");
		for (int j = 1; j <= BOARD_SIZE; j++) {
			System.out.print(" " + j + " ");
		}
		System.out.println();

		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print((i + 1) + "  ");
			for (int j = 0; j < BOARD_SIZE; j++) {
				char cell = ocean[i][j];

				if (!showShips && cell == SHIP) {
					System.out.print(" " + WATER + " ");
				} else {
					System.out.print(" " + cell + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	// ======================================================

	// ======================================================

	public static void announceWinner(int shipsTeam1, int shipsTeam2, int shipsTeam3) {
		System.out.println("\n🎉 ===== FIN DE LA BATALLA NAVAL =====");

		if (shipsTeam1 > 0 && shipsTeam2 == 0 && shipsTeam3 == 0) {
			System.out.println("🏆 ¡El EQUIPO 1 ha ganado la batalla naval!");
		} else if (shipsTeam2 > 0 && shipsTeam1 == 0 && shipsTeam3 == 0) {
			System.out.println("🏆 ¡El EQUIPO 2 ha ganado la batalla naval!");
		} else if (shipsTeam3 > 0 && shipsTeam1 == 0 && shipsTeam2 == 0) {
			System.out.println("🏆 ¡El EQUIPO 3 ha ganado la batalla naval!");
		} else if (shipsTeam1 > 0 && (shipsTeam2 == 0 || shipsTeam3 == 0)) {
			System.out.println("🏆 ¡El EQUIPO 1 ha ganado la batalla naval!");
		} else if (shipsTeam2 > 0 && (shipsTeam1 == 0 || shipsTeam3 == 0)) {
			System.out.println("🏆 ¡El EQUIPO 2 ha ganado la batalla naval!");
		} else if (shipsTeam3 > 0 && (shipsTeam1 == 0 || shipsTeam2 == 0)) {
			System.out.println("🏆 ¡El EQUIPO 3 ha ganado la batalla naval!");
		} else {
			System.out.println("🤝 ¡La batalla naval ha terminado en empate!");
		}

		System.out.println("\n📊 Estadísticas finales:");
		System.out.println("⚓ Equipo 1: " + shipsTeam1 + " barcos restantes");
		System.out.println("⚓ Equipo 2: " + shipsTeam2 + " barcos restantes");
		System.out.println("⚓ Equipo 3: " + shipsTeam3 + " barcos restantes");
		System.out.println("\n🌊 ¡Gracias por jugar a la Batalla Naval! 🌊");
	}
}
