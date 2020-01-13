package timbuchalka.Immutability;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>(); // for storing different
																						// locations

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, Integer> tempExit = new HashMap<String, Integer>();
		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));
		// "new Location(0, "You are sitting in front of a computer learning Java",
		// tempExit)"
		// creates a Location object

		tempExit.put("N", 5);
		tempExit.put("E", 3);
		tempExit.put("W", 2);
		tempExit.put("S", 4);
		locations.put(1,
				new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("N", 5);
		locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 1);
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 2);
		tempExit.put("N", 1);
		locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

		tempExit = new HashMap<String, Integer>();
		tempExit.put("W", 2);
		tempExit.put("S", 1);
		locations.put(5, new Location(5, "You are in the forest", tempExit));

		int loc = 1;
		while (true) { // infinite loop for user input and printing out location description and
						// available exits
			// for each location input

			// Problem with just passing tempExit to Location class objects like
			// new Location(5, "You are in the forest", tempExit) :-
			// tempExit.remove("S"); -> Would remove South exit from 5th location as
			// tempExit currently points to exits of fifth location
			// and we did not pass the copy of temp exit to any of the location objects. If
			// we had a different exit object for each location we would have been able to
			// change exits for each location outside of Location class

			System.out.println(loc + " " + locations.get(loc).getDescription());
			if (loc == 0) {
				break;
			}
			System.out.println("Available exits: - ");
			Map<String, Integer> exits = new HashMap<String, Integer>(locations.get(loc).getExits());
			for (String dir : exits.keySet()) {
				System.out.print(dir + ", ");
			}

			System.out.println("choose your exit: ");
			String chosenExit = scanner.nextLine().toUpperCase();
			if (chosenExit.length() > 1) {
				ArrayList<String> words = new ArrayList<>(Arrays.asList(chosenExit.split(" ")));
				if (words.contains("WEST"))
					chosenExit = "W";
				else if (words.contains("EAST"))
					chosenExit = "E";
				else if (words.contains("SOUTH"))
					chosenExit = "S";
				else if (words.contains("NORTH"))
					chosenExit = "N";
			}
			System.out.println("Chosen exit: " + chosenExit);
			// loc = scanner.nextInt(); // user inputs a new value
			if (exits.containsKey(chosenExit)) {
				loc = exits.get(chosenExit);
			} else {
				System.out.println("You cannot go in that direction");
			}
		}

	}
}
