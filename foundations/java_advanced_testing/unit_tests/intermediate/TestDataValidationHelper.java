package java_advanced_testing.unit_tests.intermediate;

import java_advanced_testing.model.Book;
import java_advanced_testing.model.Customer;
import java_advanced_testing.model.Employee;
import java_advanced_testing.model.Product;
import java_advanced_testing.model.Project;

public class TestDataValidationHelper {

	// Metodos de validacion para Book
	public static boolean isValidBook(Book book) {
		return book != null && book.getTitle() != null && !book.getTitle().trim().isEmpty() && book.getAuthor() != null
				&& !book.getAuthor().trim().isEmpty() && book.getIsbn() != null && !book.getIsbn().trim().isEmpty()
				&& book.getPrice() >= 0.0;
	}

	public static boolean isExpensiveBook(Book book) {
		return book != null && book.getPrice() > 100.0;
	}

	public static boolean isFreeBook(Book book) {
		return book != null && book.getPrice() == 0.0;
	}

	// Metodos de validacion para Customer
	public static boolean isValidCustomer(Customer customer) {
		return customer != null && customer.getName() != null && !customer.getName().trim().isEmpty()
				&& customer.getEmail() != null && customer.getEmail().contains("@") && customer.getPhone() != null
				&& !customer.getPhone().trim().isEmpty() && customer.getAge() > 0 && customer.getAge() < 150;
	}

	public static boolean isMinor(Customer customer) {
		return customer != null && customer.getAge() < 18;
	}

	public static boolean isSenior(Customer customer) {
		return customer != null && customer.getAge() >= 65;
	}

	public static boolean isAdult(Customer customer) {
		return customer != null && customer.getAge() >= 18 && customer.getAge() < 65;
	}

	// Metodos de validacion para Employee
	public static boolean isValidEmployee(Employee employee) {
		return employee != null && employee.getName() != null && !employee.getName().trim().isEmpty()
				&& employee.getDepartment() != null && !employee.getDepartment().trim().isEmpty()
				&& employee.getSalary() > 0.0;
	}

	public static boolean isHighSalaryEmployee(Employee employee) {
		return employee != null && employee.getSalary() > 60000.0;
	}

	public static boolean isInternEmployee(Employee employee) {
		return employee != null && employee.getSalary() < 25000.0;
	}

	// Metodos de validacion para Product
	public static boolean isValidProduct(Product product) {
		return product != null && product.getName() != null && !product.getName().trim().isEmpty()
				&& product.getSku() != null && !product.getSku().trim().isEmpty() && product.getPrice() >= 0.0;
	}

	public static boolean isPremiumProduct(Product product) {
		return product != null && product.getPrice() > 500.0;
	}

	public static boolean isEconomicProduct(Product product) {
		return product != null && product.getPrice() > 0.0 && product.getPrice() < 50.0;
	}

	// Metodos de validacion para Project
	public static boolean isValidProject(Project project) {
		return project != null && project.getName() != null && !project.getName().trim().isEmpty()
				&& project.getDescription() != null && !project.getDescription().trim().isEmpty()
				&& project.getStartDate() != null && project.getEndDate() != null
				&& project.getStartDate().isBefore(project.getEndDate()) && project.getTeam() != null;
	}

	public static boolean isActiveProject(Project project) {
		return project != null && project.getEndDate().isAfter(java.time.LocalDate.now());
	}

	public static boolean isExpiredProject(Project project) {
		return project != null && project.getEndDate().isBefore(java.time.LocalDate.now());
	}

	public static boolean hasAdequateTeamSize(Project project) {
		if (project == null)
			return false;

		long duration = java.time.temporal.ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate());

		int minTeamSize = (int) (duration / 30); // 1 empleado por mes
		return project.getTeam().size() >= minTeamSize;
	}

	// Metodos utilitarios
	public static String getAgeCategory(int age) {
		if (age < 18)
			return "MENOR";
		else if (age < 30)
			return "JOVEN_ADULTO";
		else if (age < 65)
			return "ADULTO";
		else
			return "SENIOR";
	}

	public static String getSalaryCategory(double salary) {
		if (salary < 25000)
			return "INTERNO";
		else if (salary < 50000)
			return "JUNIOR";
		else if (salary < 80000)
			return "SENIOR";
		else
			return "EJECUTIVO";
	}

	public static String getPriceCategory(double price) {
		if (price == 0.0)
			return "GRATIS";
		else if (price < 50.0)
			return "ECONOMICO";
		else if (price < 500.0)
			return "MEDIO";
		else
			return "PREMIUM";
	}

	public static String getProjectStatus(Project project) {
		if (project == null)
			return "INVALIDO";

		java.time.LocalDate now = java.time.LocalDate.now();

		if (project.getEndDate().isBefore(now))
			return "VENCIDO";
		else if (project.getStartDate().isAfter(now))
			return "FUTURO";
		else
			return "ACTIVO";
	}
}