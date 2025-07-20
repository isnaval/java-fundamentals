package collections.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class TextFrequencyAnalyzer {
	public static void main(String[] args) {
		analyzeUserInput();
		analizePredefinedText();
	}

	private static void analyzeUserInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("=== ANALIZADOR DE FRECUENCIA");
		System.out.println("Escribe una frase");
		String text = scanner.nextLine();
		HashMap<String, Integer> frequency = countWords(text);
		showResults(frequency);
		scanner.close();
	}

	private static void showResults(HashMap<String, Integer> frequency) {
		System.out.println("\n--- RESULTADOS ---");
		System.out.println("Frecuencia de palabras");
		for (String word : frequency.keySet()) {
			int count = frequency.get(word);
			System.out.println(word + ": " + count);
		}
	}

	private static HashMap<String, Integer> countWords(String text) {
		HashMap<String, Integer> wordCount = new HashMap<>();
		String[] words = text.toLowerCase().split(" ");
		for (String word : words) {
			word = word.replaceAll("[^a-zA-Z0-9]", "");
			if (!word.isEmpty()) {
				if (wordCount.containsKey(word)) {
					int count = wordCount.get(word);
					wordCount.put(word, count + 1);
				} else {
					wordCount.put(word, 1);
				}
			}

		}
		return wordCount;
	}

	private static void analizePredefinedText() {
		System.out.println("\n=== EJEMPLO CON TEXTO PREDEFINIDO ===");
		String text = "java es genial java es poderoso java es popular";
		System.out.println("Texto: " + text);

		HashMap<String, Integer> frequency = countWords(text);
		showResults(frequency);

	}

}
