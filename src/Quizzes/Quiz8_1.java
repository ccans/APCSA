package Quizzes;

import java.util.Scanner;

public class Quiz8_1 {

	public static void main(String args[]) {
		// Declare variables
		Scanner reader = new Scanner(System.in);
		int input;
		//Obviously, the class would not be named "Quiz8_1" in normal circumstances
		Quiz8_1 worker = new  Quiz8_1();
		
		// Get user input
		System.out.println("Would yo like to find the area of a circle (0) or a rectangle (1)?");
		input = reader.nextInt();
		
		// Call the appropriate code
		if(input == 0) {
			System.out.println("Enter the radius");
			System.out.println("The area is " + worker.FindArea(reader.nextDouble()));
		} else {
			double a, b;
			System.out.println("Enter the height");
			a = reader.nextDouble();
			System.out.println("Enter the width");
			b = reader.nextDouble();
			System.out.println("The area is " + worker.FindArea(a, b));
		}
		
		
		
	}
	
	// Circle area function
	public double FindArea(double radius) {
		return 3.14*radius*radius;
	}
	
	// Rectangle area function
	public double FindArea(double height, double width) {
		return height*width;
	}
}
