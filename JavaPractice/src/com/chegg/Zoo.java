package com.chegg;

import java.util.ArrayList;

public class Zoo {
	String zooName;
	ArrayList<Animal> animals;

	public Zoo() {
		this.zooName = null;
		this.animals = null;
	}

	public Zoo(String zooName) {
		this.zooName = zooName;
		this.animals = new ArrayList<>();
	}

	public void setZooName(String zooName) {
		this.zooName = zooName;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}

	public void addAnimal(String type, double weight) {
		Animal newAnimal = new Animal(type, weight);
		this.animals.add(newAnimal);
	}

	public void printAnimals() {
		for (int i = 0; i < animals.size(); i++) {
			System.out.println("Animals in " + zooName + " zoo:-");
			System.out.println(animals.get(i).getWeight());
		}
	}

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public String getZooName() {
		return zooName;
	}

	public int getNumberOfAnimals() {
		return animals.size();
	}
}
