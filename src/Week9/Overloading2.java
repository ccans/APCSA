package Week9;

import java.util.Scanner;

/*

Neev Mangal
4/12/21 
Tika Kude
B3 AP Computer Science A

This program takes in either 2 or 3 numbers and then tests to see if 2 of the same numbers exist using the specific right function from between 2 overloaded functions
*/

public class Overloading2 {
	
	public static void main(String args[]) {
		// Declare variables (and initialize)
		
		int[] input = new int[3];
		Scanner reader = new Scanner(System.in);
		Overloading2 worker = new Overloading2();
		boolean equal = false;
		
		
		// Get input
		for(int i = 0; i < 3; i++) {
			System.out.println("Enter a number! (or enter -1 to stop at 2 numbers entered)");
			input[i] = reader.nextInt();
		}
		reader.close();
		
		// Check if 2 or 3 numbers were called and call the appropriate function
		if(input[2] == -1) {
			if(worker.checkEqual(input[0], input[1])) equal = true;
		} else {
			if(worker.checkEqual(input[0], input[1], input[2])) equal = true;
		}
		
		// Output
		if(equal) System.out.println("At least 2 of the numbers you entered are the same");
		else System.out.println("You entered distinct numbers");
		
		
		
		
	}
	
	// Function to check if 2 numbers entered are equal
	public boolean checkEqual(int num1, int num2) {
		if(num1 == num2) return true;
		return false;
	}
	
	// Function to check if the 3 numbers entered are equal
	public boolean checkEqual(int num1, int num2, int num3) {
		if(num1 == num2 || num2 == num3 || num1 == num3) return true;
		return false;
	}
	
	
}
