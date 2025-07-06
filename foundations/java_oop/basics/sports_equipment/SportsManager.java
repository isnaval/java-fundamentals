package java_oop.basics.sports_equipment;

import java.util.ArrayList;
import java.util.List;

public class SportsManager {

	private List<Equipment> equipment;
	private int nextId;

	public SportsManager() {
		this.equipment = new ArrayList<>();
		this.nextId = 1;
	}

	public void addEquipment(Equipment item) {
		equipment.add(item);
		System.out.println("✅ Equipamiento agregado: " + item.getSport() + " (ID: " + item.getId() + ")");
	}

	public Basketball createBasketball(String color, String usage) {
		Basketball ball = new Basketball(nextId, false, color, usage, nextId, usage);
		addEquipment(ball);
		return ball;
	}

	public Football createFootball(String type) {
		Football ball = new Football(nextId++, type);
		addEquipment(ball);
		return ball;
	}

	public Equipment findById(int id) {
		return equipment.stream().filter(item -> item.getId() == id).findFirst().orElse(null);
	}

	public List<Equipment> findBySport(String sport) {
		return equipment.stream().filter(item -> item.getSport().equalsIgnoreCase(sport)).toList();
	}

	public void inflateAllBalls() {
		System.out.println("\n🔧 Inflando todas las pelotas...");
		equipment.stream().filter(item -> item instanceof Ball).map(item -> (Ball) item).forEach(ball -> {
			if (!ball.isInflated()) {
				ball.inflate(ball.getRecommendedPressure());
			} else {
				System.out.println("Pelota ID " + ball.getId() + " ya está inflada");
			}
		});
	}

	public void performAllTests() {
		System.out.println("\n REALIZANDO TESTS DE RENDIMIENTO");
		System.out.println("═══════════════════════════════════════");

		for (Equipment item : equipment) {
			if (item instanceof Basketball) {
				Basketball ball = (Basketball) item;
				System.out.println("Test Basketball ID " + ball.getId() + ":");
				ball.performBounceTest();

			} else if (item instanceof Football) {
				Football ball = (Football) item;
				System.out.println("Test Football ID " + ball.getId() + ":");
				ball.performKickTest();
			}
			System.out.println();
		}
	}

	public void showInventory() {
		System.out.println("\n INVENTARIO DEPORTIVO");
		System.out.println("═══════════════════════════════════════");

		if (equipment.isEmpty()) {
			System.out.println("No hay equipamiento registrado");
			return;
		}

		List<Basketball> basketballs = equipment.stream().filter(item -> item instanceof Basketball)
				.map(item -> (Basketball) item).toList();

		List<Football> footballs = equipment.stream().filter(item -> item instanceof Football)
				.map(item -> (Football) item).toList();

		System.out.println("📊 ESTADÍSTICAS:");
		System.out.println("Total equipamiento: " + equipment.size());
		System.out.println("Basketballs: " + basketballs.size());
		System.out.println("Footballs: " + footballs.size());
		System.out.println();

		for (Equipment item : equipment) {
			System.out.println(item);
		}
	}

	public void showInflatedBalls() {
		System.out.println("\n PELOTAS INFLADAS Y LISTAS");
		System.out.println("═══════════════════════════════════════");

		List<Ball> inflatedBalls = equipment.stream().filter(item -> item instanceof Ball).map(item -> (Ball) item)
				.filter(Ball::isInflated).toList();

		if (inflatedBalls.isEmpty()) {
			System.out.println("No hay pelotas infladas");
		} else {
			inflatedBalls.forEach(ball -> {
				System.out.printf("ID %d - %s: %.1f PSI%n", ball.getId(), ball.getSport(), ball.getCurrentPressure());
			});
		}
	}

	public void clearInventory() {
		equipment.clear();
		nextId = 1;
		System.out.println("🧹 Inventario limpiado");
	}

	public void showStatistics() {
		System.out.println("\n ESTADÍSTICAS DETALLADAS");
		System.out.println("═══════════════════════════════════════");

		long totalBalls = equipment.stream().filter(item -> item instanceof Ball).count();
		long inflatedBalls = equipment.stream().filter(item -> item instanceof Ball).map(item -> (Ball) item)
				.filter(Ball::isInflated).count();

		long adaptiveBalls = equipment.stream().filter(Equipment::isAdaptive).count();

		System.out.println("Total pelotas: " + totalBalls);
		System.out.println("Pelotas infladas: " + inflatedBalls);
		System.out.println("Pelotas desinfladas: " + (totalBalls - inflatedBalls));
		System.out.println("Equipamiento adaptivo: " + adaptiveBalls);

		if (totalBalls > 0) {
			double inflationRate = (double) inflatedBalls / totalBalls * 100;
			System.out.printf("Tasa de inflado: %.1f%%%n", inflationRate);
		}
	}
}