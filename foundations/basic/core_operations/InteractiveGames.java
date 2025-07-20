package basic.core_operations;

import java.util.Random;
import java.util.Scanner;

public class InteractiveGames {
	private static Scanner scanner = MainController.getScanner();
	private static Random random = new Random();

	public static void showGamesMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("        🎮 JUEGOS INTERACTIVOS");
			System.out.println("=".repeat(40));
			System.out.println("1. 🎯 Adivinar número (con pistas)");
			System.out.println("2. 🧮 Desafío matemático");
			System.out.println("3. 🎲 Juego de dados");
			System.out.println("4. 🔢 Secuencia misteriosa");
			System.out.println("5. 📊 Estadísticas de números");
			System.out.println("6. 🎪 Ruleta de la suerte");
			System.out.println("7. 🧩 Rompecabezas numérico");
			System.out.println("0. Volver al menú principal");
			System.out.println("=".repeat(40));
			System.out.print("Selecciona un juego: ");

			int option = MainController.getValidOption(0, 7);

			switch (option) {
			case 1:
				numberGuessingGame();
				break;
			case 2:
				mathChallenge();
				break;
			case 3:
				diceGame();
				break;
			case 4:
				mysterySequence();
				break;
			case 5:
				numberStatistics();
				break;
			case 6:
				luckyWheel();
				break;
			case 7:
				numberPuzzle();
				break;
			case 0:
				return;
			}

