package timbuchalka.CollectionsFramework.Sets;

/**
 * Created by dev on 17/01/2016.
 */
public class DogMain {
	public static void main(String[] args) {
		Labrador rover = new Labrador("Rover");
		Dog rover2 = new Dog("Rover");

		System.out.println(rover2.equals(rover));
		System.out.println(rover.equals(rover2)); // This gives false if equals
		// is overridden in subclass of Dog i.e. in Labrador as rover2 of Dog is
		// not an instance of rover of Labrador
		// equals() needs to follow the rule of SYMMETRY i.e. if a = b then b = a should
		// also be true so we do not override equals in subclass.
	}
}
