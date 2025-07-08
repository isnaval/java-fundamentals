package java_core.conditionals.advanced;

import java.util.Scanner;

public class GeometricCalculator {

	private static final double PI = Math.PI;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== CALCULADORA GEOMÉTRICA AVANZADA ===");
		System.out.println("Cálculos precisos de áreas, perímetros y volúmenes\n");

		boolean continuar = true;

		while (continuar) {
			System.out.println("\nCATEGORÍAS:");
			System.out.println("1. Figuras 2D (Área y Perímetro)");
			System.out.println("2. Figuras 3D (Volumen y Superficie)");
			System.out.println("3. Conversión de unidades");
			System.out.println("4. Comparación de figuras");
			System.out.println("5. Salir");
			System.out.print("\nSeleccione categoría: ");

			int categoria = scanner.nextInt();

			switch (categoria) {
			case 1:
				calcularFiguras2D(scanner);
				break;
			case 2:
				calcularFiguras3D(scanner);
				break;
			case 3:
				convertirUnidades(scanner);
				break;
			case 4:
				compararFiguras(scanner);
				break;
			case 5:
				continuar = false;
				System.out.println("\n¡Gracias por usar la calculadora!");
				break;
			default:
				System.out.println("Opción no válida");
			}
		}

		scanner.close();
	}

	private static void calcularFiguras2D(Scanner scanner) {
		System.out.println("\n--- FIGURAS 2D ---");
		System.out.println("1. Círculo");
		System.out.println("2. Cuadrado");
		System.out.println("3. Rectángulo");
		System.out.println("4. Triángulo");
		System.out.println("5. Trapecio");
		System.out.println("6. Pentágono regular");
		System.out.println("7. Hexágono regular");
		System.out.println("8. Polígono regular (n lados)");
		System.out.print("\nSeleccione figura: ");

		int figura = scanner.nextInt();
		double area = 0, perimetro = 0;

		switch (figura) {
		case 1:
			System.out.print("Radio: ");
			double radio = scanner.nextDouble();
			if (radio <= 0) {
				System.out.println("Error: El radio debe ser positivo");
				return;
			}
			area = PI * radio * radio;
			perimetro = 2 * PI * radio;
			System.out.println("\n=== CÍRCULO ===");
			System.out.println("Radio: " + radio);
			System.out.println("Diámetro: " + (2 * radio));
			System.out.println("Área: " + String.format("%.4f", area));
			System.out.println("Perímetro: " + String.format("%.4f", perimetro));
			System.out.println("Longitud del arco (90°): " + String.format("%.4f", perimetro / 4));
			break;

		case 2:
			System.out.print("Lado: ");
			double lado = scanner.nextDouble();
			if (lado <= 0) {
				System.out.println("Error: El lado debe ser positivo");
				return;
			}
			area = lado * lado;
			perimetro = 4 * lado;
			System.out.println("\n=== CUADRADO ===");
			System.out.println("Lado: " + lado);
			System.out.println("Diagonal: " + String.format("%.4f", lado * Math.sqrt(2)));
			System.out.println("Área: " + String.format("%.4f", area));
			System.out.println("Perímetro: " + String.format("%.4f", perimetro));
			break;

		case 3:
			System.out.print("Base: ");
			double base = scanner.nextDouble();
			System.out.print("Altura: ");
			double altura = scanner.nextDouble();
			if (base <= 0 || altura <= 0) {
				System.out.println("Error: Las dimensiones deben ser positivas");
				return;
			}
			area = base * altura;
			perimetro = 2 * (base + altura);
			double diagonal = Math.sqrt(base * base + altura * altura);
			System.out.println("\n=== RECTÁNGULO ===");
			System.out.println("Base: " + base);
			System.out.println("Altura: " + altura);
			System.out.println("Diagonal: " + String.format("%.4f", diagonal));
			System.out.println("Área: " + String.format("%.4f", area));
			System.out.println("Perímetro: " + String.format("%.4f", perimetro));
			break;

		case 4:
			System.out.println("\nTipo de datos disponibles:");
			System.out.println("1. Base y altura");
			System.out.println("2. Tres lados (fórmula de Herón)");
			System.out.println("3. Dos lados y ángulo entre ellos");
			System.out.print("Seleccione: ");
			int tipoTriangulo = scanner.nextInt();

			switch (tipoTriangulo) {
			case 1:
				System.out.print("Base: ");
				double baseT = scanner.nextDouble();
				System.out.print("Altura: ");
				double alturaT = scanner.nextDouble();
				area = (baseT * alturaT) / 2;
				System.out.println("\nÁrea del triángulo: " + String.format("%.4f", area));
				System.out.println("(No se puede calcular el perímetro con estos datos)");
				break;

			case 2:
				System.out.print("Lado a: ");
				double a = scanner.nextDouble();
				System.out.print("Lado b: ");
				double b = scanner.nextDouble();
				System.out.print("Lado c: ");
				double c = scanner.nextDouble();

				if (a + b <= c || a + c <= b || b + c <= a) {
					System.out.println("Error: Los lados no forman un triángulo válido");
					return;
				}

				perimetro = a + b + c;
				double s = perimetro / 2;
				area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

				System.out.println("\n=== TRIÁNGULO ===");
				System.out.println("Lados: " + a + ", " + b + ", " + c);
				System.out.println("Área: " + String.format("%.4f", area));
				System.out.println("Perímetro: " + String.format("%.4f", perimetro));

				if (a == b && b == c) {
					System.out.println("Tipo: Equilátero");
				} else if (a == b || b == c || a == c) {
					System.out.println("Tipo: Isósceles");
				} else {
					System.out.println("Tipo: Escaleno");
				}
				break;

			case 3:
				System.out.print("Lado 1: ");
				double lado1 = scanner.nextDouble();
				System.out.print("Lado 2: ");
				double lado2 = scanner.nextDouble();
				System.out.print("Ángulo entre ellos (grados): ");
				double angulo = scanner.nextDouble();

				double anguloRad = Math.toRadians(angulo);
				area = (lado1 * lado2 * Math.sin(anguloRad)) / 2;

				System.out.println("\nÁrea del triángulo: " + String.format("%.4f", area));
				break;
			}
			break;

		case 5:
			System.out.print("Base mayor: ");
			double baseMayor = scanner.nextDouble();
			System.out.print("Base menor: ");
			double baseMenor = scanner.nextDouble();
			System.out.print("Altura: ");
			double alturaTrap = scanner.nextDouble();

			area = ((baseMayor + baseMenor) * alturaTrap) / 2;
			System.out.println("\n=== TRAPECIO ===");
			System.out.println("Área: " + String.format("%.4f", area));
			break;

		case 6:
			System.out.print("Lado: ");
			double ladoPent = scanner.nextDouble();
			area = (Math.sqrt(25 + 10 * Math.sqrt(5)) / 4) * ladoPent * ladoPent;
			perimetro = 5 * ladoPent;
			System.out.println("\n=== PENTÁGONO REGULAR ===");
			System.out.println("Área: " + String.format("%.4f", area));
			System.out.println("Perímetro: " + String.format("%.4f", perimetro));
			break;

		case 7:
			System.out.print("Lado: ");
			double ladoHex = scanner.nextDouble();
			area = (3 * Math.sqrt(3) / 2) * ladoHex * ladoHex;
			perimetro = 6 * ladoHex;
			System.out.println("\n=== HEXÁGONO REGULAR ===");
			System.out.println("Área: " + String.format("%.4f", area));
			System.out.println("Perímetro: " + String.format("%.4f", perimetro));
			break;

		case 8:
			System.out.print("Número de lados: ");
			int n = scanner.nextInt();
			System.out.print("Longitud del lado: ");
			double ladoPoly = scanner.nextDouble();

			if (n < 3) {
				System.out.println("Error: Un polígono debe tener al menos 3 lados");
				return;
			}

			area = (n * ladoPoly * ladoPoly) / (4 * Math.tan(PI / n));
			perimetro = n * ladoPoly;
			double apotema = ladoPoly / (2 * Math.tan(PI / n));

			System.out.println("\n=== POLÍGONO REGULAR ===");
			System.out.println("Número de lados: " + n);
			System.out.println("Apotema: " + String.format("%.4f", apotema));
			System.out.println("Área: " + String.format("%.4f", area));
			System.out.println("Perímetro: " + String.format("%.4f", perimetro));
			break;
		}
	}

	private static void calcularFiguras3D(Scanner scanner) {
		System.out.println("\n--- FIGURAS 3D ---");
		System.out.println("1. Esfera");
		System.out.println("2. Cubo");
		System.out.println("3. Cilindro");
		System.out.println("4. Cono");
		System.out.println("5. Pirámide cuadrada");
		System.out.println("6. Prisma rectangular");
		System.out.print("\nSeleccione figura: ");

		int figura = scanner.nextInt();
		double volumen = 0, superficie = 0;

		switch (figura) {
		case 1:
			System.out.print("Radio: ");
			double radioEsf = scanner.nextDouble();
			volumen = (4.0 / 3.0) * PI * Math.pow(radioEsf, 3);
			superficie = 4 * PI * radioEsf * radioEsf;
			System.out.println("\n=== ESFERA ===");
			System.out.println("Radio: " + radioEsf);
			System.out.println("Diámetro: " + (2 * radioEsf));
			System.out.println("Volumen: " + String.format("%.4f", volumen));
			System.out.println("Superficie: " + String.format("%.4f", superficie));
			break;

		case 2:
			System.out.print("Arista: ");
			double arista = scanner.nextDouble();
			volumen = Math.pow(arista, 3);
			superficie = 6 * arista * arista;
			double diagonalCubo = arista * Math.sqrt(3);
			System.out.println("\n=== CUBO ===");
			System.out.println("Arista: " + arista);
			System.out.println("Diagonal: " + String.format("%.4f", diagonalCubo));
			System.out.println("Volumen: " + String.format("%.4f", volumen));
			System.out.println("Superficie: " + String.format("%.4f", superficie));
			break;

		case 3:
			System.out.print("Radio de la base: ");
			double radioCil = scanner.nextDouble();
			System.out.print("Altura: ");
			double alturaCil = scanner.nextDouble();
			volumen = PI * radioCil * radioCil * alturaCil;
			superficie = 2 * PI * radioCil * (radioCil + alturaCil);
			System.out.println("\n=== CILINDRO ===");
			System.out.println("Radio: " + radioCil);
			System.out.println("Altura: " + alturaCil);
			System.out.println("Volumen: " + String.format("%.4f", volumen));
			System.out.println("Superficie total: " + String.format("%.4f", superficie));
			System.out.println("Área lateral: " + String.format("%.4f", 2 * PI * radioCil * alturaCil));
			break;

		case 4:
			System.out.print("Radio de la base: ");
			double radioCono = scanner.nextDouble();
			System.out.print("Altura: ");
			double alturaCono = scanner.nextDouble();
			double generatriz = Math.sqrt(radioCono * radioCono + alturaCono * alturaCono);
			volumen = (PI * radioCono * radioCono * alturaCono) / 3;
			superficie = PI * radioCono * (radioCono + generatriz);
			System.out.println("\n=== CONO ===");
			System.out.println("Radio: " + radioCono);
			System.out.println("Altura: " + alturaCono);
			System.out.println("Generatriz: " + String.format("%.4f", generatriz));
			System.out.println("Volumen: " + String.format("%.4f", volumen));
			System.out.println("Superficie total: " + String.format("%.4f", superficie));
			break;

		case 5:
			System.out.print("Lado de la base: ");
			double ladoBase = scanner.nextDouble();
			System.out.print("Altura: ");
			double alturaPir = scanner.nextDouble();
			double apotemaPir = Math.sqrt(alturaPir * alturaPir + (ladoBase / 2) * (ladoBase / 2));
			volumen = (ladoBase * ladoBase * alturaPir) / 3;
			superficie = ladoBase * ladoBase + 2 * ladoBase * apotemaPir;
			System.out.println("\n=== PIRÁMIDE CUADRADA ===");
			System.out.println("Lado base: " + ladoBase);
			System.out.println("Altura: " + alturaPir);
			System.out.println("Apotema: " + String.format("%.4f", apotemaPir));
			System.out.println("Volumen: " + String.format("%.4f", volumen));
			System.out.println("Superficie total: " + String.format("%.4f", superficie));
			break;

		case 6:
			System.out.print("Largo: ");
			double largo = scanner.nextDouble();
			System.out.print("Ancho: ");
			double ancho = scanner.nextDouble();
			System.out.print("Alto: ");
			double alto = scanner.nextDouble();
			volumen = largo * ancho * alto;
			superficie = 2 * (largo * ancho + largo * alto + ancho * alto);
			double diagonalPrisma = Math.sqrt(largo * largo + ancho * ancho + alto * alto);
			System.out.println("\n=== PRISMA RECTANGULAR ===");
			System.out.println("Dimensiones: " + largo + " x " + ancho + " x " + alto);
			System.out.println("Diagonal: " + String.format("%.4f", diagonalPrisma));
			System.out.println("Volumen: " + String.format("%.4f", volumen));
			System.out.println("Superficie total: " + String.format("%.4f", superficie));
			break;
		}
	}

	private static void convertirUnidades(Scanner scanner) {
		System.out.println("\n--- CONVERSIÓN DE UNIDADES ---");
		System.out.println("1. Área (m² ↔ ft² ↔ cm²)");
		System.out.println("2. Volumen (m³ ↔ L ↔ galones)");
		System.out.print("\nSeleccione tipo: ");

		int tipo = scanner.nextInt();

		if (tipo == 1) {
			System.out.print("\nIngrese el área: ");
			double valor = scanner.nextDouble();
			System.out.println("\nUnidad actual:");
			System.out.println("1. m²");
			System.out.println("2. ft²");
			System.out.println("3. cm²");
			System.out.print("Seleccione: ");
			int unidad = scanner.nextInt();

			double metros2 = 0;
			switch (unidad) {
			case 1:
				metros2 = valor;
				break;
			case 2:
				metros2 = valor * 0.092903;
				break;
			case 3:
				metros2 = valor / 10000;
				break;
			}

			System.out.println("\n=== CONVERSIONES ===");
			System.out.println("Metros²: " + String.format("%.4f", metros2));
			System.out.println("Pies²: " + String.format("%.4f", metros2 / 0.092903));
			System.out.println("Centímetros²: " + String.format("%.4f", metros2 * 10000));
			System.out.println("Hectáreas: " + String.format("%.6f", metros2 / 10000));
		} else if (tipo == 2) {
			System.out.print("\nIngrese el volumen: ");
			double valor = scanner.nextDouble();
			System.out.println("\nUnidad actual:");
			System.out.println("1. m³");
			System.out.println("2. Litros");
			System.out.println("3. Galones");
			System.out.print("Seleccione: ");
			int unidad = scanner.nextInt();

			double metros3 = 0;
			switch (unidad) {
			case 1:
				metros3 = valor;
				break;
			case 2:
				metros3 = valor / 1000;
				break;
			case 3:
				metros3 = valor * 0.00378541;
				break;
			}

			System.out.println("\n=== CONVERSIONES ===");
			System.out.println("Metros³: " + String.format("%.4f", metros3));
			System.out.println("Litros: " + String.format("%.4f", metros3 * 1000));
			System.out.println("Galones: " + String.format("%.4f", metros3 / 0.00378541));
			System.out.println("Pies³: " + String.format("%.4f", metros3 * 35.3147));
		}
	}

	private static void compararFiguras(Scanner scanner) {
		System.out.println("\n--- COMPARACIÓN DE FIGURAS ---");
		System.out.println("Compare el área de dos figuras 2D");

		double area1 = 0, area2 = 0;
		String nombre1 = "", nombre2 = "";

		for (int i = 1; i <= 2; i++) {
			System.out.println("\nFIGURA " + i + ":");
			System.out.println("1. Círculo");
			System.out.println("2. Cuadrado");
			System.out.println("3. Rectángulo");
			System.out.print("Seleccione: ");
			int figura = scanner.nextInt();

			double areaActual = 0;
			String nombreActual = "";

			switch (figura) {
			case 1:
				System.out.print("Radio: ");
				double radio = scanner.nextDouble();
				areaActual = PI * radio * radio;
				nombreActual = "Círculo (r=" + radio + ")";
				break;
			case 2:
				System.out.print("Lado: ");
				double lado = scanner.nextDouble();
				areaActual = lado * lado;
				nombreActual = "Cuadrado (l=" + lado + ")";
				break;
			case 3:
				System.out.print("Base: ");
				double base = scanner.nextDouble();
				System.out.print("Altura: ");
				double altura = scanner.nextDouble();
				areaActual = base * altura;
				nombreActual = "Rectángulo (" + base + "x" + altura + ")";
				break;
			}

			if (i == 1) {
				area1 = areaActual;
				nombre1 = nombreActual;
			} else {
				area2 = areaActual;
				nombre2 = nombreActual;
			}
		}

		System.out.println("\n=== COMPARACIÓN ===");
		System.out.println(nombre1 + " - Área: " + String.format("%.4f", area1));
		System.out.println(nombre2 + " - Área: " + String.format("%.4f", area2));

		if (Math.abs(area1 - area2) < 0.0001) {
			System.out.println("\nLas figuras tienen áreas iguales");
		} else if (area1 > area2) {
			double porcentaje = ((area1 - area2) / area2) * 100;
			System.out.println("\n" + nombre1 + " es mayor");
			System.out.println("Diferencia: " + String.format("%.4f", area1 - area2));
			System.out.println("Es " + String.format("%.2f%%", porcentaje) + " más grande");
		} else {
			double porcentaje = ((area2 - area1) / area1) * 100;
			System.out.println("\n" + nombre2 + " es mayor");
			System.out.println("Diferencia: " + String.format("%.4f", area2 - area1));
			System.out.println("Es " + String.format("%.2f%%", porcentaje) + " más grande");
		}
	}
}