package collections.hashmap;

import java.util.HashMap;

public class HashMapIterationMethods {
	public static void main(String[] args) {
		demonstratePutIfAbsent();
		demonstrateReplace();
		demonstrateMerge();
		demonstrateComputeMethods();
	}

	private static void demonstratePutIfAbsent() {
		System.out.println("=== PUT IF ABSENT ===");
		HashMap<String, Integer> scores = new HashMap<>();
		scores.put("Ana", 85);
		scores.put("Luis", 92);
		System.out.println("Puntuaciones iniciales: " + scores);
		scores.putIfAbsent("Ana", 95);
		scores.putIfAbsent("Carlos", 88);
		System.out.println("Después de putIfAbsent: " + scores);
	}

	private static void demonstrateReplace() {
		System.out.println("\n=== REPLACE METHODS ===");
		HashMap<String, String> status = new HashMap<>();
		status.put("servidor1", "activo");
		status.put("servidor2", "inactivo");
		System.out.println("Estado inicial: " + status);
		status.replace("servidor1", "mantenimiento");
		status.replace("servidor3", "activo");
		System.out.println("Después de replace: " + status);
		boolean changed = status.replace("servidor2", "inactivo", "activo");
		System.out.println("¿Se cambió servidor2? " + changed);
		System.out.println("Estado final: " + status);
	}

	private static void demonstrateMerge() {
		System.out.println("\n=== MERGE METHOD ===");
		HashMap<String, Integer> inventory = new HashMap<>();
		inventory.put("manzanas", 10);
		inventory.put("peras", 5);
		System.out.println("Inventario inicial: " + inventory);
		inventory.merge("manzanas", 8, Integer::sum);
		inventory.merge("naranjas", 12, Integer::sum);
		System.out.println("Después de merge: " + inventory);
		String[] fruits = { "manzana", "pera", "manzana", "naranja", "manzana" };
		HashMap<String, Integer> count = new HashMap<>();
		for (String fruit : fruits) {
			count.merge(fruit, 1, Integer::sum);
		}
		System.out.println("Conteo de frutas: " + count);
	}

	private static void demonstrateComputeMethods() {
		System.out.println("\n=== COMPUTE METHODS ===");
		HashMap<String, Integer> ages = new HashMap<>();
		ages.put("Juan", 25);
		ages.put("María", 30);
		System.out.println("Edades iniciales: " + ages);
		ages.computeIfAbsent("Pedro", name -> name.length() * 5);
		ages.computeIfAbsent("Juan", name -> 999);
		System.out.println("Después de computeIfAbsent: " + ages);
		ages.computeIfPresent("María", (name, age) -> age + 1);
		ages.computeIfPresent("Ana", (name, age) -> age + 1);
		System.out.println("Después de computeIfPresent: " + ages);
		ages.compute("Juan", (name, age) -> age == null ? 1 : age * 2);
		ages.compute("Sofia", (name, age) -> age == null ? 22 : age * 2);
		System.out.println("Después de compute: " + ages);
	}

}
