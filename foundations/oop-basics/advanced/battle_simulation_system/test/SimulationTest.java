package java_oop.advanced.battle_simulation_system.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java_oop.advanced.battle_simulation_system.simulation.BattleSimulator;
import java_oop.advanced.battle_simulation_system.simulation.SimulationStats;

class SimulationTest {

	private BattleSimulator simulator;
	private SimulationStats stats;

	@BeforeEach
	void setUp() {
		simulator = new BattleSimulator();
		stats = new SimulationStats();
	}

	@Test
	@DisplayName("Battle simulator initializes correctly")
	void testSimulatorInitialization() {
		assertNotNull(simulator);
		assertNotNull(simulator.getCharacters());
		assertFalse(simulator.getCharacters().isEmpty());
		long uniqueClasses = simulator.getCharacters().stream().map(c -> c.getCharacterType()).distinct().count();
		assertTrue(uniqueClasses >= 4);
	}

	@Test
	@DisplayName("Statistics track battles correctly")
	void testStatsTracking() {
		assertEquals(0, stats.getTotalBattles());
		stats.reset();
		assertEquals(0, stats.getTotalBattles());
		assertNotNull(stats.getClassWins());
		assertNotNull(stats.getClassLosses());
		assertTrue(stats.getClassWins().containsKey("Warrior"));
		assertTrue(stats.getClassWins().containsKey("Mage"));
		assertTrue(stats.getClassWins().containsKey("Archer"));
		assertTrue(stats.getClassWins().containsKey("Healer"));
	}

	@Test
	@DisplayName("Random battles can be run")
	void testRandomBattles() {
		simulator.runRandomBattles(5);

		SimulationStats results = simulator.getStats();
		assertEquals(5, results.getTotalBattles());
		assertTrue(results.getAverageTurns() > 0);
		boolean someoneWon = results.getClassWins().values().stream().anyMatch(wins -> wins > 0);
		assertTrue(someoneWon);
	}

	@Test
	@DisplayName("Class analysis produces results")
	void testClassAnalysis() {
		simulator.runClassAnalysis();

		SimulationStats results = simulator.getStats();
		assertTrue(results.getTotalBattles() > 0);
		for (String className : new String[] { "Warrior", "Mage", "Archer", "Healer" }) {
			int wins = results.getClassWins().get(className);
			int losses = results.getClassLosses().get(className);
			assertTrue(wins + losses > 0, className + " should have participated in battles");
		}
	}

	@Test
	@DisplayName("Tournament completes successfully")
	void testTournament() {
		assertDoesNotThrow(() -> {
			simulator.runTournament();
		});
	}

	@Test
	@DisplayName("Statistics provide meaningful data")
	void testStatisticsData() {
		simulator.runRandomBattles(20);

		SimulationStats results = simulator.getStats();
		assertTrue(results.getAverageTurns() >= 1);
		assertTrue(results.getAverageTurns() <= 20);
		int totalWins = results.getClassWins().values().stream().mapToInt(Integer::intValue).sum();
		int totalLosses = results.getClassLosses().values().stream().mapToInt(Integer::intValue).sum();
		assertEquals(totalWins, totalLosses);
		assertEquals(results.getTotalBattles(), totalWins);
		assertEquals(results.getTotalBattles(), totalLosses);
	}

	@Test
	@DisplayName("Simulation handles edge cases")
	void testEdgeCases() {
		simulator.runRandomBattles(0);
		assertEquals(0, simulator.getStats().getTotalBattles());
		simulator.runRandomBattles(1);
		assertEquals(1, simulator.getStats().getTotalBattles());
	}

	@Test
	@DisplayName("Statistics can be reset")
	void testStatsReset() {
		simulator.runRandomBattles(5);
		assertTrue(simulator.getStats().getTotalBattles() > 0);
		simulator.getStats().reset();
		assertEquals(0, simulator.getStats().getTotalBattles());
		assertEquals(0.0, simulator.getStats().getAverageTurns());
		for (int wins : simulator.getStats().getClassWins().values()) {
			assertEquals(0, wins);
		}
		for (int losses : simulator.getStats().getClassLosses().values()) {
			assertEquals(0, losses);
		}
	}
}