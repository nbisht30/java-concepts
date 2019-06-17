package com.chegg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Test_Animal {
	@Test
	public void TestDefaultConstructor() {
		Animal snailWeightUnknown = new Animal();
		assertEquals(null, snailWeightUnknown.getSpecies());
		assertEquals(0, snailWeightUnknown.getWeight());
	}

	@Test
	public void TestParameterizedConstructor() {
		Animal snailWeightUndefined = new Animal("Snail", -10);
		assertEquals("Snail", snailWeightUndefined.getSpecies());
		assertEquals(0, snailWeightUndefined.getWeight());
	}

	@Test
	public void TestWeightSetter() {
		Animal snailWeightKnown = new Animal();
		snailWeightKnown.setWeight(.10);
		assertEquals(.10, snailWeightKnown.getWeight());
	}
}
