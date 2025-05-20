package java_oop.basics.bar_order_system;

public class DrinkManager {
	
	public boolean addDrinksToOrder(Order order, Drink drinks) {
		boolean allDrinksAdded = true; 
		
			if (order.getNumberOfDrinks() < order.getMaxDrinks()){
				order.getDrinks()[order.getNumberOfDrinks()] = drinks; 
				order.setNumberOfDrinks(order.getNumberOfDrinks()+1);
				
			} else {
				System.out.println("Cannot add more drinks: Maximun is limited to 5 drinks");
				allDrinksAdded = false; 
			}
			return allDrinksAdded;	
	};
	
	
	public double calculateTotalCost(Order order) {
		double totalCost = 0.0;
		for (int i = 0; i < order.getNumberOfDrinks(); i++) {
			totalCost += order.getDrinks()[i].getPrice();
		}
		
		return totalCost; 
	}
	
	private String getFormattedTotalCost(Order order) {
		return String.format("%.2f €", calculateTotalCost(order));
	}
	
	public void displayOrderInformation(Order order) {
		System.out.println("Información del pedido: ");
		System.out.println("Ciente: " + order.getClient().getName());
		System.out.println("Bebidas: ");
		
        if (order.getNumberOfDrinks() > 0) {
            for (int i = 0; i < order.getNumberOfDrinks(); i++) {
                System.out.println("- " + order.getDrinks()[i].getName() + ": " + 
                                  order.getDrinks()[i].getPrice() + " €");
            }
            System.out.println("Precio final total: " + getFormattedTotalCost(order));
        } else {
            System.out.println("El pedido está vacío");
        }
		
	}
	
	public double applyDiscount(Order order, double discountPercentage) {
		if(discountPercentage <0 || discountPercentage > 100) {
			System.out.println("El descuento debe ser un % entre 0 y 100");
			return calculateTotalCost(order);
		} 
		double totalCost = calculateTotalCost(order);
		double discountAmount = totalCost * (discountPercentage / 100);
		return totalCost - discountAmount;
		
		
	}

	public boolean removeDrinkByIndex( Order order, int index) {
		if (index <0 || index >= order.getNumberOfDrinks()) {
			System.out.println("Indice no valido");
			return false; 
		} 
		for (int i = index; i < order.getNumberOfDrinks() - 1; i++) {
			order.getDrinks()[i] = order.getDrinks() [i + 1];
		}
		order.getDrinks()[order.getNumberOfDrinks()-1] = null;
		order.setNumberOfDrinks(order.getNumberOfDrinks()-1);
		return true; 
		
	}
}































