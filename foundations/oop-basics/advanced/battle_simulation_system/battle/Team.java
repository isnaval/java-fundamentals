package java_oop.advanced.battle_simulation_system.battle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import java_oop.advanced.battle_simulation_system.characters.Character;

public class Team {
	private String teamName;
	private List<Character> members;
	private Character teamLeader;
	private String teamMotto;
	private Map<String, Integer> teamStats;
	private int victories;
	private int defeats;
	private int totalBattles;
	private double teamRating;
	private List<String> achievements;
	private TeamStrategy strategy;

	public Team() {
		this.strategy = TeamStrategy.BALANCED;
	}

	public Team(String teamName, int i) {
		this(teamName);

	}

	public Team(String teamName) {
		this.teamName = teamName;
		this.members = new ArrayList<>();
		this.teamStats = new HashMap<>();
		this.victories = 0;
		this.defeats = 0;
		this.totalBattles = 0;
		this.teamRating = 1000.0;
		this.achievements = new ArrayList<>();
		this.teamMotto = "Victory through unity!";

		initializeTeamStats();
	}

	public enum TeamStrategy {
		BALANCED("Balanced formation with mixed roles"), AGGRESSIVE("All-out attack formation"),
		DEFENSIVE("Tank and support heavy formation"), SUPPORT("Healer and buffer focused"),
		GLASS_CANNON("High damage, low defense"), ENDURANCE("Built for long battles");

		private final String description;

		TeamStrategy(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}

	private void initializeTeamStats() {
		teamStats.put("totalDamageDealt", 0);
		teamStats.put("totalDamageReceived", 0);
		teamStats.put("totalHealing", 0);
		teamStats.put("abilitiesUsed", 0);
		teamStats.put("criticalHits", 0);
	}

	public void addMember(Character character) {
		if (members.size() >= 5) {
			throw new IllegalStateException("Team is full! Maximum 5 members allowed.");
		}

		if (members.contains(character)) {
			throw new IllegalArgumentException("Character is already a team member!");
		}

		members.add(character);

		if (teamLeader == null) {
			teamLeader = character;
		}

		System.out.printf("🎯 %s joined team %s!%n", character.getName(), teamName);
		updateTeamRating();
	}

	public void setStrategy(TeamStrategy strategy) {
		this.strategy = strategy;
		System.out.printf("📋 Team %s strategy changed to: %s%n", teamName, strategy.getDescription());
	}

	public void removeMember(Character character) {
		if (!members.contains(character)) {
			throw new IllegalArgumentException("Character is not a team member!");
		}

		members.remove(character);

		if (teamLeader == character && !members.isEmpty()) {
			teamLeader = getStrongestMember();
			System.out.printf("👑 %s is now the team leader!%n", teamLeader.getName());
		}

		System.out.printf("👋 %s left team %s%n", character.getName(), teamName);
		updateTeamRating();
	}

	public void setTeamLeader(Character character) {
		if (!members.contains(character)) {
			throw new IllegalArgumentException("Character must be a team member to be leader!");
		}

		Character oldLeader = teamLeader;
		teamLeader = character;

		if (oldLeader != null) {
			System.out.printf("👑 Leadership transferred from %s to %s%n", oldLeader.getName(), character.getName());
		} else {
			System.out.printf("👑 %s is now the team leader!%n", character.getName());
		}
	}

	public Character getNextFighter() {
		return members.stream().filter(Character::isAlive).findFirst().orElse(null);
	}

	public List<Character> getAliveMembersOrdered() {
		return members.stream().filter(Character::isAlive)
				.sorted((c1, c2) -> Double.compare(c2.getSpeed(), c1.getSpeed())) // Sort by speed
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
	}

	public boolean hasActiveMembers() {
		return members.stream().anyMatch(Character::isAlive);
	}

	public int getActiveMemberCount() {
		return (int) members.stream().filter(Character::isAlive).count();
	}

	public double getTotalTeamHealth() {
		return members.stream().filter(Character::isAlive).mapToDouble(Character::getHealth).sum();
	}

	public double getTotalTeamMana() {
		return members.stream().filter(Character::isAlive).mapToDouble(Character::getMana).sum();
	}

	public double getAverageLevel() {
		return members.stream().mapToInt(Character::getLevel).average().orElse(1.0);
	}

	public Character getStrongestMember() {
		return members.stream().max(Comparator.comparingDouble(Character::getAttack)).orElse(null);
	}

	public Character getFastestMember() {
		return members.stream().max(Comparator.comparingDouble(Character::getSpeed)).orElse(null);
	}

	public Character getMostDefensiveMember() {
		return members.stream().max(Comparator.comparingDouble(Character::getDefense)).orElse(null);
	}

	public void recordVictory() {
		victories++;
		totalBattles++;
		teamRating += calculateRatingChange(true);

		checkAchievements();

		System.out.printf("🏆 Team %s wins! Record: %d-%d (Rating: %.0f)%n", teamName, victories, defeats, teamRating);
	}

	public void recordDefeat() {
		defeats++;
		totalBattles++;
		teamRating += calculateRatingChange(false);

		System.out.printf("💔 Team %s loses... Record: %d-%d (Rating: %.0f)%n", teamName, victories, defeats,
				teamRating);
	}

	private double calculateRatingChange(boolean isVictory) {
		double baseChange = isVictory ? 25 : -15;

		if (teamRating > 1500)
			baseChange *= 0.8;
		if (teamRating > 2000)
			baseChange *= 0.6;

		return baseChange;
	}

