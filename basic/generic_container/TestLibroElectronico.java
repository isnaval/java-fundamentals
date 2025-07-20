package basic.generic_container;

public class TestLibroElectronico {

	public static void main(String[] args) {
		System.out.println("=".repeat(40));
		System.out.println("TESTS BÁSICOS PARA LIBROELECTRONICO");
		System.out.println("=".repeat(40));

		System.out.println("\nTest 1: Libro con precio Double");
		LibroElectronico<Double> libro1 = new LibroElectronico<>("El Principito", "Antoine de Saint-Exupéry", 15.50);
		libro1.mostrarDetalles();

		System.out.println("\nTest 2: Libro con precio Integer");
		LibroElectronico<Integer> libro2 = new LibroElectronico<>("Harry Potter", "J.K. Rowling", 300);
		libro2.mostrarDetalles();

		System.out.println("\nTest 3: Libro con precio String");
		LibroElectronico<String> libro3 = new LibroElectronico<>("Don Quijote", "Miguel de Cervantes", "Gratis");
		libro3.mostrarDetalles();

		System.out.println("\nTest 4: Constructor vacío y setters");
		LibroElectronico<Double> libro4 = new LibroElectronico<>();
		libro4.setTitulo("Cien años de soledad");
		libro4.setAutor("Gabriel García Márquez");
		libro4.setPrecio(22.75);
		libro4.mostrarDetalles();

		System.out.println("\nTest 5: Probando getters");
		System.out.println("Título: " + libro1.getTitulo());
		System.out.println("Autor: " + libro1.getAutor());
		System.out.println("Precio: " + libro1.getPrecio());

		System.out.println("\nTest 6: Probando toString()");
		System.out.println(libro1.toString());
		System.out.println(libro2.toString());
		System.out.println(libro3.toString());

		System.out.println("\n¡Todos los tests completados!");
	}
}
