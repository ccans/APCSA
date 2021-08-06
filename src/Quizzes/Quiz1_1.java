package Quizzes;

//Imports
import java.util.Scanner;

/*
Neev Mangal
2/12/21 
Tika Kude
B3 AP Computer Science A

This program gets an amount of money from the user (in dollars) and converts it to canadian dollars, pesos, and euros. It then prints out each value to let the user know
*/ 


public class Quiz1_1 {
	public static void main(String[] args) {
	// This program gets an amount of money from the user (in dollars) and converts it to canadian dollars, pesos, and euros. It then prints out each value to let the user know

		
	// Declare variables and Scanner
		double dollars, cdollars, pesos, euros;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter the amount of dollars");
		dollars = reader.nextDouble();
		reader.close();

		// Calculate
		cdollars = dollars*1.34;
		pesos = dollars*22.07;
		euros = dollars*(.86);
		
		// Output
		System.out.println("Your " + dollars + " dollars are worth " + cdollars + " canadian dollars, " + pesos + " pesos, and " + euros + " euros.");
	}
}