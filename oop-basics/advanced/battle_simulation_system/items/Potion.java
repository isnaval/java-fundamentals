package java_oop.advanced.battle_simulation_system.items;

import java_oop.advanced.battle_simulation_system.characters.Character;

public class Potion implements Item {
	private String name;
	private String description;
	private int value;
	private String rarity;
	private PotionType type;
	private double potency;
	private int duration;
	private boolean hasInstantEffect;
	private String statusEffect;

	public enum PotionType {
		HEALTH("Health Potion", "Restores health"), MANA("Mana Potion", "Restores mana"),
		STRENGTH("Strength Potion", "Increases attack power"), DEFENSE("Defense Potion", "Increases defense"),
		SPEED("Speed Potion", "Increases speed"), POISON("Poison", "Deals damage over time"),
		REGENERATION("Regeneration Potion", "Heals over time"),
		INVULNERABILITY("Invulnerability Potion", "Temporary damage immunity"),
		BERSERKER("Berserker Potion", "Increases attack but reduces defense"),
		INVISIBILITY("Invisibility Potion", "Grants stealth for several turns");

		private final String displayName;
		private final String effect;

		PotionType(String displayName, String effect) {
			this.displayName = displayName;
			this.effect = effect;
		}

		public String getDisplayName() {
			return displayName;
		}

		public String getEffect() {
			return effect;
		}
	}

	public Potion(String name, PotionType type, double potency, String rarity) {
		this.name = name;
		this.type = type;
		this.potency = potency;
		this.rarity = rarity;
		this.value = calculateValue();
		this.description = generateDescription();
		this.duration = calculateDuration();
		this.hasInstantEffect = determineInstantEffect();
		this.statusEffect = generateStatusEffect();
	}

	private int calculateValue() {
		int baseValue = (int) (potency * 5);

		switch (type) {
		case HEALTH:
		case MANA:
			baseValue *= 1;
			break;
		case STRENGTH:
		case DEFENSE:
		case SPEED:
			baseValue *= 2;
			break;
		case REGENERATION:
			baseValue *= 3;
			break;
		case INVULNERABILITY:
		case BERSERKER:
		case INVISIBILITY:
			baseValue *= 5;
			break;
		case POISON:
			baseValue *= 1.5;
			break;
		}

		switch (rarity.toLowerCase()) {
		case "common":
			return baseValue;
		case "uncommon":
			return (int) (baseValue * 1.5);
		case "rare":
			return baseValue * 3;
		case "epic":
			return baseValue * 6;
		case "legendary":
			return baseValue * 10;
		default:
			return baseValue;
		}
	}

	private String generateDescription() {
		String rarityPrefix = rarity.substring(0, 1).toUpperCase() + rarity.substring(1).toLowerCase();
		return String.format("%s %s (%.0f potency)", rarityPrefix, type.getDisplayName(), potency);
	}

	private int calculateDuration() {
		switch (type) {
		case HEALTH:
		case MANA:
			return 0;
		case POISON:
			return 3;
		case REGENERATION:
			return 5;
		case STRENGTH:
		case DEFENSE:
		case SPEED:
		case BERSERKER:
			return 4;
		case INVULNERABILITY:
			return 2;
		case INVISIBILITY:
			return 3;
		default:
			return 1;
		}
	}

	private boolean determineInstantEffect() {
		return type == PotionType.HEALTH || type == PotionType.MANA;
	}

	private String generateStatusEffect() {
		switch (type) {
		case STRENGTH:
			return "Attack increased by " + (int) (potency * 0.3);
		case DEFENSE:
			return "Defense increased by " + (int) (potency * 0.3);
		case SPEED:
			return "Speed increased by " + (int) (potency * 0.2);
		case POISON:
			return "Taking " + (int) (potency * 0.5) + " poison damage per turn";
		case REGENERATION:
			return "Healing " + (int) (potency * 0.4) + " HP per turn";
		case BERSERKER:
			return "Attack +50%, Defense -30%";
		case INVULNERABILITY:
			return "Immune to all damage";
		case INVISIBILITY:
			return "Cannot be targeted by attacks";
		default:
			return "No ongoing effect";
		}
	}

