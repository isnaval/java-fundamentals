package collections.hashmap;

import java.util.HashMap;

public class HashMapCrudOperations {

	public static void main(String[] args) {
		demonstrateBasicOperations();
		demonstrateContainsMethods();
		demonstrateUpdateOperations();
		demonstrateSizeAndRemoveOperations();
	}

	private static void demonstrateBasicOperations() {
		System.out.println("=== OPERACIONES BÁSICOS ===");
		HashMap<Integer, String> languages = new HashMap<>();
		languages.put(1, "JAVA");
		languages.put(2, "JavaScript");
		languages.put(3, "PHP");
		languages.put(4, "Swift");
		languages.put(5, "Ruby");
		languages.put(6, "HTML");
		System.out.println("HashMap creado: " + languages);

		String lang1 = languages.get(1);
		String lang2 = languages.get(2);
		String lang3 = languages.get(3);
		System.out.println("Elementos obtenidos: " + lang1 + ", " + lang2 + ", " + lang3);

		String noExiste = languages.get(100);
		System.out.println("Elemento que no existe (clave 100): " + noExiste);
	}

	private static void demonstrateContainsMethods() {
		System.out.println("\n=== MÉTODOS CONTAINS ===");
		HashMap<Integer, String> languages = createLanguagesMap();
		System.out.println("¿Contiene clave 1? " + languages.containsKey(1));
		System.out.println("¿Contiene clave 100? " + languages.containsKey(100));
		System.out.println("¿Contiene valor 'JAVA'? " + languages.containsValue("JAVA"));
		System.out.println("¿Contiene valor 'Python'? " + languages.containsValue("Python"));
		System.out.println("¿Contiene valor 'Onix'? " + languages.containsValue("Onix"));
	}

	private static void demonstrateUpdateOperations() {
		System.out.println("\n=== OPERACIONES DE ACTUALIZACIÓN ===");
		HashMap<Integer, String> languages = createLanguagesMap();
		languages.put(3, "Haskell");
		System.out.println("Después de cambiar clave 3 a 'Haskell': " + languages.get(3));
		String valorAnterior = languages.put(4, "Kotlin");
		System.out.println("Valor anterior de clave 4: " + valorAnterior);
		System.out.println("Nuevo Valor de clave 4: " + languages.get(4));
		System.out.println("HashMap actualizado: " + languages);
	}

	private static void demonstrateSizeAndRemoveOperations() {
		System.out.println("\n=== OPERACIONES DE ELIMINACIÓN Y TAMAÑO ===");
		HashMap<Integer, String> languages = createLanguagesMap();
		System.out.println("Tamaño inicial: " + languages.size());
		System.out.println("HashMap antes de eliminar: " + languages);
		String removed = languages.remove(5);
		System.out.println("Elemento eliminado (clave 5): " + removed);
		System.out.println("HashMap después de eliminar: " + languages);
		System.out.println("Nuevo tamaño: " + languages.size());
		String noRemovido = languages.remove(100);
		System.out.println("Intento de eliminar clave 100: " + noRemovido);
		System.out.println("¿Está vacío? " + languages.isEmpty());
		languages.clear();
		System.out.println("Después de clear() - Tamaño: " + languages.size());
		System.out.println("¿Está vacío ahora? " + languages.isEmpty());
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

}
