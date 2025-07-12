package java_oop.advanced.employee_project_management.reporting;

import java.util.HashMap;
import java.util.Map;

public class ResourceAllocator {
	private Map<String, Integer> resourceUsage;
	private Map<String, Double> resourceCosts;

	public ResourceAllocator() {
		this.resourceUsage = new HashMap<>();
		this.resourceCosts = new HashMap<>();
	}

	public void trackResourceUsage(String resource, int hours) {
		resourceUsage.put(resource, resourceUsage.getOrDefault(resource, 0) + hours);
		System.out.println("📊 Uso de recurso registrado: " + resource + " - " + hours + " horas");
	}

	public void trackResourceCost(String resource, double cost) {
		resourceCosts.put(resource, resourceCosts.getOrDefault(resource, 0.0) + cost);
	}

	public void generateResourceReport() {
		System.out.println("📊 REPORTE DE RECURSOS:");
		System.out.println("=======================");

		System.out.println("Uso de recursos (horas):");
		for (Map.Entry<String, Integer> entry : resourceUsage.entrySet()) {
			System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " horas");
		}

		System.out.println("\nCostos de recursos:");
		for (Map.Entry<String, Double> entry : resourceCosts.entrySet()) {
			System.out.println("- " + entry.getKey() + ": €" + String.format("%.2f", entry.getValue()));
		}
	}

	public double getTotalCost() {
		return resourceCosts.values().stream().mapToDouble(Double::doubleValue).sum();
	}
}
