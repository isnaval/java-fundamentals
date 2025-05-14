package java_core.generics.container;

public class UseContainer {
	
	 public static void main(String[] args) {
		 
		 
	        // Prueba con String
	        System.out.println("=== TESTING STRING CONTAINER ===");
	        Container<String> stringContainer = new Container<>();
	        
	        // Añadir elementos
	        System.out.println("Adding string elements...");
	        stringContainer.addElement("Hello");
	        stringContainer.addElement("World");
	        stringContainer.addElement("Java");
	        stringContainer.showInfo();
	        
	        // Obtener elemento
	        System.out.println("\nGetting element at index 1: " + stringContainer.getElement(0));
	        
	        // Buscar elemento
	        System.out.println("\nSearching for 'Java': " + stringContainer.searchElement("Java"));
	        System.out.println("Searching for 'Python': " + stringContainer.searchElement("Python"));
	        
	        // Actualizar elemento
	        System.out.println("\nUpdating element at index 2...");
	        stringContainer.updateElement("Cambio",2);
	        stringContainer.showInfo();
	        
	        // Eliminar elemento
	        System.out.println("\nRemoving 'World'...");
	        stringContainer.removeElement("World");
	        stringContainer.showInfo();
	        
	        // Prueba con Integer
	        System.out.println("\n=== TESTING INTEGER CONTAINER ===");
	        Container<Integer> intContainer = new Container<>();
	        
	        // Añadir elementos
	        intContainer.addElement(10);
	        intContainer.addElement(20);
	        intContainer.addElement(30);
	        intContainer.showInfo();
	        
	        // Buscar y actualizar
	        System.out.println("\nSearching for value 20: " + intContainer.searchElement(20));
	        System.out.println("Updating index 1 with value 25...");
	        intContainer.updateElement(25, 1);
	        intContainer.showInfo();
	        
	        // Prueba con objetos personalizados
	        System.out.println("\n=== TESTING CUSTOM OBJECT CONTAINER ===");

	        Container<Product> productContainer = new Container<>();
	        productContainer.addElement(new Product("Laptop", 999.99));
	        productContainer.addElement(new Product("Mouse", 29.99));
	        productContainer.showInfo();
	    }
	}


