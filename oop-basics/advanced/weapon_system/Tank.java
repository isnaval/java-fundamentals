package java_oop.advanced.weapon_system;

public class Tank extends Weapon implements TerrainUse, AmmunitionType {
	private int x, y; // Posición
	private boolean deployed;
	private int movementSpeed;
	private int armor;
	private AmmoType currentAmmoType;

	public Tank(String name, int damage, int range, int ammoCapacity, int armor, int speed) {
		super(name, damage, range, ammoCapacity, WeaponType.HEAVY);
		this.x = 0;
		this.y = 0;
		this.deployed = false;
		this.movementSpeed = speed;
		this.armor = armor;
		this.currentAmmoType = AmmoType.ARMOR_PIERCING;
	}

	@Override
	public void fire() {
		if (!canFire()) {
			System.out.println("Sin munición en " + name);
			return;
		}

		if (!deployed) {
			System.out.println("El tanque debe estar desplegado para disparar");
			return;
		}

		currentAmmo--;
		double finalDamage = damage * currentAmmoType.getDamageMultiplier();
		System.out.println(
				name + " DISPARA! Daño masivo: " + (int) finalDamage + " (" + currentAmmoType.getDescription() + ")");
		System.out.println("BOOM! Impacto devastador!");

		if (currentAmmo <= 5) {
			System.out.println("Advertencia: Munición baja (" + currentAmmo + " restantes)");
		}
	}

	@Override
	public void reload() {
		currentAmmo = ammoCapacity;
		System.out.println(name + " recargado con munición pesada - " + currentAmmo + " proyectiles");
	}

	@Override
	public void deploy() {
		deployed = true;
		System.out.println(name + " desplegado en posición (" + x + ", " + y + ")");
		System.out.println("Sistema de armas activado - Listo para combate");
	}

	@Override
	public void move(int newX, int newY) {
		if (deployed) {
			System.out.println("Repliegue del sistema de armas para movimiento");
			deployed = false;
		}

		int distance = Math.abs(newX - x) + Math.abs(newY - y);
		this.x = newX;
		this.y = newY;

		System.out.println(name + " se mueve a posición (" + x + ", " + y + ")");
		System.out.println("Distancia recorrida: " + distance + " unidades");
	}

	@Override
	public boolean canTraverse(String terrainType) {
		return switch (terrainType.toLowerCase()) {
		case "llanura", "carretera", "desierto" -> true;
		case "montaña", "pantano" -> movementSpeed > 30;
		case "agua", "precipicio" -> false;
		default -> true;
		};
	}

	@Override
	public int getMovementSpeed() {
		return movementSpeed;
	}

	@Override
	public AmmoType getAmmoType() {
		return currentAmmoType;
	}

	@Override
	public int getAmmoCost() {
		return switch (currentAmmoType) {
		case STANDARD -> 5;
		case ARMOR_PIERCING -> 8;
		case EXPLOSIVE -> 12;
		case INCENDIARY -> 10;
		};
	}

	@Override
	public String getEffectDescription() {
		return "Proyectil de tanque " + currentAmmoType.getDescription().toLowerCase();
	}

	public void changeAmmoType(AmmoType newType) {
		this.currentAmmoType = newType;
		System.out.println("Cargando proyectiles: " + newType.getDescription());
	}

	public int getArmor() {
		return armor;
	}

	public String getPosition() {
		return "(" + x + ", " + y + ")";
	}

	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("Posición: " + getPosition());
		System.out.println("Velocidad: " + movementSpeed + " km/h");
		System.out.println("Blindaje: " + armor + " mm");
		System.out.println("Estado: " + (deployed ? "Desplegado" : "En movimiento"));
		System.out.println("Proyectil: " + currentAmmoType.getDescription());
	}
}