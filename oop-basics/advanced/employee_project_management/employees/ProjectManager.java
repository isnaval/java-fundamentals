package java_oop.advanced.employee_project_management.employees;

import java.util.ArrayList;
import java.util.List;

public class ProjectManager extends Employee {
	private List<String> managedProjects;
	private int teamSize;
	private double budgetManaged;
	private String methodologyUsed;

	public ProjectManager(String id, String name, String email, double baseSalary) {
		super(id, name, email, baseSalary, "Gestión");
		this.managedProjects = new ArrayList<>();
		this.teamSize = 0;
		this.budgetManaged = 0.0;
		this.methodologyUsed = "Agile";
	}

	@Override
	public double calculateSalary() {
		double bonus = 0.0;
		bonus += baseSalary * 0.06 * experienceYears;
		bonus += teamSize * 200;
		bonus += managedProjects.size() * 300;
		bonus += budgetManaged * 0.001;
		return baseSalary + bonus;
	}

	@Override
	public String getRole() {
		return "Project Manager (" + methodologyUsed + ")";
	}

	public void assignProject(String projectName, double budget) {
		managedProjects.add(projectName);
		budgetManaged += budget;
		System.out.println(name + " asignado al proyecto: " + projectName);
	}

	public void manageTeam(int newTeamSize) {
		this.teamSize = newTeamSize;
		System.out.println(name + " ahora gestiona un equipo de " + teamSize + " personas");
	}

	public void completeProject(String projectName) {
		if (managedProjects.contains(projectName)) {
			System.out.println("✅ Proyecto completado: " + projectName + " por " + name);
		}
	}

	// Getters específicos
	public List<String> getManagedProjects() {
		return new ArrayList<>(managedProjects);
	}

	public int getTeamSize() {
		return teamSize;
	}

	public double getBudgetManaged() {
		return budgetManaged;
	}

	public String getMethodologyUsed() {
		return methodologyUsed;
	}

	public void setMethodologyUsed(String methodology) {
		this.methodologyUsed = methodology;
	}
}