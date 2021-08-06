package Week2;

//Imports
import java.util.Scanner;

/*
Neev Mangal
2/10/21 
Tika Kude
B3 AP Computer Science A

This program has the user enter in 2 numbers, then enter a third number outputs the sum of the numbers between the first and second number that are evenly divisible by the third number.
*/ 


public class loopsOne {
	public static void main(String[] args) {
    // This program has the user enter in 2 numbers, then enter a third number outputs the sum of the numbers between the first and second number that are evenly divisible by the third number.
		
	// Declare variables and Scanner
		int lowerBound, upperBound, divisor, dummy, total = 0;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter a lower bound");
		lowerBound = reader.nextInt();
		System.out.println("Enter an upper bound");
		upperBound = reader.nextInt();
		System.out.println("Enter the divisor");
		divisor = reader.nextInt();
		reader.close();
		
		// Create a dummy lower bound variable to iterate over
		
		dummy = lowerBound;
		
		// Run the loop and print every number that matches
		System.out.println("Your numbers are: ");
		for(;dummy < upperBound; dummy++) {
			if(dummy%divisor == 0) {
				System.out.print(dummy + ", ");
				total += dummy;
			}
		}
		System.out.println("The total is " + total);
	}
}
