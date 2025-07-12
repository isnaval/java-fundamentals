package java_oop.advanced.employee_project_management.reporting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProjectManagementSystem {
	private List<String> reports;
	private Date lastReportGenerated;

	public ProjectManagementSystem() {
		this.reports = new ArrayList<>();
	}

	public void generateWeeklyReport() {
		String report = "Reporte Semanal - " + new Date();
		reports.add(report);
		lastReportGenerated = new Date();
		System.out.println("📄 Reporte semanal generado");
	}

	public void generateMonthlyReport() {
		String report = "Reporte Mensual - " + new Date();
		reports.add(report);
		lastReportGenerated = new Date();
		System.out.println("📄 Reporte mensual generado");
	}

	public void showAllReports() {
		System.out.println("📚 REPORTES GENERADOS:");
		System.out.println("======================");
		for (int i = 0; i < reports.size(); i++) {
			System.out.println((i + 1) + ". " + reports.get(i));
		}
	}

	public void exportReport(String reportName) {
		System.out.println("📤 Exportando reporte: " + reportName);
		System.out.println("✅ Reporte exportado exitosamente");
	}
}
