package timbuchalka.CollectionsFramework.Sets;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
	private final String name;
	private final double orbitalPeriod;
	private final Set<HeavenlyBody> satellites; // set of all moons/satellites of that heavenly body.

	public HeavenlyBody(String name, double orbitalPeriod) {
		this.name = name;
		this.orbitalPeriod = orbitalPeriod;
		this.satellites = new HashSet<>();
	}

	public boolean addMoon(HeavenlyBody moon) {
		return this.satellites.add(moon);
	}
	// we've not made this class as immutable because new information is always
	// found about bodies in the solar system, eg new moon found.

	public String getName() {
		return name;
	}

	public double getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public Set<HeavenlyBody> getSatellites() {
		return new HashSet<>(satellites);
	}

	@Override
	public boolean equals(Object obj) { // the method must be overridden equals(HeavenlyBody obj) is incorrect, that's
										// overloading!
		// Set class would not use it in that case.
		if (this == obj) {
			return true;
		}

		//System.out.println("obj.getClass() is " + obj.getClass());
		//System.out.println("this.getClass() is " + this.getClass());
		if ((obj == null) || (obj.getClass() != this.getClass())) { // (obj.getClass() != this.getClass()) tests that
			// the class of obj is not a subclass of HeavenlyBody or some other class
			// We could have used instanceOf here as well, because HeavenlyBody is a final
			// class and we cannot create a subclass for it
			// String class in java is also final, hence its equals() also uses instanceOf
			// But when the class is not final, this is what we need to do.
			// We're checking for null first, because if we run obj.getClass for a null
			// object we get an exception.

			return false;
		}

		String objName = ((HeavenlyBody) obj).getName();
		return this.name.equals(objName);
	}

	@Override
	public int hashCode() {
		//System.out.println("hashcode called");
		return this.name.hashCode() + 57;
	}

}
