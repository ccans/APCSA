package Week1;

// Imports
import java.util.Scanner;

/*
Neev Mangal
2/2/21 
Tika Kude
B3 AP Computer Science A

This program uses the radius of a sphere to output the sphere's diameter, circumference, surface area, and volume
*/

public class spheres {
	public static void main(String[] args) {
		// This program uses the radius of a sphere to output the sphere's diameter, circumference, surface area, and volume
		
		// Declare variables and Scanner
		double surfaceArea, circumference, diameter, volume, pi, radius;
		pi = 3.1415;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input (radius) 
		System.out.println("Enter the radius of the sphere");
		radius = reader.nextDouble();
		reader.close();
		
		// Calculate
		diameter = radius*2;
		volume = (4 * pi * Math.pow(radius, 3))/3;
		circumference = diameter * pi;
		surfaceArea = 4*pi*Math.pow(radius, 2);
		
		// Print results
		
		System.out.println("The diameter of a sphere with radius " + radius + " is " + diameter + ". The volume is " + volume + ", the circumference is " + circumference + ", and the surface area is " + surfaceArea + ".");
		
	}
}
