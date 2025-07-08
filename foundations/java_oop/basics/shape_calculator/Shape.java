package java_oop.basics.shape_calculator;

public abstract class Shape {
	public abstract double calculateArea();

	public abstract double calculatePerimeter();

	public void displayInfo() {
		System.out.println("=== " + this.getClass().getSimpleName() + " ===");
		System.out.println("Área: " + String.format("%.2f", calculateArea()));
		System.out.println("Perímetro: " + String.format("%.2f", calculatePerimeter()));
	}

}
