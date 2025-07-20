package fundamentals.games;

import java.util.Scanner;

public class CarRaceGame {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("=".repeat(40));
		System.out.println("JUEGO DE CARRERAS");
		System.out.println("=".repeat(40));
		while (true) {
			System.out.println("\n1.Jugar carrera");
			System.out.println("2. Carrera manual");
			System.out.println("0. Salir");
			System.out.println("Opcion: ");
			int option = scanner.nextInt();

			switch (option) {
			case 1:
				jugarCarrera();
				break;
			case 2:
				carreraManual();
				break;
			case 0:
				System.out.println("Adios! ");
				return;
			default:
				System.out.println("Opcion invalida");

			}
		}
	}

	static void jugarCarrera() {
		System.out.println("\n🏁 CARRERA 🏁");

		String[] autos = { "🚗 Auto 1", "🚙 Auto 2", "🚘 Auto 3" };
		int[] posicion = { 0, 0, 0 };
		int meta = 10;

		System.out.println("Meta: " + meta + " puntos\n");

		while (true) {
			for (int i = 0; i < 3; i++) {
				int avance = (int) (Math.random() * 3) + 1;
				posicion[i] += avance;
			}

			for (int i = 0; i < 3; i++) {
				System.out.println(autos[i] + ": " + posicion[i] + " puntos");
			}
			System.out.println("---");

			for (int i = 0; i < 3; i++) {
				if (posicion[i] >= meta) {
					System.out.println("🏆 ¡GANADOR: " + autos[i] + "! 🏆");
					return;
				}
			}

			try {
				Thread.sleep(1500);
			} catch (Exception e) {
			}
		}
	}

	static void carreraManual() {
		System.out.println("\n🏁 CARRERA MANUAL 🏁");
		System.out.println("¡Presiona ENTER para avanzar!");

		String[] autos = { "🚗 TU AUTO", "🚙 Rival" };
		int[] posicion = { 0, 0 };
		int meta = 8;

		scanner.nextLine();

		while (true) {
			System.out.println("\nPresiona ENTER:");
			scanner.nextLine();
			posicion[0] += (int) (Math.random() * 3) + 1;
			posicion[1] += (int) (Math.random() * 3) + 1;
			System.out.println(autos[0] + ": " + posicion[0]);
			System.out.println(autos[1] + ": " + posicion[1]);
			if (posicion[0] >= meta && posicion[1] >= meta) {
				if (posicion[0] > posicion[1]) {
					System.out.println("🏆 ¡GANASTE! 🏆");
				} else if (posicion[1] > posicion[0]) {
					System.out.println("😔 ¡Perdiste!");
				} else {
					System.out.println("🤝 ¡Empate!");
				}
				return;
			} else if (posicion[0] >= meta) {
				System.out.println("🏆 ¡GANASTE! 🏆");
				return;
			} else if (posicion[1] >= meta) {
				System.out.println("😔 ¡Perdiste!");
				return;
			}
		}
	}

}
