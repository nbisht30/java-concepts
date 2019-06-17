package com.CollectionsFramework.AdventureExample;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dev on 8/12/2015.
 */
public class Location {
	// final makes sure the field values cannot be changed once initialized.
	private final int locationID;
	private final String description;
	private final Map<String, Integer> exits;

	public Location(int locationID, String description) {
		this.locationID = locationID;
		this.description = description;
		this.exits = new HashMap<String, Integer>();
		this.addExit("Q", 0);
	}

	public void addExit(String direction, int location) {
		exits.put(direction, location);
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
