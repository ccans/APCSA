package Midterm;

import java.util.Scanner;

/*
Neev Mangal
3/6/21 
Tika Kude
B3 AP Computer Science A

This program prints out a pattern based on user input
*/

public class pattern {
	public static void main(String args[]) {
		
		// Initialize variables
		int input;
		Scanner reader = new Scanner(System.in);
		
		// Get user input
		System.out.println("Enter a number");
		input = reader.nextInt();
		reader.close();
		
		// Nested Loops
		for(int k = 0; k < input; k++) {
			System.out.println();
			for(int j = 0 ; j < input; j++) {
				System.out.print(k+1);
			}
		}
		
	}
}
