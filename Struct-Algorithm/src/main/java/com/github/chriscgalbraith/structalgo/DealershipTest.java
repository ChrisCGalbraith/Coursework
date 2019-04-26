package com.github.chriscgalbraith.structalgo;

import com.github.chriscgalbraith.structalgo.Dealership.duplicateMakeException;

import com.github.chriscgalbraith.structalgo.Dealership.NoMakeFoundException;
import com.github.chriscgalbraith.structalgo.Dealership.NoModelFoundException;

public class DealershipTest {
	
	private static Dealership dealership = new Dealership();
	
	public static void main(String[] args) {
		Integer option = -2;
		do {
			System.out.println("0: Quit.");
			System.out.println("1: Add a new make of car to the Dealership.");
			System.out.println("2: Display makes of car available."); 
			System.out.println("3: Remove a make of car from the Dealership.");
			System.out.println("4: Find if a particular make is held by the Dealership.");
			System.out.println("5: Display models of car available.");
			System.out.println("6: Add a new Car to the Dealership");
			System.out.println("7: Remove a Car from the Dealership");
			try{
				option = Input.getInteger("Option: ");
			} catch(NumberFormatException e2){
				System.out.println("Please enter a number instead.");
			}
			switch (option) {
			case 0:
				System.out.println("Are you sure you want to quit?");
				String choice = Input.getString("Press y to quit or anything else to remain.");
				if(!choice.equals("y")) {
					break;
				}else {
					return;
				}
			case 1:
				try {
					dealership.addMake(Input.getString("Enter the make of car to add to the Dealership"));
				} catch (duplicateMakeException e1) {
					System.out.println("That make already exists in the system.");
				}
				break;
			case 2:
					dealership.displayMakes();
				break;
			case 3:
					dealership.removeMake(Input.getString("Enter the make to remove from the system"));
				break;
			case 4:
					dealership.findMake(Input.getString("What make are you looking to find?: "));
				break;
			case 5:
					dealership.displayModels();
				break;
			case 6:
				try {
					handleAddCar();
				} catch (Exception e) {
					System.out.println("An exception was caught, but lets be nonspecific about it right?");
				}
				break;
			case 7:
					dealership.removeCar(Input.getString("Regi plate to remove:"));
					break;
			case 8:
					dealership.displayNumberCarsByMakeAndModel(Input.getString("Choose make of cars:"), Input.getString("Choose model of cars:"));
			default:
				System.out.println("Invalid input, returning to main menu.");
				option = -2;
			}
		}while (option != -1);
	}
	
	public static void handleAddCar() throws NoModelFoundException, NoMakeFoundException {
		String make;
		String model;
		String regi;
		make = Input.getString("Enter the make to add a car of ");
		if(dealership.findMake(make)) {
			model = Input.getString("Enter the model of the car ");
			System.out.println("Need to check if the car already exists in the Dealership. \nPlease enter the regi-number.");
			regi = Input.getString("Regi number: ");
			if(dealership.checkRegi(regi))
				dealership.addCar(make, model, new Car(regi, Input.getString("Enter the colour of the car: ")));
		}else {
			return;	
		}
	}	
}



