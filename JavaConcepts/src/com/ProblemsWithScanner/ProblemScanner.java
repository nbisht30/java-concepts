package com.ProblemsWithScanner;

import java.util.Scanner;

public class ProblemScanner {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.print("\nEnter flight number: ");
    int flightNumber = scanner.nextInt();
    scanner.nextLine();
    System.out.print("\nEnter departing city: ");
    String departingCity = scanner.nextLine();
    System.out.print("\nEnter arrival city: ");
    String arrivalCity = scanner.nextLine();
}
}
