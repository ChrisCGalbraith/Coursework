package com.github.chriscgalbraith.structalgo;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;



public class Dealership {

	public class NoMakeFoundException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	public class NoModelFoundException extends Exception {
		private static final long serialVersionUID = 1L;
	}
	
	public class duplicateMakeException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	private TreeMap<String, TreeMap<String, ArrayList<Car>>> myDoubleTree = new TreeMap<>();

	public void addMake(String make) throws duplicateMakeException {

		// Check if the make already exists
		if (myDoubleTree.containsKey(make)) {
			throw new duplicateMakeException();
			
		} else if(make == "") {
				System.out.println("No input detected.");
			}
			else {
				myDoubleTree.put(make, new TreeMap<>());
				System.out.println("Successfuly added " + make + " to the Dealership.");
			}
		}
	
	public void removeMake(String make) {

		// Check if the make exists in the tree
		if (!myDoubleTree.containsKey(make)) {
			System.out.println("That make does not exist. Returning to main menu.");
		} else {
			myDoubleTree.remove(make);
			System.out.println("Successfully removed " + make + " from the Dealership.");
		}
	}
	
	public boolean findMake(String make) {
		if(!myDoubleTree.containsKey(make)){
			 System.out.println("The Dealership does not have this make in stock!");
		}else {
			System.out.println("The Dealership has this make in stock!");
			return true;
		}
		return false;
	}
	
	public boolean findModel(String model) {
		if(!myDoubleTree.containsValue(model)) {
			System.out.println("The Dealership does not have this model in stock");
		}else {
			System.out.println("The Dealership has this model in stock.");
			return true;
		}
		return false;
	}
    // Checks if the model of car (fiesta, punto etc) exists and if it does not, adds the model. Then adds the car details to that.
	public void addCar(String make, String model, Car car) throws NoMakeFoundException, NoModelFoundException {
		 //Check if the make of car exists in the system
		if (!myDoubleTree.containsKey(make)) {
			System.out.println("The selected make does not exist");
			throw new NoMakeFoundException();
		}
		 //Check if the model of the car exists in the system
	    if (!myDoubleTree.get(make).containsKey(model)) {
			addModel(make, model);			
		}			
		myDoubleTree.get(make).get(model).add(car);
		System.out.println("Car successfully added.");
	}
	    
			
	 	
	// Cars must have a unique regi plate, so cars can be identified by this. Loop through all Makes then Models and get the value 
	// Loop through all Makes then Models and get the Value which corresponds to a Car object.
	public void removeCar(String regi) {
		for (Map.Entry<String, TreeMap<String, ArrayList<Car>>> entry : myDoubleTree.entrySet()) {
			for (Map.Entry<String, ArrayList<Car>> entry1 : entry.getValue().entrySet()) {
					ArrayList<Car> cars = entry1.getValue();
					for (int i = 0; i < cars.size(); i++) {
						if(cars.get(i).regi.equals(regi)) {
							cars.remove(i);
							System.out.println("Car Removed. \nThis is the remaining inventory of cars in the Dealership: ");
							displayModels(); 
					}
				}			
			}
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
	
	public void displayModels() {
		if(myDoubleTree.size() == 0) {
			System.out.println("There are no models of that make in the Dealership.");
		}
		else
			for (Map.Entry<String, TreeMap<String, ArrayList<Car>>> entry : myDoubleTree.entrySet()) {
				System.out.println(entry.getValue());
			}
	}	
	
	public void addModel(String make, String model) {
		myDoubleTree.get(make).put(model, new ArrayList<Car>());
	}
	
	public void displayAll(String make, String model) {
		
		String y;
		if(myDoubleTree.size() == 0) {
			System.out.println("There are no makes in the system to display.");
		}
		for (Map.Entry<String, TreeMap<String, ArrayList<Car>>> entry : myDoubleTree.entrySet()) {
			System.out.println(entry.getKey());
		}
	}
	
	public void displayNumberCarsByMakeAndModel(String make, String model) {
		int number = myDoubleTree.get(make).get(model).size();
		System.out.println("Number of " + make + " " + model + " = " + number);
	}
	
	public void createArrayList() {
		for (Map.Entry<String, TreeMap<String, ArrayList<Car>>> entry : myDoubleTree.entrySet()) {
			for (Map.Entry<String, ArrayList<Car>> entry1 : entry.getValue().entrySet()) {
					ArrayList<Car> cars = entry1.getValue();
			}
		}
	}
	
	public boolean checkRegi(String regi) {
		for (Map.Entry<String, TreeMap<String, ArrayList<Car>>> entry : myDoubleTree.entrySet()) {
			for (Map.Entry<String, ArrayList<Car>> entry1 : entry.getValue().entrySet()) {
					ArrayList<Car> cars = entry1.getValue();
					for (int i = 0; i < cars.size(); i++) {
						if(cars.get(i).regi.equals(regi)) {
							System.out.println("This car already exists in the Dealership.");
							return false;
					 }	
				}
			}	
		}
		return true;
	}
}
