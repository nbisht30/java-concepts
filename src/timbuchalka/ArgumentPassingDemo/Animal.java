package timbuchalka.ArgumentPassingDemo;

public class Animal {
	String name;
	String type;
	int testArray[];

	Animal(String name, String type, int testArray[]) {
		this.name = name;
		this.type = type;
		this.testArray = testArray;
	}

	public void animalChange(Animal newAnimal) {
		newAnimal.name = this.name;
		newAnimal.type = this.type;
	}

	public void getDetails() { // to print name, type and array
		System.out.println(this.name + " " + this.type);
		for (int var : testArray) {
			System.out.print(var + " ");
		}
		System.out.println();
	}

	public static void arrayChangeDemo(int arr[]) {
		arr[0] = 90;
		arr[1] = 100;
	}

	public static void stringObjectMemberChangeDemo(String x) {
		x = "Tamed/Circus";
	}

	public static void arrayMemberChangeObjectDemo(int x[]) {
		x[0] = 10;
		x[1] = 20;
		x[2] = 30;
	}

	public static void dataStringChangeDemo(String x) {
		x = "Ronaldo";
	}

	public static void dataStringArrChangeDemo(String x[]) {
		x[0] = "Ronaldo";
		x[1] = "Bale";
	}

	public static void main(String args[]) {
		int tArray[] = { 1, 2, 3 };
		Animal elephant = new Animal("Bajrangi", "Tamed/Zoo", tArray);
		Animal elephant2 = new Animal("Bhim", "Wild", tArray);
		System.out.println("elephant:-");
		elephant.getDetails();
		
		System.out.println("elephant2:-");
		elephant2.getDetails(); // prints Bhim, Wild and array values
		elephant.animalChange(elephant2);
		//elephant2 is assigned to values(only name and type) of elephant
		// newAnimal references in the method points to where elephant2 was pointing
		// changes that object.
		System.out.println("elephant2 after being assigned to elephant:-");
		elephant2.getDetails(); // outputs Bajrangi Tamed/Zoo, original values changed. SO OBJECT ARE PASSED BY REFERENCE
		System.out.println("==================");

//Array example below
		int mainArray[] = { 10, 20 };
		arrayChangeDemo(mainArray);
		System.out.println("New Values: " + mainArray[0] + " " + mainArray[1]); // outputs 90 and 100, original values
																				// changed, PASSED BY REF
		System.out.println("==================");
//When trying to change a String object member
		stringObjectMemberChangeDemo(elephant2.type);
		elephant2.getDetails(); // Nothing happens to elephant2 because even though Strings are objects they are
								// also immutable, hence a new object is created in the
//memory when x="Tamed/Circus" is done in the stringObjectMemberChangeDemo() method.
		System.out.println("==================");
//When trying to change an object member which was an array
		arrayMemberChangeObjectDemo(elephant.testArray);
		elephant.getDetails(); // changes the array associated with elephant object i.e. original values
								// changed.
		System.out.println("==================");
//When a single String variable is passed.
		String s = "Messi";
		dataStringChangeDemo(s);
		System.out.println(s); // outputs Messi only, because even though Strings are objects they are also
								// immutable, hence a new object is created in the
//memory when x="Ronaldo" is done in the dataStringChangeDemo() method. Same is the case for wrapper classes like Integer, Double etc.
		System.out.println("==================");
//when String array is passed
		String sArr[] = { "Messi", "Neymar" };
		dataStringArrChangeDemo(sArr);
		System.out.println(sArr[0] + " " + sArr[1]); // Replaces Messi Neymar with Ronaldo Bale because passed as array.
	}
}
//Conclusion: Original arrays and objects get modified in the method whenever passed and the parameter that received them was not initialized to a new object, then the operations on that parameter just modify the original object, however immutable classes and primitive types are not midified.
