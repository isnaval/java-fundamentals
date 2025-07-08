package java_oop.basics.shape_calculator;

import java.util.Scanner;

public class ShapeCalculatorMain {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean continuar = true;

		System.out.println("CALCULADORA DE FIGURAS GEOMETRICAS");
		System.out.println("==================================");

		while (continuar) {
			System.out.println("\nMENU:");
			System.out.println("1. Circulo");
			System.out.println("2. Rectangulo");
			System.out.println("3. Cuadrado");
			System.out.println("4. Triangulo");
			System.out.println("5. Salir");
			System.out.print("\nElija una opcion: ");

			int opcion = scanner.nextInt();
			scanner.nextLine();

			switch (opcion) {
			case 1:
				calcularCirculo();
				break;
			case 2:
				calcularRectangulo();
				break;
			case 3:
				calcularCuadrado();
				break;
			case 4:
				calcularTriangulo();
				break;
			case 5:
				continuar = false;
				System.out.println("\nGracias por usar la calculadora!");
				break;
			default:
				System.out.println("\nOpcion no valida.");
			}
		}

		scanner.close();
	}

	private static void calcularCirculo() {
		System.out.println("\n--- CIRCULO ---");
		System.out.print("Radio: ");
		double radio = scanner.nextDouble();
		scanner.nextLine();

		Circle circulo = new Circle(radio);
		System.out.println("Area: " + String.format("%.2f", circulo.calculateArea()));
		System.out.println("Perimetro: " + String.format("%.2f", circulo.calculatePerimeter()));
	}

	private static void calcularRectangulo() {
		System.out.println("\n--- RECTANGULO ---");
		System.out.print("Ancho: ");
		double ancho = scanner.nextDouble();
		System.out.print("Alto: ");
		double alto = scanner.nextDouble();
		scanner.nextLine();

		Rectangle rectangulo = new Rectangle(ancho, alto);
		System.out.println("Area: " + String.format("%.2f", rectangulo.calculateArea()));
		System.out.println("Perimetro: " + String.format("%.2f", rectangulo.calculatePerimeter()));
	}

	private static void calcularCuadrado() {
		System.out.println("\n--- CUADRADO ---");
		System.out.print("Lado: ");
		double lado = scanner.nextDouble();
		scanner.nextLine();

		Square cuadrado = new Square(lado);
		System.out.println("Area: " + String.format("%.2f", cuadrado.calculateArea()));
		System.out.println("Perimetro: " + String.format("%.2f", cuadrado.calculatePerimeter()));
	}

	private static void calcularTriangulo() {
		System.out.println("\n--- TRIANGULO ---");
		System.out.println("1. Ingresar tres lados");
		System.out.println("2. Ingresar base y altura");
		System.out.print("Opcion: ");
		int opcion = scanner.nextInt();
		scanner.nextLine();

		Triangle triangulo = null;

		if (opcion == 1) {
			System.out.print("Lado A: ");
			double ladoA = scanner.nextDouble();
			System.out.print("Lado B: ");
			double ladoB = scanner.nextDouble();
			System.out.print("Lado C: ");
			double ladoC = scanner.nextDouble();
			scanner.nextLine();

			triangulo = new Triangle(ladoA, ladoB, ladoC);
		} else if (opcion == 2) {
			System.out.print("Base: ");
			double base = scanner.nextDouble();
			System.out.print("Altura: ");
			double altura = scanner.nextDouble();
			scanner.nextLine();

			triangulo = Triangle.fromBaseHeight(base, altura);
		}

		if (triangulo != null) {
			System.out.println("Area: " + String.format("%.2f", triangulo.calculateArea()));
			System.out.println("Perimetro: " + String.format("%.2f", triangulo.calculatePerimeter()));
		}
	}
}