package com.github.chriscgalbraith.structalgo;

import com.github.chriscgalbraith.structalgo.Dealership.duplicateMakeException;
import com.github.chriscgalbraith.structalgo.Dealership.noMakeFoundException;

public class DealershipTest {

	public static void main(String[] args) {
		Dealership dealership = new Dealership();
		Integer option = -2;
		do {
			System.out.println("0: Quit.");
			System.out.println("1: Add a new make of car to the Dealership.");
			System.out.println("2: Display makes of car available."); 
			System.out.println("3: Remove a make of car from the Dealership.");
			System.out.println("4: Find if a particular make is held by the Dealership.");
			try{
				option = Input.getInteger("Option: ");
			} catch(NumberFormatException e2){
				System.out.println("Not a valid input, please enter a number.");
			}
			switch (option) {
			case 0:
				System.out.println("Are you sure you want to quit?");
				String choice = Input.getString("Press y to quit or anything else to remain.");
				if(!choice.equals("y")) {
					break;
				}else {
					option = -1;
				}
				break;
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
				try {         // Try to remove make, if doesnt exist, handles exception and returns to top
					dealership.removeMake(Input.getString("Enter the make to remove from the system"));
				} 
				catch (noMakeFoundException e) {
					System.out.println("Exception: The make does not exist! Going back to main menu.");	
				}
				break;
			case 4:
				try {
					dealership.findMake(Input.getString("What make are you looking to find?: "));
				} catch (noMakeFoundException e) {
					System.out.println("The Dealership does not currently hold that make.");
				}
				break;
			default:
				System.out.println("Returning to main menu");
				option = -2;
			}
		}while (option != -1);
	}

}
