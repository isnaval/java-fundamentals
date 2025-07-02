package java_core_basic.core_operations;

import java.util.Scanner;

public class TextConversionOperations {
	private static Scanner scanner = MainController.getScanner();

	private static final String[] UNITS = { "", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho",
			"nueve" };

	private static final String[] TEENS = { "diez", "once", "doce", "trece", "catorce", "quince", "dieciséis",
			"diecisiete", "dieciocho", "diecinueve" };

	private static final String[] TENS = { "", "", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta",
			"ochenta", "noventa" };

	private static final String[] TWENTIES = { "veinte", "veintiuno", "veintidós", "veintitrés", "veinticuatro",
			"veinticinco", "veintiséis", "veintisiete", "veintiocho", "veintinueve" };

	public static void showTextMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("      📝 CONVERSIONES DE TEXTO");
			System.out.println("=".repeat(40));
			System.out.println("1. Número a palabras (0-99)");
			System.out.println("2. Número a palabras (0-999)");
			System.out.println("3. Nota numérica a calificación");
			System.out.println("4. Evaluador de examen completo");
			System.out.println("5. Convertir temperatura con texto");
			System.out.println("6. Día de la semana por número");
			System.out.println("7. Mes del año por número");
			System.out.println("0. Volver al menú principal");
			System.out.println("=".repeat(40));
			System.out.print("Selecciona una opción: ");

			int option = MainController.getValidOption(0, 7);

