package timbuchalka.Immutability;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public final class Location {
	// final makes sure the field values cannot be changed once initialized.
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits;

	public Location(int locationID, String description, Map<String, Integer> exits) {
		this.locationID = locationID;
		this.description = description;
		// this.exits=exits; IF THIS IS USED IT GIVES RISE TO PROBLEM MENTIONED IN LINE
		// 51 IN Main CLASS I.E. YOU COULD HAVE REMOVED EXITS FROM OUTSIDE OF LOCATION
		// CLASS
		if (exits != null)
			this.exits = new HashMap<String, Integer>(exits);
		else
			this.exits = new HashMap<String, Integer>(); // in case null is passed as the third parameter of Location
															// constructor, then create a new list.
		this.exits.put("Q", 0);
	}

	public int getLocationID() {
		return locationID;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(exits);
		/*
		 * Why not simply use "return exits;" Because on returning exits from here, it
		 * returns a reference to the same object. And code outside this class will be
		 * able to change the contents of exit using that reference. Consequently,
		 * discarding the use of "final" in the declaration. HashMap<String,
		 * Integer>(exits) creates a new object which has same contents as exits and
		 * returns that to code outside.
		 */
	}
}
