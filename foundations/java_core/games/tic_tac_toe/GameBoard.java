package java_core.games.tic_tac_toe;

public class GameBoard {

	private static final int BOARD_SIZE = 3;
	private static final String EMPTY_CELL = "[ ]";

	public static void initializeBoard(String[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = EMPTY_CELL;
			}
		}
	}

	public static void printBoard(String[][] board) {
		System.out.println("\nTablero actual:");
		System.out.println("   1   2   3");

		for (int i = 0; i < BOARD_SIZE; i++) {
			System.out.print((i + 1) + " ");
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(" " + board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void placeToken(String[][] board, int row, int col, String token) {
		board[row][col] = "[" + token + "]";
	}

	public static boolean isValidMove(String[][] board, int row, int col) {
		return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col].equals(EMPTY_CELL);
	}

	public static boolean checkWinner(String[][] board, String token) {
		String targetToken = "[" + token + "]";

		// DEBUG
		System.out.println("=== DEBUG checkWinner ===");
		System.out.println("Token buscado: '" + targetToken + "'");
		System.out.println("Fila 0: '" + board[0][0] + "' '" + board[0][1] + "' '" + board[0][2] + "'");
		System.out.println("¿Son iguales? " + board[0][0].equals(targetToken));
		System.out.println("========================");

		// Verificar filas
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (board[i][0].equals(targetToken) && board[i][1].equals(targetToken) && board[i][2].equals(targetToken)) {
				return true;
			}
		}

		for (int i = 0; i < BOARD_SIZE; i++) {
			if (board[i][0].equals(targetToken) && board[i][1].equals(targetToken) && board[i][2].equals(targetToken)) {
				return true;
			}
		}

		for (int j = 0; j < BOARD_SIZE; j++) {
			if (board[0][j].equals(targetToken) && board[1][j].equals(targetToken) && board[2][j].equals(targetToken)) {
				return true;
			}
		}
		if (board[0][0].equals(targetToken) && board[1][1].equals(targetToken) && board[2][2].equals(targetToken)) {
			return true;
		}
		if (board[0][2].equals(targetToken) && board[1][1].equals(targetToken) && board[2][0].equals(targetToken)) {
			return true;
		}
		return false;

	}

	public static boolean checkTie(String[][] board) {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j].equals(EMPTY_CELL)) {
					return false;
				}
			}
		}
		return true;
	}

}
