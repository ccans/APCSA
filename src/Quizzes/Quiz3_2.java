package Quizzes;

/*
Neev Mangal
2/20/21 
Tika Kude
B3 AP Computer Science A

This program takes in a number that someone paid for an item 9and its price) and then output how much change they need

*/ 

import java.util.Scanner;

public class Quiz3_2 {
	public static void main(String[] args) {
		// Declare variables and Scanner
		double price, payed;
		Scanner reader = new Scanner(System.in);
		
		// I know that the class should be named something that's not "Quiz3_2" so that
		// it is usable, i just have it as that here becuase I already made the file and
		// eclipse will be weird if i try and change it, sorry.
		Quiz3_2 changeCalculator = new Quiz3_2();
				
		// Get user input to initialize variables
		System.out.println("How much does the item cost?");
		price = reader.nextDouble();
		System.out.println("How much did you pay?");
		payed = reader.nextDouble();
		reader.close();
		
		
		//Output
		System.out.println("You are owed " + changeCalculator.calculate(price, payed));
	}
	
	
	// Method that calculated how much is to be reutrned in change
	public double calculate(double cost, double paid) {
		return paid - cost;
	}
}
