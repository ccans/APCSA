package Quizzes;

import java.util.Scanner;

public class Quiz2_3 {
	public static void main(String[] args) {
		
		
	    // Declare variables and Scanner
		int inputNumber;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input, and keep asking till the input is odd
		do {
			System.out.println("Please enter an odd number");
			 inputNumber =  reader.nextInt();
			 if(inputNumber % 2 != 1) System.out.println("That number is not odd, try again");
			}
		while (inputNumber % 2 != 1);
		reader.close();
		
		// Print the square of the odd number
		System.out.println( (int) Math.pow(inputNumber, 2));
		
	}
		
		
}
