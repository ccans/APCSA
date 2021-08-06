package Quizzes;

//Imports
import java.util.Scanner;

/*
Neev Mangal
2/20/21 
Tika Kude
B3 AP Computer Science A

This program reads in a number, prints out the number, divides by 2, and repeats the process until the number is <=0


*/ 


public class Quiz2_2 {
	public static void main(String[] args) {
	
	    // Declare variables and Scanner
		int inputNumber;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter the number");
		inputNumber = reader.nextInt();
		reader.close();

		// Use while loop to print number over and over till the condition is met
		while(!(inputNumber <= 0)) {
			System.out.println(inputNumber);
			inputNumber /= 2;
		}
		
	}

}
