package com.chegg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class Test_Zoo {
	@Test
	public void TestDefaultConstructor() {
		Zoo newZoo = new Zoo();
		assertEquals(null, newZoo.getZooName());
		assertEquals(null, newZoo.getAnimals());
	}

	@Test
	public void TestParameterizedConstructor() {
		Zoo newZoo = new Zoo("New York Zoo");
		assertEquals("New York Zoo", newZoo.getZooName());
		assertEquals(0, newZoo.getNumberOfAnimals());
	}

	@Test
	public void TestNameSetter() {
		Zoo newZoo = new Zoo("Name Undecided");
		newZoo.setZooName("New York Zoo");
		assertEquals("New York Zoo", newZoo.getZooName());
	}
	
	@Test
	public void TestAnimalsSetter() {
		ArrayList<Animal> animals = new ArrayList<>();
		animals.add(new Animal("Lion", 180));
		animals.add(new Animal("Tiger", 220));
		animals.add(new Animal("Elephant", 6000));
		Zoo newZoo = new Zoo("New York Zoo");
		newZoo.setAnimals(animals);
		//ArrayList<Animal> birds = new ArrayList<>(); //to test failure
		assertEquals(animals, newZoo.getAnimals());  //use birds instead of animals to test failure
	}
	
	@Test
	public void TestAddition() {
		Zoo newZoo = new Zoo("New York Zoo");
		assertEquals(0, newZoo.getNumberOfAnimals());
		newZoo.addAnimal("Lion", 180);
		assertEquals(1, newZoo.getNumberOfAnimals());
		newZoo.addAnimal("Tiger", 220);
		assertEquals(2, newZoo.getNumberOfAnimals());
	}
}
