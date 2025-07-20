package java_oop.basics.discount_system;

public class FixedDiscountCalculator implements DiscountCalculatorInterface {
	

	private double fixedDiscount;

	public FixedDiscountCalculator(double fixedDiscount) {
		if (fixedDiscount < 0) {
			throw new IllegalArgumentException("El descuento no puede ser negativo");
		}
		this.fixedDiscount = fixedDiscount;
		
	}

	@Override
	public double calculateDiscount(double orignalPrice) {
		if (fixedDiscount < 0) {
			throw new IllegalArgumentException("El descuento no puede ser negativo");
		}
		double finalPrice = orignalPrice - this.fixedDiscount;
		return Math.max(0, finalPrice);
	}

}
