package java_advanced_testing.unit_tests.advanced;

import java_advanced_testing.model.Book;
import java_advanced_testing.resources.test_data.BookTestData;

public class BookAuthorCombinationTest {
	public static void main(String[] args) {
		System.out.println("BOOK AUTHOR COMBINATION ADVANCED TESTS");
		System.out.println("========================================");

		testAuthorBookCombinations();
		testMultipleBooksByAuthor();
		testBookGenreAnalysis();
		testAuthorProductivity();
		testBookQualityMetrics();

		System.out.println("\nBook author combination tests completados");
	}

	public static void testAuthorBookCombinations() {
		System.out.println("\n--- Test: Author Book Combinations ---");

		// Crear múltiples libros del mismo autor
		Book[] cervantesBooks = { new Book("El Quijote", "Miguel de Cervantes", "978-84-001", 15.99),
				new Book("La Galatea", "Miguel de Cervantes", "978-84-002", 12.99),
				new Book("Novelas Ejemplares", "Miguel de Cervantes", "978-84-003", 18.99) };

		// Validar consistencia del autor
		String expectedAuthor = "Miguel de Cervantes";
		boolean allSameAuthor = true;
		double totalPrice = 0.0;

		for (Book book : cervantesBooks) {
			if (!book.getAuthor().equals(expectedAuthor)) {
				allSameAuthor = false;
			}
			totalPrice += book.getPrice();
		}

		System.out.println("Libros del mismo autor: " + allSameAuthor);
		System.out.println("Precio total coleccion: $" + totalPrice);
		System.out.println("Precio promedio: $" + (totalPrice / cervantesBooks.length));
		System.out.println("   Test consistencia autor: " + (allSameAuthor ? "PASS" : "FAIL"));
		System.out.println("   Test precio razonable: " + (totalPrice > 40.0 && totalPrice < 100.0 ? "PASS" : "FAIL"));
	}

	public static void testMultipleBooksByAuthor() {
		System.out.println("\n--- Test: Multiple Books by Author ---");

		// Simular biblioteca de libros
		Book[] library = { BookTestData.createValidBook(), BookTestData.createExpensiveBook(),
				BookTestData.createFreeBook(),
				new Book("Cien años de soledad", "Gabriel García Márquez", "978-84-100", 22.99),
				new Book("El amor en los tiempos del cólera", "Gabriel García Márquez", "978-84-101", 20.99),
				new Book("1984", "George Orwell", "978-84-200", 16.99),
				new Book("Rebelión en la granja", "George Orwell", "978-84-201", 14.99) };

		// Análisis por autor
		String[] authors = { "Miguel de Cervantes", "Gabriel García Márquez", "George Orwell" };

		for (String author : authors) {
			int bookCount = 0;
			double totalValue = 0.0;
			double minPrice = Double.MAX_VALUE;
			double maxPrice = Double.MIN_VALUE;

			for (Book book : library) {
				if (book.getAuthor().equals(author)) {
					bookCount++;
					totalValue += book.getPrice();
					minPrice = Math.min(minPrice, book.getPrice());
					maxPrice = Math.max(maxPrice, book.getPrice());
				}
			}

			if (bookCount > 0) {
				System.out.println("Autor: " + author);
				System.out.println("   Libros: " + bookCount);
				System.out.println("   Valor total: $" + totalValue);
				System.out.println("   Precio min: $" + minPrice);
				System.out.println("   Precio max: $" + maxPrice);
				System.out.println("   Promedio: $" + (totalValue / bookCount));

				boolean isProductiveAuthor = bookCount >= 2;
				System.out.println("   Es autor productivo: " + (isProductiveAuthor ? "PASS" : "FAIL"));
			}
		}
	}

