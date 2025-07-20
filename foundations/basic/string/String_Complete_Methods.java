package basic.string;

public class String_Complete_Methods {

	public static void main(String[] args) {
		String text = "estamos aprendiendo a programar";
		System.out.println("Texto original: " + text);
		System.out.println("=====================");

		// Basic properties
		System.out.println("Longitud: " + text.length());
		System.out.println("Mayúsculas: " + text.toUpperCase());
		System.out.println("Minúsculas: " + text.toLowerCase());
		System.out.println("=====================");

		// Character access
		System.out.println("Caracter en posición 8: " + text.charAt(7));
		System.out.println("Último caracter: " + text.charAt(text.length() - 1));
		System.out.println("=====================");

		// Substring operations
		System.out.println("Desde posición 3: " + text.substring(2));
		System.out.println("Posición 3 a 8: " + text.substring(2, 8));
		System.out.println("Últimos 2 caracteres: " + text.substring(text.length() - 2));
		System.out.println("=====================");

		// Search and replace
		System.out.println("Reemplazar 'a' por '-': " + text.replace('a', '-'));
		System.out.println("Índice de 'd': " + text.indexOf('d'));
		System.out.println("Último índice de 'a': " + text.lastIndexOf('a'));
		System.out.println("Índice de 'x': " + text.indexOf('x'));
		System.out.println("=====================");

		// Pattern matching
		System.out.println("¿Contiene 'o a p'? " + text.contains("o a p"));
		System.out.println("¿Empieza con 'estamos'? " + text.startsWith("estamos"));
		System.out.println("¿Termina con 'programar'? " + text.endsWith("programar"));
		System.out.println("=====================");

		// Complex operations
		System.out.println("Sin espacios en mayúsculas: " + text.replaceAll(" ", "").toUpperCase());
		System.out.println("=====================");

	}

}
