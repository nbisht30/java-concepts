package timbuchalka.CollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Theatre theatre = new Theatre("Olympian", 8, 12);
		// theatre.getSeats();
		if (theatre.reserveSeat("H11")) {
			System.out.println("Please pay.");
		}
		theatre.reserveSeat("H11");
		System.out.println("================");

		/*
		 * SHALLOW COPYING: Copying one object to another but the actual object is not
		 * copied a new reference is made to the original object.
		 */
		List<ShallowCopying> mainList = new ArrayList<>();
		System.out.println("MainList:-");
		initShallowCopyList(mainList);
		printShallowCopyList(mainList);
		List<ShallowCopying> shallowCopy = new ArrayList<>(mainList);
		System.out.println("ShallowCopy List:-");
		printShallowCopyList(shallowCopy);

		// Changing the order of mainList does not affect shallowCopy
		Collections.reverse(mainList);
		System.out.println("MainList Reversed:-");
		printShallowCopyList(mainList);
		System.out.println("ShallowCopy not affected:-");
		printShallowCopyList(shallowCopy);
		// shallowCopy shuffled but mainList not affected
		Collections.shuffle(shallowCopy);
		System.out.println("ShallowCopy shuflled:-");
		printShallowCopyList(shallowCopy);
		System.out.println("MainList not affected:-");
		printShallowCopyList(mainList);

		// But Changing the actual object at 0 in mainList ie 4G changes 4G to 11X in
		// shallowCopy
		mainList.get(0).setField1(11);
		mainList.get(0).setField2('X');
		// affects shallowCopy also
		System.out.println("ShallowCopy List after one object changed:-");
		printShallowCopyList(shallowCopy);
		System.out.println("================");
		/*
		 * COMPARATOR
		 */
		List<Theatre.Seat> seats = new ArrayList<>(theatre.getSeats());
		System.out.println("List without price sorting:-");
		printList(seats);
		List<Theatre.Seat> priceSeats = new ArrayList<>(theatre.getSeats());
		priceSeats.add(theatre.new Seat("B00", 13.00)); // this is the syntax to create an inner class object.
		priceSeats.add(theatre.new Seat("A00", 13.00));
		System.out.println("List with price sorting:-");
		Collections.sort(priceSeats, Theatre.PRICE_ORDER);
		printList(priceSeats); 
	}

	public static void printList(List<Theatre.Seat> list) {
		for (Theatre.Seat seat : list) {
			System.out.print(seat.getSeatNumber() + " $" + seat.getPrice() + "/- | ");
		}
		System.out.println();
		System.out.println("================");
	}

	public static void printShallowCopyList(List<ShallowCopying> list) {
		for (ShallowCopying item : list) {
			System.out.print(item.getField1() + "" + item.getField2() + " ");
		}
		System.out.println();
		System.out.println("================");
	}

	public static void initShallowCopyList(List<ShallowCopying> list) {
		for (int field1 = 1; field1 <= 4; field1++) {
			for (char field2 = 'A'; field2 <= 'G'; field2++) {
				ShallowCopying item = new ShallowCopying(field1, field2);
				list.add(item);
			}
		}
	}

}

