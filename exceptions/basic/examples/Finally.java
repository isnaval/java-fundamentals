package exceptions.basic.examples;

import java.io.FileWriter;
import java.io.IOException;

public class Finally {

	public static void main(String[] args) {
		FileWriter writer = null;

		try {
			writer = new FileWriter("test.txt");
			writer.write("Hola mundo!");
			int result = 10 / 0;

			writer.write("Esta línea nunca se ejecuta");

		} catch (IOException e) {
			System.out.println("Error de E/S: " + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("Error aritmético: " + e.getMessage());
		} finally {
			System.out.println("Bloque finally: cerrando recursos...");
			if (writer != null) {
				try {
					writer.close();
					System.out.println("Archivo cerrado correctamente");
				} catch (IOException e) {
					System.out.println("Error al cerrar archivo");
				}
			}
		}
	}
}
