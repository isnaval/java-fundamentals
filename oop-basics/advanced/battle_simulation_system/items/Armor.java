package java_oop.advanced.battle_simulation_system.items;

public class Armor implements Item {
	private String name;
	private String description;
	private int value;
	private String rarity;
	private double defenseBonus;
	private String armorType;
	private double magicResistance;
	private double speedPenalty;
	private int durability;
	private int maxDurability;
	private boolean providesSpecialEffect;
	private String specialEffect;

	public Armor(String name, double defenseBonus, String armorType, String rarity) {
		this.name = name;
		this.defenseBonus = defenseBonus;
		this.armorType = armorType;
		this.rarity = rarity;
		this.value = calculateValue();
		this.description = generateDescription();
		this.magicResistance = calculateMagicResistance();
		this.speedPenalty = calculateSpeedPenalty();
		this.maxDurability = calculateDurability();
		this.durability = maxDurability;
		this.providesSpecialEffect = determineSpecialEffect();
	}

	private int calculateValue() {
		int baseValue = (int) (defenseBonus * 12);
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
		return String.format("%s %s (+%.0f Defense)", rarity, armorType, defenseBonus);
	}

	private double calculateMagicResistance() {
		switch (armorType.toLowerCase()) {
		case "robes":
		case "enchanted robes":
			return 0.25;
		case "leather armor":
			return 0.10;
		case "chainmail":
			return 0.05;
		case "plate armor":
			return 0.02;
		case "dragon scale":
			return 0.40;
		default:
			return 0.05;
		}
	}

	private double calculateSpeedPenalty() {
		switch (armorType.toLowerCase()) {
		case "robes":
		case "enchanted robes":
			return 0.0;
		case "leather armor":
			return 0.05;
		case "chainmail":
			return 0.10;
		case "plate armor":
			return 0.20;
		case "dragon scale":
			return 0.15;
		default:
			return 0.05;
		}
	}

	private int calculateDurability() {
		int baseDurability = 120;
		switch (rarity.toLowerCase()) {
		case "common":
			return baseDurability;
		case "uncommon":
			return baseDurability + 30;
		case "rare":
			return baseDurability + 60;
		case "epic":
			return baseDurability + 120;
		case "legendary":
			return baseDurability + 250;
		default:
			return baseDurability;
		}
	}

	private boolean determineSpecialEffect() {
		if (rarity.equals("epic") || rarity.equals("legendary")) {
			generateSpecialEffect();
			return true;
		}
		return false;
	}

	private void generateSpecialEffect() {
		switch (armorType.toLowerCase()) {
		case "robes":
		case "enchanted robes":
			specialEffect = "Mana Regeneration (+2 mana per turn)";
			break;
		case "leather armor":
			specialEffect = "Stealth (+10% dodge chance)";
			break;
		case "chainmail":
			specialEffect = "Deflection (5% chance to reflect damage)";
			break;
		case "plate armor":
			specialEffect = "Fortification (+10% health)";
			break;
		case "dragon scale":
			specialEffect = "Dragon's Fury (+5% critical chance when below 50% health)";
			break;
		default:
			specialEffect = "Endurance (+5% to all resistances)";
		}
	}

	@Override
	public void use(Object target) {
		System.out.printf("🛡️ Armor %s cannot be used directly! It must be equipped.%n", name);
	}

	@Override
	public boolean isConsumable() {
		return false; // Armor is not consumable
	}

	public void takeDamage(int damage) {
		durability = Math.max(0, durability - damage);
		if (durability == 0) {
			System.out.printf("💥 %s has been destroyed!%n", name);
		} else if (durability < maxDurability * 0.3) {
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

	public double getEffectiveDefenseBonus() {
		if (isBroken())
			return 0;

		double durabilityRatio = (double) durability / maxDurability;
		return defenseBonus * durabilityRatio; // Defense reduces as durability decreases
	}

	public double getEffectiveMagicResistance() {
		if (isBroken())
			return 0;

		double durabilityRatio = (double) durability / maxDurability;
		return magicResistance * durabilityRatio;
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

	public boolean isLightArmor() {
		return armorType.toLowerCase().contains("robes") || armorType.toLowerCase().contains("leather");
	}

	public boolean isHeavyArmor() {
		return armorType.toLowerCase().contains("plate") || armorType.toLowerCase().contains("chainmail");
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

	public double getDefenseBonus() {
		return getEffectiveDefenseBonus();
	}

	public double getBaseDefenseBonus() {
		return defenseBonus;
	}

	public String getArmorType() {
		return armorType;
	}

	public double getMagicResistance() {
		return getEffectiveMagicResistance();
	}

	public double getBaseMagicResistance() {
		return magicResistance;
	}

	public double getSpeedPenalty() {
		return speedPenalty;
	}

	public int getDurability() {
		return durability;
	}

	public int getMaxDurability() {
		return maxDurability;
	}

	public boolean providesSpecialEffect() {
		return providesSpecialEffect;
	}

	public String getSpecialEffect() {
		return specialEffect;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%s - %s (Defense: +%.0f, Magic Resist: %.1f%%, Speed: -%.1f%%) [%s]", name,
				description, getEffectiveDefenseBonus(), getEffectiveMagicResistance() * 100, speedPenalty * 100,
				getCondition()));

		if (providesSpecialEffect) {
			sb.append(String.format(" ✨%s", specialEffect));
		}

		sb.append(String.format(" [Value: %d gold]", value));
		return sb.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Armor armor = (Armor) obj;
		return name.equals(armor.name) && armorType.equals(armor.armorType);
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(name, armorType);
	}
}