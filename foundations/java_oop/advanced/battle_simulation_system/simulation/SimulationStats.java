package java_oop.advanced.battle_simulation_system.simulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java_oop.advanced.battle_simulation_system.battle.BattleResult;

public class SimulationStats {
	private List<BattleResult> results;
	private Map<String, Integer> classWins;
	private Map<String, Integer> classLosses;
	private int totalBattles;
	private double averageTurns;

	public SimulationStats() {
		this.results = new ArrayList<>();
		this.classWins = new HashMap<>();
		this.classLosses = new HashMap<>();
		reset();
	}

	public void reset() {
		results.clear();
		classWins.clear();
		classLosses.clear();
		totalBattles = 0;
		averageTurns = 0.0;

		// Initialize class stats
		String[] classes = { "Warrior", "Mage", "Archer", "Healer" };
		for (String className : classes) {
			classWins.put(className, 0);
			classLosses.put(className, 0);
		}
	}

	public void addBattleResult(BattleResult result) {
		results.add(result);
		totalBattles++;

		// Update class statistics
		String winnerClass = result.getWinner().getCharacterType();
		String loserClass = result.getLoser().getCharacterType();

		classWins.merge(winnerClass, 1, Integer::sum);
		classLosses.merge(loserClass, 1, Integer::sum);

		averageTurns = ((averageTurns * (totalBattles - 1)) + result.getTotalTurns()) / totalBattles;
	}

	public void printSummary() {
		System.out.println("\n" + "=".repeat(50));
		System.out.println("           SIMULATION SUMMARY");
		System.out.println("=".repeat(50));

		System.out.printf("Total Battles: %d\n", totalBattles);
		System.out.printf("Average Battle Length: %.1f turns\n", averageTurns);

		System.out.println("\n--- CLASS PERFORMANCE ---");
		for (String className : classWins.keySet()) {
			int wins = classWins.get(className);
			int losses = classLosses.get(className);
			int total = wins + losses;
			double winRate = total > 0 ? (double) wins / total * 100 : 0;

			System.out.printf("%-8s: %2d wins, %2d losses (%.1f%% win rate)\n", className, wins, losses, winRate);
		}
	}

	public void printClassAnalysis() {
		System.out.println("\n" + "=".repeat(50));
		System.out.println("          CLASS ANALYSIS");
		System.out.println("=".repeat(50));

		String strongest = "";
		String weakest = "";
		double highestWinRate = 0;
		double lowestWinRate = 100;

		for (String className : classWins.keySet()) {
			int wins = classWins.get(className);
			int losses = classLosses.get(className);
			int total = wins + losses;

			if (total > 0) {
				double winRate = (double) wins / total * 100;

				if (winRate > highestWinRate) {
					highestWinRate = winRate;
					strongest = className;
				}

				if (winRate < lowestWinRate) {
					lowestWinRate = winRate;
					weakest = className;
				}
			}
		}

		System.out.printf("🏆 Strongest Class: %s (%.1f%% win rate)\n", strongest, highestWinRate);
		System.out.printf("💀 Weakest Class: %s (%.1f%% win rate)\n", weakest, lowestWinRate);

		printSummary();
	}

	public void printTopPerformers() {
		Map<String, Integer> characterWins = new HashMap<>();

		for (BattleResult result : results) {
			String winnerName = result.getWinner().getName();
			characterWins.merge(winnerName, 1, Integer::sum);
		}

		System.out.println("\n--- TOP PERFORMERS ---");
		characterWins.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(5)
				.forEach(entry -> System.out.printf("%s: %d wins\n", entry.getKey(), entry.getValue()));
	}

	public int getTotalBattles() {
		return totalBattles;
	}

	public double getAverageTurns() {
		return averageTurns;
	}

	public Map<String, Integer> getClassWins() {
		return new HashMap<>(classWins);
	}

	public Map<String, Integer> getClassLosses() {
		return new HashMap<>(classLosses);
	}

	public List<BattleResult> getResults() {
		return new ArrayList<>(results);
	}
}