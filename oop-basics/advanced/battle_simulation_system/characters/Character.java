package java_oop.advanced.battle_simulation_system.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java_oop.advanced.battle_simulation_system.items.Armor;
import java_oop.advanced.battle_simulation_system.items.Item;
import java_oop.advanced.battle_simulation_system.items.Weapon;

public abstract class Character {
	protected String name;
	protected int level;
	protected double health;
	protected double maxHealth;
	protected double mana;
	protected double maxMana;
	protected double attack;
	protected double defense;
	protected double speed;
	protected List<Item> inventory;
	protected Weapon equippedWeapon;
	protected Armor equippedArmor;
	public boolean isAlive;
	protected int experience;
	protected Map<String, Double> statusEffects;

	public Character(String name, int level) {
		this.name = name;
		this.level = level;
		this.inventory = new ArrayList<>();
		this.isAlive = true;
		this.experience = 0;
		this.statusEffects = new HashMap<>();
		initializeStats();
	}

	protected abstract void initializeStats();

	public abstract void useSpecialAbility(Character target);

	public abstract String getCharacterType();

	public abstract double getCriticalChance();

	public void attack(Character target) {
		if (!isAlive || !target.isAlive) {
			System.out.println("Cannot attack: one of the characters is defeated!");
			return;
		}

		double damage = calculateDamage(target);

		if (Math.random() < getCriticalChance()) {
			damage *= 2.0;
			System.out.printf("💥 CRITICAL HIT! ");
		}

		target.takeDamage(damage);
		System.out.printf("%s attacks %s for %.1f damage!%n", name, target.getName(), damage);
	}

	protected double calculateDamage(Character target) {
		double baseDamage = this.attack;
		if (equippedWeapon != null) {
			baseDamage += equippedWeapon.getAttackBonus();
		}

		double defense = target.getDefense();
		if (target.getEquippedArmor() != null) {
			defense += target.getEquippedArmor().getDefenseBonus();
		}

		double randomFactor = 0.8 + (Math.random() * 0.4);

		return Math.max(1, (baseDamage - defense) * randomFactor);
	}

	public void takeDamage(double damage) {
		this.health = Math.max(0, this.health - damage);
		if (this.health <= 0 && isAlive) {
			isAlive = false;
			System.out.printf("💀 %s has been defeated!%n", name);
		}
	}

	public void heal(double amount) {
		if (!isAlive)
			return;

		this.health = Math.min(maxHealth, this.health + amount);
		System.out.printf("❤️ %s heals for %.1f HP! (%.0f/%.0f)%n", name, amount, health, maxHealth);
	}

	public void restoreMana(double amount) {
		this.mana = Math.min(maxMana, this.mana + amount);
	}

	public boolean canUseSpecialAbility() {
		return isAlive && mana >= getSpecialAbilityCost();
	}

	protected double getSpecialAbilityCost() {
		return 20.0;
	}

	public void equipWeapon(Weapon weapon) {
		this.equippedWeapon = weapon;
		System.out.printf("⚔️ %s equipped %s%n", name, weapon.getName());
	}

	public void equipArmor(Armor armor) {
		this.equippedArmor = armor;
		System.out.printf("🛡️ %s equipped %s%n", name, armor.getName());
	}

	public void addItem(Item item) {
		inventory.add(item);
	}

	public void useItem(String itemName, Character target) {
		Optional<Item> item = inventory.stream().filter(i -> i.getName().equalsIgnoreCase(itemName)).findFirst();

		if (item.isPresent()) {
			item.get().use(target);
			if (item.get().isConsumable()) {
				inventory.remove(item.get());
			}
		} else {
			System.out.printf("%s doesn't have %s in inventory%n", name, itemName);
		}
	}

	public void gainExperience(int exp) {
		this.experience += exp;
		checkLevelUp();
	}

	private void checkLevelUp() {
		int expNeeded = level * 100;
		if (experience >= expNeeded) {
			level++;
			experience -= expNeeded;
			levelUp();
			System.out.printf("🌟 %s reached level %d!%n", name, level);
		}
	}

	protected void levelUp() {
		maxHealth *= 1.1;
		health = maxHealth;
		maxMana *= 1.1;
		mana = maxMana;
		attack *= 1.05;
		defense *= 1.05;
		speed *= 1.02;
	}

	public double getHealthPercentage() {
		return (health / maxHealth) * 100;
	}

	public double getManaPercentage() {
		return (mana / maxMana) * 100;
	}

	public String getHealthBar() {
		int barLength = 20;
		int healthBars = (int) ((health / maxHealth) * barLength);
		StringBuilder bar = new StringBuilder("[");

		for (int i = 0; i < barLength; i++) {
			if (i < healthBars) {
				bar.append("█");
			} else {
				bar.append("░");
			}
		}
		bar.append("]");
		return bar.toString();
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public double getHealth() {
		return health;
	}

	public double getMaxHealth() {
		return maxHealth;
	}

	public double getMana() {
		return mana;
	}

	public double getMaxMana() {
		return maxMana;
	}

	public double getAttack() {
		return attack;
	}

	public double getDefense() {
		return defense;
	}

	public double getSpeed() {
		return speed;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public int getExperience() {
		return experience;
	}

	public List<Item> getInventory() {
		return inventory;
	}

	public Weapon getEquippedWeapon() {
		return equippedWeapon;
	}

	public Armor getEquippedArmor() {
		return equippedArmor;
	}

	@Override
	public String toString() {
		return String.format("%s (%s) Lv.%d %s HP:%.0f/%.0f MP:%.0f/%.0f", name, getCharacterType(), level,
				isAlive ? "🟢" : "💀", health, maxHealth, mana, maxMana);
	}

}
