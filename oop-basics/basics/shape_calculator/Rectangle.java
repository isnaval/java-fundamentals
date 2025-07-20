package java_oop.basics.shape_calculator;

public class Rectangle extends Shape {
	private double width;
	private double height;

	public Rectangle(double width, double height) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Las dimensiones deben ser positivas");
		}
		this.width = width;
		this.height = height;
	}

	@Override
	public double calculateArea() {
		return width * height;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * (width + height);
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		if (width <= 0) {
			throw new IllegalArgumentException("El ancho debe ser positivo");
		}
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		if (height <= 0) {
			throw new IllegalArgumentException("La altura debe ser positiva");
		}
		this.height = height;
	}
}
