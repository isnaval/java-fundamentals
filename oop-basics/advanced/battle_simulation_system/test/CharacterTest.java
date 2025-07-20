package java_oop.advanced.battle_simulation_system.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java_oop.advanced.battle_simulation_system.characters.Archer;
import java_oop.advanced.battle_simulation_system.characters.Healer;
import java_oop.advanced.battle_simulation_system.characters.Mage;
import java_oop.advanced.battle_simulation_system.characters.Warrior;
import java_oop.advanced.battle_simulation_system.items.Armor;
import java_oop.advanced.battle_simulation_system.items.Potion;
import java_oop.advanced.battle_simulation_system.items.Weapon;

class CharacterTest {

	private Warrior warrior;
	private Mage mage;
	private Archer archer;
	private Healer healer;

	@BeforeEach
	void setUp() {
		warrior = new Warrior("TestWarrior", 5);
		mage = new Mage("TestMage", 5);
		archer = new Archer("TestArcher", 5);
		healer = new Healer("TestHealer", 5);
	}

	@Test
	@DisplayName("Characters are created with correct properties")
	void testCharacterCreation() {
		assertEquals("TestWarrior", warrior.getName());
		assertEquals(5, warrior.getLevel());
		assertEquals("Warrior", warrior.getCharacterType());
		assertTrue(warrior.isAlive());
		assertTrue(warrior.getHealth() > 0);
		assertTrue(warrior.getMaxHealth() > 0);
	}

	@Test
	@DisplayName("Characters have different stats based on class")
	void testClassDifferences() {
		assertTrue(warrior.getMaxHealth() > mage.getMaxHealth());
		assertTrue(mage.getMaxMana() > warrior.getMaxMana());
		assertTrue(archer.getSpeed() > warrior.getSpeed());
		assertTrue(healer.getMaxMana() > mage.getMaxMana());
	}

	@Test
	@DisplayName("Characters can take damage and heal")
	void testHealthSystem() {
		double originalHealth = warrior.getHealth();
		warrior.takeDamage(50);
		assertEquals(originalHealth - 50, warrior.getHealth());
		warrior.heal(30);
		assertEquals(originalHealth - 20, warrior.getHealth());
		warrior.heal(1000);
		assertEquals(warrior.getMaxHealth(), warrior.getHealth());
	}

	@Test
	@DisplayName("Characters die when health reaches zero")
	void testDeath() {
		assertTrue(warrior.isAlive());

		warrior.takeDamage(warrior.getHealth());
		assertFalse(warrior.isAlive());
		assertEquals(0, warrior.getHealth());
	}

	@Test
	@DisplayName("Characters can equip weapons and armor")
	void testEquipment() {
		Weapon sword = new Weapon("Test Sword", 25, "sword", "common");
		Armor armor = new Armor("Test Armor", 20, "plate armor", "common");

		warrior.equipWeapon(sword);
		warrior.equipArmor(armor);

		assertEquals(sword, warrior.getEquippedWeapon());
		assertEquals(armor, warrior.getEquippedArmor());
	}

	@Test
	@DisplayName("Characters can use special abilities")
	void testSpecialAbilities() {
		assertTrue(mage.canUseSpecialAbility());
		double originalMana = mage.getMana();
		mage.useSpecialAbility(warrior);

		assertTrue(mage.getMana() < originalMana);
	}

	@Test
	@DisplayName("Characters gain experience and level up")
	void testLevelUp() {
		int originalLevel = warrior.getLevel();
		double originalHealth = warrior.getMaxHealth();
		warrior.gainExperience(500);

		assertTrue(warrior.getLevel() > originalLevel);
		assertTrue(warrior.getMaxHealth() > originalHealth);
	}

	@Test
	@DisplayName("Archer has arrows system")
	void testArcherArrows() {
		assertTrue(archer.getArrows() > 0);

		int originalArrows = archer.getArrows();
		archer.attack(warrior);
		assertEquals(originalArrows - 1, archer.getArrows());
	}

	@Test
	@DisplayName("Characters can use items")
	void testItemUsage() {
		Potion healthPotion = Potion.createHealthPotion("common");
		warrior.addItem(healthPotion);
		assertTrue(warrior.getInventory().contains(healthPotion));
		warrior.takeDamage(50);
		double healthBeforePotion = warrior.getHealth();
		warrior.useItem(healthPotion.getName(), warrior);
		assertTrue(warrior.getHealth() > healthBeforePotion);
		assertFalse(warrior.getInventory().contains(healthPotion));
	}
}