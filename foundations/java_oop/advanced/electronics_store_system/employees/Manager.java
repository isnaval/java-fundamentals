package java_oop.advanced.electronics_store_system.employees;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Employee {
	private List<Employee> team;
	private double managementBonus;
	private int teamSize;

	public Manager(String name, String employeeId, double baseSalary, String department, int experienceYears) {
		super(name, employeeId, baseSalary, department, experienceYears);
		this.team = new ArrayList<>();
		this.managementBonus = 500.0;
		this.teamSize = 0;
	}

	@Override
	public double calculateSalary() {
		double teamBonus = teamSize * 100;
		double experienceBonus = baseSalary * 0.03 * experienceYears;
		return baseSalary + managementBonus + teamBonus + experienceBonus;
	}

	@Override
	public void showResponsibilities() {
		System.out.println("📋 RESPONSABILIDADES DEL MANAGER:");
		System.out.println("- Supervisar el equipo de " + teamSize + " empleados");
		System.out.println("- Planificar estrategias de ventas");
		System.out.println("- Gestionar inventario");
		System.out.println("- Resolver problemas complejos");
		System.out.println("- Entrenar nuevos empleados");
		System.out.println("- Reportar a la dirección");
	}

	public void addTeamMember(Employee employee) {
		team.add(employee);
		teamSize = team.size();
	}

	public void removeTeamMember(Employee employee) {
		team.remove(employee);
		teamSize = team.size();
	}

	// Getters específicos
	public List<Employee> getTeam() {
		return new ArrayList<>(team);
	}

	public double getManagementBonus() {
		return managementBonus;
	}

	public int getTeamSize() {
		return teamSize;
	}
}
