package fundamentals.method_overloading.basic_operations;

public class OperacionesAvanzadas {

	public int sumar(int numeroUno, int numeroDos) {
		return numeroUno + numeroDos;
	}

	public int sumar(int numeroUno, int numeroDos, int numeroTres) {
		return numeroUno + numeroDos + numeroTres;
	}

	public int sumar(int[] numeros) {
		if (numeros == null) {
			throw new IllegalArgumentException("El array no puede ser null");
		}

		int suma = 0;
		for (int numero : numeros) {
			suma += numero;
		}
		return suma;
	}

	public double sumar(double numeroUno, double numeroDos) {
		return numeroUno + numeroDos;
	}

	public double sumar(double[] numeros) {
		if (numeros == null) {
			throw new IllegalArgumentException("El array no puede ser null");
		}

		double suma = 0.0;
		for (double numero : numeros) {
			suma += numero;
		}
		return suma;
	}

	public int operacionPersonalizada(int numeroUno, int numeroDos, int numeroTres, String operacion) {
		if (operacion == null) {
			System.out.println("Error: La operación no puede ser null");
			return 0;
		}

		switch (operacion.toLowerCase().trim()) {
		case "multiplicar":
			return numeroUno * numeroDos + numeroTres;
		case "restar":
			return numeroUno - numeroDos - numeroTres;
		default:
			System.out.println("Operación no soportada: " + operacion);
			System.out.println("Operaciones válidas: 'multiplicar', 'restar'");
			return 0;
		}
	}

	public String obtenerInformacionMetodos() {
		return "Métodos disponibles:\n" + "- sumar(int, int)\n" + "- sumar(int, int, int)\n" + "- sumar(int[])\n"
				+ "- sumar(double, double)\n" + "- sumar(double[])\n"
				+ "- operacionPersonalizada(int, int, int, String)";
	}
}