package java_core.method_overloading.basic_operations;

public class Main {

	public static void main(String[] args) {
		OperacionesAvanzadas operaciones = new OperacionesAvanzadas();

		System.out.println("=== DEMOSTRACIÓN DE SOBRECARGA DE MÉTODOS ===\n");
		System.out.println("Clase: OperacionesAvanzadas");
		System.out.println("Concepto: Method Overloading (Sobrecarga de Métodos)\n");

		System.out.println("1. SUMA DE DOS ENTEROS:");
		int resultado1 = operaciones.sumar(5, 7);
		System.out.println("   operaciones.sumar(5, 7) = " + resultado1);

		System.out.println("\n2. SUMA DE TRES ENTEROS:");
		int resultado2 = operaciones.sumar(5, 7, 2);
		System.out.println("   operaciones.sumar(5, 7, 2) = " + resultado2);

		System.out.println("\n3. SUMA DE ARRAY DE ENTEROS:");
		int[] arrayEnteros = { 1, 2, 3, 4, 5 };
		int resultado3 = operaciones.sumar(arrayEnteros);
		System.out.println("   operaciones.sumar([1, 2, 3, 4, 5]) = " + resultado3);

		System.out.println("\n4. SUMA DE DOS DECIMALES:");
		double resultado4 = operaciones.sumar(2.5, 5.1);
		System.out.println("   operaciones.sumar(2.5, 5.1) = " + resultado4);

		System.out.println("\n5. SUMA DE ARRAY DE DECIMALES:");
		double[] arrayDecimales = { 1.5, 2.0, 3.3, 4.7, 8.2 };
		double resultado5 = operaciones.sumar(arrayDecimales);
		System.out.println("   operaciones.sumar([1.5, 2.0, 3.3, 4.7, 8.2]) = " + resultado5);

		System.out.println("\n6. OPERACIONES PERSONALIZADAS:");
		int resultado6 = operaciones.operacionPersonalizada(3, 4, 4, "multiplicar");
		System.out.println("   operacionPersonalizada(3, 4, 4, \"multiplicar\") = " + resultado6);

		int resultado7 = operaciones.operacionPersonalizada(10, 3, 2, "restar");
		System.out.println("   operacionPersonalizada(10, 3, 2, \"restar\") = " + resultado7);

		System.out.println("\n7. INFORMACIÓN DE MÉTODOS DISPONIBLES:");
		System.out.println(operaciones.obtenerInformacionMetodos());

		System.out.println("\n=== FIN DE LA DEMOSTRACIÓN ===");
	}
}