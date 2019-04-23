package com.github.chriscgalbraith.structalgo;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Dealership {

	public class noMakeFoundException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	public class noModelFoundException extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	public class duplicateMakeException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	private TreeMap<String, TreeMap<String, ArrayList<Car>>> myDoubleTree = new TreeMap<>();
	String make;
	String model;
	Car car;

	public void addMake(String make) throws duplicateMakeException {

		// Check if the make already exists
		if (myDoubleTree.containsKey(make)) {
				throw new duplicateMakeException();
			
		} else {
			myDoubleTree.put(make, new TreeMap<>());
			System.out.println("Successfuly added " + make + " to the Dealership.");
		}
	}
	
	public void removeMake(String make) throws noMakeFoundException {

		// Check if the make exists in the tree
		if (!myDoubleTree.containsKey(make)) {
			throw new noMakeFoundException();
		} else {
			myDoubleTree.remove(make);
		}
	}

	public void addCar(String make, String model, Car car) throws noMakeFoundException, noModelFoundException {

		// Check if the make of car exists in the system
		if (!myDoubleTree.containsKey(make)) {
			System.out.println("The selected make does not exist");
			throw new noMakeFoundException();
		}

		// Check if the model of the car exists in the system
		else if (!myDoubleTree.get(make).containsKey(model)) {
			System.out.println("The selected model does not exist");
			throw new noModelFoundException();
		}

		else {
			myDoubleTree.get(make).get(model).add(car);
		}
	}

	public void displayMakes() {
		if(myDoubleTree.size() == 0) {
			System.out.println("There are no makes in the system to display.");
		}
		else 
			for (Map.Entry<String, TreeMap<String, ArrayList<Car>>> entry : myDoubleTree.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
}
