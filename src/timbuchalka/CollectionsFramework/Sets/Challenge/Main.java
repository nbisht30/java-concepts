package timbuchalka.CollectionsFramework.Sets.Challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	private static Map<String, HeavenlyBody> solarSystem = new HashMap<>(); // every solar system object

	public static void main(String[] args) {

		// Sun:-
		HeavenlyBody sun = new Star("Sun", 0, "Star");
		solarSystem.put("Sun", sun);

		HeavenlyBody temp = new Planet("Mercury", 88, "Planet");
		solarSystem.put(temp.getName(), temp);
		sun.addMoon(temp);

		//TC2:-
		HeavenlyBody dum = new Planet("Dummys", 12, "Dummy");
		HeavenlyBody ddumm = new Star("Dummy", 12, "Dummy");
		System.out.println(dum.equals(ddumm));
		System.out.println(ddumm.equals(dum));
		//TC2 ENDS

		temp = new Planet("Venus", 225, "Planet");
		solarSystem.put(temp.getName(), temp);
		sun.addMoon(temp);

		temp = new Planet("Earth", 365, "Planet");
		solarSystem.put(temp.getName(), temp);
		sun.addMoon(temp);

		HeavenlyBody tempMoon = new Moon("Moon", 27, "Moon");
		solarSystem.put(tempMoon.getName(), tempMoon);

		System.out.println(tempMoon.getName() + " added to Earth: " + temp.addMoon(tempMoon));

		HeavenlyBody mars = new Planet("Mars", 687, "Planet");
		solarSystem.put(mars.getName(), mars);
		sun.addMoon(temp);
		// Code to demonstrate that planet(Earth is temp here) will not accept a planet
		// as a satellite.
		System.out.println(mars.getName() + " added to Earth: " + temp.addMoon(mars));

		// Addition of more heavenly bodies
		// Adding moons to mars:-
		tempMoon = new Moon("Deimos", 1.3, "Moon");
		solarSystem.put(tempMoon.getName(), tempMoon);
		mars.addMoon(tempMoon);

		tempMoon = new Moon("Phobos", 0.3, "Moon");
		solarSystem.put(tempMoon.getName(), tempMoon);
		mars.addMoon(tempMoon);

		// Jupiter and its moons:-
		temp = new Planet("Jupiter", 4332, "Planet");
		solarSystem.put(temp.getName(), temp);
		sun.addMoon(temp);

		tempMoon = new Moon("Io", 1.8, "Moon");
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon);

		tempMoon = new Moon("Europa", 3.5, "Moon");
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon);

		tempMoon = new Moon("Ganymede", 7.1, "Moon");
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon);

		tempMoon = new Moon("Callisto", 16.7, "Moon");
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon);

		// Saturn and its moons:-
		temp = new Planet("Saturn", 10759, "Planet");
		solarSystem.put(temp.getName(), temp);
		sun.addMoon(temp);

		tempMoon = new Moon("Titan", 16.7, "Moon");
		solarSystem.put(tempMoon.getName(), tempMoon);
		temp.addMoon(tempMoon);
		//TC3:-
		HeavenlyBody tempMoon2 = new Moon("Titan", 16.8, "Moon");
		solarSystem.put(tempMoon2.getName(), tempMoon2);
		temp.addMoon(tempMoon2);
		System.out.println("===============");
		System.out.println("Moons of Saturn:-");
		HeavenlyBody sat = solarSystem.get("Saturn");
		for (HeavenlyBody moonSat : sat.getSatellites()) {
			System.out.println(": " + moonSat.getName() + " " + moonSat.getOrbitalPeriod());
		}
		//TC3 ENDS
		
		// Other Planets:-
		temp = new Planet("Uranus", 30660, "Planet");
		solarSystem.put(temp.getName(), temp);
		sun.addMoon(temp);

		temp = new Planet("Neptune", 165, "Planet");
		solarSystem.put(temp.getName(), temp);
		sun.addMoon(temp);

		temp = new Planet("Pluto", 248, "Planet");
		solarSystem.put(temp.getName(), temp);
		sun.addMoon(temp);
		
		HeavenlyBody pluto = new Planet("Pluto", 878, "Planet");
		solarSystem.put("Pluto", pluto);

		System.out.println("===============");
		System.out.println("All Heavenly Bodies:-");
		for (String key : solarSystem.keySet()) {
			System.out.println(" : " + solarSystem.get(key).getName() + " - " + solarSystem.get(key).getType() + " - "
					+ solarSystem.get(key).getOrbitalPeriod());
		}

		System.out.println("===============");
		System.out.println("All Planets:-");
		for (String key : solarSystem.keySet()) {
			if (solarSystem.get(key).getType() == "Planet")
				System.out.println(" : " + solarSystem.get(key).getName());
		}

		System.out.println("===============");
		System.out.println("All Moons:-");
		for (String key : solarSystem.keySet()) {
			if (solarSystem.get(key).getType() == "Moon")
				System.out.println(" : " + solarSystem.get(key).getName());
		}
		System.out.println("===============");
		System.out.println("Moons of Jupiter:-");
		HeavenlyBody jup = solarSystem.get("Jupiter");
		for (HeavenlyBody moonJup : jup.getSatellites()) {
			System.out.println(": " + moonJup.getName());
		}

		System.out.println("===============");
		System.out.println("Planets around Sun:-");
		sun = solarSystem.get("Sun");
		for (HeavenlyBody moonSun : sun.getSatellites()) {
			System.out.println(": " + moonSun.getName());
		}

	}
}
