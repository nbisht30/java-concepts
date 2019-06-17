package com.chegg;

public class Animal {
	String species;
	double weight;

	public Animal() {
		this.species = null;
		this.weight = 0;
	}

	public Animal(String species, double weight) {
		this.species = species; 
		if (weight > 0)
			this.weight = weight;
		else {
			this.weight = 0; //initialize to 0 if negative number is passed
		}
	}

	public void setWeight(double weight) {
		if (weight > 0)
			this.weight = weight;
		else {
			this.weight = 0;
			System.out.println("Cannot have weight less than 0. Weight initialized to 0 as default");
		}
	}

	public String getSpecies() {
		return species;
	}

	public double getWeight() {
		return weight;
	}
}
