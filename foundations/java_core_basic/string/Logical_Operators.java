package java_core_basic.string;

public class Logical_Operators {
	public static void main(String[] args) {
		System.out.println("=== Logical Operators with Numbers ===");
		int x = 5;
		int y = 10;
		System.out.println("x = " + x + ", y = " + y);
		System.out.println("(x > 0) && (y < 20): " + ((x > 0) && (y < 20)));
		System.out.println("(x == 5) || (y == 10): " + ((x == 5) || (y == 10)));
		System.out.println("(x <= 6) && !(y <= 9): " + ((x <= 6) && !(y <= 9)));
		System.out.println("(x == y) && !(y <= 9): " + ((x == y) && !(y <= 9)));
		System.out.println("!((y >= x) || (x >= y)): " + (!((y >= x) || (x >= y))));

		System.out.println("\n=== Logical Operators with Strings ===");
		String text = "Hola Amigo";
		System.out.println("Texto: '" + text + "'");
		System.out.println("(Tamaño del Texto <= 10): " + (text.length() <= 10));
		System.out
				.println("(charAt(0) == 'H') && equals('Hola'): " + ((text.charAt(0) == 'H') && (text.equals("Hola"))));
		System.out.println("trim().equals(text) && startsWith('Hol'): "
				+ (("Hola".trim().equals(text)) && (text.startsWith("Hol"))));
		System.out.println("!endsWith('eM') || toLowerCase().startsWith('h'): "
				+ (!(text.endsWith("eM")) || (text.toLowerCase().startsWith("h"))));
		System.out.println("(indexOf('h') < 0) || (lastIndexOf('EM') >= -1): "
				+ ((text.indexOf("h") < 0) || (text.lastIndexOf("EM") >= -1)));
	}

}
