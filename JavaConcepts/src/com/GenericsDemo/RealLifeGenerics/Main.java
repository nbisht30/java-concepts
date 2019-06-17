package com.GenericsDemo.RealLifeGenerics;

public class Main {
	public static void main(String[] args) {
		FootballPlayer joe = new FootballPlayer("Joe");
		FootballPlayer nik = new FootballPlayer("Nik");
		FootballPlayer sim = new FootballPlayer("Sim");
		FootballPlayer jim = new FootballPlayer("Jim");
		FootballPlayer john = new FootballPlayer("John");
		FootballPlayer jake = new FootballPlayer("Jake");
		BaseballPlayer pat = new BaseballPlayer("Pat");
		SoccerPlayer beckham = new SoccerPlayer("Beckham");

		/*
		 * Implementation allows below commented code to work i.e. allows adding players
		 * of different sport to the same team! This is wrong and can be avoided using
		 * generics. Other solution is to create three separate team classes for each
		 * sport but that would mean duplicated code.
		 */
		// Team adelaideCrows = new Team("Adelaide Crows");
		// adelaideCrows.addPlayer(joe);
		// adelaideCrows.addPlayer(pat);
		// adelaideCrows.addPlayer(beckham);
		
		
		 Team<FootballPlayer> footballTeamA = new Team<>("Adelaide Crows");
		 footballTeamA.addPlayer(joe);
		 footballTeamA.addPlayer(nik);
		 footballTeamA.addPlayer(sim);
		 
		 Team<FootballPlayer> footballTeamB = new Team<>("Hawthorn");
		 footballTeamB.addPlayer(jim);
		 footballTeamB.addPlayer(john);
		 footballTeamB.addPlayer(jake);
		 
		 Team<FootballPlayer> footballTeamC = new Team<>("Fremanthe");
		 Team<FootballPlayer> footballTeamD = new Team<>("Mohun Bagan");
		 Team<FootballPlayer> footballTeamE = new Team<>("FC Pune City");
		 Team<FootballPlayer> footballTeamF = new Team<>("Chennai Lions");
		 
		 Team<BaseballPlayer> baseballTeam = new Team<>("Chicago Cubs");
		 baseballTeam.addPlayer(pat);
		 
		 Team<SoccerPlayer> soccerTeam = new Team<>("Broken Team");
		 soccerTeam.addPlayer(beckham);
		 
		 footballTeamB.matchResult(footballTeamC, 1, 0);
		 footballTeamB.matchResult(footballTeamA, 3, 8);
		 footballTeamA.matchResult(footballTeamC, 2, 1);
		 footballTeamD.matchResult(footballTeamA, 5, 1);
		 footballTeamD.matchResult(footballTeamE, 4, 2);
		 footballTeamD.matchResult(footballTeamC, 4, 2);
		 footballTeamF.matchResult(footballTeamC, 2, 1);
		 
		 System.out.println();
		 System.out.println("Rankings:- ");
		 System.out.println(footballTeamA.getName()+ " : "+footballTeamA.ranking());
		 System.out.println(footballTeamB.getName()+ " : "+footballTeamB.ranking());
		 System.out.println(footballTeamC.getName()+ " : "+footballTeamC.ranking());
		 System.out.println(footballTeamD.getName()+ " : "+footballTeamD.ranking());
		 System.out.println(footballTeamE.getName()+ " : "+footballTeamE.ranking());
		 System.out.println(footballTeamF.getName()+ " : "+footballTeamF.ranking());
		 
		 System.out.println();
		 System.out.println("Outputs from compareTo function:-");
		 System.out.println(footballTeamA.compareTo(footballTeamB));
		 System.out.println(footballTeamA.compareTo(footballTeamC));
		 System.out.println();
		 //adding teams to a league(PART OF THE CHALLENGE LECTURE)
		 League<Team<FootballPlayer>> footballLeague= new League<>();
		 footballLeague.addTeam(footballTeamA);
		 footballLeague.addTeam(footballTeamC);
		 footballLeague.addTeam(footballTeamC);
		 footballLeague.addTeam(footballTeamB);
		 footballLeague.addTeam(footballTeamE);
		 footballLeague.addTeam(footballTeamF);
		 footballLeague.addTeam(footballTeamD);
		 //footballLeague.addTeam(baseballTeam); //Gives error at compile time
		 System.out.println("Unranked league table:- ");
		 footballLeague.printLeagueTable();
		 footballLeague.sortLeagueTable();
		 System.out.println();
		 System.out.println("Ranked league table:- ");
		 footballLeague.printLeagueTable();
	}
}