			System.out.println("\n¿Quieres jugar otra vez?");
			System.out.print("Presiona Enter para continuar o escribe 'menu' para volver al menú: ");
			scanner.nextLine();
			String input = scanner.nextLine();
			if (input.toLowerCase().contains("menu")) {
				continue;
			}
		}
	}

	private static void numberGuessingGame() {
		System.out.println("\n🎯 ¡ADIVINA EL NÚMERO!");
		System.out.println("Selecciona la dificultad:");
		System.out.println("1. Fácil (1-50, 10 intentos)");
		System.out.println("2. Medio (1-100, 8 intentos)");
		System.out.println("3. Difícil (1-200, 6 intentos)");
		System.out.println("4. Experto (1-500, 5 intentos)");
		System.out.print("Dificultad: ");

		int difficulty = MainController.getValidOption(1, 4);

		int maxNumber, maxAttempts;
		String difficultyName;

		switch (difficulty) {
		case 1:
			maxNumber = 50;
			maxAttempts = 10;
			difficultyName = "Fácil";
			break;
		case 2:
			maxNumber = 100;
			maxAttempts = 8;
			difficultyName = "Medio";
			break;
		case 3:
			maxNumber = 200;
			maxAttempts = 6;
			difficultyName = "Difícil";
			break;
		default:
			maxNumber = 500;
			maxAttempts = 5;
			difficultyName = "Experto";
			break;
		}

		int secretNumber = random.nextInt(maxNumber) + 1;
		int attempts = 0;
		boolean won = false;

		System.out.printf("\n🎮 Nivel: %s\n", difficultyName);
		System.out.printf("🎯 He pensado un número entre 1 y %d\n", maxNumber);
		System.out.printf("🎪 Tienes %d intentos para adivinarlo\n", maxAttempts);
		System.out.println("💡 Te daré pistas para ayudarte\n");

		while (attempts < maxAttempts && !won) {
			attempts++;
			System.out.printf("Intento %d/%d - Ingresa tu número: ", attempts, maxAttempts);
			int guess = scanner.nextInt();

			if (guess == secretNumber) {
				won = true;
				System.out.println("\n🎉 ¡FELICITACIONES! ¡Adivinaste el número!");
				System.out.printf("🏆 Lo lograste en %d intentos\n", attempts);

				if (attempts == 1) {
					System.out.println("⭐ ¡Increíble! ¡Lo adivinaste al primer intento!");
				} else if (attempts <= maxAttempts / 3) {
					System.out.println("⭐ ¡Excelente! Muy pocos intentos.");
				} else if (attempts <= maxAttempts / 2) {
					System.out.println("👍 ¡Buen trabajo!");
				} else {
					System.out.println("✅ ¡Lo lograste! Estuvo cerca.");
				}

			} else {
				int remaining = maxAttempts - attempts;

				if (guess < secretNumber) {
					System.out.printf("📈 El número es MAYOR que %d\n", guess);
				} else {
					System.out.printf("📉 El número es MENOR que %d\n", guess);
				}

				int difference = Math.abs(guess - secretNumber);
				if (difference <= 5) {
					System.out.println("🔥 ¡Estás MUY cerca!");
				} else if (difference <= 15) {
					System.out.println("🎯 Estás cerca...");
				} else if (difference <= 30) {
					System.out.println("🌡️  Tibio...");
				} else {
					System.out.println("❄️  Frío...");
				}

				if (remaining > 0) {
					System.out.printf("⏰ Te quedan %d intentos\n\n", remaining);
				} else {
					System.out.printf("\n💥 ¡Se acabaron los intentos!\n");
					System.out.printf("🎯 El número era: %d\n", secretNumber);
					System.out.println("🎮 ¡Mejor suerte la próxima vez!");
				}
			}
		}
	}

	private static void mathChallenge() {
		System.out.println("\n🧮 ¡DESAFÍO MATEMÁTICO!");
		System.out.println("Resuelve 5 problemas matemáticos:");

		int correctAnswers = 0;
		int totalProblems = 5;

		for (int i = 1; i <= totalProblems; i++) {
			System.out.printf("\n--- Problema %d/%d ---\n", i, totalProblems);

			int problemType = random.nextInt(4) + 1;
			boolean isCorrect = false;

			switch (problemType) {
			case 1:
				isCorrect = solveSumProblem();
				break;
			case 2:
				isCorrect = solveMultiplicationProblem();
				break;
			case 3:
				isCorrect = solveSequenceProblem();
				break;
			case 4:
				isCorrect = solveFactorialProblem();
				break;
			}

			if (isCorrect) {
				correctAnswers++;
				System.out.println("✅ ¡Correcto! +1 punto");
			} else {
				System.out.println("❌ Incorrecto. +0 puntos");
			}
		}

		System.out.println("\n" + "=".repeat(30));
		System.out.println("       🏆 RESULTADOS FINALES");
		System.out.println("=".repeat(30));
		System.out.printf("📊 Respuestas correctas: %d/%d\n", correctAnswers, totalProblems);
		System.out.printf("📊 Porcentaje de acierto: %.1f%%\n", (correctAnswers * 100.0 / totalProblems));

		if (correctAnswers == totalProblems) {
			System.out.println("🏆 ¡PERFECTO! ¡Eres un genio matemático!");
		} else if (correctAnswers >= 4) {
			System.out.println("⭐ ¡Excelente trabajo!");
		} else if (correctAnswers >= 3) {
			System.out.println("👍 ¡Buen desempeño!");
		} else if (correctAnswers >= 2) {
			System.out.println("📚 Necesitas practicar un poco más.");
		} else {
			System.out.println("💪 ¡No te rindas! La práctica hace al maestro.");
		}
	}

	private static void diceGame() {
		System.out.println("\n🎲 ¡JUEGO DE DADOS!");
		System.out.println("Adivina la suma de dos dados (2-12)");

		int points = 100;
		int rounds = 0;

		while (points > 0 && rounds < 10) {
			rounds++;
			System.out.printf("\n--- Ronda %d ---\n", rounds);
			System.out.printf("💰 Puntos actuales: %d\n", points);
			System.out.print("💸 ¿Cuántos puntos quieres apostar? (1-" + Math.min(points, 20) + "): ");

			int bet = MainController.getValidOption(1, Math.min(points, 20));

			System.out.print("🎯 ¿Cuál crees que será la suma de los dos dados? (2-12): ");
			int prediction = MainController.getValidOption(2, 12);

			int dice1 = random.nextInt(6) + 1;
			int dice2 = random.nextInt(6) + 1;
			int sum = dice1 + dice2;

			System.out.printf("\n🎲 Dado 1: %d\n", dice1);
			System.out.printf("🎲 Dado 2: %d\n", dice2);
			System.out.printf("🎯 Suma total: %d\n", sum);

			if (prediction == sum) {
				int winnings = bet * 5;
				points += winnings;
				System.out.printf("🎉 ¡ACERTASTE! Ganaste %d puntos\n", winnings);
			} else {
				points -= bet;
				System.out.printf("❌ Fallaste. Perdiste %d puntos\n", bet);

				int difference = Math.abs(prediction - sum);
				if (difference == 1) {
					System.out.println("🔥 ¡Estuviste muy cerca!");
				} else if (difference == 2) {
					System.out.println("🎯 Bastante cerca...");
				}
			}

			if (points <= 0) {
				System.out.println("\n💸 ¡Te quedaste sin puntos! Fin del juego.");
				break;
			}

			if (rounds < 10) {
				System.out.print("\n¿Continuar? (s/n): ");
				String continueGame = scanner.next().toLowerCase();
				if (!continueGame.equals("s") && !continueGame.equals("si")) {
					break;
				}
			}
		}

		System.out.printf("\n🏁 Juego terminado después de %d rondas\n", rounds);
		System.out.printf("💰 Puntos finales: %d\n", points);

		if (points > 100) {
			System.out.println("🏆 ¡Felicitaciones! Terminaste con ganancia.");
		} else if (points == 100) {
			System.out.println("🤝 Quedaste igual que al inicio.");
		} else if (points > 0) {
			System.out.println("📉 Perdiste algunos puntos, pero no todos.");
		} else {
			System.out.println("💔 Mejor suerte la próxima vez.");
		}
	}

	private static void mysterySequence() {
		System.out.println("\n🔢 ¡SECUENCIA MISTERIOSA!");
		System.out.println("Descubre el patrón y completa la secuencia");

		int sequenceType = random.nextInt(4) + 1;
		int[] sequence = new int[6];
		int answer = 0;
		String pattern = "";

		switch (sequenceType) {
		case 1:
			int start = random.nextInt(10) + 1;
			int diff = random.nextInt(5) + 2;
			for (int i = 0; i < 5; i++) {
				sequence[i] = start + (i * diff);
			}
			answer = sequence[4] + diff;
			pattern = "suma constante de " + diff;
			break;

		case 2:
			start = random.nextInt(3) + 2;
			int ratio = random.nextInt(2) + 2;
			sequence[0] = start;
			for (int i = 1; i < 5; i++) {
				sequence[i] = sequence[i - 1] * ratio;
			}
			answer = sequence[4] * ratio;
			pattern = "multiplicación por " + ratio;
			break;

		case 3:
			start = random.nextInt(3) + 1;
			for (int i = 0; i < 5; i++) {
				int num = start + i;
				sequence[i] = num * num;
			}
			int nextNum = start + 5;
			answer = nextNum * nextNum;
			pattern = "cuadrados perfectos";
			break;

		case 4:
			sequence[0] = random.nextInt(3) + 1;
			sequence[1] = random.nextInt(3) + 1;
			for (int i = 2; i < 5; i++) {
				sequence[i] = sequence[i - 1] + sequence[i - 2];
			}
			answer = sequence[4] + sequence[3];
			pattern = "suma de los dos anteriores (Fibonacci)";
			break;
		}

		System.out.print("🔍 Secuencia: ");
		for (int i = 0; i < 5; i++) {
			System.out.print(sequence[i]);
			if (i < 4)
				System.out.print(", ");
		}
		System.out.print(", ?");

		System.out.print("\n🎯 ¿Cuál es el siguiente número? ");
		int userAnswer = scanner.nextInt();

		if (userAnswer == answer) {
			System.out.println("🎉 ¡CORRECTO!");
			System.out.printf("💡 El patrón era: %s\n", pattern);
		} else {
			System.out.printf("❌ Incorrecto. La respuesta era: %d\n", answer);
			System.out.printf("💡 El patrón era: %s\n", pattern);
		}

		System.out.print("📊 Secuencia completa: ");
		for (int i = 0; i < 5; i++) {
			System.out.print(sequence[i] + ", ");
		}
		System.out.println(answer);
	}

	private static void numberStatistics() {
		System.out.println("\n📊 ¡ESTADÍSTICAS DE NÚMEROS!");
		System.out.println("Ingresa 8 números y te mostraré estadísticas interesantes");

		int[] numbers = new int[8];
		int sum = 0;

		for (int i = 0; i < 8; i++) {
			System.out.printf("Número %d: ", i + 1);
			numbers[i] = scanner.nextInt();
			sum += numbers[i];
		}

		double average = sum / 8.0;
		int max = numbers[0];
		int min = numbers[0];
		int evenCount = 0;
		int oddCount = 0;
		int positiveCount = 0;
		int negativeCount = 0;
		int zeroCount = 0;

		for (int num : numbers) {
			if (num > max)
				max = num;
			if (num < min)
				min = num;
			if (num % 2 == 0)
				evenCount++;
			else
				oddCount++;
			if (num > 0)
				positiveCount++;
			else if (num < 0)
				negativeCount++;
			else
				zeroCount++;
		}

		System.out.println("\n" + "=".repeat(40));
		System.out.println("      📊 ESTADÍSTICAS CALCULADAS");
		System.out.println("=".repeat(40));
		System.out.printf("📈 Suma total: %d\n", sum);
		System.out.printf("📊 Promedio: %.2f\n", average);
		System.out.printf("⬆️  Número mayor: %d\n", max);
		System.out.printf("⬇️  Número menor: %d\n", min);
		System.out.printf("🔢 Pares: %d | Impares: %d\n", evenCount, oddCount);
		System.out.printf("➕ Positivos: %d | ➖ Negativos: %d | ⚪ Ceros: %d\n", positiveCount, negativeCount, zeroCount);

		System.out.println("\n🎮 Ahora responde algunas preguntas:");
		int correctAnswers = 0;

		System.out.printf("1. ¿Cuál es la suma total? ");
		if (scanner.nextInt() == sum) {
			System.out.println("✅ ¡Correcto!");
			correctAnswers++;
		} else {
			System.out.printf("❌ Incorrecto. Era %d\n", sum);
		}

		System.out.printf("2. ¿Cuántos números pares hay? ");
		if (scanner.nextInt() == evenCount) {
			System.out.println("✅ ¡Correcto!");
			correctAnswers++;
		} else {
			System.out.printf("❌ Incorrecto. Hay %d pares\n", evenCount);
		}

		System.out.printf("3. ¿Cuál es el número mayor? ");
		if (scanner.nextInt() == max) {
			System.out.println("✅ ¡Correcto!");
			correctAnswers++;
		} else {
			System.out.printf("❌ Incorrecto. Es %d\n", max);
		}

		System.out.printf("\n🏆 Puntuación: %d/3\n", correctAnswers);
	}

	private static void luckyWheel() {
		System.out.println("\n🎪 ¡RULETA DE LA SUERTE!");

		String[] prizes = { "🎁 100 puntos extra", "🎊 Multiplicador x2", "🎈 Giro gratis", "🍀 Día de suerte",
				"⭐ Poder especial", "🎯 Acierto garantizado", "🎨 Cambio de color", "🔮 Visión del futuro" };

		System.out.println("🎡 Gira la ruleta y gana un premio!");
		System.out.print("Presiona Enter para girar... ");
		scanner.nextLine();
		scanner.nextLine();

		System.out.print("🎪 Girando");
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(300);
				System.out.print(".");
			} catch (InterruptedException e) {
			}
		}

		int prizeIndex = random.nextInt(prizes.length);
		System.out.printf("\n\n🎉 ¡Has ganado: %s!\n", prizes[prizeIndex]);

		switch (prizeIndex) {
		case 0:
			System.out.println("💰 ¡Qué suerte! Puntos extra para tus próximos juegos.");
			break;
		case 1:
			System.out.println("📈 ¡Increíble! Tus próximas puntuaciones se duplicarán.");
			break;
		case 2:
			System.out.println("🔄 ¡Fantástico! Puedes volver a girar sin costo.");
			break;
		case 3:
			System.out.println("🌟 ¡Maravilloso! Hoy será tu día de suerte.");
			break;
		case 4:
			System.out.println("⚡ ¡Asombroso! Has desbloqueado un poder especial.");
			break;
		case 5:
			System.out.println("🎯 ¡Perfecto! Tu próxima respuesta será correcta automáticamente.");
			break;
		case 6:
			System.out.println("🌈 ¡Genial! El mundo se ve más colorido ahora.");
			break;
		case 7:
			System.out.println("🔮 ¡Místico! Ahora puedes ver las respuestas antes de las preguntas.");
			break;
		}
	}

	private static void numberPuzzle() {
		System.out.println("\n🧩 ¡ROMPECABEZAS NUMÉRICO!");
		System.out.println("Resuelve estos desafíos de lógica matemática");

		int puzzleType = random.nextInt(3) + 1;

		switch (puzzleType) {
		case 1:
			magicSquarePuzzle();
			break;
		case 2:
			numberOperationPuzzle();
			break;
		case 3:
			digitalRootPuzzle();
			break;
		}
	}

	private static boolean solveSumProblem() {
		int a = random.nextInt(50) + 10;
		int b = random.nextInt(50) + 10;
		int c = random.nextInt(50) + 10;

		System.out.printf("🧮 ¿Cuánto es %d + %d + %d? ", a, b, c);
		int answer = scanner.nextInt();

		return answer == (a + b + c);
	}

	private static boolean solveMultiplicationProblem() {
		int a = random.nextInt(12) + 2;
		int b = random.nextInt(12) + 2;

		System.out.printf("✖️  ¿Cuánto es %d × %d? ", a, b);
		int answer = scanner.nextInt();

		return answer == (a * b);
	}

	private static boolean solveSequenceProblem() {
		int start = random.nextInt(5) + 2;
		int diff = random.nextInt(3) + 2;

		System.out.printf("🔢 Secuencia: %d, %d, %d, ? ", start, start + diff, start + 2 * diff);
		System.out.print("¿Cuál sigue? ");
		int answer = scanner.nextInt();

		return answer == (start + 3 * diff);
	}

	private static boolean solveFactorialProblem() {
		int n = random.nextInt(4) + 3; // 3 a 6

		System.out.printf("❗ ¿Cuánto es %d! (factorial de %d)? ", n, n);
		int answer = scanner.nextInt();

		int factorial = 1;
		for (int i = 2; i <= n; i++) {
			factorial *= i;
		}

		return answer == factorial;
	}

	private static void magicSquarePuzzle() {
		System.out.println("🔮 CUADRADO MÁGICO");
		System.out.println("Completa el cuadrado mágico donde todas las filas, columnas y diagonales suman lo mismo:");

		int[][] square = { { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } };

		int hiddenRow = random.nextInt(3);
		int hiddenCol = random.nextInt(3);
		int hiddenValue = square[hiddenRow][hiddenCol];

		System.out.println("\n📋 Cuadrado actual:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == hiddenRow && j == hiddenCol) {
					System.out.print("? ");
				} else {
					System.out.print(square[i][j] + " ");
				}
			}
			System.out.println();
		}

		System.out.println("💡 Pista: Cada fila, columna y diagonal debe sumar 15");
		System.out.printf("❓ ¿Qué número falta en la posición [%d,%d]? ", hiddenRow + 1, hiddenCol + 1);

		int answer = scanner.nextInt();

		if (answer == hiddenValue) {
			System.out.println("🎉 ¡Correcto! Has resuelto el cuadrado mágico.");
		} else {
			System.out.printf("❌ Incorrecto. El número era %d\n", hiddenValue);
		}

		System.out.println("\n📋 Cuadrado completo:");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void numberOperationPuzzle() {
		System.out.println("🔢 OPERACIÓN MISTERIOSA");
		System.out.println("Descubre qué operación se aplica a estos números:");

		int operation = random.nextInt(3) + 1;
		int[] inputs = { 4, 7, 10, 13 };
		int[] outputs = new int[4];
		String operationName = "";

		switch (operation) {
		case 1:
			for (int i = 0; i < 4; i++) {
				outputs[i] = inputs[i] * 2 + 1;
			}
			operationName = "multiplicar por 2 y sumar 1";
			break;
		case 2:
			for (int i = 0; i < 4; i++) {
				outputs[i] = inputs[i] * inputs[i] - 3;
			}
			operationName = "elevar al cuadrado y restar 3";
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				outputs[i] = (inputs[i] + 5) * 2;
			}
			operationName = "sumar 5 y multiplicar por 2";
			break;
		}

		System.out.println("📊 Ejemplos:");
		for (int i = 0; i < 3; i++) {
			System.out.printf("   %d → %d\n", inputs[i], outputs[i]);
		}

		System.out.printf("❓ Si el número es %d, ¿cuál es el resultado? ", inputs[3]);
		int answer = scanner.nextInt();

		if (answer == outputs[3]) {
			System.out.println("🎉 ¡Correcto!");
			System.out.printf("💡 La operación era: %s\n", operationName);
		} else {
			System.out.printf("❌ Incorrecto. La respuesta era %d\n", outputs[3]);
			System.out.printf("💡 La operación era: %s\n", operationName);
		}
	}

	private static void digitalRootPuzzle() {
		System.out.println("🌿 RAÍZ DIGITAL");
		System.out.println("La raíz digital es el resultado de sumar los dígitos hasta obtener un solo dígito.");

		int number = random.nextInt(900) + 100;

		System.out.printf("🔢 Número: %d\n", number);
		System.out.println("💡 Ejemplo: 123 → 1+2+3 = 6 (raíz digital = 6)");
		System.out.println("💡 Ejemplo: 789 → 7+8+9 = 24 → 2+4 = 6 (raíz digital = 6)");

		int temp = number;
		while (temp >= 10) {
			int sum = 0;
			while (temp > 0) {
				sum += temp % 10;
				temp /= 10;
			}
			temp = sum;
		}
		int digitalRoot = temp;

		System.out.printf("❓ ¿Cuál es la raíz digital de %d? ", number);
		int answer = scanner.nextInt();

		if (answer == digitalRoot) {
			System.out.println("🎉 ¡Correcto! Has dominado la raíz digital.");
		} else {
			System.out.printf("❌ Incorrecto. La raíz digital de %d es %d\n", number, digitalRoot);

			System.out.println("🔍 Proceso:");
			temp = number;
			while (temp >= 10) {
				int sum = 0;
				int originalTemp = temp;
				String process = "";
				while (temp > 0) {
					int digit = temp % 10;
					sum += digit;
					if (process.length() > 0)
						process = digit + "+" + process;
					else
						process = String.valueOf(digit);
					temp /= 10;
				}
				System.out.printf("   %d → %s = %d\n", originalTemp, process, sum);
				temp = sum;
			}
		}
	}
}