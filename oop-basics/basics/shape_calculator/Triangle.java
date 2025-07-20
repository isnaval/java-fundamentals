package java_oop.basics.shape_calculator;

public class Triangle extends Shape {
	private double sideA;
	private double sideB;
	private double sideC;

	public Triangle(double sideA, double sideB, double sideC) {
		if (!isValidTriangle(sideA, sideB, sideC)) {
			throw new IllegalArgumentException("Los lados no forman un triángulo válido");
		}
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}

	// Constructor para triángulo con base y altura conocidas
	public static Triangle fromBaseHeight(double base, double height) {
		double side = Math.sqrt(Math.pow(base / 2, 2) + Math.pow(height, 2));
		return new Triangle(base, side, side);
	}

	@Override
	public double calculateArea() {
		double s = calculatePerimeter() / 2;
		return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
	}

	@Override
	public double calculatePerimeter() {
		return sideA + sideB + sideC;
	}

	private boolean isValidTriangle(double a, double b, double c) {
		return a > 0 && b > 0 && c > 0 && (a + b > c) && (a + c > b) && (b + c > a);
	}

	public double getSideA() {
		return sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public double getSideC() {
		return sideC;
	}

}
