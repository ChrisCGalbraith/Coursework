package com.github.chriscgalbraith.structalgo;

import java.util.ArrayList;
import java.util.TreeMap;

public class DealershipTest {
	
	public static void main(String[] args) {
		TreeMap<String, TreeMap<String, ArrayList<Car>>> myDoubleTree = new TreeMap<>();
		ArrayList<Car> carList = new ArrayList<Car>();
		Integer option;
		do{
	            System.out.println("0: Quit");
	            System.out.println("1: Add a new make of car");
	            System.out.println("2: Display makes of car available");    //Check bookmark on arraylist
	            option=Input.getInteger("option: ");
	            switch (option){
	                case 0:
	                    System.out.println("quitting program");
	                    break;
	                case 1:
	                	
	                	break;
	                case 2:

	                	break;
	                default:
	                    System.out.println("invalid option");
	            }
	        }while(option!=0);

	}
}
