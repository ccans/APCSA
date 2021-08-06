package Week3;


import java.util.Scanner;

/*
Neev Mangal
2/16/21 
Tika Kude
B3 AP Computer Science A

 This program uses nested lops to produce an output in a patter such as
 
 #
 ?#
 ??#
 ???#
 ??#
 ?#
 #
 
 for the number 4
*/ 


public class nestedLoops2 {
	public static void main(String[] args) {	
		
		// Declare variables
		int initial;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Generate a pattern! Enter a number");
		initial = reader.nextInt();
		reader.close();

		
		// First loop, to print the pattern getting bigger
		for(int i = 0; i < initial-1; i++) {
			// Print one more question mark every time (starting with 0)
			for(int j =0; j < i; j++) {
				System.out.print("?");
			}
			// Print the # to cap off the line
			System.out.println("#");
		}
		// Second loop, to print the pattern getting smaller
		
		for(int k = initial-1; k > 0; k--) {
			// Do the opposite as above, one less ? every time (starting with input-1)
			for(int l =0; l < k; l++) {
				System.out.print("?");
			}
			// Print the # to cap off the line
			System.out.println("#");
		}
		// Print the final, lone #
		System.out.println("#");


		
}
}