	private void updateTeamRating() {
		if (members.isEmpty()) {
			teamRating = 1000.0;
			return;
		}

		double memberRating = members.stream().mapToDouble(this::calculateMemberRating).average().orElse(1000.0);

		teamRating = (teamRating * 0.7) + (memberRating * 0.3);
	}

	private double calculateMemberRating(Character character) {
		double baseRating = 1000 + (character.getLevel() * 50);
		double statRating = (character.getAttack() + character.getDefense() + character.getSpeed()) * 2;
		return baseRating + statRating;
	}

	private void checkAchievements() {
		if (victories == 1 && !achievements.contains("First Victory")) {
			achievements.add("First Victory");
			System.out.println("🏅 Achievement Unlocked: First Victory!");
		}

		if (victories == 10 && !achievements.contains("Veteran Team")) {
			achievements.add("Veteran Team");
			System.out.println("🏅 Achievement Unlocked: Veteran Team!");
		}

		if (victories >= 5 && defeats == 0 && !achievements.contains("Undefeated")) {
			achievements.add("Undefeated");
			System.out.println("🏅 Achievement Unlocked: Undefeated!");
		}

		if (teamRating >= 2000 && !achievements.contains("Elite Team")) {
			achievements.add("Elite Team");
			System.out.println("🏅 Achievement Unlocked: Elite Team!");
		}
	}

	public double getWinRate() {
		return totalBattles > 0 ? (double) victories / totalBattles * 100 : 0.0;
	}

	public String getTeamRank() {
		if (teamRating >= 2500)
			return "Legendary";
		if (teamRating >= 2000)
			return "Elite";
		if (teamRating >= 1700)
			return "Expert";
		if (teamRating >= 1400)
			return "Advanced";
		if (teamRating >= 1100)
			return "Intermediate";
		return "Novice";
	}

	public void healAllMembers(double amount) {
		System.out.printf("🌟 Team %s receives group healing!%n", teamName);
		members.stream().filter(Character::isAlive).forEach(member -> member.heal(amount));
	}

	public void restoreAllMana(double amount) {
		System.out.printf("💙 Team %s receives group mana restoration!%n", teamName);
		members.stream().filter(Character::isAlive).forEach(member -> member.restoreMana(amount));
	}

	public String generateTeamReport() {
		StringBuilder report = new StringBuilder();

		report.append("═══════════════════════════════════════════════════════════════\n");
		report.append(
				String.format("                       TEAM %s                           \n", teamName.toUpperCase()));
		report.append("═══════════════════════════════════════════════════════════════\n");

		// Team Info
		report.append(String.format("Motto: \"%s\"\n", teamMotto));
		report.append(String.format("Leader: %s\n", teamLeader != null ? teamLeader.getName() : "None"));
		report.append(String.format("Members: %d/5\n", members.size()));
		report.append(String.format("Rating: %.0f (%s)\n", teamRating, getTeamRank()));
		report.append(String.format("Record: %d-%d (%.1f%% win rate)\n", victories, defeats, getWinRate()));
		report.append("\n");

		// Team Stats
		report.append("📊 TEAM STATISTICS\n");
		report.append("───────────────────────────────────────────────────────────────\n");
		report.append(String.format("Average Level: %.1f\n", getAverageLevel()));
		report.append(String.format("Active Members: %d\n", getActiveMemberCount()));
		report.append(String.format("Total Health: %.0f\n", getTotalTeamHealth()));
		report.append(String.format("Total Mana: %.0f\n", getTotalTeamMana()));
		report.append("\n");

		// Members
		report.append("👥 TEAM MEMBERS\n");
		report.append("───────────────────────────────────────────────────────────────\n");
		for (int i = 0; i < members.size(); i++) {
			Character member = members.get(i);
			String leaderMark = member == teamLeader ? " 👑" : "";
			String statusMark = member.isAlive() ? "🟢" : "💀";

			report.append(String.format("%d. %s %s Lv.%d (%s)%s\n", i + 1, statusMark, member.getName(),
					member.getLevel(), member.getCharacterType(), leaderMark));
		}
		report.append("\n");

		// Achievements
		if (!achievements.isEmpty()) {
			report.append("🏅 ACHIEVEMENTS\n");
			report.append("───────────────────────────────────────────────────────────────\n");
			achievements.forEach(achievement -> report.append("• ").append(achievement).append("\n"));
			report.append("\n");
		}

		report.append("═══════════════════════════════════════════════════════════════\n");

		return report.toString();
	}

// Getters
	public String getTeamName() {
		return teamName;
	}

	public List<Character> getMembers() {
		return new ArrayList<>(members);
	}

	public Character getTeamLeader() {
		return teamLeader;
	}

	public String getTeamMotto() {
		return teamMotto;
	}

	public Map<String, Integer> getTeamStats() {
		return new HashMap<>(teamStats);
	}

	public int getVictories() {
		return victories;
	}

	public int getDefeats() {
		return defeats;
	}

	public int getTotalBattles() {
		return totalBattles;
	}

	public double getTeamRating() {
		return teamRating;
	}

	public List<String> getAchievements() {
		return new ArrayList<>(achievements);
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public void setTeamMotto(String teamMotto) {
		this.teamMotto = teamMotto;
	}

	@Override
	public String toString() {
		return String.format("Team %s (%d members, Rating: %.0f, Record: %d-%d)", teamName, members.size(), teamRating,
				victories, defeats);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Team team = (Team) obj;
		return Objects.equals(teamName, team.teamName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamName);
	}
}