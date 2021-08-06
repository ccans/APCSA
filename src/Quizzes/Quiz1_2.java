package Quizzes;


//Imports
import java.util.Scanner;

/*
Neev Mangal
2/12/21 
Tika Kude
B3 AP Computer Science A

This program reads in a number representing a pollution index and displays the appropriate classification for it. 
*/ 


public class Quiz1_2 {
	public static void main(String[] args) {
	// This program reads in a number representing a pollution index and displays the appropriate classification for it. 
		
	// Declare variables and Scanner
		double pollutionIndex;
		Scanner reader = new Scanner(System.in);
		
		// Get the user input 
		System.out.println("Enter the pollution index");
		pollutionIndex = reader.nextDouble();
		reader.close();

		// Calculate and output
		if(pollutionIndex > 60) {
			System.out.println("Yikes! Your pollution index is hazardous!");
		} else if (pollutionIndex >= 35) {
			System.out.println("Your pollution index is unpleasent.");
		} else {
			System.out.println("Nice! your pollution index is pleasent!");
		}
	}
}