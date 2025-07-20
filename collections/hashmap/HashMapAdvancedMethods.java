package collections.hashmap;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapAdvancedMethods {
	public static void main(String[] args) {
		HashMap<Integer, String> languages = createLanguagesMap();
		iterateKeys(languages);
		iterateValues(languages);
		iterateEntries(languages);
	}

	private static HashMap<Integer, String> createLanguagesMap() {
		HashMap<Integer, String> languages = new HashMap<>();
		languages.put(1, "JAVA");
		languages.put(2, "JavaScript");
		languages.put(3, "PHP");
		languages.put(4, "Swift");
		languages.put(5, "Ruby");
		languages.put(6, "HTML");
		return languages;
	}

	private static void iterateKeys(HashMap<Integer, String> map) {
		System.out.println("=== RECORRER CLAVES ===");
		for (Integer key : map.keySet()) {
			System.out.println(key + " ");
		}
		System.out.println();
	}

	private static void iterateValues(HashMap<Integer, String> map) {
		System.out.println("=== RECORER VALORES ===");
		for (String value : map.values()) {
			System.out.println(value + " ");
		}
		System.out.println();

	}

	private static void iterateEntries(HashMap<Integer, String> map) {
		System.out.println("=== RECORRER CLAVES Y VALORES ===");
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
