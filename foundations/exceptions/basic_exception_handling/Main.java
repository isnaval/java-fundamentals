package exceptions.basic_exception_handling;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AuxiliarMethods.showWelcome();
		while (true) {
			AuxiliarMethods.showMenu();
			try {
				int choice = scanner.nextInt();

				if (choice == 0) {
					break;
				}

				AuxiliarMethods.executeChoice(choice);

			} catch (Exception e) {
				System.out.println("❌ Invalid input. Please enter a number.");
				scanner.nextLine();
			}
		}

		AuxiliarMethods.showGoodbye();
		scanner.close();
	}

}
