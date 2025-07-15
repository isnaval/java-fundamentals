package java_advanced_testing.model;

public class Employee {
	private String name;
	private String department;
	private double salary;
	private String email;

	public Employee(String name, String department, double salary, String email) {
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.email = email;
	}

	// Getters y setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee{name='" + name + "', department='" + department + "', salary=" + salary + "}";
	}

}