	@Override
	public void use(Object target) {
		if (!(target instanceof Character)) {
			System.out.println("⚠️ Potion can only be used on characters!");
			return;
		}

		Character character = (Character) target;

		if (!character.isAlive() && type != PotionType.HEALTH) {
			System.out.printf("⚠️ Cannot use %s on defeated character!%n", name);
			return;
		}

		applyEffect(character);
	}

	private void applyEffect(Character character) {
		System.out.printf("🧪 %s drinks %s!%n", character.getName(), name);

		switch (type) {
		case HEALTH:
			double healAmount = potency;
			character.heal(healAmount);
			if (!character.isAlive() && character.getHealth() > 0) {
				System.out.printf("✨ %s has been revived!%n", character.getName());
			}
			break;

		case MANA:
			double manaAmount = potency;
			character.restoreMana(manaAmount);
			System.out.printf("💙 %s restored %.0f mana!%n", character.getName(), manaAmount);
			break;

		case STRENGTH:
			System.out.printf("💪 %s feels stronger! (+%.0f attack for %d turns)%n", character.getName(), potency * 0.3,
					duration);
			break;

		case DEFENSE:
			System.out.printf("🛡️ %s feels more resilient! (+%.0f defense for %d turns)%n", character.getName(),
					potency * 0.3, duration);
			break;

		case SPEED:
			System.out.printf("💨 %s feels faster! (+%.0f speed for %d turns)%n", character.getName(), potency * 0.2,
					duration);
			break;

		case POISON:
			System.out.printf("☠️ %s has been poisoned! (%.0f damage per turn for %d turns)%n", character.getName(),
					potency * 0.5, duration);
			break;

		case REGENERATION:
			System.out.printf("🌱 %s begins regenerating! (%.0f heal per turn for %d turns)%n", character.getName(),
					potency * 0.4, duration);
			break;

		case BERSERKER:
			System.out.printf("😡 %s enters berserker rage! (+50%% attack, -30%% defense for %d turns)%n",
					character.getName(), duration);
			break;

		case INVULNERABILITY:
			System.out.printf("✨ %s becomes invulnerable for %d turns!%n", character.getName(), duration);
			break;

		case INVISIBILITY:
			System.out.printf("👻 %s becomes invisible for %d turns!%n", character.getName(), duration);
			break;
		}
	}

	@Override
	public boolean isConsumable() {
		return true;
	}

	public boolean isHarmful() {
		return type == PotionType.POISON;
	}

	public boolean isBeneficial() {
		return !isHarmful();
	}

	public boolean canBeUsedInCombat() {
		return type != PotionType.INVULNERABILITY;
	}

	public String getFullEffect() {
		StringBuilder effect = new StringBuilder();
		effect.append(type.getEffect());

		if (hasInstantEffect) {
			effect.append(String.format(" (%.0f points instantly)", potency));
		} else {
			effect.append(String.format(" (%s for %d turns)", statusEffect, duration));
		}

		return effect.toString();
	}

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

	public PotionType getType() {
		return type;
	}

	public double getPotency() {
		return potency;
	}

	public int getDuration() {
		return duration;
	}

	public boolean hasInstantEffect() {
		return hasInstantEffect;
	}

	public String getStatusEffect() {
		return statusEffect;
	}

	@Override
	public String toString() {
		return String.format("%s - %s (%s) [Value: %d gold]", name, description, getFullEffect(), value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Potion potion = (Potion) obj;
		return name.equals(potion.name) && type == potion.type;
	}

	@Override
	public int hashCode() {
		return java.util.Objects.hash(name, type);
	}

	// Static factory methods for common potions
	public static Potion createHealthPotion(String rarity) {
		double potency = getRarityPotency(rarity) * 50;
		return new Potion("Health Potion", PotionType.HEALTH, potency, rarity);
	}

	public static Potion createManaPotion(String rarity) {
		double potency = getRarityPotency(rarity) * 40;
		return new Potion("Mana Potion", PotionType.MANA, potency, rarity);
	}

	public static Potion createStrengthPotion(String rarity) {
		double potency = getRarityPotency(rarity) * 30;
		return new Potion("Strength Potion", PotionType.STRENGTH, potency, rarity);
	}

	private static double getRarityPotency(String rarity) {
		switch (rarity.toLowerCase()) {
		case "common":
			return 1.0;
		case "uncommon":
			return 1.5;
		case "rare":
			return 2.5;
		case "epic":
			return 4.0;
		case "legendary":
			return 6.0;
		default:
			return 1.0;
		}
	}
}
