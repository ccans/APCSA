package Quizzes;

import java.util.Scanner;

/*

Neev Mangal
3/14/21 
Tika Kude
B3 AP Computer Science A

This program takes in a number and outputs the number of digits tat
*/

public class quiz4_1 {
	
		public static void main(String args[]) {
			
			// Declare Variables
			Scanner reader = new Scanner(System.in);
			int input;
			quiz4_1 Counter = new quiz4_1();
			
			// Get user input
			System.out.println("Enter a number");
			input = reader.nextInt();
			reader.close();
			
			// Output
			System.out.println(Counter.count(input));
			
			
			
		}
		
		
		// Recursive function
		public int count(int a) {
			if(a <= 9) {
				// Base case
				return 1;
			} else {
				// Recursive case
				return count( (int) a/10) + 1;
			}
		}
		
		
}
