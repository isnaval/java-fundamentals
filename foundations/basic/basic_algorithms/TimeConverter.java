package basic.basic_algorithms;

import java.util.Scanner;

public class TimeConverter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		presentApplication();
		int option = showMenuAndGetOption(scanner);

		switch (option) {
		case 1:
			convertSecondsToTime(scanner);
			break;
		case 2:
			convertTimeToSeconds(scanner);
			break;
		case 3:
			convertWithBreakdown(scanner);
			break;
		case 4:
			convertMultipleTimes(scanner);
			break;
		case 5:
			System.out.println("Thanks for using the Time Converter");
			break;
		default:
			System.out.println("Invalid option");
		}

		scanner.close();
	}

	private static void presentApplication() {
		System.out.println("=======================================");
		System.out.println("        TIME CONVERTER");
		System.out.println("=======================================");
		System.out.println("Program that converts between seconds");
		System.out.println("and hours:minutes:seconds format");
		System.out.println();
	}

	private static int showMenuAndGetOption(Scanner scanner) {
		System.out.println("Select an option:");
		System.out.println("1. Convert seconds to HH:MM:SS");
		System.out.println("2. Convert HH:MM:SS to seconds");
		System.out.println("3. Convert seconds (show breakdown)");
		System.out.println("4. Convert multiple times");
		System.out.println("5. Exit");
		System.out.print("\nEnter your option (1-5): ");

		return scanner.nextInt();
	}

	private static void convertSecondsToTime(Scanner scanner) {
		int totalSeconds = requestSeconds(scanner);
		int[] timeComponents = performSecondsToTime(totalSeconds);

		System.out.println("\nResult: " + totalSeconds + " seconds = "
				+ formatTime(timeComponents[0], timeComponents[1], timeComponents[2]));
	}

	private static void convertTimeToSeconds(Scanner scanner) {
		int[] timeComponents = requestTimeComponents(scanner);
		int totalSeconds = performTimeToSeconds(timeComponents[0], timeComponents[1], timeComponents[2]);

		System.out.println("\nResult: " + formatTime(timeComponents[0], timeComponents[1], timeComponents[2]) + " = "
				+ totalSeconds + " seconds");
	}

	private static void convertWithBreakdown(Scanner scanner) {
		int totalSeconds = requestSeconds(scanner);
		int[] timeComponents = performSecondsToTimeWithBreakdown(totalSeconds);

		System.out.println("\nFinal result: " + totalSeconds + " seconds = "
				+ formatTime(timeComponents[0], timeComponents[1], timeComponents[2]));
	}

	private static void convertMultipleTimes(Scanner scanner) {
		System.out.println("\n--- Multiple Time Conversion ---");
		System.out.print("How many times do you want to convert? ");
		int count = scanner.nextInt();

		for (int i = 1; i <= count; i++) {
			System.out.print("\nEnter seconds for conversion " + i + ": ");
			int seconds = scanner.nextInt();
			int[] timeComponents = performSecondsToTime(seconds);

			System.out.println(
					seconds + " seconds = " + formatTime(timeComponents[0], timeComponents[1], timeComponents[2]));
		}
	}

	private static int requestSeconds(Scanner scanner) {
		System.out.println("\n--- Data Input ---");
		System.out.print("Enter total seconds: ");
		return scanner.nextInt();
	}

	private static int[] requestTimeComponents(Scanner scanner) {
		System.out.println("\n--- Data Input ---");
		System.out.println("You can enter time in two ways:");
		System.out.println("1. Enter each component separately");
		System.out.println("2. Enter in HH:MM:SS format (e.g., 12:30:45)");
		System.out.print("Choose format (1 or 2): ");

		int format = scanner.nextInt();

		if (format == 2) {
			return parseTimeString(scanner);
		} else {
			return parseTimeComponents(scanner);
		}
	}

	private static int[] parseTimeComponents(Scanner scanner) {
		System.out.print("Enter hours: ");
		int hours = scanner.nextInt();
		System.out.print("Enter minutes: ");
		int minutes = scanner.nextInt();
		System.out.print("Enter seconds: ");
		int seconds = scanner.nextInt();

		return new int[] { hours, minutes, seconds };
	}

	private static int[] parseTimeString(Scanner scanner) {
		System.out.print("Enter time (HH:MM:SS): ");
		scanner.nextLine(); // Clear the buffer
		String timeString = scanner.nextLine();

		try {
			String[] parts = timeString.split(":");
			if (parts.length != 3) {
				System.out.println("Invalid format. Using 00:00:00");
				return new int[] { 0, 0, 0 };
			}

			int hours = Integer.parseInt(parts[0]);
			int minutes = Integer.parseInt(parts[1]);
			int seconds = Integer.parseInt(parts[2]);

			return new int[] { hours, minutes, seconds };
		} catch (NumberFormatException e) {
			System.out.println("Invalid numbers in time format. Using 00:00:00");
			return new int[] { 0, 0, 0 };
		}
	}

	private static int[] performSecondsToTime(int totalSeconds) {
		final int SECONDS_IN_HOUR = 3600;
		final int SECONDS_IN_MINUTE = 60;

		int hours = totalSeconds / SECONDS_IN_HOUR;
		int minutes = (totalSeconds % SECONDS_IN_HOUR) / SECONDS_IN_MINUTE;
		int seconds = totalSeconds % SECONDS_IN_MINUTE;

		return new int[] { hours, minutes, seconds };
	}

	private static int[] performSecondsToTimeWithBreakdown(int totalSeconds) {
		final int SECONDS_IN_HOUR = 3600;
		final int SECONDS_IN_MINUTE = 60;

		System.out.println("\n--- Conversion Breakdown ---");
		System.out.println("Total seconds to convert: " + totalSeconds);

		System.out.println("\nStep 1: Calculate hours");
		int hours = totalSeconds / SECONDS_IN_HOUR;
		int remainingAfterHours = totalSeconds % SECONDS_IN_HOUR;
		System.out.println("Hours: " + totalSeconds + " ÷ " + SECONDS_IN_HOUR + " = " + hours + " hours");
		System.out.println("Remaining seconds: " + totalSeconds + " % " + SECONDS_IN_HOUR + " = " + remainingAfterHours
				+ " seconds");

		System.out.println("\nStep 2: Calculate minutes from remaining seconds");
		int minutes = remainingAfterHours / SECONDS_IN_MINUTE;
		int finalSeconds = remainingAfterHours % SECONDS_IN_MINUTE;
		System.out
				.println("Minutes: " + remainingAfterHours + " ÷ " + SECONDS_IN_MINUTE + " = " + minutes + " minutes");
		System.out.println("Final seconds: " + remainingAfterHours + " % " + SECONDS_IN_MINUTE + " = " + finalSeconds
				+ " seconds");

		System.out.println("\nStep 3: Final result");
		System.out.println("Hours: " + hours);
		System.out.println("Minutes: " + minutes);
		System.out.println("Seconds: " + finalSeconds);

		return new int[] { hours, minutes, finalSeconds };
	}

	private static int performTimeToSeconds(int hours, int minutes, int seconds) {
		final int SECONDS_IN_HOUR = 3600;
		final int SECONDS_IN_MINUTE = 60;

		return (hours * SECONDS_IN_HOUR) + (minutes * SECONDS_IN_MINUTE) + seconds;
	}

	private static String formatTime(int hours, int minutes, int seconds) {
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}
}