package com.github.chriscgalbraith.structalg;

public class Car {;
	public String regi;
	public String colour;
	
	public Car(String regi, String colour) {
		this.regi = regi;
		this.colour = colour;
	}
	
	//accessors
	public String getRegi() {
		return regi;
	}
	public String getColour() {
		return colour;
	}
	
	// toString is called in the println printstream
	public String toString() {
		return "Regi:" +  this.regi + " Colour: " + this.colour + "]"; 
	}
}