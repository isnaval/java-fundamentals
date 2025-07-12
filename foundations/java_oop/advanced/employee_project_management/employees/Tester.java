package java_oop.advanced.employee_project_management.employees;

public class Tester extends Employee {
	private String testingTool;
	private int testsExecuted;
	private int bugsFound;
	private String testingType;

	public Tester(String id, String name, String email, double baseSalary, String testingTool) {
		super(id, name, email, baseSalary, "QA");
		this.testingTool = testingTool;
		this.testsExecuted = 0;
		this.bugsFound = 0;
		this.testingType = "Manual";
	}

	@Override
	public double calculateSalary() {
		double bonus = 0.0;
		bonus += baseSalary * 0.03 * experienceYears;
		bonus += testsExecuted * 2;
		bonus += bugsFound * 10;
		return baseSalary + bonus;
	}

	@Override
	public String getRole() {
		return "Tester " + testingType;
	}

	public void executeTest() {
		testsExecuted++;
		System.out.println(name + " ejecutó una prueba! Total: " + testsExecuted);
	}

	public void findBug(String description) {
		bugsFound++;
		System.out.println(name + " encontró un bug: " + description + " (Total: " + bugsFound + ")");
	}

	// Getters específicos
	public String getTestingTool() {
		return testingTool;
	}

	public int getTestsExecuted() {
		return testsExecuted;
	}

	public int getBugsFound() {
		return bugsFound;
	}

	public String getTestingType() {
		return testingType;
	}

	public void setTestingType(String testingType) {
		this.testingType = testingType;
	}
}
