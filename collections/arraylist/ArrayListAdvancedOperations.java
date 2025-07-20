package collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ArrayListAdvancedOperations {

	public static void main(String[] args) {
		System.out.println("=== OPERACIONES AVANZADAS CON ARRAYLIST ===\n");

		System.out.println("1. CONVERSIONES:");
		String[] arrayFrutas = { "Manzana", "Banana", "Naranja" };
		ArrayList<String> listaFrutas = new ArrayList<>(Arrays.asList(arrayFrutas));
		System.out.println("Array a ArrayList: " + listaFrutas);
		String[] nuevoArray = listaFrutas.toArray(new String[0]);
		System.out.println("ArrayList a Array: " + Arrays.toString(nuevoArray));

		System.out.println("\n2. UNIR DOS LISTAS:");
		ArrayList<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3));
		ArrayList<Integer> lista2 = new ArrayList<>(Arrays.asList(4, 5, 6));
		ArrayList<Integer> union = new ArrayList<>(lista1);
		union.addAll(lista2);
		System.out.println("Lista 1: " + lista1);
		System.out.println("Lista 2: " + lista2);
		System.out.println("Unión: " + union);

		System.out.println("\n3. ELIMINAR DUPLICADOS:");
		ArrayList<Integer> conDuplicados = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 3, 4, 5, 5));
		System.out.println("Lista con duplicados: " + conDuplicados);
		ArrayList<Integer> sinDuplicados = new ArrayList<>(new HashSet<>(conDuplicados));
		System.out.println("Sin duplicados: " + sinDuplicados);

		System.out.println("\n4. SUBLISTAS:");
		ArrayList<String> colores = new ArrayList<>(Arrays.asList("Rojo", "Verde", "Azul", "Amarillo", "Negro"));
		System.out.println("Lista original: " + colores);
		ArrayList<String> sublista = new ArrayList<>(colores.subList(1, 4));
		System.out.println("Sublista (índices 1-3): " + sublista);

		System.out.println("\n5. OPERACIONES ÚTILES:");
		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(15, 3, 42, 7, 28, 9));
		System.out.println("Lista de números: " + numeros);
		System.out.println("Máximo: " + Collections.max(numeros));
		System.out.println("Mínimo: " + Collections.min(numeros));
		Collections.shuffle(numeros);
		System.out.println("Lista mezclada: " + numeros);
		Collections.sort(numeros);
		System.out.println("Lista ordenada: " + numeros);

		System.out.println("\n6. COPIAR LISTAS:");
		ArrayList<String> original = new ArrayList<>(Arrays.asList("A", "B", "C"));
		ArrayList<String> copia1 = new ArrayList<>(original);
		ArrayList<String> copia2 = (ArrayList<String>) original.clone();
		System.out.println("Original: " + original);
		System.out.println("Copia 1: " + copia1);
		System.out.println("Copia 2: " + copia2);
		copia1.add("D");
		System.out.println("Después de modificar copia1:");
		System.out.println("Original: " + original);
		System.out.println("Copia 1: " + copia1);

		System.out.println("\n7. REEMPLAZAR ELEMENTOS:");
		ArrayList<String> letras = new ArrayList<>(Arrays.asList("A", "B", "A", "C", "A"));
		System.out.println("Lista original: " + letras);
		Collections.replaceAll(letras, "A", "X");
		System.out.println("Después de reemplazar A por X: " + letras);

		System.out.println("\n8. VERIFICAR CONTENIDO:");
		ArrayList<Integer> lista = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
		System.out.println("Lista: " + lista);
		System.out.println("¿Contiene 20? " + lista.contains(20));
		System.out.println("¿Contiene 25? " + lista.contains(25));
		System.out.println("¿Está vacía? " + lista.isEmpty());
		ArrayList<Integer> sublista2 = new ArrayList<>(Arrays.asList(20, 30));
		System.out.println("¿Contiene todos [20, 30]? " + lista.containsAll(sublista2));
	}
}
