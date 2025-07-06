package java_core_basic.generic_container;

public class Main {
	public static void main(String[] args) {

		System.out.println("SISTEMA DE LIBROS ELECTRÓNICOS - DEMO GENERICS");
		System.out.println("=".repeat(40));

		System.out.println("\n1. Libro con precio en Double (euros):");
		LibroElectronico<Double> libroDouble = new LibroElectronico<>("Dune", "Frank Herbert", 24.99);
		libroDouble.mostrarDetalles();

		System.out.println("\n2. Libro con precio en Integer (puntos):");
		LibroElectronico<Integer> libroInteger = new LibroElectronico<>("1984", "George Orwell", 450);
		libroInteger.mostrarDetalles();

		System.out.println("\n3. Libro con precio en String:");
		LibroElectronico<String> libroString = new LibroElectronico<>("El Quijote", "Miguel de Cervantes", "Gratis");
		libroString.mostrarDetalles();

		System.out.println("\n4. Libro creado con setters:");
		LibroElectronico<Float> libroFloat = new LibroElectronico<>();
		libroFloat.setTitulo("Clean Code");
		libroFloat.setAutor("Robert C. Martin");
		libroFloat.setPrecio(39.99f);
		libroFloat.mostrarDetalles();

		System.out.println("\n5. Usando toString():");
		System.out.println(libroDouble.toString());
		System.out.println(libroInteger.toString());
		System.out.println(libroString.toString());

		System.out.println("\n¡Demo completada!");

	}

}
