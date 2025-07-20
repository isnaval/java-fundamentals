package java_oop.advanced.employee_project_management.test;

import java_oop.advanced.employee_project_management.employees.Designer;
import java_oop.advanced.employee_project_management.employees.Developer;
import java_oop.advanced.employee_project_management.employees.ProjectManager;

public class EmployeeTest {

	public static void testEmployeeCreation() {
		System.out.println("🧪 TESTING CREACIÓN DE EMPLEADOS:");
		System.out.println("==================================");

		// Test Developer
		Developer dev = new Developer("DEV001", "Juan Pérez", "juan@test.com", 3000, "Java");
		dev.addSkill("Spring Boot");
		dev.writeCode(500);
		dev.fixBug();
		dev.showEmployeeInfo();

		System.out.println();

		// Test Designer
		Designer designer = new Designer("DES001", "Ana García", "ana@test.com", 2800, "Figma");
		designer.addSkill("UI/UX");
		designer.completeDesign();
		designer.updateCreativityRating(8.5);
		designer.showEmployeeInfo();

		System.out.println("✅ Test de empleados completado");
	}

	public static void testSalaryCalculation() {
		System.out.println("\n🧪 TESTING CÁLCULO DE SALARIOS:");
		System.out.println("===============================");

		Developer dev = new Developer("DEV002", "Carlos López", "carlos@test.com", 3000, "Python");
		dev.setExperienceYears(3);
		dev.writeCode(15000);

		System.out.println("Salario base: €" + dev.getBaseSalary());
		System.out.println("Salario total: €" + dev.calculateSalary());

		ProjectManager pm = new ProjectManager("PM001", "María Rodríguez", "maria@test.com", 4000);
		pm.setExperienceYears(5);
		pm.manageTeam(8);
		pm.assignProject("Proyecto Test", 50000);

		System.out.println("Salario PM: €" + pm.calculateSalary());
		System.out.println("✅ Test de salarios completado");
	}

	public static void runAllTests() {
		testEmployeeCreation();
		testSalaryCalculation();
	}

	public static void main(String[] args) {
		runAllTests();
	}
}