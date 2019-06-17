package com.ImmutabilityExample2;

public class Mutable extends Immutable {
	private int realValue;

	public Mutable(int value) {
		super(value);
		realValue = value;
	}

	public int getValue() {
		return realValue;
	}

	public void setValue(int newValue) {
		realValue = newValue;
	}

	public static void main(String[] arg) {
		Mutable obj = new Mutable(4);
		Immutable immObj = (Immutable) obj; // Making an Immutable type reference ot the same object obj was pointing
											// to.
		System.out.println(immObj.getValue()); // Initial value of supposedly Immutable class object
		obj.setValue(8); // Setting value using Mutable class reference to 8, so the change would also
							// reflect in the Immutable class reference immObj as both point to same object.
		System.out.println(immObj.getValue()); // Turns out class was actually Mutable.
	}
}