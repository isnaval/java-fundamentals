package exceptions.basic.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

	public static void main(String[] args) {
		oldWay("archivo1.txt");
		modernWay("archivo2.txt");
	}

	public static void oldWay(String filename) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filename));
			System.out.println("Primera línea: " + reader.readLine());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("Error al cerrar: " + e.getMessage());
				}
			}
		}
	}

	public static void modernWay(String filename) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			System.out.println("Primera línea: " + reader.readLine());
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
