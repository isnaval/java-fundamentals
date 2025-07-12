package java_oop.advanced.electronics_store_system.employees;

public abstract class Employee {
	protected String name;
	protected String employeeId;
	protected double baseSalary;
	protected String department;
	protected int experienceYears;

	public Employee(String name, String employeeId, double baseSalary, String department, int experienceYears) {
		this.name = name;
		this.employeeId = employeeId;
		this.baseSalary = baseSalary;
		this.department = department;
		this.experienceYears = experienceYears;
	}

	public abstract double calculateSalary();

	public abstract void showResponsibilities();

	public void showEmployeeInfo() {
		System.out.println("👨‍💼 INFORMACIÓN DEL EMPLEADO:");
		System.out.println("=============================");
		System.out.println("Nombre: " + name);
		System.out.println("ID: " + employeeId);
		System.out.println("Departamento: " + department);
		System.out.println("Experiencia: " + experienceYears + " años");
		System.out.println("Salario base: €" + String.format("%.2f", baseSalary));
		System.out.println("Salario total: €" + String.format("%.2f", calculateSalary()));
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public String getDepartment() {
		return department;
	}

	public int getExperienceYears() {
		return experienceYears;
	}
}