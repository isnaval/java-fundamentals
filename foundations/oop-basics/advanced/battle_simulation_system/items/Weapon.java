package java_oop.advanced.battle_simulation_system.items;

public class Weapon implements Item {
	private String name;
	private String description;
	private int value;
	private String rarity;
	private double attackBonus;
	private String weaponType;
	private double criticalChanceBonus;
	private boolean isTwoHanded;
	private int durability;
	private int maxDurability;

	public Weapon(String name, double attackBonus, String weaponType, String rarity) {
		this.name = name;
		this.attackBonus = attackBonus;
		this.weaponType = weaponType;
		this.rarity = rarity;
		this.value = calculateValue();
		this.description = generateDescription();
		this.criticalChanceBonus = calculateCritBonus();
		this.isTwoHanded = determineTwoHanded();
		this.maxDurability = calculateDurability();
		this.durability = maxDurability;
	}

	private int calculateValue() {
		int baseValue = (int) (attackBonus * 15);
		switch (rarity.toLowerCase()) {
		case "common":
			return baseValue;
		case "uncommon":
			return baseValue * 2;
		case "rare":
			return baseValue * 4;
		case "epic":
			return baseValue * 8;
		case "legendary":
			return baseValue * 15;
		default:
			return baseValue;
		}
	}

	private String generateDescription() {
		return String.format("%s %s (+%.0f Attack)", rarity, weaponType, attackBonus);
	}

	private double calculateCritBonus() {
		switch (weaponType.toLowerCase()) {
		case "dagger":
		case "bow":
			return 0.10;
		case "sword":
			return 0.05;
		case "axe":
		case "mace":
			return 0.02;
		case "staff":
			return 0.08;
		default:
			return 0.03;
		}
	}

	private boolean determineTwoHanded() {
		return weaponType.toLowerCase().contains("bow") || weaponType.toLowerCase().contains("staff")
				|| weaponType.toLowerCase().contains("greatsword") || weaponType.toLowerCase().contains("battleaxe");
	}

	private int calculateDurability() {
		int baseDurability = 100;
		switch (rarity.toLowerCase()) {
		case "common":
			return baseDurability;
		case "uncommon":
			return baseDurability + 25;
		case "rare":
			return baseDurability + 50;
		case "epic":
			return baseDurability + 100;
		case "legendary":
			return baseDurability + 200;
		default:
			return baseDurability;
		}
	}

	@Override
	public void use(Object target) {
		System.out.printf("⚔️ Weapon %s cannot be used directly! It must be equipped.%n", name);
	}

	@Override
	public boolean isConsumable() {
		return false; // Weapons are not consumable
	}

	public void takeDamage(int damage) {
		durability = Math.max(0, durability - damage);
		if (durability == 0) {
			System.out.printf("💥 %s has broken!%n", name);
		} else if (durability < maxDurability * 0.2) {
			System.out.printf("⚠️ %s is heavily damaged!%n", name);
		}
	}

	public void repair(int repairAmount) {
		durability = Math.min(maxDurability, durability + repairAmount);
		System.out.printf("🔧 %s repaired! Durability: %d/%d%n", name, durability, maxDurability);
	}

	public boolean isBroken() {
		return durability <= 0;
	}

	public double getEffectiveAttackBonus() {
		if (isBroken())
			return 0;

		double durabilityRatio = (double) durability / maxDurability;
		return attackBonus * durabilityRatio; // Damage reduces as durability decreases
	}

	public String getCondition() {
		double ratio = (double) durability / maxDurability;
		if (ratio > 0.8)
			return "Excellent";
		if (ratio > 0.6)
			return "Good";
		if (ratio > 0.4)
			return "Fair";
		if (ratio > 0.2)
			return "Poor";
		if (ratio > 0)
			return "Broken";
		return "Destroyed";
	}

	// Getters
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public String getRarity() {
		return rarity;
	}

	public double getAttackBonus() {
		return getEffectiveAttackBonus();
	}

	public double getBaseAttackBonus() {
		return attackBonus;
	}

	public String getWeaponType() {
		return weaponType;
	}

	public double getCriticalChanceBonus() {
		return criticalChanceBonus;
	}

	public boolean isTwoHanded() {
		return isTwoHanded;
	}

	public int getDurability() {
		return durability;
	}

	public int getMaxDurability() {
		return maxDurability;
	}

	@Override
	public String toString() {
		return String.format("%s - %s (Attack: +%.0f, Crit: +%.1f%%, Condition: %s) [Value: %d gold]", name,
				description, getEffectiveAttackBonus(), criticalChanceBonus * 100, getCondition(), value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Weapon weapon = (Weapon) obj;
		return name.equals(weapon.name) && weaponType.equals(weapon.weaponType);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(name, weaponType);
	}
}
