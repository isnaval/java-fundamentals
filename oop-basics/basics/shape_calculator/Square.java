package java_oop.basics.shape_calculator;

public class Square extends Rectangle {
	public Square(double side) {
		super(side, side);
	}

	public double getSide() {
		return getWidth();
	}

	public void setSide(double side) {
		setWidth(side);
		setHeight(side);
	}

	@Override
	public void displayInfo() {
		System.out.println("=== Cuadrado ===");
		System.out.println("Lado: " + getSide());
		System.out.println("Área: " + String.format("%.2f", calculateArea()));
		System.out.println("Perímetro: " + String.format("%.2f", calculatePerimeter()));
	}

}
