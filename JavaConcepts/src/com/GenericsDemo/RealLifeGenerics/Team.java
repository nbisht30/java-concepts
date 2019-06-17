package com.GenericsDemo.RealLifeGenerics;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> { // "T extends Player" ->Bounded Type Parameter :
																		// Used to restrict types allowed
	// for Team to only
	// to Player's subclasses. If only T was used here we could have created a
	// Team<String> object and it is not a valid team type.
	private String name;
	int played = 0;
	int won = 0;
	int tied = 0;
	int lost = 0;

	private ArrayList<T> members = new ArrayList<>(); // members of the team

	public Team(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean addPlayer(T player) {
		if (members.contains(player)) {
			System.out.println(player.getName() + " player is already on the team!");
			// No need to cast to Player like below when only using T as the type parameter
			// and not using extended types.
			// System.out.println(((Player) player).getName() + " player is already on the
			// team!");
			return false;
		} else {
			members.add(player);
			System.out.println((player.getName() + " picked for team " + this.getName()));
			// No need to cast to Player like below when only using T as the type parameter
			// and not using extended types.
			// System.out.println(((Player) player).getName() + " picked for team " +
			// this.getName());
			return true;
		}
	}

	public int numPlayers() {
		return this.members.size();
	}

	public void matchResult(Team<T> opponent, int ourScore, int theirScore) { // If you dont put Team<T> any types of
																				// teams can play with each other
		String message;
		if (ourScore > theirScore) {
			won++;
			message = " beat ";
		} else if (ourScore < theirScore) {
			lost++;
			message = " lost to ";
		} else {
			tied++;
			message = " drew with ";
		}
		played++;

		if (opponent != null) {
			System.out.println(this.name + message + opponent.getName());
			opponent.matchResult(null, theirScore, ourScore);
		}
	}

	public int ranking() {
		return (won * 2) + tied;
	}

	@Override
	public int compareTo(Team<T> team) {
		// TODO Auto-generated method stub
		if (this.ranking() > team.ranking()) {
			return -1; // ranking of current object is better(actual value is more) than ranking of
						// passed object
			// ie when you want the current object to be earlier in the list after running
			// the sort
			// function!!!!(basically treating the current object as smaller than the passed
			// object and sorting in ascending order)
		} else if (this.ranking() < team.ranking()) {
			return 1;
		} else
			return 0;
	}

}

/*
 * This is the previous implementation of some statements which makes the
 * commented code in Main.java work and allows adding player of any sport to a
 * Team object.
 */
//public class Team {
// ......
// private ArrayList<Player> members = new ArrayList<>(); // members of the team
// ......
// public boolean addPlayer(Player player) {
// .....
// }
// ....
//}
