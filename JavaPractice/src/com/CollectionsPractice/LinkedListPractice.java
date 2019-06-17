package com.CollectionsPractice;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListPractice {
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		addInOrder(list, "Melbourne");
		addInOrder(list, "Alabama");
		addInOrder(list, "Mumbai");
		addInOrder(list, "Jakarta");
		addInOrder(list, "Mumbai");
		addInOrder(list, "Boston");
		printList(list);
		

	}

	public static boolean addInOrder(List<String> list, String city) {
		// Using ListIterator and not Iterator
		// ListIterator allows us to go backwards.
		ListIterator<String> listItr = list.listIterator();

		while (listItr.hasNext()) {
			int comparison = listItr.next().compareTo(city);

			if (comparison == 0) {
				// City already present
				System.out.println("City Already Present.");
				return false;
			} else if (comparison > 0) {
				listItr.previous();
				listItr.add(city);
				return true;

			} else {
				// Skip
			}
		}
		listItr.add(city);
		return false;
	}

	public static void printList(List<String> list) {
		// Using ListIterator and not Iterator
		// ListIterator allows us to go backwards.
		ListIterator<String> listItr = list.listIterator();

		while (listItr.hasNext()) {
			String item = listItr.next();
			System.out.println(item);
		}
	}
}
