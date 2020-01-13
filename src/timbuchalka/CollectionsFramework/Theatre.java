package timbuchalka.CollectionsFramework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Theatre {
	private String theatreName;
	private List<Seat> seats = new ArrayList<>();
	
	//Using Comparator to sort using price
	//It looks like we're instantiating an Interface Comparator
	//but it is an anonymous inner class implementing comparator and returning
	//the object to PRICE_ORDER
	static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
		@Override
		public int compare(Seat seat1, Seat seat2) {
			if(seat1.getPrice()<seat2.getPrice())
				return -1;
			else if(seat1.getPrice()>seat2.getPrice())
				return 1;
			else
				return 0;
		}
	};
	
	public Theatre(String theatreName, int numRows, int seatsPerRow) {
		this.theatreName = theatreName;
		int lastRow = 'A' + numRows - 1;
		for (char row = 'A'; row <= lastRow; row++) {
			for (int seatNo = 1; seatNo <= seatsPerRow; seatNo++) {
				double price = 12;
				if((row<'D') && (seatNo>=4 && seatNo <=9)) {
					price=14;
				}	
				else if((row>'F') || (seatNo <4 || seatNo>9)) {
					price=7;
				}
				Seat seat = new Seat(row + String.format("%02d", seatNo), price);
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;
	}

	public boolean changeSeatNumber(String oldSeatNumber, String newSeatNumber) {
		System.out.println("Changing " + oldSeatNumber + " to " + newSeatNumber + "!");
		Seat requestedSeat = new Seat(oldSeatNumber, 0);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if (foundSeat >= 0) {
			seats.get(foundSeat).seatNumber = newSeatNumber;
			return true;
		} else {
			System.out.println("This seat does not exist in this Theatre.");
			return false;
		}
	}

	public boolean reserveSeat(String seatNumber) {
		System.out.println("Reserving " + seatNumber + "!");
		Seat requestedSeat = new Seat(seatNumber, 0);
		int foundSeat = Collections.binarySearch(seats, requestedSeat, null);
		if (foundSeat >= 0) {
			return seats.get(foundSeat).reserve();
		} else {
			System.out.println("This seat does not exist in this Theatre.");
			return false;
		}
//		for (Seat seatItr : seats) { // to check if seat exists or not. //Linear Search when ArrayList is used.
//			System.out.print(".");
//			if (seatItr.getSeatNumber().equals(seatNumber)) {
//				// seat exists.
//				requestedSeat = seatItr;
//				break;
//			}
//		}
	} // reserveSeat ends

	public Collection<Seat> getSeats() {
		return seats;
	}

	public class Seat implements Comparable<Seat> {
		private String seatNumber;
		private double price;
		private boolean reserved = false;

		public Seat(String seatNumber, double price) {
			this.seatNumber = seatNumber;
			this.price = price;
		}

		public String getSeatNumber() {
			return seatNumber;
		}

		public double getPrice() {
			return price;
		}

		public boolean reserve() {
			if (!reserved) {
				reserved = true;
				System.out.println("Seat " + seatNumber + " reserved.");
				return true;
			} else {
				System.out.println("Seat was already reserved!");
				return false;
			}
		}

		public boolean cancel() {
			if (this.reserved) {
				this.reserved = false;
				System.out.println("Reservation of seat " + seatNumber + " cancelled.");
				return true;
			} else
				return false; // unable to cancel as seat wasnt already reserved.
		}

		@Override
		public int compareTo(Seat o) {
			return this.seatNumber.compareToIgnoreCase(o.seatNumber);
		}
	}
}
