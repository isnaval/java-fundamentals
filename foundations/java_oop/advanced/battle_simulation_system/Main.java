package java_oop.advanced.battle_simulation_system;

import java_oop.advanced.battle_simulation_system.battle.BattleEngine;
import java_oop.advanced.battle_simulation_system.battle.BattleResult;
import java_oop.advanced.battle_simulation_system.battle.Team;
import java_oop.advanced.battle_simulation_system.characters.Archer;
import java_oop.advanced.battle_simulation_system.characters.Healer;
import java_oop.advanced.battle_simulation_system.characters.Mage;
import java_oop.advanced.battle_simulation_system.characters.Warrior;
import java_oop.advanced.battle_simulation_system.items.Armor;
import java_oop.advanced.battle_simulation_system.items.Potion;
import java_oop.advanced.battle_simulation_system.items.Weapon;
import java_oop.advanced.battle_simulation_system.simulation.BattleSimulator;

public class Main {

	public static void main(String[] args) {
		System.out.println("🎮 BATTLE SIMULATION SYSTEM 🎮");
		System.out.println("=".repeat(40));

		demoSimpleBattle();
		demoCharacterWithItems();
		demoTeamBattle();
		demoMassSimulation();
		demoTournament();
	}

	private static void demoSimpleBattle() {
		System.out.println("\n📍 DEMO 1: Simple Character Battle");
		System.out.println("-".repeat(40));

		Warrior warrior = new Warrior("Conan", 5);
		Mage mage = new Mage("Merlin", 5);

		System.out.println("Characters created:");
		System.out.println(warrior);
		System.out.println(mage);

		BattleEngine engine = new BattleEngine();
		BattleResult result = engine.simulateBattle(warrior, mage);

		System.out.println("\n" + result.generateDetailedReport());
	}

	private static void demoCharacterWithItems() {
		System.out.println("\n📍 DEMO 2: Characters with Items");
		System.out.println("-".repeat(40));

		Archer archer = new Archer("Legolas", 6);

		Weapon bow = new Weapon("Elven Bow", 35, "bow", "rare");
		Armor leatherArmor = new Armor("Elven Cloak", 18, "leather armor", "rare");

		archer.equipWeapon(bow);
		archer.equipArmor(leatherArmor);

		archer.addItem(Potion.createHealthPotion("uncommon"));
		archer.addItem(Potion.createHealthPotion("common"));

		System.out.println("Equipped Archer:");
		System.out.println(archer);
		System.out.println("Weapon: " + bow);
		System.out.println("Armor: " + leatherArmor);
		System.out.println("Inventory: " + archer.getInventory().size() + " items");

		Warrior warrior = new Warrior("Gimli", 6);
		warrior.equipWeapon(new Weapon("Dwarven Axe", 40, "axe", "uncommon"));
		warrior.equipArmor(new Armor("Chain Mail", 25, "chainmail", "common"));

		BattleEngine engine = new BattleEngine();
		engine.simulateBattle(archer, warrior);
	}

	private static void demoTeamBattle() {
		System.out.println("\n📍 DEMO 3: Team Battle");
		System.out.println("-".repeat(40));

		Team fellowship = new Team("Fellowship", 4);
		fellowship.addMember(new Warrior("Aragorn", 8));
		fellowship.addMember(new Archer("Legolas", 7));
		fellowship.addMember(new Warrior("Gimli", 7));
		fellowship.addMember(new Mage("Gandalf", 10));
		fellowship.setStrategy(Team.TeamStrategy.BALANCED);

		Team darkForces = new Team("Dark Forces", 4);
		darkForces.addMember(new Warrior("Orc Chief", 6));
		darkForces.addMember(new Mage("Dark Wizard", 8));
		darkForces.addMember(new Archer("Goblin Archer", 5));
		darkForces.addMember(new Healer("Necromancer", 7));
		darkForces.setStrategy(Team.TeamStrategy.AGGRESSIVE);

		System.out.println("Team 1: " + fellowship.generateTeamReport());
		System.out.println("Team 2: " + darkForces.generateTeamReport());

		BattleEngine engine = new BattleEngine();
		engine.simulateTeamBattle(fellowship, darkForces);
	}

	private static void demoMassSimulation() {
		System.out.println("\n📍 DEMO 4: Mass Simulation");
		System.out.println("-".repeat(40));

		BattleSimulator simulator = new BattleSimulator();

		simulator.runRandomBattles(50);

		simulator.runClassAnalysis();
	}

	private static void demoTournament() {
		System.out.println("\n📍 DEMO 5: Tournament");
		System.out.println("-".repeat(40));

		BattleSimulator simulator = new BattleSimulator();
		simulator.runTournament();
	}
}