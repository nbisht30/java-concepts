package timbuchalka.FileIO.CharacterStreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/*STDIN is also known as Console Input i.e. System.in*/
public class ReadingFromStdin {
	private static void readFromStandardInput() {
		System.out.println("\nInside readFromStandardInput ...");
		String data;
		
		//METHOD1: BufferedReader
		System.out.print("Enter \"start\" to continue (Using BufferedReader): ");		
		try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))){
			while ((data = in.readLine()) != null && !data.equals("start")) {
				System.out.print("\nDid not enter \"start\". Try again: ");				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Correct!!");
		
		//METHOD2: Scanner
		System.out.print("\nEnter \"start\" to continue (Using java.util.Scanner): ");		
		Scanner scanner = new Scanner(System.in);
		
		while(!(data = scanner.nextLine()).equals("start")) {
			System.out.print("\nDid not enter \"start\". Try again: ");	
	    }	
		System.out.println("Correct!!");
		
		
		System.out.println("Now, enter the start code: ");
		int code = scanner.nextInt(); // other methods: nextLong, nextDouble, etc
		System.out.println("Thanks. You entered code: " + code);
		
		
		/**
		 * Scanner ~ a text scanner for parsing primitives & string
		 *         ~ breaks its input into tokens using a delimited pattern (default: whitespace)
		 *         ~ when System.in is used, internally constructor uses 
		 *            an InputStreamReader to read from it
		 *         ~ hasXXX & nextXXX can be used together
		 *         ~ InputMismatchException is thrown
		 *         ~ From Java 5 onwards
		 */
		
		Scanner s1 = new Scanner("Hello, How are you?");
		while(s1.hasNext()) {
			System.out.println(s1.next());  //next() reads one word
		}	
	}
	
	public static void main(String[] args) {
		readFromStandardInput();
	}
}
