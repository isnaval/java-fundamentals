package java_oop.basics.sports_equipment;

public class Main {

	public static void main(String[] args) {
		System.out.println("===============================================================");
		System.out.println("         SISTEMA DE GESTIÓN DE EQUIPAMIENTO DEPORTIVO");
		System.out.println("===============================================================");

		SportsManager manager = new SportsManager();
		demo1CrearEquipamiento(manager);
		demo2InflarYProbar(manager);
		demo3TestsRendimiento(manager);
		demo4GestionAvanzada(manager);
		System.out.println("\nDEMOSTRACION COMPLETADA!");
	}

	private static void demo1CrearEquipamiento(SportsManager manager) {
		System.out.println("\nDEMO 1: CREANDO EQUIPAMIENTO");
		System.out.println("===============================================");

		Basketball basket1 = manager.createBasketball("Naranja", "profesional");
		Basketball basket2 = manager.createBasketball("Azul", "entrenamiento");
		Basketball basket3 = manager.createBasketball("Rojo", "recreativo");
		basket3.setAdaptive(true);

		Football futbol1 = manager.createFootball("FIFA");
		Football futbol2 = manager.createFootball("entrenamiento");
		Football futbol3 = manager.createFootball("playa");

		manager.showInventory();
	}

	private static void demo2InflarYProbar(SportsManager manager) {
		System.out.println("\nDEMO 2: INFLADO Y VERIFICACION");
		System.out.println("===============================================");

		manager.inflateAllBalls();

		manager.showInflatedBalls();

		System.out.println("\nInflado manual con presiones específicas:");
		Basketball basket = (Basketball) manager.findById(1);
		if (basket != null) {
			basket.deflate();
			basket.inflate(9.0);
			basket.displayInfo();
		}
	}

	private static void demo3TestsRendimiento(SportsManager manager) {
		System.out.println("\nDEMO 3: TESTS DE RENDIMIENTO");
		System.out.println("===============================================");

		manager.performAllTests();

		System.out.println("Tests específicos:");

		Football fifa = (Football) manager.findById(4);
		if (fifa != null) {
			System.out.println("\nTest FIFA compliance:");
			fifa.displayInfo();
			System.out.println("Cumple estándar FIFA: " + fifa.isFIFACompliant());
		}

		Basketball professional = (Basketball) manager.findById(1);
		if (professional != null) {
			System.out.println("\nTest profesional:");
			professional.performBounceTest();
		}
	}

	private static void demo4GestionAvanzada(SportsManager manager) {
		System.out.println("\nDEMO 4: GESTION AVANZADA");
		System.out.println("===============================================");

		manager.showStatistics();

		System.out.println("\nBUSQUEDAS:");
		System.out.println("Equipamiento de baloncesto:");
		manager.findBySport("Baloncesto").forEach(System.out::println);

		System.out.println("\nEquipamiento de fútbol:");
		manager.findBySport("Fútbol").forEach(System.out::println);

		System.out.println("\nDEMOSTRACION DE POLIMORFISMO:");
		System.out.println("Mostrando info de todo el equipamiento:");
		for (int i = 1; i <= 6; i++) {
			Equipment item = manager.findById(i);
			if (item != null) {
				System.out.println("\n--- Equipamiento ID " + i + " ---");
				item.displayInfo();
			}
		}

		System.out.println("\nMANIPULACION DE INTERFACES INFLATABLE:");
		Equipment item = manager.findById(2);
		if (item instanceof Inflatable) {
			Inflatable inflatable = (Inflatable) item;
			System.out.println("Presión actual: " + inflatable.getCurrentPressure());
			System.out.println("Presión recomendada: " + inflatable.getRecommendedPressure());
			System.out.println("¿Está inflado? " + inflatable.isInflated());
		}
	}
}