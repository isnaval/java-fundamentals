package java_advanced_testing.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project {
	private String name;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private List<Employee> team;

	public Project(String name, String description, LocalDate startDate, LocalDate endDate) {
		this.name = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.team = new ArrayList<>();
	}

	// Getters y setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public List<Employee> getTeam() {
		return team;
	}

	public void setTeam(List<Employee> team) {
		this.team = team;
	}

	public void addTeamMember(Employee employee) {
		this.team.add(employee);
	}

	@Override
	public String toString() {
		return "Project{name='" + name + "', description='" + description + "', team size=" + team.size() + "}";
	}

}
