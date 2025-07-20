package fundamentals.games;

import java.util.Scanner;

/**
 * Juego de laberinto simple.
 */
public class MazeGame {

	static int playerRow = 0;
	static int playerCol = 1;

	static char[][] maze = { { '#', 'S', '.', '#', '.', '.', '#', '.', '.', '#' },
			{ '#', '.', '.', '#', '.', '#', '#', '.', '#', '#' }, { '#', '.', '#', '#', '.', '.', '.', '.', '.', '.' },
			{ '#', '.', '.', '.', '#', '#', '#', '#', '#', '.' }, { '#', '#', '#', '.', '.', '.', '.', '.', '#', '.' },
			{ '.', '.', '.', '.', '#', '.', '#', '.', '#', '.' }, { '.', '#', '#', '#', '#', '.', '#', '.', '.', '.' },
			{ '.', '.', '.', '.', '.', '.', '#', '#', '#', '.' }, { '#', '#', '.', '#', '#', '.', '.', '.', '.', '.' },
			{ '#', '.', '.', '.', '#', '#', '#', '.', 'E', '#' } };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== LABERINTO ===");

		while (true) {
			showMaze();

			System.out.print("Movimiento \nw(arriba) -\na(izquierda) -\ns(abajo) -\nd(derecha): ");
			char move = scanner.nextLine().charAt(0);

			movePlayer(move);

			if (maze[playerRow][playerCol] == 'E') {
				System.out.println("¡GANASTE!");
				break;
			}
		}
		scanner.close();
	}

	private static void showMaze() {
		System.out.println("\nPosición: (" + playerRow + "," + playerCol + ")");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (i == playerRow && j == playerCol) {
					System.out.print("P ");
				} else if (maze[i][j] == 'S') {
					System.out.print(". ");
				} else {
					System.out.print(maze[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void movePlayer(char direction) {
		int newRow = playerRow;
		int newCol = playerCol;

		switch (direction) {
		case 'w':
			newRow--;
			break;
		case 's':
			newRow++;
			break;
		case 'a':
			newCol--;
			break;
		case 'd':
			newCol++;
			break;
		default:
			System.out.println("Tecla no válida");
			return;
		}

		if (isValidMove(newRow, newCol)) {
			playerRow = newRow;
			playerCol = newCol;
			System.out.println("Movimiento exitoso");
		} else {
			System.out.println("No puedes moverte ahí");
		}
	}

	private static boolean isValidMove(int row, int col) {
		if (row < 0 || row >= 10 || col < 0 || col >= 10) {
			return false;
		}
		return maze[row][col] != '#';
	}
}