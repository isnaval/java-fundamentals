package java_core.games.tic_tac_toe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToeGame {

	private static final int BOARD_SIZE = 3;
	private static final String PLAYER_1_TOKEN = "X";
	private static final String PLAYER_2_TOKEN = "O";

	public static void main(String[] args) {
		String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
		Scanner scanner = new Scanner(System.in);

		showIntroduction();
		GameBoard.initializeBoard(board);
		GameBoard.printBoard(board);

		int currentPlayer = 1;

		try {
			while (true) {
				String currentToken = (currentPlayer == 1) ? PLAYER_1_TOKEN : PLAYER_2_TOKEN;

				System.out.println("🎯 Turno del Jugador " + currentPlayer + " (" + currentToken + ")");

				int[] coordinates = getPlayerMove(scanner);
				int row = coordinates[0] - 1; //
				int col = coordinates[1] - 1;

				if (GameBoard.isValidMove(board, row, col)) {
					GameBoard.placeToken(board, row, col, currentToken);
					GameBoard.printBoard(board);

					if (GameBoard.checkWinner(board, currentToken)) {
						throw new VictoriaException("¡El Jugador " + currentPlayer + " ha ganado!");
					}

					if (GameBoard.checkTie(board)) {
						throw new EmpateException("¡Es un empate! El tablero está lleno.");
					}

					currentPlayer = (currentPlayer == 1) ? 2 : 1;

				} else {
					System.out.println("❌ Movimiento inválido. La casilla está ocupada o fuera de rango.");
				}
			}

		} catch (VictoriaException e) {
			System.out.println("\n🎉 " + e.getMessage());

		} catch (EmpateException e) {
			System.out.println("\n🤝 " + e.getMessage());

		} catch (InputMismatchException e) {
			System.out.println("\n❌ Error: Debes ingresar números válidos.");

		} finally {
			System.out.println("¡Gracias por jugar!");
			scanner.close();
		}
	}

	private static void showIntroduction() {
		System.out.println("🎮 =============== TRES EN RAYA =============== 🎮");
		System.out.println("📋 Jugador 1: X  |  Jugador 2: O");
		System.out.println("📍 Ingresa coordenadas (fila, columna) del 1 al 3");
		System.out.println("🏆 ¡Consigue 3 en línea para ganar!");
		System.out.println("===============================================");
	}

	private static int[] getPlayerMove(Scanner scanner) throws InputMismatchException {
		System.out.print("Fila (1-3): ");
		int row = scanner.nextInt();
		System.out.print("Columna (1-3): ");
		int col = scanner.nextInt();

		return new int[] { row, col };
	}

}
