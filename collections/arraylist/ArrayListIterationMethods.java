package collections.arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ArrayListIterationMethods {

	public static void main(String[] args) {

		ArrayList<Integer> numeros = new ArrayList<>();
		for (int i = 1; i <= 5; i++) {
			numeros.add(i * 10);
		}

		System.out.println("=== MÉTODOS DE ITERACIÓN EN ARRAYLIST ===");
		System.out.println("Lista original: " + numeros + "\n");

		System.out.println("1. Iteración con FOR tradicional:");
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println("   Índice " + i + ": " + numeros.get(i));
		}

		System.out.println("\n2. Iteración con FOR-EACH:");
		for (Integer num : numeros) {
			System.out.println("   Valor: " + num);
		}

		System.out.println("\n3. Iteración con ITERATOR:");
		Iterator<Integer> iterator = numeros.iterator();
		while (iterator.hasNext()) {
			Integer num = iterator.next();
			System.out.println("   Valor: " + num);
		}

		System.out.println("\n4. Iteración con LISTITERATOR (bidireccional):");
		ListIterator<Integer> listIterator = numeros.listIterator();
		System.out.println("   Hacia adelante:");
		while (listIterator.hasNext()) {
			System.out.println("      Índice " + listIterator.nextIndex() + ": " + listIterator.next());
		}
		System.out.println("   Hacia atrás:");
		while (listIterator.hasPrevious()) {
			System.out.println("      Índice " + listIterator.previousIndex() + ": " + listIterator.previous());
		}

		System.out.println("\n5. Iteración con FOREACH y lambda:");
		numeros.forEach(num -> System.out.println("   Valor: " + num));

		System.out.println("\n6. Iteración con FOREACH y referencia a método:");
		numeros.forEach(System.out::println);

		System.out.println("\n7. Ejemplo práctico - Eliminar elementos pares:");
		ArrayList<Integer> lista = new ArrayList<>(numeros);
		System.out.println("   Lista antes: " + lista);

		Iterator<Integer> it = lista.iterator();
		while (it.hasNext()) {
			if (it.next() % 20 == 0) {
				it.remove();
			}
		}
		System.out.println("   Lista después: " + lista);

		System.out.println("\n8. Iteración con WHILE simple:");
		ArrayList<String> frutas = new ArrayList<>();
		frutas.add("Manzana");
		frutas.add("Banana");
		frutas.add("Naranja");

		int i = 0;
		System.out.println("   Lista de frutas:");
		while (i < frutas.size()) {
			System.out.println("      " + i + ": " + frutas.get(i));
			i++;
		}
	}
}