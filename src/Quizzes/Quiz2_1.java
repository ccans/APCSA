package Quizzes;

//Imports
import java.util.Scanner;

/*
Neev Mangal
2/20/21 
Tika Kude
B3 AP Computer Science A

This program reads in 2 numbers and prints out the sum of the cubed numbers between them.
*/ 


public class Quiz2_1 {
	public static void main(String[] args) {
	
	    // Declare variables and Scanner
		int num1, num2, sum = 0;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter the first number");
		num1 = reader.nextInt();
		System.out.println("Enter the second number");
		num2 = reader.nextInt();
		reader.close();

		// Use for loop to sum the numbers in between up
		for(; num2 >= num1; num1++) {
			sum += (int) Math.pow(num1, 3);
		}
		
		// Output
		System.out.println(sum);
		
	}

}
