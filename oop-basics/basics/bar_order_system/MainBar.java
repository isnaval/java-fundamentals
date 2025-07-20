package java_oop.basics.bar_order_system;

public class MainBar {
	public static void main (String[] args) {
		// 1 instanciamos al administrador de bebidas
		DrinkManager drinkManager = new DrinkManager();
		// 2. instanciamos a un nuevo cliente
		Client client = new Client("Miguel", 25);
		// 3 .instanciamos a un nuevo pedido
		Order order1 = new Order();
		order1.setClient(client);
		order1.setDrinks(new Drink[order1.getMaxDrinks()]);
		order1.setNumberOfDrinks(0);
		
		System.out.println("Pedido creado para: " + client.getName());
		System.out.println("Capacidad máxima: " + order1.getMaxDrinks() + " bebidas.");
		System.out.println();
		
		// 4. Mostrar el enum con el bebido de la carta
		System.out.println("\n === CARTA DE BEBIDAS ===");
		for(Drinks drink : Drinks.values()) {
			System.out.println(drink);
		}
		
		//5, Añado bebidas al pedido del usuario
		System.out.println("\n === PEDIDO === ");
		
		if(drinkManager.addDrinksToOrder(order1, Drinks.COFFEE.toDrink())) {
			System.out.println("Añadido: " + Drinks.COFFEE);
		}
		if (drinkManager.addDrinksToOrder(order1, Drinks.BEER.toDrink())) {
            System.out.println("Añadido: " + Drinks.BEER);
        }
        
        if (drinkManager.addDrinksToOrder(order1, Drinks.JUICE.toDrink())) {
            System.out.println("Añadido: " + Drinks.JUICE);
        }
		
        //6. Información del pedido
        System.out.println("\n === INFORMACIÓN DEL PEDIDO ===");
        drinkManager.displayOrderInformation(order1);
	
	
        //7. Aplicar descuento
        System.out.println("\n === APLICAR DESCUENTO ===");
        double discountPercentage = 15.0;
        double discountedPrice = drinkManager.applyDiscount(order1, discountPercentage);
        System.out.println("El precio original: " + String.format("%.2f €", drinkManager.calculateTotalCost(order1)));
        System.out.println("Precio con " + discountPercentage + "% de descuento: " + String.format("%.2f €", discountedPrice));

	}

}