	public static void testBookGenreAnalysis() {
		System.out.println("\n--- Test: Book Genre Analysis ---");

		// Clasificación por precio como indicador de género
		Book[] books = { BookTestData.createFreeBook(), // Género: Educativo
				new Book("Novela Popular", "Autor Pop", "978-84-300", 12.99), // Género: Popular
				new Book("Libro Académico", "Dr. Académico", "978-84-400", 89.99), // Género: Académico
				BookTestData.createExpensiveBook() // Género: Premium
		};

		int educationalCount = 0;
		int popularCount = 0;
		int academicCount = 0;
		int premiumCount = 0;

		for (Book book : books) {
			String genre = classifyBookByPrice(book.getPrice());
			switch (genre) {
			case "EDUCATIVO":
				educationalCount++;
				break;
			case "POPULAR":
				popularCount++;
				break;
			case "ACADEMICO":
				academicCount++;
				break;
			case "PREMIUM":
				premiumCount++;
				break;
			}

			System.out.println(book.getTitle() + " - Género: " + genre + " ($" + book.getPrice() + ")");
		}

		System.out.println("Distribución por género:");
		System.out.println("   Educativo: " + educationalCount);
		System.out.println("   Popular: " + popularCount);
		System.out.println("   Académico: " + academicCount);
		System.out.println("   Premium: " + premiumCount);

		boolean balancedDistribution = educationalCount > 0 && popularCount > 0 && academicCount > 0
				&& premiumCount > 0;
		System.out.println("   Distribución balanceada: " + (balancedDistribution ? "PASS" : "FAIL"));
	}

	private static String classifyBookByPrice(double price) {
		if (price == 0.0)
			return "EDUCATIVO";
		else if (price < 20.0)
			return "POPULAR";
		else if (price < 100.0)
			return "ACADEMICO";
		else
			return "PREMIUM";
	}

	public static void testAuthorProductivity() {
		System.out.println("\n--- Test: Author Productivity ---");

		// Simular productividad de autores
		String[] productiveAuthors = { "Autor Prolífico", "Escritor Rápido" };
		String[] slowAuthors = { "Autor Perfeccionista" };

		// Test autor prolífico
		Book[] prolificBooks = new Book[5];
		for (int i = 0; i < prolificBooks.length; i++) {
			prolificBooks[i] = new Book("Libro " + (i + 1), productiveAuthors[0], "978-84-" + String.format("%03d", i),
					15.99 + i);
		}

		System.out.println("Autor prolífico: " + prolificBooks.length + " libros");
		System.out.println("   Es prolífico: " + (prolificBooks.length >= 5 ? "PASS" : "FAIL"));

		// Test autor perfeccionista (pocos libros pero caros)
		Book perfectBook = new Book("Obra Maestra", slowAuthors[0], "978-84-999", 299.99);
		System.out.println("Autor perfeccionista: 1 libro premium ($" + perfectBook.getPrice() + ")");
		System.out.println("   Es perfeccionista: " + (perfectBook.getPrice() > 200.0 ? "PASS" : "FAIL"));
	}

	public static void testBookQualityMetrics() {
		System.out.println("\n--- Test: Book Quality Metrics ---");

		Book[] qualityBooks = { BookTestData.createValidBook(),
				new Book("Libro Extenso con Descripción Muy Detallada", "Autor Detallista", "978-84-500", 45.99),
				new Book("A", "B", "123", 1.0), // Libro de baja calidad
				BookTestData.createExpensiveBook() };

		for (Book book : qualityBooks) {
			int qualityScore = calculateQualityScore(book);
			String qualityLevel = getQualityLevel(qualityScore);

			System.out.println(book.getTitle() + " - Puntuación: " + qualityScore + " (" + qualityLevel + ")");
		}
	}

	private static int calculateQualityScore(Book book) {
		int score = 0;

		// Puntuación por longitud del título
		if (book.getTitle().length() > 10)
			score += 2;
		else if (book.getTitle().length() > 5)
			score += 1;

		// Puntuación por longitud del autor
		if (book.getAuthor().length() > 10)
			score += 2;
		else if (book.getAuthor().length() > 3)
			score += 1;

		// Puntuación por precio
		if (book.getPrice() > 50.0)
			score += 3;
		else if (book.getPrice() > 20.0)
			score += 2;
		else if (book.getPrice() > 0.0)
			score += 1;

		// Puntuación por ISBN válido
		if (book.getIsbn() != null && book.getIsbn().length() > 10)
			score += 2;

		return score;
	}

	private static String getQualityLevel(int score) {
		if (score >= 8)
			return "EXCELENTE";
		else if (score >= 6)
			return "BUENO";
		else if (score >= 4)
			return "REGULAR";
		else
			return "BAJO";
	}
}
