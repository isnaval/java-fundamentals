package java_core_basic.string;

public class String_Validation_Comparison {
	public static void main(String[] main) {
		String password = "1234";
		boolean passwordEmpy = password.isEmpty();
		System.out.println("La constraseña esta vacia: " + passwordEmpy);
		boolean passwordEmpy2 = password.length() == 0;
		System.out.println("La constraseña esta vacia " + passwordEmpy2);

		String example = "HOLA";
		String example1 = "Hola";
		String example2 = "HOla";

		System.out.println("=== String Comparison Examples ===");
		System.out.println("Las dos palabras son iguales: (==) " + (example == example1));
		System.out.println("Las dos palabras son siguales: (equals)" + (example.equals(example2)));
		System.out.println("Las dos palabras son iguales: (==) " + (example == example1));
		System.out.println("Las dos palabras son iguales: (==) " + (example == example1));
		System.out.println("las dos palabras son diferentes (!=): " + (example1 != example2));
		System.out.println("las dos palabras son diferentes (!equals): " + (!(example.equals(example1))));

	}

}
