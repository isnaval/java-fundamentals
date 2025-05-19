package java_opp.basics.discount_system;

public class PercentageDiscountCalculator implements DiscountCalculatorInterface {
	
	private double percentageDiscount;

	public PercentageDiscountCalculator(double percentageDiscount) {
		if(percentageDiscount < 0 || percentageDiscount > 100) {
			throw new IllegalArgumentException("El descuento debe estar entre 0 y 100");
		}
		
		this.percentageDiscount = percentageDiscount;
	}
	
	@Override
	public double calculateDiscount(double originalPrice) {
		if (originalPrice < 0) {
			throw new IllegalArgumentException("El precio original no puede ser inferior a 0");
		}
		
		double discountPercentage = (1-percentageDiscount / 100);
		double finalPrice = originalPrice*discountPercentage;
		return Math.max(0, finalPrice);
	}

}
