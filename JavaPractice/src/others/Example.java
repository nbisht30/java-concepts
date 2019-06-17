package others;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	public static String rollingString(String s, List<String> operations) {
		int size = operations.size();
		for (int i = 0; i < size; i++) {
			int x = Character.getNumericValue(operations.get(i).charAt(0));
			int y = Character.getNumericValue(operations.get(i).charAt(2));
			char z = operations.get(i).charAt(4);
			s = rotateString(s, x, y, z);
		}
		return s;
	}

	public static String rotateString(String s, int i, int j, char op) {
		StringBuilder builder = new StringBuilder(s);
		switch (op) {
		case 'L':
			for (int a = i; a <= j; a++) {
				if (builder.charAt(a) == 'a') {
					builder.setCharAt(a, 'z');
				} else {
					builder.setCharAt(a, (char) (builder.charAt(a) - 1));
				}
			}
			break;
		case 'R':
			for (int a = i; a <= j; a++) {
				if (builder.charAt(a) == 'z') {
					builder.setCharAt(a, 'a');
				} else {
					builder.setCharAt(a, (char) (builder.charAt(a) + 1));
				}
			}
		}
		return builder.toString();

	}

}

public class Example {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		int n = in.nextInt();
		in.nextLine();
		List<String> operations = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			operations.add(in.nextLine());
		}
//		for (int i = 0; i < n; i++) {
//			System.out.println(operations.get(i));
//		}
		System.out.println("Result: " + Result.rollingString(s, operations));
	}
}
