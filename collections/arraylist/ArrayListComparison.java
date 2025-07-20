package collections.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListComparison {

	// 1 creo el objeto
	static class Estudiante {
		String nombre;
		int edad;
		double promedio;

		public Estudiante(String nombre, int edad, double promedio) {
			this.nombre = nombre;
			this.edad = edad;
			this.promedio = promedio;
		}

		@Override
		public String toString() {
			return String.format("%s (edad: %d, promedio: %.2f)", nombre, edad, promedio);
		}
	}

	// 2 creo el metodo
	public static void main(String[] args) {
		System.out.println("=== COMPARACIÓN Y ORDENAMIENTO EN ARRAYLIST ===\n");
		System.out.println("1. COMPARACIÓN DE LISTAS: ");
		ArrayList<String> lista1 = new ArrayList<>();
		ArrayList<String> lista2 = new ArrayList<>();
		ArrayList<String> lista3 = new ArrayList<>();
		lista1.add("A");
		lista1.add("B");
		lista1.add("C");
		lista2.add("A");
		lista2.add("B");
		lista2.add("C");
		lista3.add("C");
		lista3.add("B");
		lista3.add("A");
		System.out.println("Lista 1: " + lista1);
		System.out.println("Lista 2: " + lista2);
		System.out.println("Lista 3: " + lista3);
		System.out.println("¿Lista1 equals Lista2? " + lista1.equals(lista2));
		System.out.println("¿Lista1 equals Lista3? " + lista1.equals(lista3));

		System.out.println("\n2. ORDENAMIENTO BÁSICO:");
		ArrayList<Integer> numeros = new ArrayList<>();
		numeros.add(5);
		numeros.add(2);
		numeros.add(8);
		numeros.add(1);
		numeros.add(9);
		System.out.println("Lista original: " + numeros);
		Collections.sort(numeros);
		System.out.println("Lista ordenada ascendente: " + numeros);
		Collections.reverse(numeros);
		System.out.println("Lista ordenada descendente: " + numeros);

		System.out.println("\n3. ORDENAMIENTO DE STRINGS:");
		ArrayList<String> palabras = new ArrayList<>();
		palabras.add("Zebra");
		palabras.add("Árbol");
		palabras.add("Casa");
		palabras.add("Banana");
		System.out.println("Lista original: " + palabras);
		Collections.sort(palabras);
		System.out.println("Ordenada alfabéticamente: " + palabras);
		Collections.sort(palabras, String.CASE_INSENSITIVE_ORDER);
		System.out.println("Ordenada sin considerar mayúsculas: " + palabras);

		System.out.println("\n4. ORDENAMIENTO DE OBJETOS PERSONALIZADOS:");
		ArrayList<Estudiante> estudiantes = new ArrayList<>();
		estudiantes.add(new Estudiante("Ana", 28, 8.5));
		estudiantes.add(new Estudiante("Carlos", 19, 9.2));
		estudiantes.add(new Estudiante("Beatriz", 21, 7.8));
		estudiantes.add(new Estudiante("David", 20, 8.9));
		System.out.println("\nLista original: ");
		estudiantes.forEach(e -> System.out.println("   " + e));
		System.out.println("\n Ordenados por edad: ");
		Collections.sort(estudiantes, Comparator.comparingInt(e -> e.edad));
		estudiantes.forEach(e -> System.out.println("   " + e));
		System.out.println("\nOrdenados por promedio (mayor a menor):");
		Collections.sort(estudiantes, Comparator.comparingDouble((Estudiante e) -> e.promedio).reversed());
		estudiantes.forEach(e -> System.out.println("   " + e));
		System.out.println("\nOrdenados por nombre:");
		Collections.sort(estudiantes, Comparator.comparing(e -> e.nombre));
		estudiantes.forEach(e -> System.out.println("   " + e));

		System.out.println("\n5. BÚSQUEDA BINARIA:");
		ArrayList<Integer> listaOrdenada = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			listaOrdenada.add(i * 5);
		}
		System.out.println("Lista " + listaOrdenada);
		int buscar = 25;
		int indice = Collections.binarySearch(listaOrdenada, buscar);
		System.out.println("Búsqueda de " + buscar + ": índice " + indice);

		buscar = 23;
		indice = Collections.binarySearch(listaOrdenada, buscar);
		System.out.println("Búsqueda de " + buscar + ": índice " + indice + " (negativo = no encontrado)");
	}

}
