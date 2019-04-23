package com.github.chriscgalbraith.structalg;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Dealership {
	
	public class noMakeFoundException extends Exception{
		
	}
	
	private TreeMap<String, TreeMap<String, ArrayList<Car>>> myDoubleTree = new TreeMap<>();
	String make;
	String model;
	Car car;
	
	public void addMake(String make) {
		myDoubleTree.put(make, new TreeMap<>());
	}
	
	public void removeMake(String make) {
		
	}
	
	public void addCar(String make, String model, Car car) throws noMakeFoundException {
		if(myDoubleTree.get(make) == null) {
			
			throw new noMakeFoundException();
			
		}
		myDoubleTree.get(make).get(model).add(car);
	}
	
	public void displayMakes() {
		for (Map.Entry<String, TreeMap<String, ArrayList<Car>>> entry : myDoubleTree.entrySet())
	    {
	      System.out.println(entry.getKey());
	    }
	}
}
