package com.CollectionsFramework.Sets.Challenge;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
	private final String name;
	private final double orbitalPeriod;
	private final String bodyType;
	private final Set<HeavenlyBody> satellites; // set of all moons/satellites of that heavenly body.

	public HeavenlyBody(String name, double orbitalPeriod, String bodyType) {
		this.name = name;
		this.orbitalPeriod = orbitalPeriod;
		this.bodyType = bodyType;
		this.satellites = new HashSet<>();
	}

	public boolean addMoon(HeavenlyBody satellite) {
		return this.satellites.add(satellite);
	}
	// we've not made this class as immutable because new information is always
	// found about bodies in the solar system, eg new moon found.

	public String getName() {
		return name;
	}

	public String getType() {
		return bodyType;
	}
	
	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(satellites);
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if ((obj == null) || !(obj instanceof HeavenlyBody)) { 
			return false;
		}

		String objName = ((HeavenlyBody) obj).getName();
		String objType = ((HeavenlyBody) obj).getType();
		return this.name.equals(objName)&&this.bodyType.equals(objType);
	}

	@Override
	public int hashCode() {
		return this.name.hashCode() + 57;
	}

}
