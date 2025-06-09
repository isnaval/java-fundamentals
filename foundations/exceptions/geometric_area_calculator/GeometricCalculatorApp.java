package exceptions.geometric_area_calculator;

import java.util.InputMismatchException;

public class GeometricCalculatorApp {

	public static void main(String[] args) {

		try {
			while (true) {
				UserInterface.showMenu();
				int option = UserInterface.getOption();

				if (option == 5) {
					UserInterface.showGoodbye();
					break;
				}

				processOption(option);
			}

		} catch (InputMismatchException e) {
			UserInterface.showError("You must enter valid numbers.");
		} catch (IllegalArgumentException e) {
			UserInterface.showError(e.getMessage());
		} catch (UnknownShapeException e) {
			UserInterface.showError(e.getMessage());
		} finally {
			UserInterface.closeScanner();
			System.out.println("System finished successfully.");
		}
	}

	private static void processOption(int option) throws InputMismatchException, IllegalArgumentException {

		switch (option) {
		case 1:
			calculateCircle();
			break;

		case 2:
			calculateSquare();
			break;

		case 3:
			calculateRectangle();
			break;

		case 4:
			calculateTriangle();
			break;
		}
	}

	private static void calculateCircle() throws InputMismatchException, IllegalArgumentException {
		double radius = UserInterface.getDoubleInput("\n🔵 Enter the circle radius: ");
		double area = AreaCalculator.calculateCircleArea(radius);
		UserInterface.showResult("circle", area);
	}

	private static void calculateSquare() throws InputMismatchException, IllegalArgumentException {
		double side = UserInterface.getDoubleInput("\n🟩 Enter the square side: ");
		double area = AreaCalculator.calculateSquareArea(side);
		UserInterface.showResult("square", area);
	}

	private static void calculateRectangle() throws InputMismatchException, IllegalArgumentException {
		double width = UserInterface.getDoubleInput("\n🟦 Enter the rectangle width: ");
		double height = UserInterface.getDoubleInput("🟦 Enter the rectangle height: ");
		double area = AreaCalculator.calculateRectangleArea(width, height);
		UserInterface.showResult("rectangle", area);
	}

	private static void calculateTriangle() throws InputMismatchException, IllegalArgumentException {
		double base = UserInterface.getDoubleInput("\n🔺 Enter the triangle base: ");
		double height = UserInterface.getDoubleInput("🔺 Enter the triangle height: ");
		double area = AreaCalculator.calculateTriangleArea(base, height);
		UserInterface.showResult("triangle", area);
	}

}
