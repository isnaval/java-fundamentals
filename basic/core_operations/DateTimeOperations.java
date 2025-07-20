package basic.core_operations;

import java.util.Scanner;

public class DateTimeOperations {
	private static Scanner scanner = MainController.getScanner();

	private static final int[] DAYS_IN_MONTH = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] MONTH_NAMES = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
			"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };

	public static void showDateTimeMenu() {
		while (true) {
			System.out.println("\n" + "=".repeat(40));
			System.out.println("        📅 FECHAS Y TIEMPO");
			System.out.println("=".repeat(40));
			System.out.println("1. Validar fecha (sin años bisiestos)");
			System.out.println("2. Validar fecha (con años bisiestos)");
			System.out.println("3. Incrementar fecha en un día");
			System.out.println("4. Incrementar fecha completa (días/meses/años)");
			System.out.println("5. Incrementar hora en un segundo");
			System.out.println("6. Calculadora de días entre fechas");
			System.out.println("7. Información completa de una fecha");
			System.out.println("0. Volver al menú principal");
			System.out.println("=".repeat(40));
			System.out.print("Selecciona una opción: ");

			int option = MainController.getValidOption(0, 7);

			switch (option) {
			case 1:
				validateDateSimple();
				break;
			case 2:
				validateDateWithLeapYear();
				break;
			case 3:
				incrementDateByDay();
				break;
			case 4:
				incrementDateComplete();
				break;
			case 5:
				incrementTime();
				break;
			case 6:
				calculateDaysBetween();
				break;
			case 7:
				dateCompleteInfo();
				break;
			case 0:
				return;
			}
			MainController.pauseAndContinue();
		}
	}

	private static void validateDateSimple() {
		System.out.println("\n--- VALIDAR FECHA (SIN BISIESTOS) ---");
		System.out.print("Ingresa el día: ");
		int day = scanner.nextInt();
		System.out.print("Ingresa el mes: ");
		int month = scanner.nextInt();
		System.out.print("Ingresa el año: ");
		int year = scanner.nextInt();

		boolean isValid = validateDate(day, month, year, false);

		if (isValid) {
			System.out.printf("✅ La fecha %02d/%02d/%04d es VÁLIDA\n", day, month, year);
			System.out.printf("📅 %d de %s de %d\n", day, MONTH_NAMES[month - 1], year);
		} else {
			System.out.printf("❌ La fecha %02d/%02d/%04d es INVÁLIDA\n", day, month, year);

			if (month < 1 || month > 12) {
				System.out.println("   ➤ El mes debe estar entre 1 y 12");
			} else if (day < 1 || day > DAYS_IN_MONTH[month - 1]) {
				System.out.printf("   ➤ El día debe estar entre 1 y %d para %s\n", DAYS_IN_MONTH[month - 1],
						MONTH_NAMES[month - 1]);
			}
			if (year <= 0) {
				System.out.println("   ➤ El año debe ser positivo");
			}
		}
	}

	private static void validateDateWithLeapYear() {
		System.out.println("\n--- VALIDAR FECHA (CON BISIESTOS) ---");
		System.out.print("Ingresa el día: ");
		int day = scanner.nextInt();
		System.out.print("Ingresa el mes: ");
		int month = scanner.nextInt();
		System.out.print("Ingresa el año: ");
		int year = scanner.nextInt();

		boolean isLeap = isLeapYear(year);
		boolean isValid = validateDate(day, month, year, true);

		System.out.printf("\n📊 Año %d: %s\n", year, isLeap ? "Es BISIESTO" : "NO es bisiesto");

		if (isValid) {
			System.out.printf("✅ La fecha %02d/%02d/%04d es VÁLIDA\n", day, month, year);
			System.out.printf("📅 %d de %s de %d\n", day, MONTH_NAMES[month - 1], year);

			if (month == 2 && day == 29) {
				System.out.println("🎉 ¡Fecha especial! 29 de febrero (año bisiesto)");
			}
		} else {
			System.out.printf("❌ La fecha %02d/%02d/%04d es INVÁLIDA\n", day, month, year);

			if (month < 1 || month > 12) {
				System.out.println("   ➤ El mes debe estar entre 1 y 12");
			} else {
				int maxDays = getDaysInMonth(month, year);
				if (day < 1 || day > maxDays) {
					System.out.printf("   ➤ El día debe estar entre 1 y %d para %s %d\n", maxDays,
							MONTH_NAMES[month - 1], year);
					if (month == 2) {
						System.out.printf("   ➤ Febrero %d tiene %d días (%s)\n", year, maxDays,
								isLeap ? "año bisiesto" : "año normal");
					}
				}
			}
		}
	}

	private static void incrementDateByDay() {
		System.out.println("\n--- INCREMENTAR FECHA EN UN DÍA ---");
		System.out.print("Ingresa el día: ");
		int day = scanner.nextInt();
		System.out.print("Ingresa el mes: ");
		int month = scanner.nextInt();
		System.out.print("Ingresa el año: ");
		int year = scanner.nextInt();

		if (!validateDate(day, month, year, true)) {
			System.out.println("❌ La fecha ingresada no es válida.");
			return;
		}

		System.out.printf("📅 Fecha original: %02d/%02d/%04d (%d de %s de %d)\n", day, month, year, day,
				MONTH_NAMES[month - 1], year);

		day++;
		int maxDays = getDaysInMonth(month, year);

		if (day > maxDays) {
			day = 1;
			month++;
			if (month > 12) {
				month = 1;
				year++;
			}
		}

		System.out.printf("📅 Fecha incrementada: %02d/%02d/%04d (%d de %s de %d)\n", day, month, year, day,
				MONTH_NAMES[month - 1], year);
	}

	private static void incrementDateComplete() {
		System.out.println("\n--- INCREMENTO COMPLETO DE FECHA ---");
		System.out.print("Ingresa el día: ");
		int day = scanner.nextInt();
		System.out.print("Ingresa el mes: ");
		int month = scanner.nextInt();
		System.out.print("Ingresa el año: ");
		int year = scanner.nextInt();

		if (!validateDate(day, month, year, true)) {
			System.out.println("❌ La fecha ingresada no es válida.");
			return;
		}

		System.out.print("¿Cuántos días quieres agregar? ");
		int addDays = scanner.nextInt();
		System.out.print("¿Cuántos meses quieres agregar? ");
		int addMonths = scanner.nextInt();
		System.out.print("¿Cuántos años quieres agregar? ");
		int addYears = scanner.nextInt();

		System.out.printf("\n📅 Fecha original: %02d/%02d/%04d\n", day, month, year);
		System.out.printf("➕ Incremento: +%d días, +%d meses, +%d años\n", addDays, addMonths, addYears);

		year += addYears;

		month += addMonths;
		while (month > 12) {
			month -= 12;
			year++;
		}

		int maxDaysInNewMonth = getDaysInMonth(month, year);
		if (day > maxDaysInNewMonth) {
			day = maxDaysInNewMonth;
			System.out.printf("⚠️  Día ajustado a %d (máximo para %s %d)\n", day, MONTH_NAMES[month - 1], year);
		}

		for (int i = 0; i < addDays; i++) {
			day++;
			int maxDays = getDaysInMonth(month, year);
			if (day > maxDays) {
				day = 1;
				month++;
				if (month > 12) {
					month = 1;
					year++;
				}
			}
		}

		System.out.printf("📅 Fecha final: %02d/%02d/%04d (%d de %s de %d)\n", day, month, year, day,
				MONTH_NAMES[month - 1], year);
	}

	private static void incrementTime() {
		System.out.println("\n--- INCREMENTAR TIEMPO EN UN SEGUNDO ---");
		System.out.print("Ingresa las horas (0-23): ");
		int hours = scanner.nextInt();
		System.out.print("Ingresa los minutos (0-59): ");
		int minutes = scanner.nextInt();
		System.out.print("Ingresa los segundos (0-59): ");
		int seconds = scanner.nextInt();

		if (hours < 0 || hours > 23 || minutes < 0 || minutes > 59 || seconds < 0 || seconds > 59) {
			System.out.println("❌ Tiempo inválido. Verifica los rangos.");
			return;
		}

		System.out.printf("🕐 Tiempo original: %02d:%02d:%02d\n", hours, minutes, seconds);

		seconds++;
		if (seconds >= 60) {
			seconds = 0;
			minutes++;
			if (minutes >= 60) {
				minutes = 0;
				hours++;
				if (hours >= 24) {
					hours = 0;
					System.out.println("📅 ¡Cambio de día!");
				}
			}
		}

		System.out.printf("🕐 Tiempo incrementado: %02d:%02d:%02d\n", hours, minutes, seconds);

		String ampm = (hours < 12) ? "AM" : "PM";
		int displayHours = (hours == 0) ? 12 : (hours > 12) ? hours - 12 : hours;
		System.out.printf("🕐 Formato 12h: %02d:%02d:%02d %s\n", displayHours, minutes, seconds, ampm);
	}

	private static void calculateDaysBetween() {
		System.out.println("\n--- CALCULADORA DE DÍAS ENTRE FECHAS ---");

		System.out.println("Primera fecha:");
		System.out.print("Día: ");
		int day1 = scanner.nextInt();
		System.out.print("Mes: ");
		int month1 = scanner.nextInt();
		System.out.print("Año: ");
		int year1 = scanner.nextInt();

		System.out.println("Segunda fecha:");
		System.out.print("Día: ");
		int day2 = scanner.nextInt();
		System.out.print("Mes: ");
		int month2 = scanner.nextInt();
		System.out.print("Año: ");
		int year2 = scanner.nextInt();

		if (!validateDate(day1, month1, year1, true) || !validateDate(day2, month2, year2, true)) {
			System.out.println("❌ Una o ambas fechas son inválidas.");
			return;
		}

		int days1 = daysSinceReference(day1, month1, year1);
		int days2 = daysSinceReference(day2, month2, year2);

		int difference = Math.abs(days2 - days1);

		System.out.printf("\n📅 Fecha 1: %02d/%02d/%04d\n", day1, month1, year1);
		System.out.printf("📅 Fecha 2: %02d/%02d/%04d\n", day2, month2, year2);
		System.out.printf("📊 Diferencia: %d días\n", difference);

		int years = difference / 365;
		int remainingDays = difference % 365;
		int months = remainingDays / 30;
		int days = remainingDays % 30;

		System.out.printf("📊 Aproximadamente: %d años, %d meses y %d días\n", years, months, days);
	}

	private static void dateCompleteInfo() {
		System.out.println("\n--- INFORMACIÓN COMPLETA DE FECHA ---");
		System.out.print("Ingresa el día: ");
		int day = scanner.nextInt();
		System.out.print("Ingresa el mes: ");
		int month = scanner.nextInt();
		System.out.print("Ingresa el año: ");
		int year = scanner.nextInt();

		if (!validateDate(day, month, year, true)) {
			System.out.println("❌ La fecha ingresada no es válida.");
			return;
		}

		System.out.println("\n" + "=".repeat(50));
		System.out.println("         📅 INFORMACIÓN COMPLETA");
		System.out.println("=".repeat(50));

		System.out.printf("📅 Fecha: %02d/%02d/%04d\n", day, month, year);
		System.out.printf("📅 Formato extendido: %d de %s de %d\n", day, MONTH_NAMES[month - 1], year);

		boolean isLeap = isLeapYear(year);
		System.out.printf("📊 Año %d: %s (%d días)\n", year, isLeap ? "Bisiesto" : "Normal", isLeap ? 366 : 365);

		int daysInMonth = getDaysInMonth(month, year);
		System.out.printf("📊 %s %d: %d días\n", MONTH_NAMES[month - 1], year, daysInMonth);

		int dayOfYear = 0;
		for (int i = 1; i < month; i++) {
			dayOfYear += getDaysInMonth(i, year);
		}
		dayOfYear += day;

		System.out.printf("📊 Día del año: %d de %d\n", dayOfYear, isLeap ? 366 : 365);

		int remainingDays = (isLeap ? 366 : 365) - dayOfYear;
		System.out.printf("📊 Días restantes en el año: %d\n", remainingDays);

		int quarter = ((month - 1) / 3) + 1;
		System.out.printf("📊 Trimestre: %d° trimestre\n", quarter);

		int semester = (month <= 6) ? 1 : 2;
		System.out.printf("📊 Semestre: %d° semestre\n", semester);
	}

	private static boolean validateDate(int day, int month, int year, boolean considerLeapYear) {
		if (year <= 0 || month < 1 || month > 12 || day < 1) {
			return false;
		}

		int maxDays = considerLeapYear ? getDaysInMonth(month, year) : DAYS_IN_MONTH[month - 1];
		return day <= maxDays;
	}

	private static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	private static int getDaysInMonth(int month, int year) {
		if (month == 2 && isLeapYear(year)) {
			return 29;
		}
		return DAYS_IN_MONTH[month - 1];
	}

	private static int daysSinceReference(int day, int month, int year) {
		int totalDays = 0;

		for (int y = 1; y < year; y++) {
			totalDays += isLeapYear(y) ? 366 : 365;
		}

		for (int m = 1; m < month; m++) {
			totalDays += getDaysInMonth(m, year);
		}

		totalDays += day;

		return totalDays;
	}
}