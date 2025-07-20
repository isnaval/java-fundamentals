package collections.arraylist;

import java.util.ArrayList;

public class ArrayListAlgorithms {

	public static void main(String[] args) {
		System.out.println("=== ALGORITMOS CON ARRAYLIST ===\n");

		System.out.println("1. BÚSQUEDA LINEAL:");
		ArrayList<Integer> numeros = new ArrayList<>();
		numeros.add(10);
		numeros.add(25);
		numeros.add(30);
		numeros.add(45);
		numeros.add(50);

		System.out.println("Lista: " + numeros);
		int buscar = 30;
		int indice = busquedaLineal(numeros, buscar);
		System.out.println("Buscando " + buscar + ": encontrado en índice " + indice);
		buscar = 35;
		indice = busquedaLineal(numeros, buscar);
		System.out.println("Buscando " + buscar + ": índice " + indice);
		System.out.println("(no encontrado) = -1 ");

		System.out.println("\n2. ENCONTRAR EL MAYOR Y MENOR:");
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(23);
		lista.add(5);
		lista.add(89);
		lista.add(12);
		lista.add(45);
		System.out.println("Lista: " + lista);
		System.out.println("Mayor: " + encontrarMayor(lista));
		System.out.println("Menor: " + encontrarMenor(lista));

		System.out.println("\n3. CONTAR OCURRENCIAS:");
		ArrayList<String> palabras = new ArrayList<>();
		palabras.add("Java");
		palabras.add("Python");
		palabras.add("Java");
		palabras.add("C++");
		palabras.add("Java");
		palabras.add("Python");
		System.out.println("Lista: " + palabras);
		System.out.println("Ocurrencias de 'Java': " + contarOcurrencias(palabras, "Java"));
		System.out.println("Ocurrencias de 'Python': " + contarOcurrencias(palabras, "Python"));
		System.out.println("Ocurrencias de 'C#': " + contarOcurrencias(palabras, "C#"));

		System.out.println("\n4. INVERTIR LISTA:");
		ArrayList<Character> letras = new ArrayList<>();
		letras.add('A');
		letras.add('B');
		letras.add('C');
		letras.add('D');
		letras.add('E');
		System.out.println("Lista original: " + letras);
		invertirLista(letras);
		System.out.println("Lista invertida: " + letras);

		System.out.println("\n5. SUMAR ELEMENTOS:");
		ArrayList<Integer> numeros2 = new ArrayList<>();
		numeros2.add(10);
		numeros2.add(20);
		numeros2.add(30);
		numeros2.add(40);
		numeros2.add(50);

		System.out.println("Lista: " + numeros2);
		System.out.println("Suma total: " + sumarElementos(numeros2));
		System.out.println("Promedio: " + calcularPromedio(numeros2));

		System.out.println("\n6. FILTRAR NÚMEROS PARES:");
		ArrayList<Integer> mezclados = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			mezclados.add(i);
		}
		System.out.println("Lista original: " + mezclados);
		ArrayList<Integer> pares = filtrarPares(mezclados);
		System.out.println("Números pares: " + pares);
		System.out.println("\n7. VERIFICAR SI ESTÁ ORDENADA:");
		ArrayList<Integer> ordenada = new ArrayList<>();
		ordenada.add(10);
		ordenada.add(20);
		ordenada.add(30);
		ordenada.add(40);
		ArrayList<Integer> desordenada = new ArrayList<>();
		desordenada.add(30);
		desordenada.add(10);
		desordenada.add(40);
		desordenada.add(20);
		System.out.println("Lista 1: " + ordenada);
		System.out.println("¿Está ordenada? " + estaOrdenada(ordenada));

		System.out.println("\nLista 2: " + desordenada);
		System.out.println("¿Está ordenada? " + estaOrdenada(desordenada));

