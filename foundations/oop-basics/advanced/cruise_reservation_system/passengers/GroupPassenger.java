package java_oop.advanced.cruise_reservation_system.passengers;

import java.util.ArrayList;
import java.util.List;

public class GroupPassenger {
	private String groupName;
	private List<Passenger> members;
	private Passenger groupLeader;
	private double groupDiscount;

	public GroupPassenger(String groupName, Passenger groupLeader) {
		this.groupName = groupName;
		this.groupLeader = groupLeader;
		this.members = new ArrayList<>();
		this.members.add(groupLeader);
		this.groupDiscount = 0.0;
	}

	public void addMember(Passenger passenger) {
		members.add(passenger);
		updateGroupDiscount();
	}

	public void removeMember(Passenger passenger) {
		if (!passenger.equals(groupLeader)) {
			members.remove(passenger);
			updateGroupDiscount();
		}
	}

	private void updateGroupDiscount() {
		if (members.size() >= 10) {
			groupDiscount = 15.0;
		} else if (members.size() >= 5) {
			groupDiscount = 10.0;
		} else {
			groupDiscount = 0.0;
		}
	}

	public String getGroupName() {
		return groupName;
	}

	public List<Passenger> getMembers() {
		return new ArrayList<>(members);
	}

	public Passenger getGroupLeader() {
		return groupLeader;
	}

	public double getGroupDiscount() {
		return groupDiscount;
	}

	public int getGroupSize() {
		return members.size();
	}

	@Override
	public String toString() {
		return String.format("Group: %s (%d members, %.1f%% discount)", groupName, members.size(), groupDiscount);
	}
}
