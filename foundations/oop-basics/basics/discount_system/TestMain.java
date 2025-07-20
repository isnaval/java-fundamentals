package java_oop.basics.discount_system;

public class TestMain {
	
	public static void main(String [] args) {
		
		try {
			System.out.println(" === Test de FixedDiscountCalculator: === ");
			DiscountCalculatorInterface fixedDiscountCalculator = new FixedDiscountCalculator(20);
			System.out.println("Precio origianl: 100, Descuento: 20 --> Precio final: " + fixedDiscountCalculator.calculateDiscount(100));
			System.out.println("Precio orignal: 10, Descuento: 20 --> Precio final: " + fixedDiscountCalculator.calculateDiscount(10));
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		};
		
		try {
			System.out.println("\n === Probando PercentageDiscountCalculator: === ");
			DiscountCalculatorInterface percentageDiscountCalculator = new PercentageDiscountCalculator(50);
			System.out.println("Precio original: 100, Descuento: 50% -> Precio final: " + 
                    percentageDiscountCalculator.calculateDiscount(100)); // Esperado: 50.0
            System.out.println("Precio original: 60, Descuento: 50% -> Precio final: " + 
                    percentageDiscountCalculator.calculateDiscount(60));  // Esperado: 30.0
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
		

        try {
            System.out.println("\n === Probando entrada inválida: ===");
            DiscountCalculatorInterface fixedDiscountCalculator = new FixedDiscountCalculator(20);
            fixedDiscountCalculator.calculateDiscount(-10); // Debería lanzar una excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }	
	}
}