		System.out.println("\n8. MOVER CEROS AL FINAL:");
		ArrayList<Integer> conCeros = new ArrayList<>();
		conCeros.add(0);
		conCeros.add(1);
		conCeros.add(0);
		conCeros.add(3);
		conCeros.add(12);
		conCeros.add(0);
		System.out.println("Lista original: " + conCeros);
		moverCerosAlFinal(conCeros);
		System.out.println("Ceros al final: " + conCeros);

		System.out.println("\n9. LISTA DE ARRAYS:");
		imprimirTodasLasListas(conCeros, conCeros, palabras, letras, conCeros, conCeros, conCeros, conCeros, conCeros,
				conCeros);
	}

	public static int busquedaLineal(ArrayList<Integer> lista, int elemento) {
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).equals(elemento)) {
				return i;
			}
		}
		return -1;
	}

	public static Integer encontrarMayor(ArrayList<Integer> lista) {
		if (lista.isEmpty())
			return null;

		Integer mayor = lista.get(0);
		for (Integer num : lista) {
			if (num > mayor) {
				mayor = num;
			}
		}
		return mayor;
	}

	public static Integer encontrarMenor(ArrayList<Integer> lista) {
		if (lista.isEmpty())
			return null;

		Integer menor = lista.get(0);
		for (Integer num : lista) {
			if (num < menor) {
				menor = num;
			}
		}
		return menor;
	}

	public static int contarOcurrencias(ArrayList<String> lista, String elemento) {
		int contador = 0;
		for (String item : lista) {
			if (item.equals(elemento)) {
				contador++;
			}
		}
		return contador;
	}

	public static void invertirLista(ArrayList<Character> lista) {
		int inicio = 0;
		int fin = lista.size() - 1;

		while (inicio < fin) {
			Character temp = lista.get(inicio);
			lista.set(inicio, lista.get(fin));
			lista.set(fin, temp);
			inicio++;
			fin--;
		}
	}

	public static int sumarElementos(ArrayList<Integer> lista) {
		int suma = 0;
		for (Integer num : lista) {
			suma += num;
		}
		return suma;
	}

	public static double calcularPromedio(ArrayList<Integer> lista) {
		if (lista.isEmpty())
			return 0;
		return (double) sumarElementos(lista) / lista.size();
	}

	public static ArrayList<Integer> filtrarPares(ArrayList<Integer> lista) {
		ArrayList<Integer> pares = new ArrayList<>();
		for (Integer num : lista) {
			if (num % 2 == 0) {
				pares.add(num);
			}
		}
		return pares;
	}

	public static boolean estaOrdenada(ArrayList<Integer> lista) {
		for (int i = 0; i < lista.size() - 1; i++) {
			if (lista.get(i) > lista.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public static void moverCerosAlFinal(ArrayList<Integer> lista) {
		int indiceNoCero = 0;

		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i) != 0) {
				lista.set(indiceNoCero++, lista.get(i));
			}
		}

		while (indiceNoCero < lista.size()) {
			lista.set(indiceNoCero++, 0);
		}
	}

	public static void imprimirTodasLasListas(ArrayList<Integer> numeros, ArrayList<Integer> lista,
			ArrayList<String> palabras, ArrayList<Character> letras, ArrayList<Integer> numeros2,
			ArrayList<Integer> mezclados, ArrayList<Integer> pares, ArrayList<Integer> ordenada,
			ArrayList<Integer> desordenada, ArrayList<Integer> conCeros) {
		System.out.println("Lista de números (búsqueda): " + numeros);
		System.out.println("Lista de números (mayor/menor): " + lista);
		System.out.println("Lista de palabras: " + palabras);
		System.out.println("Lista de letras: " + letras);
		System.out.println("Lista de números (suma): " + numeros2);
		System.out.println("Lista mezclados: " + mezclados);
		System.out.println("Lista de pares: " + pares);
		System.out.println("Lista ordenada: " + ordenada);
		System.out.println("Lista desordenada: " + desordenada);
		System.out.println("Lista con ceros: " + conCeros);

		System.out.println("\nTotal de ArrayLists creadas: 10");
	}
}