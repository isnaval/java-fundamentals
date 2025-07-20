package exceptions.basic.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Throws {

	public static void main(String[] args) {

		try {
			String content = readFile("archivo.txt");
			System.out.println("Contenido: " + content);
		} catch (IOException e) {
			System.out.println("Error al leer archivo: " + e.getMessage());
		}
	}

	public static String readFile(String filename) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		try {
			StringBuilder content = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				content.append(line).append("\n");
			}
			return content.toString();
		} finally {
			reader.close();
		}
	}
}