package collections.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListCrudOperations {

	public static void main(String[] args) {
		ArrayList<String> frutas = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		System.out.println("=== OPERACIONES CRUD CON ARRAYLIST ===\n");

		System.out.println("1. CREATE - Agregar elementos:");
		System.out.println("Ingrese 4 frutas:");

		System.out.print("Fruta 1: ");
		frutas.add(scanner.nextLine());

		System.out.print("Fruta 2: ");
		frutas.add(scanner.nextLine());

		System.out.print("Fruta 3: ");
		frutas.add(scanner.nextLine());

		System.out.print("Fruta 4: ");
		frutas.add(scanner.nextLine());

		System.out.println("\nLista de frutas agregadas: " + frutas);

		System.out.print("\nIngrese una fruta para agregar en la posición 3: ");
		String frutaPosition = scanner.nextLine();
		frutas.add(2, frutaPosition);
		System.out.println("Lista después de agregar una fruta en posición 3: " + frutas);

		System.out.println("\n2. READ - Leyendo elementos:");
		System.out.println("Elemento en posición 0: " + frutas.get(0));
		System.out.println("Elemento en posición 3: " + frutas.get(3));
		System.out.println("Tamaño de la lista: " + frutas.size());

		System.out.print("\nIngrese una fruta para buscar: ");
		String frutaBuscar = scanner.nextLine();
		System.out.println("¿La lista contiene '" + frutaBuscar + "'? " + frutas.contains(frutaBuscar));
		if (frutas.contains(frutaBuscar)) {
			System.out.println("Se encuentra en el índice: " + frutas.indexOf(frutaBuscar) + 1);
		}

		System.out.println("\n3. UPDATE - Actualizando elementos:");
		System.out.println("Lista actual: " + frutas);
		System.out.print("Ingrese el índice a actualizar (0-" + (frutas.size() - 1) + "): ");

		try {
			int indiceActualizar = scanner.nextInt();
			scanner.nextLine();

			if (indiceActualizar >= 0 && indiceActualizar < frutas.size()) {
				System.out.print("Ingrese la nueva fruta: ");
				String nuevaFruta = scanner.nextLine();
				String frutaAnterior = frutas.set(indiceActualizar, nuevaFruta);
				System.out.println("Se cambió '" + frutaAnterior + "' por '" + nuevaFruta + "'");
				System.out.println("Lista actualizada: " + frutas);
			} else {
				System.out.println("Índice inválido");
			}
		} catch (Exception e) {
			System.out.println("Error: Debe ingresar un número válido");
			scanner.nextLine();
		}

		System.out.println("\n4. DELETE - Eliminando elementos:");
		System.out.println("Lista actual: " + frutas);

		System.out.print("Ingrese el nombre de la fruta a eliminar: ");
		String frutaEliminar = scanner.nextLine();
		if (frutas.remove(frutaEliminar)) {
			System.out.println("Se eliminó '" + frutaEliminar + "' exitosamente");
		} else {
			System.out.println("No se encontró '" + frutaEliminar + "' en la lista");
		}
		System.out.println("Lista después de eliminar: " + frutas);
		System.out.print("\nIngrese el índice a eliminar (0-" + (frutas.size() - 1) + "): ");
		try {
			int indiceEliminar = scanner.nextInt();
			scanner.nextLine();
			if (indiceEliminar >= 0 && indiceEliminar < frutas.size()) {
				String eliminada = frutas.remove(indiceEliminar);
				System.out.println("Se eliminó '" + eliminada + "' del índice " + indiceEliminar);
				System.out.println("Lista final: " + frutas);
			} else {
				System.out.println("Índice inválido");
			}
		} catch (Exception e) {
			System.out.println("Error: Debe ingresar un número válido");
			scanner.nextLine();
		}

		System.out.println("\n5. OPERACIONES ADICIONALES:");
		System.out.println("¿La lista está vacía? " + frutas.isEmpty());
		System.out.println("Tamaño final de la lista: " + frutas.size());

		System.out.print("\n¿Desea limpiar toda la lista? (S/N): ");
		String respuesta = scanner.nextLine();
		if (respuesta.equalsIgnoreCase("S")) {
			frutas.clear();
			System.out.println("Lista limpiada. ¿Está vacía? " + frutas.isEmpty());
		}

		scanner.close();
	}
}