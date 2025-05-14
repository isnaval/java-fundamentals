package java_core_basic;

import java.util.Scanner;

public class Basic_switch {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner mainScanner = new Scanner(System.in);
		System.out.println("=== EJERCICIOS===");
		System.out.println("Ejercicio01 - pulsa 1");
		System.out.println("Ejercicio02 - pulsa 2");
		System.out.println("Ejercicio03 - pulsa 3");
		System.out.print("Selecciona un ejercicio: ");

		int code = mainScanner.nextInt();
		mainScanner.nextLine();

		switch (code) {
		case 1:
			Ejercicio01(mainScanner);
			break;
		case 2:
			Ejercicio02(mainScanner);
			break;
		case 3:
			Ejercicio03(mainScanner);
			break;
		}

		mainScanner.close();
	}

	@SuppressWarnings("unused")
	public static void Ejercicio01(Scanner scanner) {
		System.out.println("=== CATÁLOGO DE PRODUCTOS ===");
		System.out.println("Código | Producto   | Precio");
		System.out.println("-------------------------");
		System.out.println("A001   | Camiseta   | 15.99 €");
		System.out.println("B002   | Zapatos    | 49.99 €");
		System.out.println("C003   | Pantalones | 9.99  €");
		System.out.println("-------------------------");
		System.out.println("DESCUENTO | Aplicar 10% de descuento a un precio");

		System.out.println("Introduce el código del producto: ");
		String productCode = scanner.nextLine().toUpperCase();

		String productName;
		double productPrice;

		switch (productCode) {

		case "A001":
			productName = "Camiseta";
			productPrice = 15.99;
			break;
		case "B002":
			productName = "Zapatos";
			productPrice = 49.99;
			break;
		case "C003":
			productName = "Pantalones";
			productPrice = 9.99;
			break;

		default:
			productName = "Producto no encontrado";
			productPrice = 0.0;
			System.out.println("Vuelve a poner el código correcto");
			break;
		}

		if (productPrice > 0) {

			System.out.println("\nDetalle del procuto seleccionado: ");
			System.out.println("Nombre: " + productName);
			double finalPrice = productAftherTax(productPrice);
			System.out.printf("Precio final: " + finalPrice + " €");

		} else {
			System.out.println("\nEl código introducido no corresponde con ningún producto");
		}

		scanner.close();
	}

	public static double productAftherTax(double price) {
		double taxRate = 0.21;
		return price * (1 + taxRate);
	}

	public static void Ejercicio02(Scanner scanner) {

		System.out.println("Dime que puntuación has obtenido del 0 al 10: ");
		int score = scanner.nextInt();
		scanner.close();

		if (score > 10 || score < 0) {
			System.err.println("Ingresa una puntuación que esté entre 0 y 10");
			System.exit(0);
		}

		switch (score) {
		case 10:
			System.out.println("Has obtenido un excelente");
			break;
		case 9:
			System.out.println("Has obtenido un sobresaliente");
			break;
		case 8:
			System.out.println("Has obtenido un notable alto");
			break;
		case 7:
			System.out.println("Has obtenido un notable");
			break;
		case 6:
			System.out.println("Has obtenido un bien");
			break;
		case 5:
			System.out.println("Has obtenido un aprobado");
			break;
		case 4:
		case 3:
		case 2:
		case 1:
		case 0:
			System.out.println("Has suspendido");
			break;
		default:
			System.out.println("Puntuación no válida");
			break;
		}
	}

	public static void Ejercicio03(Scanner scanner) {
		System.out.print("Dime el número del mes en el que estamos (1-12): ");
		int month = scanner.nextInt();
		System.out.print("Dime el año en el que estamos: ");
		int year = scanner.nextInt();

		try {
			if ((month < 1 || month > 12) && (year < 1 || year > 12)) {
				System.out.println("ERROR: el numero del mes y el año debe estar entre 1 y 12");
				return;
			}

			String monthName = getMonthName(month);
			int days = getDaysInMonth(month, year);
			boolean isLeap = isLeapYear(year);

			System.out.println("El mes es " + monthName + " y tiene " + days + " días. "
					+ (isLeap ? " El año " + year + " es bisiesto" : "El año " + year + " no es bisiesto"));

		} catch (NumberFormatException e) {
			System.out.println("ERROR: Por favor, ingresa numeros válidos");
		}

	}

	public static String getMonthName(int month) {
		switch (month) {
		case 1:
			return "Enero";
		case 2:
			return "Febrero";
		case 3:
			return "Marzo";
		case 4:
			return "Abril";
		case 5:
			return "Mayo";
		case 6:
			return "Junio";
		case 7:
			return "Julio";
		case 8:
			return "Agosto";
		case 9:
			return "Septiembre";
		case 10:
			return "Octubre";
		case 11:
			return "Noviembre";
		case 12:
			return "Diciembre";
		default:
			return "Mes desconocido";
		}
	}

	public static boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	public static int getDaysInMonth(int month, int year) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			return 30;
		} else {
			return isLeapYear(year) ? 29 : 28;
		}
	}
}
