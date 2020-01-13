package timbuchalka.GenericsDemo.RealLifeGenerics;

import java.util.ArrayList;
import java.util.Collections;

// Class for implementing a League of Different Sports Teams(PART OF THE CHALLENGE LECTURE)
public class League <T extends Team>{
	ArrayList<T> listOfTeams= new ArrayList<>();
	
	public void addTeam(T team) {
		if(listOfTeams.contains(team)) {
			System.out.println("Team already there in the league.");
		}
		else
		this.listOfTeams.add(team);
	}

	public void sortLeagueTable() {
		Collections.sort(listOfTeams);
	}
	
	public void printLeagueTable()
	{
		for(T i: listOfTeams)
		{
			System.out.println(i.getName());
		}
	}
}