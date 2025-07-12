package java_oop.advanced.employee_project_management.employees;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
	protected String id;
	protected String name;
	protected String email;
	protected double baseSalary;
	protected String department;
	protected int experienceYears;
	protected List<String> skills;
	protected boolean isAvailable;

	public Employee(String id, String name, String email, double baseSalary, String department) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.baseSalary = baseSalary;
		this.department = department;
		this.experienceYears = 0;
		this.skills = new ArrayList<>();
		this.isAvailable = true;
	}

	public abstract double calculateSalary();

	public abstract String getRole();

	public void addSkill(String skill) {
		if (!skills.contains(skill)) {
			skills.add(skill);
			System.out.println("✅ Habilidad agregada: " + skill + " a " + name);
		}
	}

	public void setAvailable(boolean available) {
		this.isAvailable = available;
		System.out.println(name + " está ahora " + (available ? "disponible" : "ocupado"));
	}

	public void showEmployeeInfo() {
		System.out.println("👤 EMPLEADO: " + name);
		System.out.println("ID: " + id);
		System.out.println("Email: " + email);
		System.out.println("Rol: " + getRole());
		System.out.println("Departamento: " + department);
		System.out.println("Salario: €" + String.format("%.2f", calculateSalary()));
		System.out.println("Experiencia: " + experienceYears + " años");
		System.out.println("Habilidades: " + String.join(", ", skills));
		System.out.println("Estado: " + (isAvailable ? "Disponible" : "Ocupado"));
	}

	// Getters básicos
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
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

	public List<String> getSkills() {
		return new ArrayList<>(skills);
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	// Setters básicos
	public void setExperienceYears(int years) {
		this.experienceYears = years;
	}

	public void setBaseSalary(double salary) {
		this.baseSalary = salary;
	}
}