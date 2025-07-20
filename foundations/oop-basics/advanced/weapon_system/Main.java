package java_oop.advanced.weapon_system;

public class Main {

	public static void main(String[] args) {
		System.out.println("===============================================================");
		System.out.println("         SISTEMA AVANZADO DE GESTION DE ARMAMENTO");
		System.out.println("===============================================================");

		demoRifles();
		demoTanks();
		demoCombatScenario();

		System.out.println("\nSistema de armamento finalizado.");
	}

	private static void demoRifles() {
		System.out.println("\nDEMO 1: SISTEMA DE RIFLES");

		Rifle ak47 = new Rifle("AK-47", 45, 400, 30, 4.3);
		Rifle m4a1 = new Rifle("M4A1", 40, 500, 30, 3.8);

		ak47.displayInfo();

		System.out.println("\nSecuencia de combate con AK-47:");
		ak47.shoulder();
		ak47.aim();
		ak47.fire();
		ak47.fire();
		ak47.fire();

		System.out.println("\nCambiando tipo de munición:");
		ak47.changeAmmoType(AmmunitionType.AmmoType.EXPLOSIVE);
		ak47.fire();

		System.out.println("\nComparando rifles:");
		System.out.println("AK-47 portátil: " + ak47.isPortable());
		System.out.println("M4A1 portátil: " + m4a1.isPortable());
	}

	private static void demoTanks() {
		System.out.println("\n\nDEMO 2: SISTEMA DE TANQUES");

		Tank abrams = new Tank("M1 Abrams", 120, 3000, 40, 120, 65);
		Tank leopard = new Tank("Leopard 2", 125, 3200, 42, 115, 70);

		abrams.displayInfo();

		System.out.println("\nOperaciones de tanque:");
		abrams.move(10, 5);
		abrams.deploy();

		System.out.println("\nCambio de munición y combate:");
		abrams.changeAmmoType(AmmunitionType.AmmoType.EXPLOSIVE);
		abrams.fire();
		abrams.fire();

		System.out.println("\nPrueba de terreno:");
		testTerrain(abrams, "montaña");
		testTerrain(abrams, "agua");
		testTerrain(abrams, "desierto");
	}

	private static void demoCombatScenario() {
		System.out.println("\n\nDEMO 3: ESCENARIO DE COMBATE");

		Rifle sniper = new Rifle("Barrett M82", 85, 1800, 10, 14.0);
		Tank tiger = new Tank("Tiger II", 150, 2500, 30, 185, 45);

		System.out.println("Preparando fuerzas:");
		sniper.shoulder();
		tiger.deploy();

		System.out.println("\nIniciando combate simulado:");

		sniper.changeAmmoType(AmmunitionType.AmmoType.ARMOR_PIERCING);
		sniper.aim();
		sniper.fire();

		tiger.changeAmmoType(AmmunitionType.AmmoType.EXPLOSIVE);
		tiger.fire();

		System.out.println("\nReabastecimiento:");
		sniper.reload();
		tiger.reload();

		System.out.println("\nEstado final de las unidades:");
		sniper.displayInfo();
		tiger.displayInfo();

		System.out.println("\nEstadísticas de combate:");
		showCombatStats(sniper, tiger);
	}

	private static void testTerrain(Tank tank, String terrain) {
		boolean canMove = tank.canTraverse(terrain);
		System.out.println(tank.getName() + " en " + terrain + ": " + (canMove ? "Puede avanzar" : "Bloqueado"));
	}

	private static void showCombatStats(Rifle rifle, Tank tank) {
		System.out.println("ESTADISTICAS DE COMBATE:");
		System.out.println("Rifle " + rifle.getName() + ":");
		System.out
				.println("  - Daño efectivo: " + (int) (rifle.getDamage() * rifle.getAmmoType().getDamageMultiplier()));
		System.out.println("  - Munición restante: " + rifle.getCurrentAmmo() + "/" + rifle.getAmmoCapacity());

		System.out.println("Tanque " + tank.getName() + ":");
		System.out.println("  - Daño efectivo: " + (int) (tank.getDamage() * tank.getAmmoType().getDamageMultiplier()));
		System.out.println("  - Munición restante: " + tank.getCurrentAmmo() + "/" + tank.getAmmoCapacity());
		System.out.println("  - Posición actual: " + tank.getPosition());
	}
}