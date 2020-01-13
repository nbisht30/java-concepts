package timbuchalka.CollectionsFramework.AdventureExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
		// "new Location(0, "You are sitting in front of a computer learning Java")"
		// creates a Location object
		locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
		locations.put(2, new Location(2, "You are at the top of a hill"));
		locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
		locations.put(4, new Location(4, "You are in a valley beside a stream"));
		locations.put(5, new Location(5, "You are in the forest"));

		locations.get(1).addExit("N", 5);
		locations.get(1).addExit("E", 3);
		locations.get(1).addExit("W", 2);
		locations.get(1).addExit("S", 4);

		locations.get(2).addExit("N", 5);

		locations.get(3).addExit("W", 1);

		locations.get(4).addExit("W", 2);
		locations.get(4).addExit("N", 1);

		locations.get(5).addExit("W", 2);
		locations.get(5).addExit("S", 1);

		int loc = 1;
		while (true) { // infinite loop for user input and printing out location description and
						// available exits
			// for each location input
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
