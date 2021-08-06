package Week1;

// Imports
import java.util.Scanner;

/*
Neev Mangal
2/2/21 
Tika Kude
B3 AP Computer Science A

This program uses the mass and velocity of an object to calculate its momentum
*/

public class momentum {

	public static void main(String[] args) {
		// This program uses the mass and velocity of an object to calculate its momentum
		
		// Declare variables and Scanner -- NOTE: Doubles are being used in case the mass or velocity has decimals
		double mass, velocity, momentum;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input (radius) 
		System.out.println("Enter the mass of the object (kg)");
		mass = reader.nextDouble();
		System.out.println("Enter the velocity of the object (m/s)");
		velocity = reader.nextDouble();
		reader.close();
		
		// Calculate
		momentum = mass * velocity;
		
		// Print results
		
		System.out.println("The momentum is " + momentum + " kg*m/s");
		

	}

}
