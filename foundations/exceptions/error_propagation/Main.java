package error_propagation;

/**
 * Este ejercicio muestra cómo se propaga un error de una clase a otra.
 * Al generar varios archivos conectados en cadena, siendo que el archivo 
 * final genera una excepción, podemos observar cómo esta excepción 
 * se transmite hacia atrás a través de toda la cadena de llamadas.
 */

public class Main {
	
	public static void main(String[] args) {
		File01 file01 = new File01();
		String result = file01.method();
		System.out.println(result);
	}

}
