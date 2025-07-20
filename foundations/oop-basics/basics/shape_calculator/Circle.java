package java_oop.basics.shape_calculator;

public class Circle extends Shape {
	private double radius;

	public Circle(double radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("El radio del circulo tiene que ser mayor a 0");
		}
		this.radius = radius;
	}

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double calculatePerimeter() {
		return 2 * Math.PI * radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("El radio debe ser positivo");
		}
		this.radius = radius;
	}

}
