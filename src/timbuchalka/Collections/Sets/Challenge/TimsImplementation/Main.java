package timbuchalka.Collections.Sets.Challenge.TimsImplementation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import timbuchalka.Collections.Sets.Challenge.TimsImplementation.HeavenlyBody.BodyTypes;

public class Main {
	private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>(); // every solar system object
	// THERE IS A PROBLEM WITH USING BODYNAME AS KEY LIKE BELOW:-
	// Map<String, HeavenlyBody> solarSystem = new HashMap<>();
	/*
	 * As per the challenge there can be two bodies in the solar system with the
	 * same name if they have different body types, In TC 6. "Two bodies with the
	 * same name but different designations can be added to the same map, and can be
	 * retrieved from the map." Problem comes when we try to add such bodies, the
	 * first body gets replaced by the next body.
	 * 
	 * Solution is to create a Key Class as an Inner Class of HeavenlyBody and use
	 * that class as Key.
	 */

	public static void main(String[] args) {

		// Sun:-
		HeavenlyBody sun = new Star("Sun", 0);
		solarSystem.put(sun.getKey(), sun);

		HeavenlyBody temp = new Planet("Mercury", 88);
		solarSystem.put(temp.getKey(), temp);
		sun.addSatellite(temp);

		// TC2: A.EQUALS(B) IS SAME AS B.EQUALS(A)
		HeavenlyBody dum = new Planet("Dummy", 12);
		HeavenlyBody ddumm = new Moon("Dummy", 12);
		System.out.println(dum.equals(ddumm));
		System.out.println(ddumm.equals(dum));
		// TC2 ENDS

		temp = new Planet("Venus", 225);
		solarSystem.put(temp.getKey(), temp);
		sun.addSatellite(temp);

		temp = new Planet("Earth", 365);
		solarSystem.put(temp.getKey(), temp);
		sun.addSatellite(temp);

		HeavenlyBody tempMoon = new Moon("Moon", 27);
		solarSystem.put(tempMoon.getKey(), tempMoon);

		System.out.println(tempMoon.getKey() + " added to Earth: " + temp.addSatellite(tempMoon));

		HeavenlyBody mars = new Planet("Mars", 687);
		solarSystem.put(mars.getKey(), mars);
		sun.addSatellite(temp);
		// Code to demonstrate that planet(Earth is temp here) will not accept a planet
		// as a satellite.
		System.out.println(mars.getKey().getName() + " added to Earth: " + temp.addSatellite(mars));

		// TC5: TWO BODIES WITH SAME NAME BUT DIFFERENT TYPES CAN BE ADDED TO SAME
		// SATELLITE SET
		// TRYTIN TO ADD A MOON TYPE BODY NAMED "Earth" WHEN "Earth" OF PLANET TYPE IS
		// ALREADY PRESNET IN SUN'S SATELLITE
		tempMoon = new Moon("Earth", 27);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		sun.addSatellite(tempMoon);
		// TC5 ENDS

		// Addition of more heavenly bodies
		// Adding moons to mars:-
		tempMoon = new Moon("Deimos", 1.3);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		mars.addSatellite(tempMoon);

		tempMoon = new Moon("Phobos", 0.3);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		mars.addSatellite(tempMoon);

		// Jupiter and its moons:-
		temp = new Planet("Jupiter", 4332);
		solarSystem.put(temp.getKey(), temp);
		sun.addSatellite(temp);

		tempMoon = new Moon("Io", 1.8);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);

		tempMoon = new Moon("Europa", 3.5);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);

		tempMoon = new Moon("Ganymede", 7.1);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);

		tempMoon = new Moon("Callisto", 16.7);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);

		// Saturn and its moons:-
		temp = new Planet("Saturn", 10759);
		solarSystem.put(temp.getKey(), temp);
		sun.addSatellite(temp);

		tempMoon = new Moon("Titan", 16.7);
		solarSystem.put(tempMoon.getKey(), tempMoon);
		temp.addSatellite(tempMoon);

		// TC3: ADDIND DUPLICATE TO SET IS NOT ALLOWED
		HeavenlyBody tempMoon2 = new Moon("Titan", 16.9);
		solarSystem.put(tempMoon2.getKey(), tempMoon2);
		temp.addSatellite(tempMoon2);
		System.out.println("===============");
		System.out.println("Moons of Saturn:-");
		HeavenlyBody sat = solarSystem.get(HeavenlyBody.makeKey("Saturn",BodyTypes.PLANET));
		
		for (HeavenlyBody moonSat : sat.getSatellites()) {
			System.out.println(": " + moonSat.getKey().getName() + " " + moonSat.getOrbitalPeriod());
		}
		// TC3 ENDS

		// Other Planets:-
		temp = new Planet("Uranus", 30660);
		solarSystem.put(temp.getKey(), temp);
		sun.addSatellite(temp);

		temp = new Planet("Neptune", 165);
		solarSystem.put(temp.getKey(), temp);
		sun.addSatellite(temp);

		temp = new Planet("Pluto", 248);
		solarSystem.put(temp.getKey(), temp);
		sun.addSatellite(temp);

		HeavenlyBody pluto = new Planet("Pluto", 878);
		solarSystem.put(pluto.getKey(), pluto);

		System.out.println("===============");
		System.out.println("All Heavenly Bodies:-");
		for (HeavenlyBody.Key key : solarSystem.keySet()) {
			System.out.println(" : " + key.getName() + " - " + key.getBodyType() + " - "
					+ solarSystem.get(key).getOrbitalPeriod());
		}

		System.out.println("===============");
		System.out.println("All Planets:-");
		for (HeavenlyBody.Key key : solarSystem.keySet()) {
			if (solarSystem.get(key).getKey().getBodyType() == BodyTypes.PLANET)
				System.out.println(" : " + key.getName());
		}

		System.out.println("===============");
		System.out.println("All Moons:-");
		for (HeavenlyBody.Key key : solarSystem.keySet()) {
			if (key.getBodyType() == BodyTypes.MOON)
				System.out.println(" : " + key.getName());
		}
		System.out.println("===============");
		System.out.println("Moons of Jupiter:-");
		HeavenlyBody jup = solarSystem.get(HeavenlyBody.makeKey("Jupiter",BodyTypes.PLANET));
		for (HeavenlyBody moonJup : jup.getSatellites()) {
			System.out.println(": " + moonJup.getKey().getName());
		}

		System.out.println("===============");
		System.out.println("Satellites of Sun:-");
		sun = solarSystem.get(HeavenlyBody.makeKey("Sun",BodyTypes.STAR));
		for (HeavenlyBody moonSun : sun.getSatellites()) {
			System.out.println(": " + moonSun.getKey().getName() + " - " + moonSun.getKey().getBodyType() + " - "
					+ moonSun.getOrbitalPeriod());
		}

		
		
	}
}
