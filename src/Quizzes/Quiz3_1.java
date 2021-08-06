package Quizzes;

import java.util.Scanner;

/*
Neev Mangal
2/26/21 
Tika Kude
B3 AP Computer Science A

This program takes in a number and produces pattern in the form

%& number/2 times
repeat for number lines

ex.
3 is
 
%&%
%&%
%&%

*/ 

public class Quiz3_1 {
	public static void main(String[] args) {
		
		// Initialize variables
		int inputNumber;
		Scanner scanner = new Scanner(System.in);
		
		// Get the user input
		System.out.println("Enter a number");
		inputNumber = scanner.nextInt();
		scanner.close();
		
		// Output
		
		// Outside loop
		for(int i = 0; i < inputNumber; i++) {
			// Inside loop
			for(int k = 0; k < inputNumber/2-1; k++) {
				System.out.print("%&");
			}
			System.out.println("%&");
		}
	}
}
