package collections.practice;

import java.util.HashMap;
import java.util.Map;

import java.util.Map;

public class HashMapPractice {
	public static void main(String[] args) {
		Map<Integer, String> myMap = new HashMap<>();
		// adding elements
		myMap.put(1, "Nikhil");
		myMap.put(2, "Titiksha");
		myMap.put(3, "Dipti");

		// printing
		myMap.forEach((k, v) -> System.out.println(k + " " + v));

		// trying to add duplicates
		Integer i = new Integer(1);
		myMap.put(i, "Manish");

		// printing
		myMap.forEach((k, v) -> System.out.println(k + " " + v));

		// get methods
		System.out.println(myMap.get(2));

		String a = myMap.getOrDefault(3, "Zebra"); // returns the element at key 3

		System.out.println(a);
		System.out.println(myMap.get(5));
		// printing
		myMap.forEach((k, v) -> System.out.println(k + " " + v));

	}
}
