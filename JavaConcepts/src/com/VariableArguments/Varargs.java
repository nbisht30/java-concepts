package com.VariableArguments;

public class Varargs {
	public static void main(String[] args) {
		method(1, 2, 3);
		System.out.println("++++++");
		method(4, 5, 5, 5, 7);
	}

	static void method(int... a) {
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
	}
}