			switch (option) {
			case 1:
				numberToWords99();
				break;
			case 2:
				numberToWords999();
				break;
			case 3:
				gradeToText();
				break;
			case 4:
				completeExamEvaluator();
				break;
			case 5:
				temperatureConverter();
				break;
			case 6:
				dayOfWeek();
				break;
			case 7:
				monthOfYear();
				break;
			case 0:
				return;
			}
			MainController.pauseAndContinue();
		}
	}

	private static void numberToWords99() {
		System.out.println("\n--- NÚMERO A PALABRAS (0-99) ---");
		System.out.print("Ingresa un número entre 0 y 99: ");
		int number = scanner.nextInt();

		if (number < 0 || number > 99) {
			System.out.println("❌ El número debe estar entre 0 y 99.");
			return;
		}

		String words = convertToWords(number);
		System.out.printf("📝 %d en palabras: %s\n", number, words);

		if (number == 0) {
			System.out.println("ℹ️  El cero es el único número que se escribe igual en singular y plural.");
		} else if (number == 1) {
			System.out.println("ℹ️  'Uno' se convierte en 'un' cuando acompaña a un sustantivo masculino.");
		} else if (number >= 20 && number <= 29) {
			System.out.println("ℹ️  Los números del 20 al 29 se escriben en una sola palabra.");
		}
	}

	private static void numberToWords999() {
		System.out.println("\n--- NÚMERO A PALABRAS (0-999) ---");
		System.out.print("Ingresa un número entre 0 y 999: ");
		int number = scanner.nextInt();

		if (number < 0 || number > 999) {
			System.out.println("❌ El número debe estar entre 0 y 999.");
			return;
		}

		String words = convertToWordsExtended(number);
		System.out.printf("📝 %d en palabras: %s\n", number, words);

		int hundreds = number / 100;
		int remainder = number % 100;
		int tens = remainder / 10;
		int units = remainder % 10;

		System.out.println("\n📊 Análisis del número:");
		if (hundreds > 0) {
			System.out.printf("   Centenas: %d (%s)\n", hundreds,
					hundreds == 1 ? "ciento" : UNITS[hundreds] + "cientos");
		}
		if (tens > 0) {
			System.out.printf("   Decenas: %d\n", tens);
		}
		if (units > 0) {
			System.out.printf("   Unidades: %d (%s)\n", units, UNITS[units]);
		}
	}

	private static void gradeToText() {
		System.out.println("\n--- NOTA A CALIFICACIÓN ---");
		System.out.println("Sistemas disponibles:");
		System.out.println("1. Sistema 0-10");
		System.out.println("2. Sistema 0-100");
		System.out.println("3. Sistema 0-20");
		System.out.print("Selecciona el sistema: ");

		int system = MainController.getValidOption(1, 3);

		System.out.print("Ingresa la nota: ");
		double grade = scanner.nextDouble();

		String result = "";
		boolean isValid = true;

		switch (system) {
		case 1: // 0-10
			if (grade < 0 || grade > 10) {
				isValid = false;
			} else {
				result = gradeToText10(grade);
			}
			break;
		case 2: // 0-100
			if (grade < 0 || grade > 100) {
				isValid = false;
			} else {
				result = gradeToText100(grade);
			}
			break;
		case 3: // 0-20
			if (grade < 0 || grade > 20) {
				isValid = false;
			} else {
				result = gradeToText20(grade);
			}
			break;
		}

		if (!isValid) {
			System.out.printf("❌ Nota inválida para el sistema seleccionado.\n");
			return;
		}

		System.out.printf("📝 Nota %.2f: %s\n", grade, result);

		System.out.println("\n📊 Equivalencias en otros sistemas:");
		switch (system) {
		case 1:
			System.out.printf("   Sistema 0-100: %.1f\n", grade * 10);
			System.out.printf("   Sistema 0-20: %.1f\n", grade * 2);
			break;
		case 2:
			System.out.printf("   Sistema 0-10: %.1f\n", grade / 10);
			System.out.printf("   Sistema 0-20: %.1f\n", grade / 5);
			break;
		case 3:
			System.out.printf("   Sistema 0-10: %.1f\n", grade / 2);
			System.out.printf("   Sistema 0-100: %.1f\n", grade * 5);
			break;
		}
	}

	private static void completeExamEvaluator() {
		System.out.println("\n--- EVALUADOR DE EXAMEN COMPLETO ---");
		System.out.print("Ingresa la nota del examen (0-10): ");
		double examGrade = scanner.nextDouble();

		if (examGrade < 0 || examGrade > 10) {
			System.out.println("❌ La nota debe estar entre 0 y 10.");
			return;
		}

		System.out.print("¿Tiene trabajos adicionales? (s/n): ");
		String hasWork = scanner.next().toLowerCase();

		double workGrade = 0;
		if (hasWork.equals("s") || hasWork.equals("si") || hasWork.equals("sí")) {
			System.out.print("Ingresa la nota de trabajos (0-10): ");
			workGrade = scanner.nextDouble();
			if (workGrade < 0 || workGrade > 10) {
				System.out.println("⚠️  Nota de trabajos inválida, se considerará 0.");
				workGrade = 0;
			}
		}

		System.out.print("¿Hay puntos extra? (s/n): ");
		String hasExtra = scanner.next().toLowerCase();

		double extraPoints = 0;
		if (hasExtra.equals("s") || hasExtra.equals("si") || hasExtra.equals("sí")) {
			System.out.print("Ingresa los puntos extra (0-2): ");
			extraPoints = scanner.nextDouble();
			if (extraPoints < 0 || extraPoints > 2) {
				System.out.println("⚠️  Puntos extra inválidos, se considerarán 0.");
				extraPoints = 0;
			}
		}

		double finalGrade = (examGrade * 0.7) + (workGrade * 0.3) + extraPoints;
		if (finalGrade > 10)
			finalGrade = 10;

		System.out.println("\n" + "=".repeat(50));
		System.out.println("           📋 EVALUACIÓN COMPLETA");
		System.out.println("=".repeat(50));
		System.out.printf("📝 Nota de examen: %.2f (70%% del total)\n", examGrade);
		System.out.printf("📝 Nota de trabajos: %.2f (30%% del total)\n", workGrade);
		System.out.printf("🎁 Puntos extra: %.2f\n", extraPoints);
		System.out.printf("📊 Nota final: %.2f\n", finalGrade);
		System.out.printf("📝 Calificación: %s\n", gradeToText10(finalGrade));

		if (finalGrade >= 9) {
			System.out.println("🎉 ¡Excelente trabajo! Felicitaciones.");
		} else if (finalGrade >= 7) {
			System.out.println("👍 Buen trabajo, sigue así.");
		} else if (finalGrade >= 5) {
			System.out.println("✅ Aprobado, pero hay margen de mejora.");
		} else {
			System.out.println("📚 Es necesario estudiar más para la próxima.");
		}
	}

	private static void temperatureConverter() {
		System.out.println("\n--- CONVERTIDOR DE TEMPERATURA ---");
		System.out.print("Ingresa la temperatura: ");
		double temp = scanner.nextDouble();

		System.out.println("Unidad de origen:");
		System.out.println("1. Celsius");
		System.out.println("2. Fahrenheit");
		System.out.println("3. Kelvin");
		System.out.print("Selecciona: ");
		int fromUnit = MainController.getValidOption(1, 3);

		System.out.println("Convertir a:");
		System.out.println("1. Celsius");
		System.out.println("2. Fahrenheit");
		System.out.println("3. Kelvin");
		System.out.print("Selecciona: ");
		int toUnit = MainController.getValidOption(1, 3);

		if (fromUnit == toUnit) {
			System.out.println("⚠️  Las unidades de origen y destino son iguales.");
			return;
		}

		double result = convertTemperature(temp, fromUnit, toUnit);
		String[] units = { "", "°C", "°F", "K" };

		System.out.printf("\n🌡️  %.2f%s = %.2f%s\n", temp, units[fromUnit], result, units[toUnit]);

		String description = getTemperatureDescription(result, toUnit);
		System.out.printf("📝 Descripción: %s\n", description);
	}

	private static void dayOfWeek() {
		System.out.println("\n--- DÍA DE LA SEMANA ---");
		System.out.println("Ingresa un número del 1 al 7 (1=Lunes, 7=Domingo):");
		System.out.print("Número: ");
		int day = scanner.nextInt();

		String[] days = { "", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
		String[] daysEn = { "", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };

		if (day < 1 || day > 7) {
			System.out.println("❌ El número debe estar entre 1 y 7.");
			return;
		}

		System.out.printf("📅 Día %d: %s\n", day, days[day]);
		System.out.printf("📅 En inglés: %s\n", daysEn[day]);

		if (day <= 5) {
			System.out.println("📊 Es un día laboral (día de semana)");
		} else {
			System.out.println("📊 Es fin de semana");
		}

		System.out.println("\n📅 Todos los días de la semana:");
		for (int i = 1; i <= 7; i++) {
			System.out.printf("   %d. %s\n", i, days[i]);
		}
	}

	private static void monthOfYear() {
		System.out.println("\n--- MES DEL AÑO ---");
		System.out.print("Ingresa un número del 1 al 12: ");
		int month = scanner.nextInt();

		String[] months = { "", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
				"Octubre", "Noviembre", "Diciembre" };

		String[] monthsEn = { "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		int[] daysInMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		if (month < 1 || month > 12) {
			System.out.println("❌ El número debe estar entre 1 y 12.");
			return;
		}

		System.out.printf("📅 Mes %d: %s\n", month, months[month]);
		System.out.printf("📅 En inglés: %s\n", monthsEn[month]);
		System.out.printf("📊 Días en el mes: %d", daysInMonth[month]);
		if (month == 2) {
			System.out.print(" (28 en años normales, 29 en bisiestos)");
		}
		System.out.println();

		String season = "";
		if (month == 12 || month <= 2) {
			season = "Invierno";
		} else if (month >= 3 && month <= 5) {
			season = "Primavera";
		} else if (month >= 6 && month <= 8) {
			season = "Verano";
		} else {
			season = "Otoño";
		}

		System.out.printf("🌍 Estación (hemisferio norte): %s\n", season);

		int quarter = ((month - 1) / 3) + 1;
		System.out.printf("📊 Trimestre: %d° trimestre\n", quarter);
	}

	private static String convertToWords(int number) {
		if (number == 0)
			return "cero";
		if (number < 10)
			return UNITS[number];
		if (number >= 10 && number < 20)
			return TEENS[number - 10];
		if (number >= 20 && number < 30)
			return TWENTIES[number - 20];

		int tens = number / 10;
		int units = number % 10;

		if (units == 0) {
			return TENS[tens];
		} else {
			return TENS[tens] + " y " + UNITS[units];
		}
	}

	private static String convertToWordsExtended(int number) {
		if (number == 0)
			return "cero";
		if (number < 100)
			return convertToWords(number);

		int hundreds = number / 100;
		int remainder = number % 100;

		String result = "";

		if (hundreds == 1) {
			if (remainder == 0) {
				result = "cien";
			} else {
				result = "ciento";
			}
		} else {
			result = UNITS[hundreds] + "cientos";
		}

		if (remainder > 0) {
			if (hundreds == 1 && remainder != 0) {
				result += " " + convertToWords(remainder);
			} else {
				result += " " + convertToWords(remainder);
			}
		}

		return result;
	}

	private static String gradeToText10(double grade) {
		if (grade < 0 || grade > 10)
			return "Nota inválida";

		if (grade >= 9.5)
			return "Sobresaliente Alto (Matrícula de Honor)";
		if (grade >= 9.0)
			return "Sobresaliente";
		if (grade >= 8.0)
			return "Notable Alto";
		if (grade >= 7.0)
			return "Notable";
		if (grade >= 6.0)
			return "Bien";
		if (grade >= 5.0)
			return "Aprobado";
		if (grade >= 4.0)
			return "Insuficiente";
		if (grade >= 2.0)
			return "Deficiente";
		return "Muy Deficiente";
	}

	private static String gradeToText100(double grade) {
		if (grade < 0 || grade > 100)
			return "Nota inválida";

		if (grade >= 95)
			return "Excelente Plus (A+)";
		if (grade >= 90)
			return "Excelente (A)";
		if (grade >= 85)
			return "Muy Bueno Plus (B+)";
		if (grade >= 80)
			return "Muy Bueno (B)";
		if (grade >= 75)
			return "Bueno Plus (C+)";
		if (grade >= 70)
			return "Bueno (C)";
		if (grade >= 65)
			return "Regular Plus (D+)";
		if (grade >= 60)
			return "Regular (D)";
		if (grade >= 50)
			return "Insuficiente";
		return "Reprobado (F)";
	}

	private static String gradeToText20(double grade) {
		if (grade < 0 || grade > 20)
			return "Nota inválida";

		if (grade >= 19)
			return "Excelente Plus";
		if (grade >= 18)
			return "Excelente";
		if (grade >= 16)
			return "Muy Bueno";
		if (grade >= 14)
			return "Bueno";
		if (grade >= 12)
			return "Regular";
		if (grade >= 10)
			return "Aprobado";
		if (grade >= 8)
			return "Insuficiente";
		if (grade >= 4)
			return "Deficiente";
		return "Muy Deficiente";
	}

	private static double convertTemperature(double temp, int fromUnit, int toUnit) {
		double celsius = temp;

		switch (fromUnit) {
		case 1:
			break;
		case 2:
			celsius = (temp - 32) * 5 / 9;
			break;
		case 3:
			celsius = temp - 273.15;
			break;
		}

		switch (toUnit) {
		case 1:
			return celsius;
		case 2:
			return celsius * 9 / 5 + 32;
		case 3:
			return celsius + 273.15;
		default:
			return celsius;
		}
	}

	private static String getTemperatureDescription(double temp, int unit) {
		double celsius = temp;

		if (unit == 2) {
			celsius = (temp - 32) * 5 / 9;
		} else if (unit == 3) {
			celsius = temp - 273.15;
		}

		if (celsius <= -40) {
			return "Extremadamente frío (peligroso para la vida)";
		} else if (celsius <= -20) {
			return "Muy frío (congelante)";
		} else if (celsius <= -10) {
			return "Frío intenso";
		} else if (celsius <= 0) {
			return "Frío (punto de congelación del agua)";
		} else if (celsius <= 10) {
			return "Fresco";
		} else if (celsius <= 20) {
			return "Templado";
		} else if (celsius <= 25) {
			return "Agradable";
		} else if (celsius <= 30) {
			return "Cálido";
		} else if (celsius <= 35) {
			return "Caliente";
		} else if (celsius <= 40) {
			return "Muy caliente";
		} else if (celsius <= 50) {
			return "Extremadamente caliente";
		} else {
			return "Peligrosamente caliente";
		}
	}
}