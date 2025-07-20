package exceptions.geometric_area_calculator;

public class AreaCalculator {

	public static double calculateCircleArea(double radius) throws IllegalArgumentException {
		if (radius <= 0) {
			throw new IllegalArgumentException("Radius must be greater than 0");

		}
		return Math.PI * Math.pow(radius, 2);
	}

	public static double calculateSquareArea(double side) throws IllegalArgumentException {
		if (side <= 0) {
			throw new IllegalArgumentException("Side must be greater than 0");
		}
		return Math.pow(side, 2);
	}

	public static double calculateRectangleArea(double width, double height) throws IllegalArgumentException {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Width and height must be greater than 0");
		}
		return width * height;
	}

	public static double calculateTriangleArea(double base, double height) throws IllegalArgumentException {
		if (base <= 0 || height <= 0) {
			throw new IllegalArgumentException("Base and height must be greater than 0");
		}
		return (base * height) / 2.0;
	}

}
