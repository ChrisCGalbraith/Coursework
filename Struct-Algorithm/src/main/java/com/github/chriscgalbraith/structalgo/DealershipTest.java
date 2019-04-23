package com.github.chriscgalbraith.structalgo;

import com.github.chriscgalbraith.structalgo.Dealership.duplicateMakeException;
import com.github.chriscgalbraith.structalgo.Dealership.noMakeFoundException;

public class DealershipTest {

	public static void main(String[] args) {
		Dealership dealership = new Dealership();
		Integer option;
		do {
			System.out.println("0: Quit.");
			System.out.println("1: Add a new make of car to the Dealership.");
			System.out.println("2: Display makes of car available."); 
			System.out.println("3: Remove a make of car from the Dealership.");
			System.out.println("4: Find if a particular make is held by the Dealership.");
			option = Input.getInteger("option: ");
			switch (option) {
			case 0:
				System.out.println("quitting program");
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
				System.out.println("invalid option");
			}
		} while (option != 0);

	}
}
