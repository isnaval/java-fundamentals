package fundamentals.generics.container;

import java.util.ArrayList;

/**
 * Implementación de un Contenedor Genérico (Docker)
 * 
 * Se requiere desarrollar una clase Contenedor que permita almacenar múltiples
 * elementos de cualquier tipo de manera flexible y reutilizable. Cada instancia
 * de la clase Contenedor debe ser capaz de contener una colección dinámica de
 * elementos de tipo genérico. Se espera que la clase proporcione métodos para
 * agregar, obtener, buscar, eliminar y actualizar elementos en el contenedor.
 * La clase debe ser diseñada de manera que pueda ser fácilmente integrada en
 * otros programas para el manejo de colecciones de datos genéricos.
 * 
 * Funcionalidades requeridas: - Agregar elementos al contenedor - Obtener
 * elementos del contenedor - Buscar elementos en el contenedor - Eliminar
 * elementos del contenedor - Actualizar elementos en el contenedor
 * 
 * 
 */

public class Container<T> {
	
	// 1. genero un array que voy a llamar docker 
	protected ArrayList<T> container = new ArrayList<>();
	
	// 2. genero el constructor Docker
	public Container()  {
		
	}

	// 3. establezco el CRUD
	
	public void addElement(T element) {
		getContainer().add(element);
		
	}
	
	public void removeElement(T element) {
		getContainer().remove(element);
		
	}
	
	public T getElement(int i ) {
		return getContainer().get(i);
		
	}
	
	public boolean searchElement (T data) {
		return getContainer().contains(data);
	}
	
	public void updateElement(T element, int i) {
		if(i <0 || i >= getContainer().size()) {
			System.out.println("Index out of range");
		} else {
			getContainer().set(i, element);
		}
		
	}
	
	public void showInfo() {
		System.out.println("Container elements: ");
		for (T element : getContainer()) {
			System.out.print(element + ", ");
		}
		System.out.println();
		
	}
	
	public ArrayList<T> getContainer() {
		return container;
		
	}
	
	public void setContainer(ArrayList<T> container) {
		this.container = container;
	}
	
	
}
